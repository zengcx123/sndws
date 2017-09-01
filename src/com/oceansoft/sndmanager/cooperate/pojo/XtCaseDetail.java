package com.oceansoft.sndmanager.cooperate.pojo;

import java.util.Date;




/**
 * XtCaseDetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XtCaseDetail implements java.io.Serializable {

	// Fields

	private Long id;

	private XtCaseInfo xtCaseInfo;

	private String caseStatus;

	private Date createTime;

	private String operator;

	private String acceptors;

	private String acceptOrg;

	private String attachList;

	private String disposalInfo;

	private String disposalResult;

	private Date endTime;

	private Date expTime;

	private Double expNumber;

	private String expChar;

	private String refNo;

	private String note;

	private String acceptOrgName;
	
	private String operatorName;
	// Constructors

	public XtCaseDetail(Long id, XtCaseInfo xtCaseInfo, String caseStatus, Date createTime,
			String operator, String acceptors, String acceptOrg, String attachList,
			String disposalInfo, String disposalResult, Date endTime, Date expTime,
			Double expNumber, String expChar, String refNo, String note, String acceptOrgName,
			String operatorName) {
		super();
		this.id = id;
		this.xtCaseInfo = xtCaseInfo;
		this.caseStatus = caseStatus;
		this.createTime = createTime;
		this.operator = operator;
		this.acceptors = acceptors;
		this.acceptOrg = acceptOrg;
		this.attachList = attachList;
		this.disposalInfo = disposalInfo;
		this.disposalResult = disposalResult;
		this.endTime = endTime;
		this.expTime = expTime;
		this.expNumber = expNumber;
		this.expChar = expChar;
		this.refNo = refNo;
		this.note = note;
		this.acceptOrgName = acceptOrgName;
		this.operatorName = operatorName;
	}

	/** default constructor */
	public XtCaseDetail()
	{
	}

	/** minimal constructor */
	public XtCaseDetail(Long id, XtCaseInfo xtCaseInfo, String caseStatus,
			Date createTime, String operator)
	{
		this.id = id;
		this.xtCaseInfo = xtCaseInfo;
		this.caseStatus = caseStatus;
		this.createTime = createTime;
		this.operator = operator;
	}

	/** full constructor */

	// Property accessors

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public XtCaseInfo getXtCaseInfo()
	{
		return this.xtCaseInfo;
	}

	public void setXtCaseInfo(XtCaseInfo xtCaseInfo)
	{
		this.xtCaseInfo = xtCaseInfo;
	}

	public String getCaseStatus()
	{
		return this.caseStatus;
	}

	public void setCaseStatus(String caseStatus)
	{
		this.caseStatus = caseStatus;
	}

	public Date getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public String getOperator()
	{
		return this.operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getAcceptors()
	{
		return this.acceptors;
	}

	public void setAcceptors(String acceptors)
	{
		this.acceptors = acceptors;
	}

	public String getAcceptOrg()
	{
		return this.acceptOrg;
	}

	public void setAcceptOrg(String acceptOrg)
	{
		this.acceptOrg = acceptOrg;
	}

	public String getAttachList()
	{
		return this.attachList;
	}

	public void setAttachList(String attachList)
	{
		this.attachList = attachList;
	}

	public String getDisposalInfo()
	{
		return this.disposalInfo;
	}

	public void setDisposalInfo(String disposalInfo)
	{
		this.disposalInfo = disposalInfo;
	}

	public String getDisposalResult()
	{
		return this.disposalResult;
	}

	public void setDisposalResult(String disposalResult)
	{
		this.disposalResult = disposalResult;
	}

	public Date getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public Date getExpTime()
	{
		return this.expTime;
	}

	public void setExpTime(Date expTime)
	{
		this.expTime = expTime;
	}

	public Double getExpNumber()
	{
		return this.expNumber;
	}

	public void setExpNumber(Double expNumber)
	{
		this.expNumber = expNumber;
	}

	public String getExpChar()
	{
		return this.expChar;
	}

	public void setExpChar(String expChar)
	{
		this.expChar = expChar;
	}

	public String getRefNo()
	{
		return this.refNo;
	}

	public void setRefNo(String refNo)
	{
		this.refNo = refNo;
	}

	public String getNote()
	{
		return this.note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getAcceptOrgName() {
		return acceptOrgName;
	}

	public void setAcceptOrgName(String acceptOrgName) {
		this.acceptOrgName = acceptOrgName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}


}