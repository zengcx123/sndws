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
 * 文件名:ClientUtil.java
 * <p>
 * 类产生时间: Jun 7, 2013 5:08:11 PM
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
package com.oceansoft.sndws.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.client.Client;

public class ClientUtil {;

   //private static final String URL ="http://10.44.66.135:4222/websnd/snd/caseReceive.ws";
  // private static final String URL ="http://localhost:7071/sndws/services/processMessage?wsdl";
	//private static final String URL ="http://localhost:9080/sndws/services/exchange?wsdl";
	//	private static final String URL = "http://10.44.66.135:9080/sndws/services/exchange?wsdl";
   private static final String URL ="http://10.32.251.206:7003/webapp/services/DTIService?wsdl";
	private static Client client;
	private static ClientUtil INSTANCE = new ClientUtil();

	private ClientUtil() {
		try {
			client = new Client(new URL(URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ClientUtil getInstance() {
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public <T> T invoke(Class<T> resultType, String methodName, Object... params) throws Exception {
		return (T) client.invoke(methodName, params)[0];
	}
	
	public void saveXmlBackUp(String xml, String fileName, String type) {
		// TODO:部署前在D盘目录建立scgjATAF_backup/文件夹
		File f = new File("D:/scgjATAF_/" + type + "/" + fileName
				+ ".xml");
		try {
			OutputStream ops = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(ops);
			ops.write(xml.getBytes());
			ops.flush();
			ops.close();
			bos.flush();
			bos.close();
			//logger.info("===>保存向市城管局发送的" + type + "工单成功,文件为D:/scgjATAF_backup/"
			//		+ type + "/" + fileName + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("===>保存向市城管局发送的" + type + "工单：" + f.getName() + "出错",
			//		e);
		}
	}
}
