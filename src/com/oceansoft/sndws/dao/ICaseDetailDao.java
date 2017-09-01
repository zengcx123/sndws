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
 * 文件名:ICaseDetailInfoDao.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:18:29 PM
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

import java.util.List;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean_new.Process;

public interface ICaseDetailDao {
	/**
	 * 根据工单ID加载工单详细信息
	 * 
	 * @param case_id
	 * @return
	 */
	List<CaseDetail> findByCaseId(String caseId);

	/**
	 * 保存工单详细信息
	 * 
	 * @param detail
	 */
	int save(CaseDetail detail);

	/**
	 * 更新工单主表信息
	 */
	int update(XtCaseInfo caseInfo);

	int update2(XtCaseInfo caseInfo);
}
