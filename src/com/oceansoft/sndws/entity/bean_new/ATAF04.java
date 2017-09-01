package com.oceansoft.sndws.entity.bean_new;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * 回退审批
 */
@XmlRootElement(name="CASEOPERATONDETAIL")
public class ATAF04 {
	
	/**区级平台任务号**/
	private String sectionTaskNum;
	
	/**市级平台任务号**/
	private String cityTaskNum;
	
	/**通知类型0：不需要答复 1：需要答复**/
	private int type;
	
	/**审批结果 0：同意，1：不同意**/
	private int replyResult;
	
	/**审批意见**/
	private String replyOpinion;
	
	/**审批人**/
	private String replyHuman;
	
	/**审批时间**/
	private Date replyTime;
	
	/**备注**/
	private String replyMemo;

	public ATAF04() {
		
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

	
	
}
