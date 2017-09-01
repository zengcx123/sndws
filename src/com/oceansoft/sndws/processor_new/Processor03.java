package com.oceansoft.sndws.processor_new;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF03;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * 
 * 结案通知接口
 * 
 *
 */
@Component
public class Processor03 implements IProcess {

	@Resource
	private ICaseInfoDao basedao;
	
	@Resource
	private ICaseDetailDao detaildao;
	
	public Result process(Object o) {

		Result result = new Result();
		ATAF03 atf = (ATAF03)o;
		if(null != atf){
			// 1.更新主表满意度
			CaseInfo base = basedao.findByCode(atf.getCityTaskNum());
			if (null == base) {
				result.setReason("编号："+atf.getCityTaskNum()+"的工单不存在，无法进行结案反馈处理");
				return result;
			}
			base.setExt_char(atf.getCityTaskNum());//市城管编号
			base.setSatisfaction_degree(atf.getSatisfactionlevel());//满意度暂时设为空			
			//作废
			if(atf.getEndCaseType().equals("2")){
				base.setCase_status("0303");
				basedao.updateSatifaction(base);
			}
				
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());//案件编号
			detail.setNote("市城管工单回访");//节点备注
			detail.setDisposal_info(atf.getEndCaseOpinion());//节点处置信息
			detail.setDisposal_result("");//节点处置结果
			detail.setRef_no(atf.getCityTaskNum());//参考号
			detail.setCreate_time(new Date());//节点或任务开始时间
			detail.setSatisfactionlevel(atf.getSatisfactionlevel());//满意度
			detail.setReturnvisitopinion(atf.getReturnvisitopinion()); //回访意见
			detail.setOperator("218");//操作员
			detail.setRecanalyse(atf.getRecanalyse());//违建结案方式

			if(atf.getEndCaseType().equals("2")){
				detail.setCase_status("0303");//案件状态
				detaildao.save(detail);
			}
			
			return new Result(0, String.format("[市城管工单编号]:%1$s结案通知审核成功", atf.getCityTaskNum()));
//			result.setResultValue(0);
//			result.setReason("成功");
//			return result;
		}else{
			MailUti.init("结案通知接口","结案反馈XML信息解析失败",atf.getCityTaskNum());
			result.setReason("结案反馈XML信息解析失败");
			return result;
		}
	}

}
