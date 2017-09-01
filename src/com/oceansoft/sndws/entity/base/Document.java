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
 * 文件名:Document.java
 * <p>
 * 类产生时间: Jun 7, 2013 10:18:04 AM
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
import java.util.List;

import com.oceansoft.sndws.converter.IConvert;

/**
 * 工单类型基类
 * 
 * @author chenw
 * 
 */
public abstract class Document implements IConvert {
	public abstract String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException;

	/** 市局工单唯一编号 */
	private String OpDigNumGather;
	private List<Attachment> attachments;

	/**
	 * 
	 * 业务数字编号汇总(工单唯一标识，12位数字)
	 * @return
	 */
	public String getOpDigNumGather() {
		return OpDigNumGather;
	}

	public void setOpDigNumGather(String opDigNumGather) {
		OpDigNumGather = opDigNumGather;
	}

	/**
	 * 附件
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
