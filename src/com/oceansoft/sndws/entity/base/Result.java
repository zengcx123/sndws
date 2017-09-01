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
 * 文件名:Result.java
 * <p>
 * 类产生时间: Jun 8, 2013 12:18:05 PM
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

import java.util.Date;
import java.util.UUID;

/**
 * 调用返回消息
 * 
 * @author chenw
 * 
 */
public class Result {
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	/**
	 * 消息Id
	 */
	private String id;
	/**
	 * 消息状态 0：失败 1：成功
	 */
	private int status = 1;
	private String msg;
	private Date time;
	private Throwable exception;

	public Result() {
		this.id = UUID.randomUUID().toString();
		this.time = new Date();
	}

	/**
	 * 此构造初始化状态默认为"成功"<br>
	 * 需要指定结果状态请调用{@link #Result(int, String)}
	 * 
	 * @param msg
	 *            消息体
	 */
	public Result(String msg) {
		this();
		this.status = SUCCESS;
		this.msg = msg;
	}

	/**
	 * 构造消息
	 * 
	 * @param status
	 *            状态
	 * @param msg
	 *            消息
	 */
	public Result(int status, String msg) {
		this();
		this.status = status;
		this.msg = msg;
	}

	public Result(int status, String msg, Throwable exception) {
		this(status, msg);
		this.exception = exception;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 消息生成时间
	 * 
	 * @return
	 */
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * 调用异常，调用成功则为null
	 * 
	 * @return
	 */
	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}
}
