package com.oceansoft.sndws.entity.bean;

import java.util.Date;

/**
 * add by yixin 增加一个taskinfo实体类，对应数据库中taskinfo表
 * @author Administrator
 *
 */
public class TaskInfo {
	private String taskId;
	private String taskName;
	private String caseId;
	private String taskType;
	private String taskStatus;
	private String assigner;
	private String assignDept;
	private String responsor;
	private String responsibleDept;
	private String exeucutors;
	private String exeucutDept;
	private Date assignTime;
	private Date startTime;
	private Date endTime;
	private String memo;
	private Long responseLimit;
	private Date disposalStartTime;
	private Date disposalDeadline;
	private String disposalReqDesc;
	private String disposalWayDesc;
	private String attachList;
	private Date lastModifyDate;
	private Date recordTime;
	private String auditor12345;
	private Date audit12345Time;
	private String audit12345Desc;
	private String audit12345Dept;
	private String reportor;
	private Date reportTime;
	private String reportDesc;
	private String reportDept;
	private String currentDelay;
	private String delayType;
	private Date audit12345Endtime;
	private String isdispatch;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getAssigner() {
		return assigner;
	}
	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}
	public String getAssignDept() {
		return assignDept;
	}
	public void setAssignDept(String assignDept) {
		this.assignDept = assignDept;
	}
	public String getResponsor() {
		return responsor;
	}
	public void setResponsor(String responsor) {
		this.responsor = responsor;
	}
	public String getResponsibleDept() {
		return responsibleDept;
	}
	public void setResponsibleDept(String responsibleDept) {
		this.responsibleDept = responsibleDept;
	}
	public String getExeucutors() {
		return exeucutors;
	}
	public void setExeucutors(String exeucutors) {
		this.exeucutors = exeucutors;
	}
	public String getExeucutDept() {
		return exeucutDept;
	}
	public void setExeucutDept(String exeucutDept) {
		this.exeucutDept = exeucutDept;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getResponseLimit() {
		return responseLimit;
	}
	public void setResponseLimit(Long responseLimit) {
		this.responseLimit = responseLimit;
	}
	public Date getDisposalStartTime() {
		return disposalStartTime;
	}
	public void setDisposalStartTime(Date disposalStartTime) {
		this.disposalStartTime = disposalStartTime;
	}
	public Date getDisposalDeadline() {
		return disposalDeadline;
	}
	public void setDisposalDeadline(Date disposalDeadline) {
		this.disposalDeadline = disposalDeadline;
	}
	public String getDisposalReqDesc() {
		return disposalReqDesc;
	}
	public void setDisposalReqDesc(String disposalReqDesc) {
		this.disposalReqDesc = disposalReqDesc;
	}
	public String getDisposalWayDesc() {
		return disposalWayDesc;
	}
	public void setDisposalWayDesc(String disposalWayDesc) {
		this.disposalWayDesc = disposalWayDesc;
	}
	public String getAttachList() {
		return attachList;
	}
	public void setAttachList(String attachList) {
		this.attachList = attachList;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public String getAuditor12345() {
		return auditor12345;
	}
	public void setAuditor12345(String auditor12345) {
		this.auditor12345 = auditor12345;
	}
	public Date getAudit12345Time() {
		return audit12345Time;
	}
	public void setAudit12345Time(Date audit12345Time) {
		this.audit12345Time = audit12345Time;
	}
	public String getAudit12345Desc() {
		return audit12345Desc;
	}
	public void setAudit12345Desc(String audit12345Desc) {
		this.audit12345Desc = audit12345Desc;
	}
	public String getAudit12345Dept() {
		return audit12345Dept;
	}
	public void setAudit12345Dept(String audit12345Dept) {
		this.audit12345Dept = audit12345Dept;
	}
	public String getReportor() {
		return reportor;
	}
	public void setReportor(String reportor) {
		this.reportor = reportor;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public String getReportDesc() {
		return reportDesc;
	}
	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}
	public String getReportDept() {
		return reportDept;
	}
	public void setReportDept(String reportDept) {
		this.reportDept = reportDept;
	}
	public String getCurrentDelay() {
		return currentDelay;
	}
	public void setCurrentDelay(String currentDelay) {
		this.currentDelay = currentDelay;
	}
	public String getDelayType() {
		return delayType;
	}
	public void setDelayType(String delayType) {
		this.delayType = delayType;
	}
	public Date getAudit12345Endtime() {
		return audit12345Endtime;
	}
	public void setAudit12345Endtime(Date audit12345Endtime) {
		this.audit12345Endtime = audit12345Endtime;
	}
	public String getIsdispatch() {
		return isdispatch;
	}
	public void setIsdispatch(String isdispatch) {
		this.isdispatch = isdispatch;
	}
	
	
	
	
	
}
