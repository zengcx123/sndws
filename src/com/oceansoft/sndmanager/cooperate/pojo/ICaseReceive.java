package com.oceansoft.sndmanager.cooperate.pojo;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseDetail;
import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;




/**
 * 问题接受Webservice服务
 * @author wzy
 *
 */
public interface ICaseReceive {
	public boolean setCaseAndWorkflowByScgj(XtCaseInfo xtCaseInfo ,String Userid);

	/**
	 * 问题接受Webservice服务	
	 * @param  外部xml参数字符串
	 * @return 是否调用成功
	 */
	public boolean setCase(String xml,String UserId,String Pwd);
		
	/**
	 * 问题接受Webservice服务	
	 * @param  XtCaseInfo
	 * @return 是否调用成功
	 */
	public boolean setCasebyObject(XtCaseInfo xtCaseInfo ,String Userid);
	
	/**
	 * 0107再交办新增工单
	 * 问题接受Webservice服务	
	 * @param  XtCaseInfo
	 * @return 是否调用成功
	 */
	public boolean setCasebyObject(XtCaseInfo xtCaseInfo ,XtCaseDetail xcasedetai,String Userid);
	
	/**
	 * 便民中心再交办信息发送 (ATAF0107)
	 * 功能：启动新流程，并更新案件主细表
	 * @param xtCaseInfo
	 * @return
	 */
	public boolean setCaseByATAF0107(XtCaseInfo xtCaseInfo,XtCaseDetail detail);
		
}
