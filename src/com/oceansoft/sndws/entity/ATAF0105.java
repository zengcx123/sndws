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
 * �ļ���:ATAF0105.java
 * <p>
 * �����ʱ��: Jun 7, 2013 2:16:51 PM
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
package com.oceansoft.sndws.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>���Ļط���Ϣ</b> <br>
 * �����ط���ɣ����ط����ݺ�����̶ȷ��������Ŷˡ�
 * 
 * @author chenw
 * 
 */
public class ATAF0105 extends Document {
	private String ReturnVisitContent;
	private String Satisfaction;

	@Override
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	public String getReturnVisitContent() {
		return ReturnVisitContent;
	}

	public void setReturnVisitContent(String returnVisitContent) {
		ReturnVisitContent = returnVisitContent;
	}

	public String getSatisfaction() {
		return Satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		Satisfaction = satisfaction;
	}
}
