package com.oceansoft.sndws.entity.bean_new;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF10 {
	/**
	 * ����ƽ̨�����
	 */
	private   String sectionTasKnum;
	/**
	 * �м�ƽ̨�����
	 */
	private   String cityTasKnum;
	/**
	 * ֪ͨ���ͱ���1��ת����
	 */
	private   String noticeType;
	/**
	 * ������
	 */
	private   String opthuMan;
	/**
	 * ����ʱ��
	 */
	private   Date optTime;
	/**
	 * �������˵��
	 */
	private   String optopinion;
	/**
	 * ��ע
	 */
	private   String memo;

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
	@XmlElement(name="MEMO")
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@XmlElement(name="NOTICETYPE")
	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	@XmlElement(name="OPTHUMAN")
	public String getOpthuMan() {
		return opthuMan;
	}

	public void setOpthuMan(String opthuMan) {
		this.opthuMan = opthuMan;
	}
	@XmlElement(name="OPTTIME")
	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	@XmlElement(name="OPTOPINION")
	public String getOptopinion() {
		return optopinion;
	}

	public void setOptopinion(String optopinion) {
		this.optopinion = optopinion;
	}
}

