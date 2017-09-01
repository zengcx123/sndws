package com.oceansoft.sndws.entity.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name="Attachment")
public class XtAttachInfo implements java.io.Serializable {

	// Fields
	private String caseId;   // °¸¼þid add by  smc
	
	private String attachId;
	private String aname;
	private String atype;
	private String datatype;
	private Long asize;
	private byte[] acontent;
	private String url;
	private Date createTime;
	private String note;

	// Constructors

	/** default constructor */
	public XtAttachInfo() {
	}

	/** minimal constructor */
	public XtAttachInfo(String attachId) {
		this.attachId = attachId;
	}

	@XmlElement(name="CaseId")
	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public XtAttachInfo(String aname, String atype,
			String datatype, Long asize, byte[] acontent, String url,
			Date createTime, String note) {
		this.aname = aname;
		this.atype = atype;
		this.datatype = datatype;
		this.asize = asize;
		this.acontent = acontent;
		this.url = url;
		this.createTime = createTime;
		this.note = note;
	}

	// Property accessors
	@XmlElement(name="AttachId")
	public String getAttachId() {
		return this.attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}
	@XmlElement(name="Aname")
	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	@XmlElement(name="Atype")
	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}
	@XmlElement(name="Datatype")
	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	@XmlElement(name="Asize")
	public Long getAsize() {
		return this.asize;
	}

	public void setAsize(Long asize) {
		this.asize = asize;
	}
	@XmlElement(name="Acontent")
	public byte[] getAcontent() {
		return this.acontent;
	}

	public void setAcontent(byte[] acontent) {
		this.acontent = acontent;
	}
	@XmlElement(name="Url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@XmlElement(name="CreateTime")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="Note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}