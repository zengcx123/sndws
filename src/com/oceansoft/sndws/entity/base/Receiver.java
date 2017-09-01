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
 * �ļ���:Receiver.java
 * <p>
 * �����ʱ��: Jun 6, 2013 12:47:19 PM
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

import org.dom4j.DocumentException;

import com.oceansoft.sndws.converter.IConvert;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * ��Ϣ������
 * 
 * @author chenw
 * 
 */
public class Receiver implements IConvert {
	private static final String RECEIVER_START = "<PantheonMessageReceiver><Receiver>";
	private static final String RECEIVER_END = "</Receiver></PantheonMessageReceiver>";
	private String ReceiverLDAP;
	private String ReceiverType;

	public Receiver() {
		super();
	}

	public Receiver(String receiverLDAP, String receiverType) {
		super();
		ReceiverLDAP = receiverLDAP;
		ReceiverType = receiverType;
	}

	public String getReceiverLDAP() {
		return ReceiverLDAP;
	}

	public void setReceiverLDAP(String receiverLDAP) {
		ReceiverLDAP = receiverLDAP;
	}

	public String getReceiverType() {
		return ReceiverType;
	}

	public void setReceiverType(String receiverType) {
		ReceiverType = receiverType;
	}

	public <T> T xml2Obj(String xml, Class<T> type) throws DocumentException {
		return null;
	}

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return RECEIVER_START.concat(ConvertUtil.obj2Xml(this)).concat(RECEIVER_END);
	}
}
