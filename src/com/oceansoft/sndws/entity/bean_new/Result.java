package com.oceansoft.sndws.entity.bean_new;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RESULT")
public class Result {

	/**0：成功，1：失败，默认为失败**/
	private int resultValue = 1;
	
	/**失败原因**/
	private String reason;
	
	public Result() {
	}
	
	public Result(int resultValue, String reason) {
		super();
		this.resultValue = resultValue;
		this.reason = reason;
	}

	@XmlElement(name="RESULTVALUE")
	public int getResultValue() {
		return resultValue;
	}

	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}

	@XmlElement(name="REASON")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
