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
 * 文件名:ICaseInfoDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:18:11 PM
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
package com.oceansoft.sndws.dao;

import java.util.Map;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.bean.CaseInfo;

public interface ICaseInfoDao {
	/**
	 * 向办件基本信息表中添加数据
	 * 
	 * @param params
	 */
	void save(Map<String, Object> params);

	/**
	 * 生成案件编号
	 * 
	 * @return
	 */
	String getCaseId();

	/**
	 * 获取指定工单号案件数
	 * 
	 * @param caseSN
	 *            工单号
	 * @return 已存在数量
	 */
	int getTotalNum(String caseSN);

	/**
	 * 根据市局单号字段加载工单信息
	 * 
	 * @param code
	 *            工单唯一编号opDigNumGather
	 * @return
	 */
	CaseInfo findByCode(String code);

	/**
	 * 根据市局单号字段加载工单信息
	 * 
	 * @param code
	 *            工单唯一编号opDigNumGather
	 * @return
	 */
	public XtCaseInfo findXtCaseInfoByCode(String code);

	/**
	 * 更新工单处理时限及拒绝时间
	 * 
	 * @param base
	 */
	int updateTime(CaseInfo base);

	/**
	 * 更新主表满意度
	 * 
	 * @param caseInfo
	 */
	int updateSatifaction(CaseInfo caseInfo);
	
	/**
	 * 更新主表
	 * @param caseInfo
	 * @return
	 */
	int updateQues(XtCaseInfo caseInfo);
	
	public int updateStatus(XtCaseInfo caseInfo);
	
	/**
	 * 更新处置时限
	 * @param caseInfo
	 * @return
	 */
	int updateExtDate(CaseInfo caseInfo);
	
	/**获得案件状态**/
	public String getStatus(String SectionTasKnum);
}



