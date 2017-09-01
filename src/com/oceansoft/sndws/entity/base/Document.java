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
 * �ļ���:Document.java
 * <p>
 * �����ʱ��: Jun 7, 2013 10:18:04 AM
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
import java.util.List;

import com.oceansoft.sndws.converter.IConvert;

/**
 * �������ͻ���
 * 
 * @author chenw
 * 
 */
public abstract class Document implements IConvert {
	public abstract String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException;

	/** �оֹ���Ψһ��� */
	private String OpDigNumGather;
	private List<Attachment> attachments;

	/**
	 * 
	 * ҵ�����ֱ�Ż���(����Ψһ��ʶ��12λ����)
	 * @return
	 */
	public String getOpDigNumGather() {
		return OpDigNumGather;
	}

	public void setOpDigNumGather(String opDigNumGather) {
		OpDigNumGather = opDigNumGather;
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
