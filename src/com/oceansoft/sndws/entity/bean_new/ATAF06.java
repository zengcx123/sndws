package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * 锁定解锁
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF06  {

	/**
	 * 区级平台任务号
	 */
	private String sectionTasKnum;
	/**
	 * 市级平台任务号
	 */
	private String cityTasKnum;

	/**
	 * 操作类型0：解锁1：锁定
	 */
	private int optType;

	/**
	 * 操作人
	 */
	private String opThuman;

	/**
	 * 操作时间
	 */

	private Date optTime;

	/**
	 * 备注
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
