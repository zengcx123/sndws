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
	 * @param ����,Ψһ ��Ӧxt_caseInfo ��note�ֶ�
	 */
	public String getGuid() {
		return guid;
	}

	
	/**
	 * @param ����,Ψһ ��Ӧxt_caseInfo ��note�ֶ�
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * @param ������ˮ�� ��Ӧxt_caseInfo��EXT_CHAR�ֶ�
	 */
	public String getFlowid() {
		return flowid;
	}
	
	/**
	 * @param ������ˮ�� ��Ӧxt_caseInfo��EXT_CHAR�ֶ�
	 */
	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}

	/**
	 * @param ��������
	 */
	public String getProcessprocedure() {
		return processprocedure;
	}

	
	/**
	 * @param ��������
	 */
	public void setProcessprocedure(String processprocedure) {
		this.processprocedure = processprocedure;
	}

	
	/**
	 * @param ����ʱ��
	 */
	public Date getProcesstime() {
		return processtime;
	}

	
	/**
	 * @param ����ʱ��
	 */
	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
	}

	
	/**
	 * @param ���첿��
	 */
	public String getSecondDepartment() {
		return SecondDepartment;
	}

	

	/**
	 * @param ���첿��
	 */
	public void setSecondDepartment(String secondDepartment) {
		SecondDepartment = secondDepartment;
	}

	/**
	 * @param ������
	 */
	public String getMultiparous() {
		return multiparous;
	}
	/**
	 * @param ������
	 */
	public void setMultiparous(String multiparous) {
		this.multiparous = multiparous;
	}

	
	/**
	 * @param ����״̬
	 */
	public String getPstate() {
		return pstate;
	}

	
	/**
	 * @param ����״̬
	 */
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	
	/**
	 * @param ����쵼
	 */
	public String getAuditingleader() {
		return auditingleader;
	}

	
	/**
	 * @param ����쵼
	 */
	public void setAuditingleader(String auditingleader) {
		this.auditingleader = auditingleader;
	}

	
	/**
	 * @param Ĭ��Ϊ0,��ȡ���޸�Ϊ1
	 */
	public String getFlag() {
		return flag;
	}

	
	/**
	 * @param Ĭ��Ϊ0,��ȡ���޸�Ϊ1
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	

}
