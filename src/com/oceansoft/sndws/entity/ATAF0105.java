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
 * 文件名:ATAF0105.java
 * <p>
 * 类产生时间: Jun 7, 2013 2:16:51 PM
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

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>中心回访信息</b> <br>
 * 工单回访完成，将回访内容和满意程度反馈给部门端。
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
