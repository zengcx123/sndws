package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * �᰸֪ͨ
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF03  {

	/**����ƽ̨�����**/
	private String sectionTaskNum;
	
	/**�м�ƽ̨�����**/
	private String cityTaskNum;
	
	/**�᰸���ͱ���1���᰸2������**/
	private String endCaseType;
	
	/**�᰸��**/
	private String endCaseHuman;
	
	/**�᰸���˵��**/
	private String endCaseOpinion;
	
	/**�᰸ʱ��**/
	private Date endCaseTime;
	
	/**�ط����**/
	private String returnvisitopinion;
	
	/**�����**/
	private String satisfactionlevel;
	
	
	/**��ע**/
	private String memo;

	//Υ���᰸��ʽ
	private String recanalyse;

	@XmlElement(name="RECANALYSE")
	public String getRecanalyse() {
		return recanalyse;
	}

	public void setRecanalyse(String recanalyse) {
		this.recanalyse = recanalyse;
	}

	public ATAF03() {
		
	}
	@XmlElement(name="SECTIONTASKNUM")
	public String getSectionTaskNum() {
		return sectionTaskNum;
	}

	public void setSectionTaskNum(String sectionTaskNum) {
		this.sectionTaskNum = sectionTaskNum;
	}
	@XmlElement(name="CITYTASKNUM")
	public String getCityTaskNum() {
		return cityTaskNum;
	}

	public void setCityTaskNum(String cityTaskNum) {
		this.cityTaskNum = cityTaskNum;
	}
	@XmlElement(name="ENDCASETYPE")
	public String getEndCaseType() {
		return endCaseType;
	}

	public void setEndCaseType(String endCaseType) {
		this.endCaseType = endCaseType;
	}
	@XmlElement(name="ENDCASEHUMAN")
	public String getEndCaseHuman() {
		return endCaseHuman;
	}

	public void setEndCaseHuman(String endCaseHuman) {
		this.endCaseHuman = endCaseHuman;
	}
	@XmlElement(name="ENDCASEOPINION")
	public String getEndCaseOpinion() {
		return endCaseOpinion;
	}

	public void setEndCaseOpinion(String endCaseOpinion) {
		this.endCaseOpinion = endCaseOpinion;
	}
	@XmlElement(name="ENDCASETIME")
	public Date getEndCaseTime() {
		return endCaseTime;
	}

	public void setEndCaseTime(Date endCaseTime) {
		this.endCaseTime = endCaseTime;
	}
	@XmlElement(name="RETURNVISITOPINION")
	public String getReturnvisitopinion() {
		return returnvisitopinion;
	}
	public void setReturnvisitopinion(String returnvisitopinion) {
		this.returnvisitopinion = returnvisitopinion;
	}
	@XmlElement(name="SATISFACTIONLEVEL")
	public String getSatisfactionlevel() {
		return satisfactionlevel;
	}
	public void setSatisfactionlevel(String satisfactionlevel) {
		this.satisfactionlevel = satisfactionlevel;
	}
	@XmlElement(name="MEMO")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	
	
	
}
