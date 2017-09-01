/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ���й����ݿƼ�����ɽ·1��
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: ���ݹ���ͳһ�û�����ƽ̨1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:ATAF0107.java
 * <p>
 * �����ʱ��: Jun 7, 2013 2:17:09 PM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * ������ : ���ݹ���ͳһ�û�����ƽ̨
 * <p>
 * ���ڲ���: ����/����������������
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
 * <b>�����ٽ�����Ϣ</b><br>
 * �ලָ�����Ľ�ҵ����ٽ�����Ϣ���͸����š�
 * 
 * @author chenw
 * 
 */
public class ATAF0107 extends Document {
	
	//2015��8��26��09:49:56�޸� ���ATAF0001
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
	private int SuperviseState;
	private String SystemVersion;//�����2015��4��17��15:17:55 �гǹܹ��� �¹�����Ҫ������ж� v2 ��ʾ ���ظ���ϵͳ �ӿ�

	
	private String PassCause;
	private String CheckContent;
	private String DispatchOpinion;
	private String ReturnVisitContent;
	private Date DisposalTime;
	private Date RefuseOverTime;

	@Override
	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	public String getPassCause() {
		return PassCause;
	}

	public void setPassCause(String passCause) {
		PassCause = passCause;
	}

	public String getCheckContent() {
		return CheckContent;
	}

	public void setCheckContent(String checkContent) {
		CheckContent = checkContent;
	}

	public String getDispatchOpinion() {
		return DispatchOpinion;
	}

	public void setDispatchOpinion(String dispatchOpinion) {
		DispatchOpinion = dispatchOpinion;
	}

	public String getReturnVisitContent() {
		return ReturnVisitContent;
	}

	public void setReturnVisitContent(String returnVisitContent) {
		ReturnVisitContent = returnVisitContent;
	}

	public Date getDisposalTime() {
		return DisposalTime;
	}

	public void setDisposalTime(Date disposalTime) {
		DisposalTime = disposalTime;
	}

	public Date getRefuseOverTime() {
		return RefuseOverTime;
	}

	public void setRefuseOverTime(Date refuseOverTime) {
		RefuseOverTime = refuseOverTime;
	}

	//���ATAF0001������ 2015��8��26��09:52:50 -by fym
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

	public void setKHXM(String khxm) {
		KHXM = khxm;
	}

	public String getKHDH() {
		return KHDH;
	}

	public void setKHDH(String khdh) {
		KHDH = khdh;
	}

	public String getLXFS() {
		return LXFS;
	}

	public void setLXFS(String lxfs) {
		LXFS = lxfs;
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

	public void setSBJLX(String sbjlx) {
		SBJLX = sbjlx;
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

	public void setURBAN(String urban) {
		URBAN = urban;
	}

	public String getSTREET() {
		return STREET;
	}

	public void setSTREET(String street) {
		STREET = street;
	}

	public String getCOMMUNITY() {
		return COMMUNITY;
	}

	public void setCOMMUNITY(String community) {
		COMMUNITY = community;
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

	public void setBJContent(String content) {
		BJContent = content;
	}

	public String getYJJBDW() {
		return YJJBDW;
	}

	public void setYJJBDW(String yjjbdw) {
		YJJBDW = yjjbdw;
	}

	public String getEJJBD() {
		return EJJBD;
	}

	public void setEJJBD(String ejjbd) {
		EJJBD = ejjbd;
	}

	public String getSJJBDW() {
		return SJJBDW;
	}

	public void setSJJBDW(String sjjbdw) {
		SJJBDW = sjjbdw;
	}

	public String getSJDW() {
		return SJDW;
	}

	public void setSJDW(String sjdw) {
		SJDW = sjdw;
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

	public void setSFLA(String sfla) {
		SFLA = sfla;
	}

	public String getSystemVersion() {
		return SystemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		SystemVersion = systemVersion;
	}

	public int getSuperviseState() {
		return SuperviseState;
	}

	public void setSuperviseState(int superviseState) {
		SuperviseState = superviseState;
	}
	
}	
