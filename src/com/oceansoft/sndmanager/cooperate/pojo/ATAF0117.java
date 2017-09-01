/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK1.6
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：苏州新区青山路1号索迪实训基地
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: OCP 1.0
 * <p>
 * 作者: 101202(刘秉元)
 * <p>
 * <p>
 * 文件名: ATAF0117.java
 * <p>
 * 类产生时间:2011-7-26 下午02:36:25
 * <p>
 * 负责人: 101202(刘秉元)
 * <p>
 * 所在组:融合通信产品组
 * <p>
 * 所在部门: 开发一部-技术二部
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
 *         <Guid Type=”TEXT”>数据标识</Guid>
 * 
 *         <FlowCode Type=”TEXT”>工单号</FlowCode>
 * 
 *         <hflag Type=”TEXT”>回访标识</ Dtype >
 * 
 *         <Dreason Type=”TEXT”>申请原因</ Dreason >
 * 
 *         <Ddname Type=”TEXT”>申请部门</ Ddname >
 * 
 *         <Doperator Type=”TEXT”>申请人</ Doperator >
 * 
 *         <Ddate Type=”TEXT”>申请时间</ Ddate >
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
