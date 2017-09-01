package com.oceansoft.sndws.entity.bean_new;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * ������ɲ�������
 * @author liyang
 *
 */
public class CaseOperatonDetail {
	
	/**����ƽ̨�����**/
	private String sectionTaskNum;
	
	/**�м�ƽ̨�����**/
	private String cityTaskNum;
	
	/**�������Ҫ��**/
	private String request;
	
	/**�������ʱ��**/
	private Double timeLimit;
	
	/**���������**/
	private String dispatchHuman;
	
	/**��������ϵ��ʽ**/
	private String dispatchHumanTel;
	
	/**�������ʱ��**/
	private Date dispatchTime;
	
	/**�����ֹʱ��**/
	private Date endTime;
	
	/**�����ٽ���/ת�������**/
	private String acceptopinion;
	
	/**�ط����**/
	private String returnvisitopinion;
	
	/**�����**/
	private String satisfactionlevel;
	
	/**��ע**/
	private String memo;
	
	/**��������**/
	private List<Attachment_New> Attachment;
			
	/**2.2.14 ����/���б���רҵ���Ű������  �ĵ��汾��1.6**/
	private List<Process> Process;
	
	private Date refusedeadline;

	private String archivecond;

	@XmlElement(name="ARCHIVECOND")
	public String getArchivecond() {
		return archivecond;
	}

	public void setArchivecond(String archivecond) {
		this.archivecond = archivecond;
	}

	@XmlElement(name="REFUSEDEADLINE")
	public Date getRefusedeadline() {
		return refusedeadline;
	}

	public void setRefusedeadline(Date refusedeadline) {
		this.refusedeadline = refusedeadline;
	}

	public CaseOperatonDetail() {
		
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
	@XmlElement(name="REQUEST")
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	@XmlElement(name="TIMELIMIT")
	public Double getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Double timeLimit) {
		this.timeLimit = timeLimit;
	}
	@XmlElement(name="DISPATCHHUMAN")
	public String getDispatchHuman() {
		return dispatchHuman;
	}

	public void setDispatchHuman(String dispatchHuman) {
		this.dispatchHuman = dispatchHuman;
	}
	@XmlElement(name="DISPATCHHUMANTEL")
	public String getDispatchHumanTel() {
		return dispatchHumanTel;
	}

	public void setDispatchHumanTel(String dispatchHumanTel) {
		this.dispatchHumanTel = dispatchHumanTel;
	}
	@XmlElement(name="DISPATCHTIME")
	public Date getDispatchTime() {
		return dispatchTime;
	}

	public void setDispatchTime(Date dispatchTime) {
		this.dispatchTime = dispatchTime;
	}
	@XmlElement(name="MEMO")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	@XmlElementWrapper(name="ATTACHMENT")
	@XmlElement(name="ITEM")
	public List<Attachment_New> getAttachment() {
		return Attachment;
	}

	public void setAttachment(List<Attachment_New> attachment) {
		Attachment = attachment;
	}
	@XmlElement(name="ENDTIME")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@XmlElement(name="ACCEPTOPINION")
	public String getAcceptopinion() {
		return acceptopinion;
	}
	public void setAcceptopinion(String acceptopinion) {
		this.acceptopinion = acceptopinion;
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
	@XmlElementWrapper(name="PROCESS")
	@XmlElement(name="ITEM")
	public List<Process> getProcess() {
		return Process;
	}
	public void setProcess(List<Process> process) {
		Process = process;
	}
	
	
	
}
