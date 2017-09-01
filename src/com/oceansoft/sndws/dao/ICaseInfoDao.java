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
 * �ļ���:ICaseInfoDao.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:18:11 PM
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

import java.util.Map;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.bean.CaseInfo;

public interface ICaseInfoDao {
	/**
	 * ����������Ϣ�����������
	 * 
	 * @param params
	 */
	void save(Map<String, Object> params);

	/**
	 * ���ɰ������
	 * 
	 * @return
	 */
	String getCaseId();

	/**
	 * ��ȡָ�������Ű�����
	 * 
	 * @param caseSN
	 *            ������
	 * @return �Ѵ�������
	 */
	int getTotalNum(String caseSN);

	/**
	 * �����оֵ����ֶμ��ع�����Ϣ
	 * 
	 * @param code
	 *            ����Ψһ���opDigNumGather
	 * @return
	 */
	CaseInfo findByCode(String code);

	/**
	 * �����оֵ����ֶμ��ع�����Ϣ
	 * 
	 * @param code
	 *            ����Ψһ���opDigNumGather
	 * @return
	 */
	public XtCaseInfo findXtCaseInfoByCode(String code);

	/**
	 * ���¹�������ʱ�޼��ܾ�ʱ��
	 * 
	 * @param base
	 */
	int updateTime(CaseInfo base);

	/**
	 * �������������
	 * 
	 * @param caseInfo
	 */
	int updateSatifaction(CaseInfo caseInfo);
	
	/**
	 * ��������
	 * @param caseInfo
	 * @return
	 */
	int updateQues(XtCaseInfo caseInfo);
	
	public int updateStatus(XtCaseInfo caseInfo);
	
	/**
	 * ���´���ʱ��
	 * @param caseInfo
	 * @return
	 */
	int updateExtDate(CaseInfo caseInfo);
	
	/**��ð���״̬**/
	public String getStatus(String SectionTasKnum);
}



