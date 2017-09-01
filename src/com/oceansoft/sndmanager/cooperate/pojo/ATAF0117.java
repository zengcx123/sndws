/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK1.6
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ������������ɽ·1������ʵѵ����
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: OCP 1.0
 * <p>
 * ����: 101202(����Ԫ)
 * <p>
 * <p>
 * �ļ���: ATAF0117.java
 * <p>
 * �����ʱ��:2011-7-26 ����02:36:25
 * <p>
 * ������: 101202(����Ԫ)
 * <p>
 * ������:�ں�ͨ�Ų�Ʒ��
 * <p>
 * ���ڲ���: ����һ��-��������
 * <p>
 * <p>
 */
package com.oceansoft.sndmanager.cooperate.pojo;

import java.util.Date;

/**
 * @author liuby <ATAF>
 * 
 *         <DOCUMENT TYPE="INF_HF">
 * 
 *         <Guid Type=��TEXT��>���ݱ�ʶ</Guid>
 * 
 *         <FlowCode Type=��TEXT��>������</FlowCode>
 * 
 *         <hflag Type=��TEXT��>�طñ�ʶ</ Dtype >
 * 
 *         <Dreason Type=��TEXT��>����ԭ��</ Dreason >
 * 
 *         <Ddname Type=��TEXT��>���벿��</ Ddname >
 * 
 *         <Doperator Type=��TEXT��>������</ Doperator >
 * 
 *         <Ddate Type=��TEXT��>����ʱ��</ Ddate >
 * 
 *         </DOCUMENT >
 * 
 *         </ATAF>
 */
public class ATAF0117 {

	private String guid;
	private String flowCode;
	private String hflag;
	private String  dreason;
	private String ddname;
	private String doperator;
	private Date ddate;
	private String type="INF_HF";
	
	public ATAF0117() {
		super();
	}

	public ATAF0117(String guid, String flowCode, String hflag, String dreason,
			String ddname, String doperator, Date ddate) {
		super();
		this.guid = guid;
		this.flowCode = flowCode;
		this.hflag = hflag;
		this.dreason = dreason;
		this.ddname = ddname;
		this.doperator = doperator;
		this.ddate = ddate;
	}
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getFlowCode() {
		return flowCode;
	}
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}
	public String getHflag() {
		return hflag;
	}
	public void setHflag(String hflag) {
		this.hflag = hflag;
	}
	public String getDreason() {
		return dreason;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDreason(String dreason) {
		this.dreason = dreason;
	}
	public String getDdname() {
		return ddname;
	}
	public void setDdname(String ddname) {
		this.ddname = ddname;
	}
	public String getDoperator() {
		return doperator;
	}
	public void setDoperator(String doperator) {
		this.doperator = doperator;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	
	
}
