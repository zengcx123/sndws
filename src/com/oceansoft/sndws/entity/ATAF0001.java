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
 * �ļ���:ATAF0001.java
 * <p>
 * �����ʱ��: Jun 6, 2013 1:25:42 PM
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
 * <b>���Ĺ�����ת</b><br>
 * Ϊ������תҵ����ת����Эͬ�칫��λ���������п��ܷ��͸����������ĵ�����
 * 
 * @author chenw
 * 
 */
public class ATAF0001 extends Document {
	private String OpSerialNumber;//������
	private Date AccTime;//����ʱ��
	private String KHXM;//�ͻ�����
	private String KHDH;//�ͻ��绰
	private String LXFS;//��ϵ��ʽ
	private String Remark;//��ע
	private String AcceptMode;//����ʽ
	private String AcceptSource;//������Դ
	private String AcceptType;//��������
	private String Exigence;//�����̶�
	private String Bound;
	private String SBJLX;//�²�������
	private String MainEnt;//����
	private String MinorEnt;//С��
	private String Address;//��ַ
	private String URBAN;
	private String STREET;
	private String COMMUNITY;
	private String DoorplateNum;
	private String StreetlampNum;
	private String BJContent;//��������
	private String YJJBDW;
	private String EJJBD;
	private String SJJBDW;
	private String SJDW;
	private String AcceptCaseCondition;//��������
	private String SFLA;
	private String DispatchOpinion;//��ǲ���
	private Date DisposalTime;//���ý���ʱ��
	private String PassCause;//����ʱ��
	private Date RefuseOverTime;//�ܾ���ʱ����ʱ��
	private int SuperviseState;
	private String SystemVersion;//�����2015��4��17��15:17:55 �гǹܹ��� �¹�����Ҫ������ж� v2 ��ʾ ���ظ���ϵͳ �ӿ�
	//http://58.210.54.170:14380/consdcg/service/SZCGReceiveService?wsdl

	public String obj2Xml() throws IllegalArgumentException, IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}

	/**
	 * ������
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
