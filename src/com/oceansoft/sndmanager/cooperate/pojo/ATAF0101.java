package com.oceansoft.sndmanager.cooperate.pojo;

import java.util.Date;

public class ATAF0101 {
	
	private String guid;
	
	private String flowid;
	
	private String processprocedure;
	
	private Date processtime;
	
	private String SecondDepartment;
	
	private String multiparous;
	
	private String pstate;
	
	private String auditingleader;
	
	private String flag;

	/**
	 * @param 主键,唯一 对应xt_caseInfo 的note字段
	 */
	public String getGuid() {
		return guid;
	}

	
	/**
	 * @param 主键,唯一 对应xt_caseInfo 的note字段
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * @param 工单流水号 对应xt_caseInfo的EXT_CHAR字段
	 */
	public String getFlowid() {
		return flowid;
	}
	
	/**
	 * @param 工单流水号 对应xt_caseInfo的EXT_CHAR字段
	 */
	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}

	/**
	 * @param 处理内容
	 */
	public String getProcessprocedure() {
		return processprocedure;
	}

	
	/**
	 * @param 处理内容
	 */
	public void setProcessprocedure(String processprocedure) {
		this.processprocedure = processprocedure;
	}

	
	/**
	 * @param 处理时间
	 */
	public Date getProcesstime() {
		return processtime;
	}

	
	/**
	 * @param 处理时间
	 */
	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
	}

	
	/**
	 * @param 经办部门
	 */
	public String getSecondDepartment() {
		return SecondDepartment;
	}

	

	/**
	 * @param 经办部门
	 */
	public void setSecondDepartment(String secondDepartment) {
		SecondDepartment = secondDepartment;
	}

	/**
	 * @param 经办人
	 */
	public String getMultiparous() {
		return multiparous;
	}
	/**
	 * @param 经办人
	 */
	public void setMultiparous(String multiparous) {
		this.multiparous = multiparous;
	}

	
	/**
	 * @param 工单状态
	 */
	public String getPstate() {
		return pstate;
	}

	
	/**
	 * @param 工单状态
	 */
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	
	/**
	 * @param 审核领导
	 */
	public String getAuditingleader() {
		return auditingleader;
	}

	
	/**
	 * @param 审核领导
	 */
	public void setAuditingleader(String auditingleader) {
		this.auditingleader = auditingleader;
	}

	
	/**
	 * @param 默认为0,读取后修改为1
	 */
	public String getFlag() {
		return flag;
	}

	
	/**
	 * @param 默认为0,读取后修改为1
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	

}
