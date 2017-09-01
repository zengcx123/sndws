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
 * 文件名:Processor0001.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:06:03 PM
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
import org.springframework.util.StringUtils;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ITaskInfoDao;
import com.oceansoft.sndws.entity.ATAF0111;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean.TaskInfo;

/**
 * <b>中心延时审核信息</b><br>
 * 对延时的申请进行审核，同意的增加超时时限，不同意不增加超时时限。
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0111 implements IProcess {

	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;
	
	@Resource
	private ITaskInfoDao taskInfoDao;

	public Result process(Message msg) {
		
		ATAF0111 doc = msg.getBody().getDocument(ATAF0111.class);
		Assert.notNull(doc, "Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("工单编号[%1$s]不存在，无法进行工单延时审核", doc.getOpDigNumGather()));
		}
		//更新任务表
		String caseid = base.getCase_id();
		String taskid = taskInfoDao.getLatestTaskInfoForDelay(caseid);//获取最新一条记录的taskid
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskId(taskid);
		taskInfo.setAuditor12345(doc.getSH_OPER());
		taskInfo.setAudit12345Endtime(doc.getDelaydate());
		taskInfo.setAudit12345Time(doc.getSH_TIME());
		if(1 ==  doc.getArgee_flag()){//同意
			taskInfo.setAudit12345Desc("同意");
		}else if(2 == doc.getArgee_flag()){//不同意
			taskInfo.setAudit12345Desc("不同意");
		}else{
		}
		taskInfo.setTaskStatus("0703");
		taskInfoDao.updateTaskInfo(taskInfo);
		
		
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setDisposal_info("市里审批");
		if(1 ==  doc.getArgee_flag()){//同意
			detail.setDisposal_result("1");
		}else if(2 == doc.getArgee_flag()){//不同意
			detail.setDisposal_result("2");
		}else{
		}
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status("0703");
		detaildao.save(detail);
		return new Result(String.format("[市城管工单编号]:%1$s延时审核成功", doc.getOpDigNumGather()));
		
		
		/*
		String result=null;
		ATAF0111 doc=msg.getBody().getDocument(ATAF0111.class);
		Assert.notNull(doc,"Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		CaseDetail xtCaseDetail= new CaseDetail();
		TaskInfo xtTaskInfo = new TaskInfo();
		
		if ("1".equals(doc.getArgee_flag())) {
			result = "同意";
			
		} else if ("2".equals(doc.getArgee_flag())) {
			result = "不同意";
		}
		xtCaseDetail.setCase_status("0703");
		xtTaskInfo.setTaskStatus("0703");
	

	
	xtCaseDetail.setCreate_time(doc.getSH_TIME());
	// 如果是不同意那么，延时时间是null值，这时候不保存信息
	if (doc.getDelaydate() != null) {
		xtCaseDetail.setExpTime(doc.getDelaydate()); // 延时后时间
	}

	// 计算延时的小时数，存入exp_number
	// 任务开始时间
	Date taskStartTime = xtTaskInfo.getStartTime();
	Long expNumber = new Long(0);
	if (null != doc.getDelaydate()) {
		expNumber = ataf0111.getDelaydate().getTime() - taskStartTime.getTime();
	}
	// 转换成小时
	Long expHours = expNumber / 1000 / 60 / 60;
	xtCaseDetail.setExpNumber(new Double(expHours.toString()));

	xtCaseDetail.setDisposal_result(doc.getArgee_flag());

	xtCaseDetail.setDisposal_info(result);
	xtCaseDetail.setExp_char(doc.getSH_OPER());
	xtCaseDetail.setRef_no(xtTaskInfo.getTaskId());
	// 暂时使用系统管理员的账号
	xtCaseDetail.setOperator("218");
	// 保存任务信息
	xtTaskInfo.setAudit12345Desc(result);
	xtTaskInfo.setAudit12345Time(ataf0111.getShTime());
	xtTaskInfo.setAuditor12345(ataf0111.getShOper());
	xtTaskInfo.setAudit12345Endtime(ataf0111.getDelayDate());
	getCaseDetailEntityDao().save(xtCaseDetail);
	getTaskInfoEntityDao().update(xtTaskInfo);
	
	*/

	}
}
