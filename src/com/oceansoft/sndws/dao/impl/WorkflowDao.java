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
 * �ļ���:WorkflowDao.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:21:06 PM
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
package com.oceansoft.sndws.dao.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.IWorkflowDao;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.util.Constant;

/**
 * ���������ݿ�������ʵ����<br>
 * �˴������Ժ���Ҫ�ع�������ȡ��������ŷ�ʽ�ɵ��ô�ǹܷ����Ϊ�ڴ˷���Ӧ���ж������
 * 
 * @author chenw
 * 
 */
public class WorkflowDao implements IWorkflowDao {

	private Client client = null;

	public WorkflowDao(String workflowUrl) {
		try {
			client = new Client(new URL(workflowUrl));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getWorkFlowId(String... caseSource) throws Exception {
		try {
			if (caseSource.length > 0) {
				return client.invoke("launchWorkflowByPDA", caseSource)[0].toString();
			} else {
				return client.invoke("launchWorkflowByPDA", new String[] { "" })[0].toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("generate workflow id failure");
	}

	public boolean saveCaseAndWorkflow(XtCaseInfo caseInfo, String Userid) {
		
		org.codehaus.xfire.service.Service serviceModel = new ObjectServiceFactory()
				.create(com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive.class);
		com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive service;
		try {
			service = (com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive) new XFireProxyFactory()
					.create(serviceModel, Constant.WS_SND);
			boolean rt = service.setCaseAndWorkflowByScgj(caseInfo, Userid);
			System.out.println("webservice���ý��"+rt);
			return true;
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		

	}

}
