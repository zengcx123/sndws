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
 * �ļ���:ATAF0001.java
 * <p>
 * �����ʱ��: Jun 6, 2013 1:25:42 PM
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
 * <b>���Ŵ�����Ϣ</b><br>
 * ���Ž�������Ϣ�������Ѵ����˻� ״̬�µĴ����������ݷ��������ģ���������������轫����ͬʱ���͸�����
 * 
 * @author chenw
 * 
 */
public class ATAF0101 extends Document {
	private String Processprocedure;
	private String Pstate;

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	public String getProcessprocedure() {
		return Processprocedure;
	}

	public void setProcessprocedure(String processprocedure) {
		Processprocedure = processprocedure;
	}

	public String getPstate() {
		return Pstate;
	}

	public void setPstate(String pstate) {
		Pstate = pstate;
	}
}
