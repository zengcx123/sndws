package com.oceansoft.sndws.entity.bean_new;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ������
 */
@XmlRootElement(name="ITEM")
public class Attachment_New {

	/** �����������Ƶĸ���·�� **/
	private String attachPath;

	/** �������� **/
	private String attachType;

	/** ������չ���ĸ������� **/
	private String attachName;

	public Attachment_New() {

	}

	public Attachment_New(String attachPath, String attachType, String attachName) {
		this.attachPath = attachPath;
		this.attachType = attachType;
		this.attachName = attachName;
	}
	
	@XmlElement(name="ATTACHPATH")
	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	
	@XmlElement(name="ATTACHTYPE")
	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	
	@XmlElement(name="ATTACHNAME")
	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

}
