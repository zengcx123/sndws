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
 * �ļ���:MsgHeader.java
 * <p>
 * �����ʱ��: Jun 6, 2013 12:44:22 PM
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

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.oceansoft.sndws.converter.IConvert;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * ��Ϣͷ��Ϣ
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
