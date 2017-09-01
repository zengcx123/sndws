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
 * 文件名:ATAF0111.java
 * <p>
 * 类产生时间: Jun 7, 2013 2:17:44 PM
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
package com.oceansoft.sndws.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>中心延时审核信息</b><br>
 * 对延时的申请进行审核，同意的增加超时时限，不同意不增加超时时限。
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
