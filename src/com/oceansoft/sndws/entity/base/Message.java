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
 * �ļ���:Message.java
 * <p>
 * �����ʱ��: Jun 6, 2013 1:57:22 PM
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
package com.oceansoft.sndws.entity.base;

import static com.oceansoft.sndws.util.Constant.XML_VERSION;

import java.beans.IntrospectionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import com.oceansoft.sndws.converter.MessageParser;

/**
 * ��Ϣ��װ��
 * 
 * @author chenw
 * 
 */
public class Message {
	private static final String MSG_DECLARE = "<PantheonMessage><PantheonTransport>��Ϣ���䷽�����Ϣ����չʱʹ�ã�</PantheonTransport>";
	private static final String MSG_END = "</PantheonMessage>";
	private Receiver receiver;
	private Header header;
	private Body body;

	public Message() {
		super();
	}

	public Message(Header header, Receiver receiver, Body body) {
		super();
		this.header = header;
		this.receiver = receiver;
		this.body = body;
	}

	/**
	 * �����յ���XML�ļ�ת��ΪMessage����
	 * 
	 * @param xml
	 *            �ַ�����XML�ĵ�
	 * @return com.oceansoft.sndws.casemgr.entity.base.Messageʵ�����
	 * @throws DocumentException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Message xml2Obj(String xml) throws DocumentException, ParserConfigurationException, SAXException,
			IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		MessageParser mp = new MessageParser();
		spf.newSAXParser().parse(new ByteArrayInputStream(xml.replaceAll(">\\s*<", "><").replaceAll("(\\t\\r\\n)", "").getBytes("GB2312")), mp);
		return mp.xml2Obj();
	}

	/**
	 * ��com.oceansoft.sndws.casemgr.entity.base.Message����ת��ΪXML�ַ���
	 * 
	 * @return XML�ִ�
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 */
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		StringBuffer sb = new StringBuffer(XML_VERSION);
		sb.append(MSG_DECLARE);
		sb.append(header.obj2Xml());
		sb.append(receiver.obj2Xml());
		sb.append(body.obj2Xml());
		sb.append(MSG_END);
		return sb.toString();
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
}
