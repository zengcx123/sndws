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
 * 文件名:IWorkflowDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:20:49 PM
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
package com.oceansoft.sndws.dao;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;


public interface IWorkflowDao {

	/**
	 * 获取工作流编号
	 * 
	 * @param caseSource
	 *            案件来源 ，根据不同案件来源启动FileNet相应工作流程
	 * @return
	 * @throws Exception
	 */

	String getWorkFlowId(String... caseSource) throws Exception;
	
	/**
	 * 问题接受
	 */
	
	boolean saveCaseAndWorkflow(XtCaseInfo caseInfo,String Userid);
}
