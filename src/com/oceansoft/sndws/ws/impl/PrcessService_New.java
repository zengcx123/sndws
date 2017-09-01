package com.oceansoft.sndws.ws.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import com.oceansoft.sndws.entity.bean_new.*;
import com.oceansoft.sndws.processor_new.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.jaxrpc.ServletEndpointSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oceansoft.sndws.util.MailUti;
import com.oceansoft.sndws.util.ObjectAndXmlHandle;
import com.oceansoft.sndws.ws.IProcessService_New;

@Service
@Transactional
@WebService(serviceName = "processMessage", endpointInterface = "com.oceansoft.sndws.ws.IProcessService_New")
public class PrcessService_New extends ServletEndpointSupport implements
		IProcessService_New {

	private static Logger LOGGER = Logger.getLogger(PrcessService_New.class);
	private ApplicationContext applicationContext;

	@Resource
	Processor02 pr02;
	@Resource
	Processor03 pr03;
	@Resource
	Processor04 pr04;
	@Resource
	Processor05 pr05;
	@Resource
	Processor06 pr06;
	@Resource
	Processor07 pr07;
	@Resource
	Processor09 pr09;
	@Resource
	Processor10 pr10;

	@Override
	protected void onInit() throws ServiceException {
		// TODO Auto-generated method stub
		applicationContext = super.getApplicationContext();
		pr02 = (Processor02) applicationContext.getBean("processor02");
		pr03 = (Processor03) applicationContext.getBean("processor03");
		pr04 = (Processor04) applicationContext.getBean("processor04");
		pr05 = (Processor05) applicationContext.getBean("processor05");
		pr06 = (Processor06) applicationContext.getBean("processor06");
		pr07 = (Processor07) applicationContext.getBean("processor07");
		pr09 = (Processor09) applicationContext.getBean("processor09");
		pr10 = (Processor10) applicationContext.getBean("processor10");
		super.onInit();
	}

	public String processMessage(String SenderCode, String ReceiverCode,
			String OperationCode, String MessageInfo) {

		saveXml(MessageInfo, "GB2312");// ����Xml��Ϣ������
		if (!"02".equals(OperationCode)) {
			// ������ýӿڱ�Ų���02��ȥ�����ڵ�ROOTMAIN���Ա����
			MessageInfo = MessageInfo.replace("<ROOTMAIN>", "").replace(
					"</ROOTMAIN>", "");
		}
		Result result = new Result();
		if (null != SenderCode && SenderCode.equals("00")) {//��
			if (null != ReceiverCode && ReceiverCode.equals("03")) {//������
				//�жϽӿ�����
				if (OperationCode == null || OperationCode.trim().equals("")) {
					MailUti.init("���нӿڴ���","δ����ӿ����ͱ���","");
					result.setReason("δ����ӿ����ͱ���");
					return ObjectAndXmlHandle.Object2Xml(result);
				} else {
					if (MessageInfo.equals("")) {
						MailUti.init("���нӿڴ���","ҵ����Ϣ������","");
						result.setReason("ҵ����Ϣ������");
						return ObjectAndXmlHandle.Object2Xml(result);
					} else {
						result = processXml(OperationCode, MessageInfo);

						return ObjectAndXmlHandle.Object2Xml(result);
					}
				}
			} else {
				MailUti.init("���нӿڴ���","���շ�ƽ̨���������03","");
				LOGGER.error("���շ�ƽ̨���������03");
				result.setReason("���շ�ƽ̨�������");
				return ObjectAndXmlHandle.Object2Xml(result);
			}
		} else {
			MailUti.init("���нӿڴ���","�շ�ƽ̨���������00","");
			LOGGER.error("���շ�ƽ̨���������00");
			result.setReason("���ͷ�ƽ̨�������");
			return ObjectAndXmlHandle.Object2Xml(result);
		}

	}

	/**
	 * �����гǹܹ���������
	 * 
	 * @param xml
	 *            ������������
	 * @param charset
	 *            �ַ�����
	 */
	public void saveXml(String xml, String charset) {
		File file = new File(String.format("D:/sndws/backup2/%1$s.xml",
				new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date())));
		OutputStream ops = null;
		try {
			ops = new FileOutputStream(file);
			if (null != charset && charset.length() > 0) {
				ops.write(xml.getBytes(charset));
			} else {
				ops.write(xml.getBytes());
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("=================�Ҳ����ļ�·��=================");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("=================�ַ����벻��ȷ=================");
		} catch (IOException e) {
			LOGGER.error("=================�����гǹܹ�������=================");
		} finally {
			try {
				ops.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����Xml��������
	 * 
	 * @param OperationCode
	 * @param MessageInfo
	 * @return
	 */
	public Result processXml(String OperationCode, String MessageInfo) {
		int type = Integer.valueOf(OperationCode);
		if (type == 2) {
			ATAF02 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF02.class);
			IProcess prcsObj = pr02;
			return prcsObj.process(atf);
		}
		if (type == 3) {
			ATAF03 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF03.class);
			IProcess prcsObj = pr03;
			return prcsObj.process(atf);
		}
		if (type == 4) {
			ATAF04 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF04.class);
			IProcess prcsObj = pr04;
			return prcsObj.process(atf);
		}
		if (type == 5) {
			ATAF05 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF05.class);
			IProcess prcsObj = pr05;
			return prcsObj.process(atf);
		}
		if (type == 6) {
			ATAF06 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF06.class);
			IProcess prcsObj = pr06;
			return prcsObj.process(atf);
		}
		if (type == 7) {
			ATAF07 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF07.class);
			IProcess prcsObj = pr07;
			return prcsObj.process(atf);
		}
		if (type == 9) {
			ATAF09 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF09.class);
			IProcess prcsObj = pr09;
			return prcsObj.process(atf);
		}
		if (type == 10) {
			ATAF10 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
					ATAF10.class);
			IProcess prcsObj = pr10;
			return prcsObj.process(atf);
		}
		LOGGER.error("�ӿ����ͱ��벻����!");
		Result result = new Result(1, "�ӿ����ͱ��벻����!");
		return result;

		// switch(type){
		// case 2:{
		// ATAF02 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF02.class);
		// IProcess prcsObj = pr02;
		// return prcsObj.process(atf);
		// }
		// case 3:{
		// ATAF03 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF03.class);
		// IProcess prcsObj = pr03;
		// return prcsObj.process(atf);
		// }
		// case 4:{
		// ATAF04 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF04.class);
		// IProcess prcsObj = pr04;
		// return prcsObj.process(atf);
		// }
		// case 5:{
		// ATAF05 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF05.class);
		// IProcess prcsObj = pr05;
		// return prcsObj.process(atf);
		// }
		// case 6:{
		// ATAF06 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF06.class);
		// IProcess prcsObj = pr06;
		// return prcsObj.process(atf);
		// }
		// case 7:{
		// ATAF07 atf = ObjectAndXmlHandle.parseXml2Object(MessageInfo,
		// ATAF07.class);
		// IProcess prcsObj = pr07;
		// return prcsObj.process(atf);
		// }
		// default :{
		// Result result = new Result(1,"�ӿ����ͱ��벻����!");
		// return result;
		// }
	}
	// }
}
