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
 * 文件名:Receiver.java
 * <p>
 * 类产生时间: Jun 6, 2013 12:47:19 PM
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

import org.dom4j.DocumentException;

import com.oceansoft.sndws.converter.IConvert;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * 消息接收人
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
