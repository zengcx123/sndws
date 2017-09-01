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

		saveXml(MessageInfo, "GB2312");// 保存Xml消息到本地
		if (!"02".equals(OperationCode)) {
			// 如果调用接口编号不是02，去掉根节点ROOTMAIN，以便解析
			MessageInfo = MessageInfo.replace("<ROOTMAIN>", "").replace(
					"</ROOTMAIN>", "");
		}
		Result result = new Result();
		if (null != SenderCode && SenderCode.equals("00")) {//市
			if (null != ReceiverCode && ReceiverCode.equals("03")) {//高新区
				//判断接口类型
				if (OperationCode == null || OperationCode.trim().equals("")) {
					MailUti.init("下行接口错误","未定义接口类型编码","");
					result.setReason("未定义接口类型编码");
					return ObjectAndXmlHandle.Object2Xml(result);
				} else {
					if (MessageInfo.equals("")) {
						MailUti.init("下行接口错误","业务信息不存在","");
						result.setReason("业务信息不存在");
						return ObjectAndXmlHandle.Object2Xml(result);
					} else {
						result = processXml(OperationCode, MessageInfo);

						return ObjectAndXmlHandle.Object2Xml(result);
					}
				}
			} else {
				MailUti.init("下行接口错误","接收方平台代码错误不是03","");
				LOGGER.error("接收方平台代码错误不是03");
				result.setReason("接收方平台代码错误");
				return ObjectAndXmlHandle.Object2Xml(result);
			}
		} else {
			MailUti.init("下行接口错误","收方平台代码错误不是00","");
			LOGGER.error("接收方平台代码错误不是00");
			result.setReason("发送方平台代码错误");
			return ObjectAndXmlHandle.Object2Xml(result);
		}

	}

	/**
	 * 备份市城管工单到本地
	 * 
	 * @param xml
	 *            工单数据内容
	 * @param charset
	 *            字符编码
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
			LOGGER.error("=================找不到文件路径=================");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("=================字符编码不正确=================");
		} catch (IOException e) {
			LOGGER.error("=================备份市城管工单出错=================");
		} finally {
			try {
				ops.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 解析Xml数据内容
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
		LOGGER.error("接口类型编码不存在!");
		Result result = new Result(1, "接口类型编码不存在!");
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
		// Result result = new Result(1,"接口类型编码不存在!");
		// return result;
		// }
	}
	// }
}
