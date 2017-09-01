/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：中国苏州科技城青山路1号
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: 苏州公安统一用户管理平台1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:Message.java
 * <p>
 * 类产生时间: Jun 6, 2013 1:57:22 PM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * 所在组 : 苏州公安统一用户管理平台
 * <p>
 * 所在部门: 电信/国土——技术二部
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
 * 消息封装类
 * 
 * @author chenw
 * 
 */
public class Message {
	private static final String MSG_DECLARE = "<PantheonMessage><PantheonTransport>消息传输方面的信息（扩展时使用）</PantheonTransport>";
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
	 * 将接收到的XML文件转换为Message对象
	 * 
	 * @param xml
	 *            字符串型XML文档
	 * @return com.oceansoft.sndws.casemgr.entity.base.Message实体对象
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
	 * 将com.oceansoft.sndws.casemgr.entity.base.Message对象转换为XML字符串
	 * 
	 * @return XML字串
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
