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
 * 文件名:ATAF0123.java
 * <p>
 * 类产生时间: Jun 7, 2013 2:18:46 PM
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
 * <b>中心填写督办意见信息</b><br>
 * 中心将工单的督办意见发送给协同办公单位
 * 
 * @author chenw
 * 
 */
public class ATAF0123 extends Document {
	private String Dreason;
	private String SH_OPER;
	private Date SH_TIME;

	@Override
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	public String getDreason() {
		return Dreason;
	}

	public void setDreason(String dreason) {
		Dreason = dreason;
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
