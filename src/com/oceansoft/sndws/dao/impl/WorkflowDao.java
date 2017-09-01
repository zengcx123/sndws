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
 * 文件名:WorkflowDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:21:06 PM
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
 * 工作流数据库操作组件实现类<br>
 * 此处代码以后需要重构，将获取工作流编号方式由调用大城管服务改为在此服务应用中独立完成
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
			System.out.println("webservice调用结果"+rt);
			return true;
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		

	}

}
