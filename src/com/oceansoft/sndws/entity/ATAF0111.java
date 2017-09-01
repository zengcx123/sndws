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
 * �ļ���:ATAF0111.java
 * <p>
 * �����ʱ��: Jun 7, 2013 2:17:44 PM
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
import java.util.Date;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>������ʱ�����Ϣ</b><br>
 * ����ʱ�����������ˣ�ͬ������ӳ�ʱʱ�ޣ���ͬ�ⲻ���ӳ�ʱʱ�ޡ�
 * 
 * @author chenw
 * 
 */
public class ATAF0111 extends Document {
	private Date Delaydate;
	private int Argee_flag;
	private String SH_OPER;
	private Date SH_TIME;

	@Override
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	public Date getDelaydate() {
		return Delaydate;
	}

	public void setDelaydate(Date delaydate) {
		Delaydate = delaydate;
	}

	public int getArgee_flag() {
		return Argee_flag;
	}

	public void setArgee_flag(int argee_flag) {
		Argee_flag = argee_flag;
	}

	public String getSH_OPER() {
		return SH_OPER;
	}

	public void setSH_OPER(String sH_OPER) {
		SH_OPER = sH_OPER;
	}

	public Date getSH_TIME() {
		return SH_TIME;
	}

	public void setSH_TIME(Date sH_TIME) {
		SH_TIME = sH_TIME;
	}
}
