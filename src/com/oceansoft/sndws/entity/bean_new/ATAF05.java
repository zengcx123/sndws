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
public class ATAF05  {

	/**
	 * ����ƽ̨�����
	 */

	private String sectionTasKnum;

	/**
	 * �м�ƽ̨�����
	 */
	private String cityTasKnum;

	/**
	 * ֪ͨ����0������Ҫ�� 1����Ҫ��
	 */

	private int type;

	/**
	 * ������� 0��ͬ�⣬1����ͬ��
	 */

	private int replyResult;
	/**
	 * �������
	 */

	private String replyOpinion;
	/**
	 * ������
	 */

	private String replyHuman;
	/**
	 * ����ʱ��
	 */

	private Date replyTime;
	/**
	 * �������ֹʱ��
	 */

	private Date newEndTime;

	/**
	 * ��ע
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
	@XmlElement(name="TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@XmlElement(name="REPLYRESULT")
	public int getReplyResult() {
		return replyResult;
	}

	public void setReplyResult(int replyResult) {
		this.replyResult = replyResult;
	}
	@XmlElement(name="REPLYOPINION")
	public String getReplyOpinion() {
		return replyOpinion;
	}

	public void setReplyOpinion(String replyOpinion) {
		this.replyOpinion = replyOpinion;
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
	@XmlElement(name="NEWENDTIME")
	public Date getNewEndTime() {
		return newEndTime;
	}

	public void setNewEndTime(Date newEndTime) {
		this.newEndTime = newEndTime;
	}
	
}
