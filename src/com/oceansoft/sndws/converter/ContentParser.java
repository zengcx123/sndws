/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ���й����ݿƼ�����ɽ·1��
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: ���ݹ���ͳһ�û�����ƽ̨1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:HeaderParser.java
 * <p>
 * �����ʱ��: Jun 6, 2013 5:08:51 PM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * ������ : ���ݹ���ͳһ�û�����ƽ̨
 * <p>
 * ���ڲ���: ����/����������������
 * <p>
 * <p>
 */
package com.oceansoft.sndws.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.base.Body;
import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;
import com.oceansoft.sndws.util.DocumentFactory;

/**
 * CDATA�������ݽ���
 * 
 * @author chenw
 * 
 */
public class ContentParser extends DefaultHandler {
	//Log log = LogFactory.getLog(ContentParser.class);
	private String docType;
	private Document doc;
	private List<Attachment> atts;
	private Attachment att;
	private static final String DOCUMENT_FLAG = "DOCUMENT";
	private static final String FILE_LIST_FLAG = "FileData";
	private static final String FILE_ITEM_FLAG = "File";
	private Map<String, String> nodes;
	private String qName;
	private boolean start_flag = false;

	public ContentParser(String docType) {
		super();
		this.docType = docType;
	}

	@Override
	public void startDocument() throws SAXException {
		nodes = new HashMap<String, String>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.qName = qName;
		if (DOCUMENT_FLAG.equals(qName)) {
			doc = DocumentFactory.getInstance().create(this.docType);
			start_flag = true;
		} else if (FILE_LIST_FLAG.equals(qName)) {
			atts = new ArrayList<Attachment>();
			start_flag = true;
		} else if (FILE_ITEM_FLAG.equals(qName)) {
			att = new Attachment();
			start_flag = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (start_flag) {
			String str = new String(ch, start, length);
			nodes.put(this.qName, null == str || "null".equals(str) ? "" : str);
			System.out.println(String.format("�ڵ���Ϣ:%1$s=%2$s", this.qName, str));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (DOCUMENT_FLAG.equals(qName) && null != this.doc) {
			ConvertUtil.xml2Obj(this.doc, nodes);
			start_flag = false;
		} else if (FILE_ITEM_FLAG.equals(qName)) {
			ConvertUtil.xml2Obj(att, nodes);
			atts.add(att);
			att = null;
			start_flag = false;
		} else if (FILE_LIST_FLAG.equals(qName)) {
			start_flag = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		qName = null;
		nodes = null;
	}

	public Body xml2Obj() {
		return new Body(doc, atts);
	}
}
