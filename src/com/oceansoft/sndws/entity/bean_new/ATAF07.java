package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * �ط�����
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF07 {

	/**
	 * ����ƽ̨�����
	 */
	private String sectionTasKnum;
	/**
	 * �м�ƽ̨�����
	 */
	private String cityTasKnum;
	/**
	 * �������1����ͬ�⣬2��ͬ��
	 */
	private int replyResult;
	/**
	 * �������˵��
	 */
	private String replyoPinion;
	/**
	 * ������
	 */
	private String replyHuman;
	/**
	 *����ʱ��
	 */
	private Date replyTime;
	/**
	 *��ע
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
