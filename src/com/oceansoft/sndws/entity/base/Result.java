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
 * �ļ���:Result.java
 * <p>
 * �����ʱ��: Jun 8, 2013 12:18:05 PM
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

import java.util.Date;
import java.util.UUID;

/**
 * ���÷�����Ϣ
 * 
 * @author chenw
 * 
 */
public class Result {
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	/**
	 * ��ϢId
	 */
	private String id;
	/**
	 * ��Ϣ״̬ 0��ʧ�� 1���ɹ�
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
	 * �˹����ʼ��״̬Ĭ��Ϊ"�ɹ�"<br>
	 * ��Ҫָ�����״̬�����{@link #Result(int, String)}
	 * 
	 * @param msg
	 *            ��Ϣ��
	 */
	public Result(String msg) {
		this();
		this.status = SUCCESS;
		this.msg = msg;
	}

	/**
	 * ������Ϣ
	 * 
	 * @param status
	 *            ״̬
	 * @param msg
	 *            ��Ϣ
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
	 * ��Ϣ����ʱ��
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
	 * �����쳣�����óɹ���Ϊnull
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
