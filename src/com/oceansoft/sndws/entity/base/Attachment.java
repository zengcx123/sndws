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
 * �ļ���:Attachment.java
 * <p>
 * �����ʱ��: Jun 6, 2013 1:59:18 PM
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

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.oceansoft.sndws.util.ConvertUtil;

/**
 * ������Ϣ��
 * 
 * @author chenw
 * 
 */
public class Attachment {
	private static final String FILE_START = "<File>";
	private static final String FILE_END = "</File>";
	private String FileName;
	private String ContentType;
	private String Content;
	private String Url;

	public Attachment() {
		super();
	}

	public Attachment(String fileName, String contentType, String content ,String url) {
		super();
		FileName = fileName;
		ContentType = contentType;
		Content = content;
		Url=url;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return FILE_START.concat(ConvertUtil.obj2Xml(this)).concat(FILE_END);
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
}
