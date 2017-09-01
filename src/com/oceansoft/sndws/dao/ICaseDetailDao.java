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
 * �ļ���:ICaseDetailInfoDao.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:18:29 PM
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

import java.util.List;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean_new.Process;

public interface ICaseDetailDao {
	/**
	 * ���ݹ���ID���ع�����ϸ��Ϣ
	 * 
	 * @param case_id
	 * @return
	 */
	List<CaseDetail> findByCaseId(String caseId);

	/**
	 * ���湤����ϸ��Ϣ
	 * 
	 * @param detail
	 */
	int save(CaseDetail detail);

	/**
	 * ���¹���������Ϣ
	 */
	int update(XtCaseInfo caseInfo);

	int update2(XtCaseInfo caseInfo);
}
