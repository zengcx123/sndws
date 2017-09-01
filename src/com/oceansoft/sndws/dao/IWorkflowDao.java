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
 * �ļ���:IWorkflowDao.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:20:49 PM
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
package com.oceansoft.sndws.dao;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;


public interface IWorkflowDao {

	/**
	 * ��ȡ���������
	 * 
	 * @param caseSource
	 *            ������Դ �����ݲ�ͬ������Դ����FileNet��Ӧ��������
	 * @return
	 * @throws Exception
	 */

	String getWorkFlowId(String... caseSource) throws Exception;
	
	/**
	 * �������
	 */
	
	boolean saveCaseAndWorkflow(XtCaseInfo caseInfo,String Userid);
}
