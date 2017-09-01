package com.oceansoft.sndmanager.cooperate.pojo;

import java.util.Calendar;

public class XtCaseInfoAdapter extends XtCaseInfoWeb {

	
	private XtCaseInfo xtCaseInfo;
	public XtCaseInfoAdapter(XtCaseInfo xtCaseInfo)
	{
		this.xtCaseInfo =xtCaseInfo;
		
	}
	@Override
	public String getAttachList() {
		// TODO Auto-generated method stub
		return super.getAttachList();
	}
	@Override
	public String getBgcode() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getBgcode();
	}
	@Override
	public String getCaseBigTypeName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseBigTypeName();
	}
	@Override
	public String getCaseCode() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseCode();
	}
	@Override
	public String getCaseId() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseId();
	}
	@Override
	public String getCaseLevel() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseLevel();
	}
	@Override
	public String getCaseLevelName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseLevelName();
	}
	@Override
	public String getCaseName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseName();
	}
	@Override
	public String getCaseSmallTypeName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseSmallTypeName();
	}
	@Override
	public String getCaseStatus() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseStatus();
	}
	@Override
	public String getCaseStatusName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseStatusName();
	}
	@Override
	public String getCaseType() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseType();
	}
	@Override
	public String getCaseTypeInfo() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseTypeInfo();
	}
	@Override
	public String getCaseTypeName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCaseTypeName();
	}
	@Override
	public Calendar getCloseTime() {
		// TODO Auto-generated method stub
		if(xtCaseInfo.getCloseTime()==null)
			return null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(xtCaseInfo.getCloseTime());
		return ca;
	}
	@Override
	public String getCommunity() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCommunity();
	}
	@Override
	public String getCompNo() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getCompNo();
	}
	@Override
	public String getDemageLevel() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getDemageLevel();
	}
	@Override
	public String getDemageLevelName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getDemageLevelName();
	}
	@Override
	public String getDemageName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getDemageName();
	}
	@Override
	public String getEffRangeDesc() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getEffRangeDesc();
	}
	@Override
	public String getEffRangeLevel() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getEffRangeLevel();
	}
	@Override
	public String getExtChar() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getExtChar();
	}
	@Override
	public Calendar getExtDate() {
		// TODO Auto-generated method stub
		if(xtCaseInfo.getExtDate()==null)
			return null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(xtCaseInfo.getExtDate());
		return ca;
		
	}
	@Override
	public Double getExtNumber() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getExtNumber();
	}
	@Override
	public String getGrid() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getGrid();
	}


	@Override
	public String getLampColor() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getLampColor();
	}
	@Override
	public String getLevelUnit() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getLevelUnit();
	}
	@Override
	public String getLevelUnitName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getLevelUnitName();
	}
	@Override
	public String getNote() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getNote();
	}
	@Override
	public Calendar getOccurTime() {
		// TODO Auto-generated method stub
		if(xtCaseInfo.getOccurTime()==null)
			return null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(xtCaseInfo.getOccurTime());
		return ca;
		
	}
	@Override
	public String getPositionDesc() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getPositionDesc();
	}
	@Override
	public Double getPosX() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getPosX();
	}
	@Override
	public Double getPosY() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getPosY();
	}
	@Override
	public String getQuesChannel() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getQuesChannel();
	}
	@Override
	public String getQuesResource() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getQuesResource();
	}
	@Override
	public String getQuestionChannelName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getQuestionChannelName();
	}
	@Override
	public String getQuestionDesc() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getQuestionDesc();
	}
	@Override
	public String getQuestionResourceName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getQuestionResourceName();
	}
	@Override
	public String getRegionId() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getRegionId();
	}
	@Override
	public String getRegionName() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getRegionName();
	}
	@Override
	public Calendar getRegisterTime() {
		// TODO Auto-generated method stub
			if(xtCaseInfo.getRegisterTime()==null)
			return null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(xtCaseInfo.getRegisterTime());
		return ca;
		
	}
	@Override
	public String getReporter() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getReporter();
	}
	@Override
	public String getReporterInfo() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getReporterInfo();
	}
	@Override
	public Calendar getReportTime() {
		// TODO Auto-generated method stub
		if(xtCaseInfo.getReportTime()==null)
			return null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(xtCaseInfo.getReportTime());
		return ca;
		
	}
	@Override
	public String getStreet() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getStreet();
	}
	@Override
	public String getWorkflowId() {
		// TODO Auto-generated method stub
		return xtCaseInfo.getWorkflowId();
	}
}
