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
 * 文件名:DetailInfoDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:18:03 PM
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean_new.Process;

/**
 * 案件详细信息数据库操作组件实现类
 * 
 * @author chenw
 * 
 */
@Repository
public class CaseDetailDaoImpl implements ICaseDetailDao {
	@Resource
	private NamedParameterJdbcTemplate npjt;

	public List<CaseDetail> findByCaseId(String caseId) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("case_id", caseId);
		return npjt.queryForList(
				"SELECT * FROM XT_CASE_DETAIL T WHERE T.CASE_ID = :case_id ORDER BY T.CREATE_TIME ASC", params,
				CaseDetail.class);
	}

	public int save(CaseDetail detail) {
		return npjt
				.update("INSERT INTO XT_CASE_DETAIL VALUES(XT_CASEDETAIL_SEQ.NEXTVAL,:case_id,:case_status,:create_time,:operator,:acceptors,:accept_org,:attach_list,:disposal_info,:disposal_result,:end_time,:exp_time,:exp_number,:exp_char,:ref_no,:note,:returnvisitopinion,:satisfactionlevel,:recanalyse,:noticetype)",
						new BeanPropertySqlParameterSource(detail));
	}

	public int update(XtCaseInfo caseInfo) {
		return npjt.update("UPDATE XT_CASE_INFO T SET T.REPLY2H = :reply2h WHERE T.CASE_ID = :caseId",new BeanPropertySqlParameterSource(caseInfo));
	}

	public int update2(XtCaseInfo caseInfo) {
		return npjt.update("UPDATE XT_CASE_INFO T SET T.EXT_DATE = :extDate,T.CASE_STATUS = :status WHERE T.CASE_ID = :caseId",new BeanPropertySqlParameterSource(caseInfo));
	}
}
