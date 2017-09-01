package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * ��������
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF06  {

	/**
	 * ����ƽ̨�����
	 */
	private String sectionTasKnum;
	/**
	 * �м�ƽ̨�����
	 */
	private String cityTasKnum;

	/**
	 * ��������0������1������
	 */
	private int optType;

	/**
	 * ������
	 */
	private String opThuman;

	/**
	 * ����ʱ��
	 */

	private Date optTime;

	/**
	 * ��ע
	 */

	private String memo;

	
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
	@XmlElement(name="OPTTYPE")
	public int getOptType() {
		return optType;
	}

	public void setOptType(int optType) {
		this.optType = optType;
	}
	@XmlElement(name="OPTHUMAN")
	public String getOpThuman() {
		return opThuman;
	}

	public void setOpThuman(String opThuman) {
		this.opThuman = opThuman;
	}
	@XmlElement(name="OPTTIME")
	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	@XmlElement(name="MEMO")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
