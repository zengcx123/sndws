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
 * �ļ���:ClientUtil.java
 * <p>
 * �����ʱ��: Jun 7, 2013 5:08:11 PM
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
		// TODO:����ǰ��D��Ŀ¼����scgjATAF_backup/�ļ���
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
			//logger.info("===>�������гǹַܾ��͵�" + type + "�����ɹ�,�ļ�ΪD:/scgjATAF_backup/"
			//		+ type + "/" + fileName + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("===>�������гǹַܾ��͵�" + type + "������" + f.getName() + "����",
			//		e);
		}
	}
}
