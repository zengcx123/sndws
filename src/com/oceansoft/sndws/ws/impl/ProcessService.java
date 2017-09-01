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
 * �ļ���:ReceivingService.java
 * <p>
 * �����ʱ��: Jun 3, 2013 2:14:55 PM
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
package com.oceansoft.sndws.ws.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.processor.Processor0001;
import com.oceansoft.sndws.util.DocumentFactory;
import com.oceansoft.sndws.ws.IProcessService;

@Service
@Transactional
@WebService(serviceName = "exchange", endpointInterface = "com.oceansoft.sndws.ws.IProcessService")
public class ProcessService implements IProcessService {
	 private static Logger logger = Logger.getLogger(ProcessService.class);
	/**
	 * @throws Exception
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Result send(String dataXml) throws Exception {
		saveXml(dataXml, "GB2312");
		Message msg=null;
		try{
			msg = new Message().xml2Obj(dataXml);
		}catch(Exception e){
			logger.error("=============�����гǹܹ�����������==============="+"\r\n"+e);
		}
		Result res = DocumentFactory.getInstance().create(msg).process(msg);
		return res;
	}

	/**
	 * ������յĹ���������
	 * 
	 * @param xml
	 * @param charset
	 */
	public void saveXml(String xml, String... charset) {
		File f = new File(String.format("D:/sndws/backup/%1$s.xml",
				new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date())));
		try {
			OutputStream ops = new FileOutputStream(f);
			if (charset.length > 0 && StringUtils.hasText(charset[0])) {
				ops.write(xml.getBytes(charset[0]));
			} else {
				ops.write(xml.getBytes());
			}
			ops.flush();
			ops.close();
		} catch (Exception e) {
			logger.error("=============�����гǹܹ�����������===============");
			logger.error(e);
		}
	}

	public static InputStream getInputStream(InputStream in) throws IOException {
		PushbackInputStream testin = new PushbackInputStream(in);
		int ch = testin.read();
		if (ch != 0xEF) {
			testin.unread(ch);
		} else if ((ch = testin.read()) != 0xBB) {
			testin.unread(ch);
			testin.unread(0xef);
		} else if ((ch = testin.read()) != 0xBF) {
			throw new IOException("�����UTF-8��ʽ�ļ�");
		}
		return testin;
	}
}
