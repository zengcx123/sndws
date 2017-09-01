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
 * 文件名:Body.java
 * <p>
 * 类产生时间: Jun 6, 2013 12:49:20 PM
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
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.oceansoft.sndws.converter.IConvert;

/**
 * 文档节点
 * 
 * @author chenw
 * 
 */
public class Body implements IConvert {
	private static final String BODY_START = "<PantheonMessageBody><DATA><UserArea>";
	private static final String DATA_START = "<![CDATA[";
	private static final String DOCUMENT_START = "<XMLData><ATAF><DOCUMENT TYPE=\"INF_PZ\">";
	private static final String DOCUMENT_END = "</DOCUMENT></ATAF></XMLData>";
	private static final String ATTACHMENT_START = "<FileData>";
	private static final String ATTACHMENT_END = "</FileData>";
	private static final String DATA_END = "]]>";
	private static final String BODY_END = "</UserArea></DATA></PantheonMessageBody>";
	private Document document;
	private List<Attachment> attchments;

	public Body() {
		super();
	}

	public Body(Document document) {
		super();
		this.document = document;
	}

	public Body(Document document, List<Attachment> attchments) {
		super();
		this.document = document;
		this.attchments = attchments;
	}

	@SuppressWarnings("unchecked")
	public <T extends Document> T getDocument(Class<T> type) {
		return (T) document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Attachment> getAttchments() {
		return attchments;
	}

	public void setAttchments(List<Attachment> attchments) {
		this.attchments = attchments;
	}

	/**
	 * 组装Body对象为XML
	 */
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		StringBuffer xml = new StringBuffer(BODY_START).append(DATA_START).append(XML_VERSION);
		xml.append(DOCUMENT_START).append(this.document.obj2Xml()).append(DOCUMENT_END);
		if (null != this.attchments && this.attchments.size() > 0) {
			xml.append(ATTACHMENT_START);
			for (Attachment att : this.attchments)
				xml.append(att.obj2Xml());
			xml.append(ATTACHMENT_END);
		}
		xml.append(DATA_END);
		xml.append(BODY_END);
		return xml.toString();
	}
}
