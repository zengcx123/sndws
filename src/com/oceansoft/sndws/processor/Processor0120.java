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
 * 文件名:Processor0120.java
 * <p>
 * 类产生时间: Jun 8, 2013 12:01:30 AM
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

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.ATAF0120;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;

/**
 * 中心审核缓办信息<br>
 * 中心对部门申请缓办的工单进行审核
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0120 implements IProcess {
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;

	public Result process(Message msg) {
		ATAF0120 doc = msg.getBody().getDocument(ATAF0120.class);
		Assert.notNull(doc, "Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("工单编号[%1$s]不存在，无法进行工单缓办信息审核", doc.getOpDigNumGather()));
		}
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setNote("市城管工单缓办信息审核");
		detail.setDisposal_info("审核人员：" + doc.getSH_OPER() + " 审核结果："
				+ ("2".equals(doc.getArgee_flag()) ? "不同意" : "同意") + " 审核 时间:"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(doc.getSH_TIME()));
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status(base.getCase_status());
		detaildao.save(detail);
		return new Result(String.format("[市城管工单编号]:%1$s申请缓办审核成功", doc.getOpDigNumGather()));

	}
}
