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
 * �ļ���:CaseInfo.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:46:08 PM
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
package com.oceansoft.sndws.entity.bean;

import java.util.Date;

public class CaseInfo {
	private String case_id;
	/**
	 * �������
	 */ 
	private String case_code;
	private String ques_resource;
	private String ques_channel;
	private String case_type;
	private String case_name;
	private String reporter;
	private Date report_time;
	private String reporter_info;
	private String question_desc;	
	private Date occur_time;
	private Date register_time;
	private Date close_time;
	private String case_status;
	private String eff_range_desc;
	private String eff_range_level;
	private String level_unit;
	private String demage_level;
	private String comp_no;
	private String position_desc;
	private float pos_x;
	private float pos_y;
	private String bgcode;
	private String region_id;
	private String attach_list;
	private String workflow_id;
	private String note;
	private String case_level;
	private String ext_char;
	private int ext_number = 0;
	private Date ext_date;
	private String is_cuiban;
	/**
	 * ����� 
	 */
	private String satisfaction_degree;
	private String reporter_desc;
	private Date refuse_otime;
	private String org_list;
	private String withdrawtrace;
	private String curr_org;
	private String isdispatch;
	/**
	 * �ط���� 2017��1.6�汾����
	 */
	private String  returnvisitopinion;
	/**
	 * ����� 2017��1.6�汾���� 
	 */
	private String satisfactionlevel;
	//add by yixin ����ʵ����û��applycount����ֶΣ����Խ�applycountע�͵�
	//private String applycount;
	

//	public String getApplycount() {
//		return applycount;
//	}
//
//	public void setApplycount(String applycount) {
//		this.applycount = applycount;
//	}

	public String getCase_id() {
		return case_id;
	}

	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}

	public String getCase_code() {
		return case_code;
	}

	public void setCase_code(String case_code) {
		this.case_code = case_code;
	}

	public String getQues_resource() {
		return ques_resource;
	}

	public void setQues_resource(String ques_resource) {
		this.ques_resource = ques_resource;
	}

	public String getQues_channel() {
		return ques_channel;
	}

	public void setQues_channel(String ques_channel) {
		this.ques_channel = ques_channel;
	}

	public String getCase_type() {
		return case_type;
	}

	public void setCase_type(String case_type) {
		this.case_type = case_type;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public Date getReport_time() {
		return report_time;
	}

	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}

	public String getReporter_info() {
		return reporter_info;
	}

	public void setReporter_info(String reporter_info) {
		this.reporter_info = reporter_info;
	}

	public String getQuestion_desc() {
		return question_desc;
	}

	public void setQuestion_desc(String question_desc) {
		this.question_desc = question_desc;
	}

	public Date getOccur_time() {
		return occur_time;
	}

	public void setOccur_time(Date occur_time) {
		this.occur_time = occur_time;
	}

	public Date getRegister_time() {
		return register_time;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public Date getClose_time() {
		return close_time;
	}

	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}

	public String getCase_status() {
		return case_status;
	}

	public void setCase_status(String case_status) {
		this.case_status = case_status;
	}

	public String getEff_range_desc() {
		return eff_range_desc;
	}

	public void setEff_range_desc(String eff_range_desc) {
		this.eff_range_desc = eff_range_desc;
	}

	public String getEff_range_level() {
		return eff_range_level;
	}

	public void setEff_range_level(String eff_range_level) {
		this.eff_range_level = eff_range_level;
	}

	public String getLevel_unit() {
		return level_unit;
	}

	public void setLevel_unit(String level_unit) {
		this.level_unit = level_unit;
	}

	public String getDemage_level() {
		return demage_level;
	}

	public void setDemage_level(String demage_level) {
		this.demage_level = demage_level;
	}

	public String getComp_no() {
		return comp_no;
	}

	public void setComp_no(String comp_no) {
		this.comp_no = comp_no;
	}

	public String getPosition_desc() {
		return position_desc;
	}

	public void setPosition_desc(String position_desc) {
		this.position_desc = position_desc;
	}

	public float getPos_x() {
		return pos_x;
	}

	public void setPos_x(float pos_x) {
		this.pos_x = pos_x;
	}

	public float getPos_y() {
		return pos_y;
	}

	public void setPos_y(float pos_y) {
		this.pos_y = pos_y;
	}

	public String getBgcode() {
		return bgcode;
	}

	public void setBgcode(String bgcode) {
		this.bgcode = bgcode;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getAttach_list() {
		return attach_list;
	}

	public void setAttach_list(String attach_list) {
		this.attach_list = attach_list;
	}

	public String getWorkflow_id() {
		return workflow_id;
	}

	public void setWorkflow_id(String workflow_id) {
		this.workflow_id = workflow_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCase_level() {
		return case_level;
	}

	public void setCase_level(String case_level) {
		this.case_level = case_level;
	}

	public String getExt_char() {
		return ext_char;
	}

	public void setExt_char(String ext_char) {
		this.ext_char = ext_char;
	}

	public int getExt_number() {
		return ext_number;
	}

	public void setExt_number(int ext_number) {
		this.ext_number = ext_number;
	}

	public Date getExt_date() {
		return ext_date;
	}

	public void setExt_date(Date ext_date) {
		this.ext_date = ext_date;
	}

	public String getIs_cuiban() {
		return is_cuiban;
	}

	public void setIs_cuiban(String is_cuiban) {
		this.is_cuiban = is_cuiban;
	}

	public String getSatisfaction_degree() {
		return satisfaction_degree;
	}

	public void setSatisfaction_degree(String satisfaction_degree) {
		this.satisfaction_degree = satisfaction_degree;
	}

	public String getReporter_desc() {
		return reporter_desc;
	}

	public void setReporter_desc(String reporter_desc) {
		this.reporter_desc = reporter_desc;
	}

	public Date getRefuse_otime() {
		return refuse_otime;
	}

	public void setRefuse_otime(Date refuse_otime) {
		this.refuse_otime = refuse_otime;
	}

	public String getOrg_list() {
		return org_list;
	}

	public void setOrg_list(String org_list) {
		this.org_list = org_list;
	}

	public String getWithdrawtrace() {
		return withdrawtrace;
	}

	public void setWithdrawtrace(String withdrawtrace) {
		this.withdrawtrace = withdrawtrace;
	}

	public String getCurr_org() {
		return curr_org;
	}

	public void setCurr_org(String curr_org) {
		this.curr_org = curr_org;
	}

	public String getIsdispatch() {
		return isdispatch;
	}

	public void setIsdispatch(String isdispatch) {
		this.isdispatch = isdispatch;
	}

	public String getReturnvisitopinion() {
		return returnvisitopinion;
	}

	public void setReturnvisitopinion(String returnvisitopinion) {
		this.returnvisitopinion = returnvisitopinion;
	}

	public String getSatisfactionlevel() {
		return satisfactionlevel;
	}

	public void setSatisfactionlevel(String satisfactionlevel) {
		this.satisfactionlevel = satisfactionlevel;
	}
	
	/*
	public String getApplycount() {
		return applycount;
	}

	public void setApplycount(String applycount) {
		this.applycount = applycount;
	}
	*/
}
