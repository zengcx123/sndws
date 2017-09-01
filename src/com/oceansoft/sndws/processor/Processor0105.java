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
 * 文件名:Processor0105.java
 * <p>
 * 类产生时间: Jun 8, 2013 12:00:33 AM
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
package com.oceansoft.sndws.processor;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.ATAF0105;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;

/**
 * 中心回访信息<br>
 * 工单回访完成，将回访内容和满意程度反馈给部门端
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0105 implements IProcess {
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;

	public Result process(Message msg) {
		ATAF0105 doc = msg.getBody().getDocument(ATAF0105.class);
		Assert.notNull(doc, "工单信息为空");
		// 1.更新主表满意度
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("工单编号[%1$s]不存在，无法进行再交办处理", doc.getOpDigNumGather()));
		}
		base.setExt_char(doc.getOpDigNumGather());
		String _stat = doc.getSatisfaction();
		String _code = "1";
		if ("不满意".equals(_stat))
			_code = "2";
		else if ("一般".equals(_stat))
			_code = "3";
		base.setSatisfaction_degree(_code);
		base.setCase_status("0606");
		basedao.updateSatifaction(base);
		// 2.明细表增加一条0606状态记录
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setNote("市城管工单回访");
		detail.setDisposal_info(doc.getReturnVisitContent());
		detail.setDisposal_result("");
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status("0606");
		detaildao.save(detail);
		return new Result(String.format("工单[%1$s]回访成功", doc.getOpDigNumGather()));
	}
}
