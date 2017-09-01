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
 * 文件名:BaseInfoDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:17:46 PM
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
package com.oceansoft.sndws.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.util.SQLUtil;

/**
 * 案件基本信息数据库操作组件实现类
 * 
 * @author chenw
 * 
 */
@Repository
public class CaseInfoDaoImpl implements ICaseInfoDao {
	private static final String SQL_GEN_CASE_ID = "SELECT 'C'||to_char(sysdate, 'yymmdd') || lpad(seq_snd_case_id.nextval,5,0) FROM dual";
	@Resource
	private NamedParameterJdbcTemplate npjt;
	@Resource
	private JdbcTemplate jt;

	public void save(Map<String, Object> params) {
		npjt.update(SQLUtil.genInsertSQL("XT_CASE_INFO", params), params);
	}

	public String getCaseId() {
		return jt.queryForObject(SQL_GEN_CASE_ID, String.class);
	}

	public int getTotalNum(String caseSN) {
		return jt.queryForObject("SELECT COUNT(1) FROM XT_CASE_INFO T WHERE T.EXT_CHAR=?", Integer.class, caseSN);
	}

	public int updateSatifaction(CaseInfo caseInfo) {
		return npjt
				.update("UPDATE XT_CASE_INFO SET SATISFACTION_DEGREE = :satisfaction_degree,CASE_STATUS=:case_status WHERE EXT_CHAR = :ext_char",
						new BeanPropertySqlParameterSource(caseInfo));
	}

	public CaseInfo findByCode(String code) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ext_char", code);
		List<CaseInfo> rt = npjt
				.query("SELECT CASE_ID,CASE_CODE,REPORT_TIME,REFUSE_OTIME,CASE_STATUS,EXT_CHAR FROM XT_CASE_INFO T WHERE T.EXT_CHAR = :ext_char",
						params, new RowMapper<CaseInfo>() {
							public CaseInfo mapRow(ResultSet rs, int index) throws SQLException {
								CaseInfo o = new CaseInfo();
								o.setCase_id(rs.getString("CASE_ID"));
								o.setCase_code(rs.getString("CASE_CODE"));
								o.setCase_status(rs.getString("CASE_STATUS"));
								o.setReport_time(rs.getTimestamp("REPORT_TIME"));
								o.setRefuse_otime(rs.getTimestamp("REFUSE_OTIME"));
								o.setExt_char(rs.getString("EXT_CHAR"));
								return o;
							}
						});
		return rt.size() > 0 ? rt.get(0) : null;
	}

	public XtCaseInfo findXtCaseInfoByCode(String code) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ext_char", code);
		List<XtCaseInfo> rt = npjt.query("SELECT * FROM XT_CASE_INFO T WHERE T.EXT_CHAR = :ext_char", params,
				new RowMapper<XtCaseInfo>() {
					public XtCaseInfo mapRow(ResultSet rs, int index) throws SQLException {
						XtCaseInfo o = new XtCaseInfo();
						o.setCaseId(rs.getString("CASE_ID"));
						o.setCaseCode(rs.getString("CASE_CODE"));
						o.setQuesResource(rs.getString("QUES_RESOURCE"));
						o.setQuestionDesc(rs.getString("QUESTION_DESC"));
						o.setQuesChannel(rs.getString("QUES_CHANNEL"));
						o.setCaseType(rs.getString("CASE_TYPE"));
						o.setCaseName(rs.getString("CASE_NAME"));
						o.setReporter(rs.getString("REPORTER"));
						o.setReportTime(rs.getTimestamp("REPORT_TIME"));
						o.setReporterInfo(rs.getString("REPORTER_INFO"));
						o.setOccurTime(rs.getTimestamp("OCCUR_TIME"));
						o.setRegisterTime(rs.getTimestamp("REGISTER_TIME"));
						o.setCloseTime(rs.getTimestamp("CLOSE_TIME"));
						o.setCaseStatus(rs.getString("CASE_STATUS"));
						o.setEffRangeDesc(rs.getString("EFF_RANGE_DESC"));
						o.setEffRangeLevel(rs.getString("EFF_RANGE_LEVEL"));
						o.setLevelUnit(rs.getString("LEVEL_UNIT"));
						o.setDemageLevel(rs.getString("DEMAGE_LEVEL"));
						o.setWithdrawTrace(rs.getString("WITHDRAWTRACE"));
						o.setCompNo(rs.getString("COMP_NO"));
						o.setPositionDesc(rs.getString("POSITION_DESC"));
						o.setPosX(rs.getDouble("POS_X"));
						o.setPosY(rs.getDouble("POS_Y"));
						o.setBgcode(rs.getString("BGCODE"));
						o.setRegionId(rs.getString("REGION_ID"));
						o.setAttachList(rs.getString("ATTACH_LIST"));
						o.setWorkflowId(rs.getString("WORKFLOW_ID"));
						o.setNote(rs.getString("NOTE"));
						o.setCaseLevel(rs.getString("CASE_LEVEL"));
						o.setExtChar(rs.getString("EXT_CHAR"));
						o.setExtNumber(rs.getDouble("EXT_NUMBER"));
						o.setExtDate(rs.getTimestamp("EXT_DATE"));
						o.setIsCuiban(rs.getString("IS_CUIBAN"));
						o.setSatisfyDegree(rs.getString("SATISFACTION_DEGREE"));
						o.setReportDesc(rs.getString("REPORTER_DESC"));
						o.setRefuseOTime(rs.getTimestamp("REFUSE_OTIME"));
						return o;
					}
				});
		return rt.size() > 0 ? rt.get(0) : null;
	}

	public int updateTime(CaseInfo base) {
		return npjt
				.update("UPDATE XT_CASE_IFNO SET CASE_STATUS=:case_status,REGISTER_TIME=:register_time,REFUSE_OTIME=:refuse_otime,WORKFLOW_ID=:workflow_id WHERE CASE_ID = :case_id",
						new BeanPropertySqlParameterSource(base));
	}

	public int updateQues(XtCaseInfo caseInfo) {
		return jt.update("UPDATE XT_CASE_INFO SET QUESTION_DESC ='"+caseInfo.getQuestionDesc()+"' WHERE EXT_CHAR = '"+caseInfo.getExtChar()+"'");
	}
	
	public int updateStatus(XtCaseInfo caseInfo){
		return jt.update("UPDATE XT_CASE_INFO SET  CASE_STATUS='"+caseInfo.getCaseStatus()+"' WHERE EXT_CHAR = '"+caseInfo.getExtChar()+"'");
	}

	@Override
	public int updateExtDate(CaseInfo caseInfo) {
		return	npjt.update("UPDATE XT_CASE_INFO SET  EXT_DATE=:ext_date WHERE EXT_CHAR =:ext_char ", new BeanPropertySqlParameterSource(caseInfo));	
	}

	@Override
	public String getStatus(String SectionTasKnum) {
		
		return jt.queryForObject("SELECT t.case_status FROM XT_CASE_INFO T WHERE case_id='"+SectionTasKnum+"'",String.class);
	}
	
	
	
	
	
}
