/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：中国苏州科技城青山路1号
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: 苏州公安统一用户管理平台1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:ATAF0001.java
 * <p>
 * 类产生时间: Jun 6, 2013 1:25:42 PM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * 所在组 : 苏州公安统一用户管理平台
 * <p>
 * 所在部门: 电信/国土——技术二部
 * <p>
 * <p>
 */
package com.oceansoft.sndws.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>中心转交办信息</b><br>
 * 为中心批转业务，转交办给各协同办公单位。该类型有可能发送附件（电子文档）。
 * 
 * @author chenw
 * 
 */
public class ATAF0108 extends Document {
	private String OpSerialNumber;
	private Date AccTime;
	private String KHXM;
	private String KHDH;
	private String LXFS;
	private String Remark;
	private String AcceptMode;
	private String AcceptSource;
	private String AcceptType;
	private String Exigence;
	private String Bound;
	private String SBJLX;
	private String MainEnt;
	private String MinorEnt;
	private String Address;
	private String URBAN;
	private String STREET;
	private String COMMUNITY;
	private String DoorplateNum;
	private String StreetlampNum;
	private String BJContent;
	private String YJJBDW;
	private String EJJBD;
	private String SJJBDW;
	private String SJDW;
	private String AcceptCaseCondition;
	private String SFLA;
	private String DispatchOpinion;
	private Date DisposalTime;
	private String PassCause;
	private Date RefuseOverTime;
	private int SuperviseState;

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	/**
	 * 工单号
	 * 
	 * @return
	 */
	public String getOpSerialNumber() {
		return OpSerialNumber;
	}

	public void setOpSerialNumber(String opSerialNumber) {
		OpSerialNumber = opSerialNumber;
	}

	public Date getAccTime() {
		return AccTime;
	}

	public void setAccTime(Date accTime) {
		AccTime = accTime;
	}

	public String getKHXM() {
		return KHXM;
	}

	public void setKHXM(String kHXM) {
		KHXM = kHXM;
	}

	public String getKHDH() {
		return KHDH;
	}

	public void setKHDH(String kHDH) {
		KHDH = kHDH;
	}

	public String getLXFS() {
		return LXFS;
	}

	public void setLXFS(String lXFS) {
		LXFS = lXFS;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getAcceptMode() {
		return AcceptMode;
	}

	public void setAcceptMode(String acceptMode) {
		AcceptMode = acceptMode;
	}

	public String getAcceptSource() {
		return AcceptSource;
	}

	public void setAcceptSource(String acceptSource) {
		AcceptSource = acceptSource;
	}

	public String getAcceptType() {
		return AcceptType;
	}

	public void setAcceptType(String acceptType) {
		AcceptType = acceptType;
	}

	public String getExigence() {
		return Exigence;
	}

	public void setExigence(String exigence) {
		Exigence = exigence;
	}

	public String getBound() {
		return Bound;
	}

	public void setBound(String bound) {
		Bound = bound;
	}

	public String getSBJLX() {
		return SBJLX;
	}

	public void setSBJLX(String sBJLX) {
		SBJLX = sBJLX;
	}

	public String getMainEnt() {
		return MainEnt;
	}

	public void setMainEnt(String mainEnt) {
		MainEnt = mainEnt;
	}

	public String getMinorEnt() {
		return MinorEnt;
	}

	public void setMinorEnt(String minorEnt) {
		MinorEnt = minorEnt;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getURBAN() {
		return URBAN;
	}

	public void setURBAN(String uRBAN) {
		URBAN = uRBAN;
	}

	public String getSTREET() {
		return STREET;
	}

	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}

	public String getCOMMUNITY() {
		return COMMUNITY;
	}

	public void setCOMMUNITY(String cOMMUNITY) {
		COMMUNITY = cOMMUNITY;
	}

	public String getDoorplateNum() {
		return DoorplateNum;
	}

	public void setDoorplateNum(String doorplateNum) {
		DoorplateNum = doorplateNum;
	}

	public String getStreetlampNum() {
		return StreetlampNum;
	}

	public void setStreetlampNum(String streetlampNum) {
		StreetlampNum = streetlampNum;
	}

	public String getBJContent() {
		return BJContent;
	}

	public void setBJContent(String bJContent) {
		BJContent = bJContent;
	}

	public String getYJJBDW() {
		return YJJBDW;
	}

	public void setYJJBDW(String yJJBDW) {
		YJJBDW = yJJBDW;
	}

	public String getEJJBD() {
		return EJJBD;
	}

	public void setEJJBD(String eJJBD) {
		EJJBD = eJJBD;
	}

	public String getSJJBDW() {
		return SJJBDW;
	}

	public void setSJJBDW(String sJJBDW) {
		SJJBDW = sJJBDW;
	}

	public String getSJDW() {
		return SJDW;
	}

	public void setSJDW(String sJDW) {
		SJDW = sJDW;
	}

	public String getAcceptCaseCondition() {
		return AcceptCaseCondition;
	}

	public void setAcceptCaseCondition(String acceptCaseCondition) {
		AcceptCaseCondition = acceptCaseCondition;
	}

	public String getSFLA() {
		return SFLA;
	}

	public void setSFLA(String sFLA) {
		SFLA = sFLA;
	}

	public String getDispatchOpinion() {
		return DispatchOpinion;
	}

	public void setDispatchOpinion(String dispatchOpinion) {
		DispatchOpinion = dispatchOpinion;
	}

	public Date getDisposalTime() {
		return DisposalTime;
	}

	public void setDisposalTime(Date disposalTime) {
		DisposalTime = disposalTime;
	}

	public String getPassCause() {
		return PassCause;
	}

	public void setPassCause(String passCause) {
		PassCause = passCause;
	}

	public Date getRefuseOverTime() {
		return RefuseOverTime;
	}

	public void setRefuseOverTime(Date refuseOverTime) {
		RefuseOverTime = refuseOverTime;
	}

	public int getSuperviseState() {
		return SuperviseState;
	}

	public void setSuperviseState(int superviseState) {
		SuperviseState = superviseState;
	}
}
