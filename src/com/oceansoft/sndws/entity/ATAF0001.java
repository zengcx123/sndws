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
 * <b>中心工单批转</b><br>
 * 为中心批转业务，批转给各协同办公单位。该类型有可能发送附件（电子文档）。
 * 
 * @author chenw
 * 
 */
public class ATAF0001 extends Document {
	private String OpSerialNumber;//工单号
	private Date AccTime;//受理时间
	private String KHXM;//客户姓名
	private String KHDH;//客户电话
	private String LXFS;//联系方式
	private String Remark;//备注
	private String AcceptMode;//受理方式
	private String AcceptSource;//受理来源
	private String AcceptType;//受理类型
	private String Exigence;//紧急程度
	private String Bound;
	private String SBJLX;//事部件类型
	private String MainEnt;//大类
	private String MinorEnt;//小类
	private String Address;//地址
	private String URBAN;
	private String STREET;
	private String COMMUNITY;
	private String DoorplateNum;
	private String StreetlampNum;
	private String BJContent;//受理内容
	private String YJJBDW;
	private String EJJBD;
	private String SJJBDW;
	private String SJDW;
	private String AcceptCaseCondition;//立案条件
	private String SFLA;
	private String DispatchOpinion;//派遣意见
	private Date DisposalTime;//处置截至时间
	private String PassCause;//处置时限
	private Date RefuseOverTime;//拒绝超时截至时间
	private int SuperviseState;
	private String SystemVersion;//添加于2015年4月17日15:17:55 市城管工单 新工单需要用这个判断 v2 标示 返回给新系统 接口
	//http://58.210.54.170:14380/consdcg/service/SZCGReceiveService?wsdl

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

	public String getSystemVersion() {
		return SystemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		SystemVersion = systemVersion;
	}
	
}
