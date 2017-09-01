package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * 回访审批
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF07 {

	/**
	 * 区级平台任务号
	 */
	private String sectionTasKnum;
	/**
	 * 市级平台任务号
	 */
	private String cityTasKnum;
	/**
	 * 审批结果1：不同意，2：同意
	 */
	private int replyResult;
	/**
	 * 审批意见说明
	 */
	private String replyoPinion;
	/**
	 * 审批人
	 */
	private String replyHuman;
	/**
	 *审批时间
	 */
	private Date replyTime;
	/**
	 *备注
	 */
	private String replyMemo;

	
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
	@XmlElement(name="REPLYRESULT")
	public int getReplyResult() {
		return replyResult;
	}

	public void setReplyResult(int replyResult) {
		this.replyResult = replyResult;
	}
	@XmlElement(name="REPLYOPINION")
	public String getReplyoPinion() {
		return replyoPinion;
	}

	public void setReplyoPinion(String replyoPinion) {
		this.replyoPinion = replyoPinion;
	}
	@XmlElement(name="REPLYHUMAN")
	public String getReplyHuman() {
		return replyHuman;
	}

	public void setReplyHuman(String replyHuman) {
		this.replyHuman = replyHuman;
	}
	@XmlElement(name="REPLYTIME")
	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	@XmlElement(name="REPLYMEMO")
	public String getReplyMemo() {
		return replyMemo;
	}

	public void setReplyMemo(String replyMemo) {
		this.replyMemo = replyMemo;
	}

}
