package com.oceansoft.sndws.entity.bean_new;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

/**
 * 案件主单类
 * @author liyang
 *
 */
public class CaseMain {

	/**区级平台任务号**/
	private String sectionTaskNum;
	
	/**市级平台任务号**/
	private String cityTaskNum;
	
	/**问题来源编号**/
	private String eventSrcCode;
	
	/**问题来源名称**/
	private String  eventSrcName;
	
	/**问题类型编号**/
	private String eventTypeCode;
	
	/**问题类型名称**/
	private String eventTypeName;
	
	/**大类编号**/
	private String mainTypeCode;
	
	/**大类名称**/
	private String mainTypeName;
	
	/**小类编号**/
	private String subTypeCode;
	
	/**小类名称**/
	private String subTypeName;
	
	/**立案条件编号**/
	private String newinstcondCode;
		
	/**所属城区编号**/
	private String districtCode;
	
	/**所属城区名称**/
	private String districtName;
	
	/**所属街道编号**/
	private String streetCode;
	
	/**所属街道名称**/
	private String streetName;
	
	/**所属社区编号**/
	private String communityCode;
	
	/**所属社区名称**/
	private String communityName;
	
	/**地图定位信息X**/
	private Double coordinateX;
	
	/**地图定位信息Y**/
	private Double coordinateY;
	
	/**位置说明**/
	private String address;
	
	/**问题描述**/
	private String eventdesc;
	
	/**登记时间**/
	private Date registTime;
	
	/**上报监督员姓名**/
	private String patrolName;
	
	/**上报监督员电话**/
	private String patrolTel;
	
	/**回访标识**/
	private int returnVisitFlag;
	
	/**紧急程度**/
	private int urgentLevel;
	
	/**2小时内回复标识**/
	private int replyin2HoursFlag;
	
	/**锁单标识**/
	private int lockedFlag;
	
	public CaseMain() {
		
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
	@XmlElement(name="EVENTSRCCODE")
	public String getEventSrcCode() {
		return eventSrcCode;
	}

	public void setEventSrcCode(String eventSrcCode) {
		this.eventSrcCode = eventSrcCode;
	}
	@XmlElement(name="EVENTTYPECODE")
	public String getEventTypeCode() {
		return eventTypeCode;
	}

	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}
	@XmlElement(name="MAINTYPECODE")
	public String getMainTypeCode() {
		return mainTypeCode;
	}

	public void setMainTypeCode(String mainTypeCode) {
		this.mainTypeCode = mainTypeCode;
	}
	@XmlElement(name="SUBTYPECODE")
	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	@XmlElement(name="NEWINSTCONDCODE")
	public String getNewinstcondCode() {
		return newinstcondCode;
	}

	public void setNewinstcondCode(String newinstcondCode) {
		this.newinstcondCode = newinstcondCode;
	}
	@XmlElement(name="DISTRICTCODE")
	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	@XmlElement(name="STREETCODE")
	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}
	@XmlElement(name="COMMUNITYCODE")
	public String getCommunityCode() {
		return communityCode;
	}

	public void setCommunityCode(String communityCode) {
		this.communityCode = communityCode;
	}
	@XmlElement(name="COORDINATEX")
	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}
	@XmlElement(name="COORDINATEY")
	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}
	@XmlElement(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement(name="EVENTDESC")
	public String getEventdesc() {
		return eventdesc;
	}

	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}
	@XmlElement(name="REGISTTIME")
	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	@XmlElement(name="PATROLNAME")
	public String getPatrolName() {
		return patrolName;
	}

	public void setPatrolName(String patrolName) {
		this.patrolName = patrolName;
	}
	@XmlElement(name="PATROLTEL")
	public String getPatrolTel() {
		return patrolTel;
	}

	public void setPatrolTel(String patrolTel) {
		this.patrolTel = patrolTel;
	}
	@XmlElement(name="RETURNVISITFLAG")
	public int getReturnVisitFlag() {
		return returnVisitFlag;
	}

	public void setReturnVisitFlag(int returnVisitFlag) {
		this.returnVisitFlag = returnVisitFlag;
	}
	@XmlElement(name="URGENTLEVEL")
	public int getUrgentLevel() {
		return urgentLevel;
	}

	public void setUrgentLevel(int urgentLevel) {
		this.urgentLevel = urgentLevel;
	}
	@XmlElement(name="REPLYIN2HOURSFLAG")
	public int getReplyin2HoursFlag() {
		return replyin2HoursFlag;
	}

	public void setReplyin2HoursFlag(int replyin2HoursFlag) {
		this.replyin2HoursFlag = replyin2HoursFlag;
	}
	@XmlElement(name="LOCKEDFLAG")
	public int getLockedFlag() {
		return lockedFlag;
	}

	public void setLockedFlag(int lockedFlag) {
		this.lockedFlag = lockedFlag;
	}
	@XmlElement(name="EVENTSRCNAME")
	public String getEventSrcName() {
		return eventSrcName;
	}
	public void setEventSrcName(String eventSrcName) {
		this.eventSrcName = eventSrcName;
	}
	@XmlElement(name="EVENTTYPENAME")
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	@XmlElement(name="MAINTYPENAME")
	public String getMainTypeName() {
		return mainTypeName;
	}
	public void setMainTypeName(String mainTypeName) {
		this.mainTypeName = mainTypeName;
	}
	@XmlElement(name="SUBTYPENAME")
	public String getSubTypeName() {
		return subTypeName;
	}
	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}
	@XmlElement(name="DISTRICTNAME")
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	@XmlElement(name="STREETNAMEE")
	public String getStreetNamee() {
		return streetName;
	}
	public void setStreetNamee(String streetName) {
		this.streetName = streetName;
	}	
	@XmlElement(name="COMMUNITYNAME")
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	
}
