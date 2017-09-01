package com.oceansoft.sndws.entity.bean_new;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF09 {
	/**
	 * ����ƽ̨�����
	 */
	private   String sectionTasKnum;
	/**
	 * �м�ƽ̨�����
	 */
	private   String cityTasKnum;
	/**
	 * ��������
	 */
	private   String eventDesc;
	/**
	 * �����
	 */
	private   String satisfactionlevel;
	/**
	 * ����ʱ��
	 */
	private   Date updateTime;
	/**
	 * ��ע
	 */
	private   String memo;

	/**������Ƭ**/
	private List<Attachment_New> Attachment;

	@XmlElementWrapper(name="ATTACHMENT")
	@XmlElement(name="ITEM")
	public List<Attachment_New> getAttachment() {
		return Attachment;
	}

	public void setAttachment(List<Attachment_New> attachment) {
		Attachment = attachment;
	}

	@XmlElement(name="SECTIONTASKNUM")
	public String getSectionTasKnum() {
		return sectionTasKnum;
	}
	public void setSectionTasKnum(String sectionTasKnum) {
		this.sectionTasKnum = sectionTasKnum;
	}
	@XmlElement(name="CITYTASKNUM")
	public String getCityTasKnum() {
		return cityTasKnum;
	}
	public void setCityTasKnum(String cityTasKnum) {
		this.cityTasKnum = cityTasKnum;
	}
	@XmlElement(name="EVENTDESC")
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	@XmlElement(name="UPDATETIME")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@XmlElement(name="MEMO")
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setSatisfactionlevel(String satisfactionlevel) {
		this.satisfactionlevel = satisfactionlevel;
	}
	@XmlElement(name="SATISFACTIONLEVEL")
	public String getSatisfactionlevel() {
		return satisfactionlevel;
	}
	
	
	
	
}

