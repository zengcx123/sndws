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
 * 文件名:MsgHeader.java
 * <p>
 * 类产生时间: Jun 6, 2013 12:44:22 PM
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

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.oceansoft.sndws.converter.IConvert;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * 消息头信息
 * 
 * @author chenw
 * 
 */
public class Header implements IConvert {
	private static final String HEADER_START = "<PantheonMessageHeader>";
	private static final String HEADER_END = "</PantheonMessageHeader>";
	private String MessageType;
	private String MessageName;
	private String SourceMessageName;
	private String SenderLDAP;
	private String ApplicationID;
	private String SignSize;
	private String HashSign;
	private String Notes;

	public Header() {
		super();
	}

	public Header(String messageType, String messageName) {
		super();
		MessageType = messageType;
		MessageName = messageName;
	}

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getMessageName() {
		return MessageName;
	}

	public void setMessageName(String messageName) {
		MessageName = messageName;
	}

	public String getSourceMessageName() {
		return SourceMessageName;
	}

	public void setSourceMessageName(String sourceMessageName) {
		SourceMessageName = sourceMessageName;
	}

	public String getSenderLDAP() {
		return SenderLDAP;
	}

	public void setSenderLDAP(String senderLDAP) {
		SenderLDAP = senderLDAP;
	}

	public String getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}

	public String getSignSize() {
		return SignSize;
	}

	public void setSignSize(String signSize) {
		SignSize = signSize;
	}

	public String getHashSign() {
		return HashSign;
	}

	public void setHashSign(String hashSign) {
		HashSign = hashSign;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return HEADER_START.concat(ConvertUtil.obj2Xml(this)).concat(HEADER_END);
	}
}
