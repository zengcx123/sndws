package com.oceansoft.sndmanager.cooperate.pojo;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseDetail;
import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;




/**
 * �������Webservice����
 * @author wzy
 *
 */
public interface ICaseReceive {
	public boolean setCaseAndWorkflowByScgj(XtCaseInfo xtCaseInfo ,String Userid);

	/**
	 * �������Webservice����	
	 * @param  �ⲿxml�����ַ���
	 * @return �Ƿ���óɹ�
	 */
	public boolean setCase(String xml,String UserId,String Pwd);
		
	/**
	 * �������Webservice����	
	 * @param  XtCaseInfo
	 * @return �Ƿ���óɹ�
	 */
	public boolean setCasebyObject(XtCaseInfo xtCaseInfo ,String Userid);
	
	/**
	 * 0107�ٽ�����������
	 * �������Webservice����	
	 * @param  XtCaseInfo
	 * @return �Ƿ���óɹ�
	 */
	public boolean setCasebyObject(XtCaseInfo xtCaseInfo ,XtCaseDetail xcasedetai,String Userid);
	
	/**
	 * ���������ٽ�����Ϣ���� (ATAF0107)
	 * ���ܣ����������̣������°�����ϸ��
	 * @param xtCaseInfo
	 * @return
	 */
	public boolean setCaseByATAF0107(XtCaseInfo xtCaseInfo,XtCaseDetail detail);
		
}
