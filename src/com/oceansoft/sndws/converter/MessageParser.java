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
 * �ļ���:MessageParser.java
 * <p>
 * �����ʱ��: Jun 7, 2013 9:25:07 AM
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.oceansoft.sndws.entity.base.Body;
import com.oceansoft.sndws.entity.base.Header;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Receiver;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * XML����ΪMessage����SAX������
 * 
 * @author chenw
 * 
 */
public class MessageParser extends DefaultHandler {
	// SAX��������
	private static final String HEADER_FLAG = "PantheonMessageHeader";
	private static final String RECEIVER_FLAG = "PantheonMessageReceiver";
	private static final String BODY_FLAG = "UserArea";
	private Header header;
	private Receiver receiver;
	private Body body;
	private Map<String, String> nodes;
	private String qName;
	private boolean start_flag = false;

	@Override
	public void startDocument() throws SAXException {
		nodes = new HashMap<String, String>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.qName = qName;
		if (HEADER_FLAG.equals(qName)) {
			header = new Header();
			start_flag = true;
		} else if (RECEIVER_FLAG.equals(qName)) {
			receiver = new Receiver();
			start_flag = true;
		} else if (BODY_FLAG.equals(qName)) {
			body = new Body();
			start_flag = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (start_flag) {
			nodes.put(qName, new String(ch, start, length));
		}
		// ����CDATA��������
		if (BODY_FLAG.equals(qName)) {
			String cdata = new String(ch, start, length);
			// �ӿڹ淶�Ǳ�׼XML�ĵ����ڴ��ڸ�������£���Ҫ�����ڵ�XMLǶ�����ǩ<SndDocumentWrap>�з�����������
			if (cdata.contains("FileData")) {
				cdata = cdata.replace("<XMLData>", "<SndDocumentWrap><XMLData>").replace("</FileData>",
						"</FileData></SndDocumentWrap>");
			}
			SAXParserFactory spf = SAXParserFactory.newInstance();
			if (null == this.header.getMessageType() || "".equals(this.header.getMessageType())) {
				System.out.println("�������Ͳ���ȱʧ,������ֹ...");
			} else {
				ContentParser cp = new ContentParser(this.header.getMessageType());
				try {
					spf.newSAXParser().parse(
							new ByteArrayInputStream(cdata.replaceAll(">\\s*<", "><").getBytes("GB2312")), cp);
					this.body = cp.xml2Obj();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (HEADER_FLAG.equals(qName)) {
			ConvertUtil.xml2Obj(this.header, nodes);
			nodes.clear();
			start_flag = false;
		} else if (RECEIVER_FLAG.equals(qName)) {
			ConvertUtil.xml2Obj(this.receiver, nodes);
			nodes.clear();
			start_flag = false;
		} else if (BODY_FLAG.equals(qName)) {
			// ConvertUtil.xml2Obj(this.body, nodes);
			nodes.clear();
			start_flag = false;
		}
		// temp = "";
	}

	@Override
	public void endDocument() throws SAXException {
		qName = null;
		nodes = null;
	}

	public Message xml2Obj() {
		return new Message(this.header, this.receiver, this.body);
	}
}
