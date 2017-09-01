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
 * 文件名:CaseDetail.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:46:17 PM
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
package com.oceansoft.sndws.entity.bean;

import java.util.Date;

/**
 * 
 * @author chenw
 * 
 */
public class CaseDetail {
	private String id;
	/**
	 *案件号 
	 */
	private String case_id;
	private String case_status;
	private Date create_time;
	private String operator;
	private String acceptors;
	private String accept_org;
	private String attach_list;
	/**
	 *备注 
	 */
	private String disposal_info;
	private String disposal_result;
	private Date end_time;
	private Date exp_time;
	private int exp_number;
	private String exp_char;
	private String ref_no;
	private String note;
	/**
	 * 用于更新案件状态用
	 */
	private String eventDesc;
	/**
	 * 回访意见
	 */
	private String returnvisitopinion;
	/**
	 * 用于更新案件满意度
	 */
	private String satisfactionlevel;

	//违建结案方式
	private String recanalyse;

	//通知类型编码1：转交办
	private String noticetype;

	public String getNoticetype() {
		return noticetype;
	}

	public void setNoticetype(String noticetype) {
		this.noticetype = noticetype;
	}

	public String getRecanalyse() {
		return recanalyse;
	}

	public void setRecanalyse(String recanalyse) {
		this.recanalyse = recanalyse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCase_id() {
		return case_id;
	}

	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}

	public String getCase_status() {
		return case_status;
	}

	public void setCase_status(String case_status) {
		this.case_status = case_status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAcceptors() {
		return acceptors;
	}

	public void setAcceptors(String acceptors) {
		this.acceptors = acceptors;
	}

	public String getAccept_org() {
		return accept_org;
	}

	public void setAccept_org(String accept_org) {
		this.accept_org = accept_org;
	}

	public String getAttach_list() {
		return attach_list;
	}

	public void setAttach_list(String attach_list) {
		this.attach_list = attach_list;
	}

	public String getDisposal_info() {
		return disposal_info;
	}

	public void setDisposal_info(String disposal_info) {
		this.disposal_info = disposal_info;
	}

	public String getDisposal_result() {
		return disposal_result;
	}

	public void setDisposal_result(String disposal_result) {
		this.disposal_result = disposal_result;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Date getExp_time() {
		return exp_time;
	}

	public void setExp_time(Date exp_time) {
		this.exp_time = exp_time;
	}

	public int getExp_number() {
		return exp_number;
	}

	public void setExp_number(int exp_number) {
		this.exp_number = exp_number;
	}

	public String getExp_char() {
		return exp_char;
	}

	public void setExp_char(String exp_char) {
		this.exp_char = exp_char;
	}

	public String getRef_no() {
		return ref_no;
	}

	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setSatisfactionlevel(String satisfactionlevel) {
		this.satisfactionlevel = satisfactionlevel;
	}

	public String getSatisfactionlevel() {
		return satisfactionlevel;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public String getReturnvisitopinion() {
		return returnvisitopinion;
	}

	public void setReturnvisitopinion(String returnvisitopinion) {
		this.returnvisitopinion = returnvisitopinion;
	}

	
}
