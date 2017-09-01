package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.entity.ATAF01182;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF04;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * 回退审批处理
 * @author liyang
 *
 */
@Component
public class Processor04 implements IProcess{

	@Resource
	private ICaseInfoDao basedao;
	
	@Resource
	private ICaseDetailDao detaildao;
	
	@Resource
	private ICaseTempDao tempDao;
	
	public Result process(Object o) {
		
		Result result = new Result();
		ATAF04 atf = (ATAF04)o;
		if(null != atf){
			CaseInfo base = basedao.findByCode(atf.getCityTaskNum());
			if (null == base) {
				result.setReason("编号："+atf.getCityTaskNum()+"的工单不存在,无法完成回退审批处理");
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());
			detail.setNote("市城管工单审核拒签");
			detail.setDisposal_result(0==atf.getReplyResult() ? "不同意" : "同意");
			detail.setDisposal_info(atf.getReplyOpinion());
			//detail.setDisposal_info("审核人员：" + atf.getReplyHuman() + " 审核结果："+ ("0".equals(atf.getReplyResult()) ? "不同意" : "同意") + " 审核 时间:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atf.getReplyTime()));
			detail.setRef_no(atf.getCityTaskNum());
			detail.setCreate_time(new Date());		
			detail.setCase_status(0==atf.getReplyResult() ? "0401" : "0303");
			detail.setOperator("218");
			
			detaildao.save(detail);
			XtCaseInfo xtcaseInfo=new XtCaseInfo();
			xtcaseInfo.setExtChar(base.getExt_char());
			//如果不同意状态设为待派遣状态，同意设为费案状态
			xtcaseInfo.setCaseStatus(0==atf.getReplyResult() ? "0401" : "0303");
			basedao.updateStatus(xtcaseInfo); //主表
			tempDao.copyFromViewListToTemp(base.getCase_id());
			return new Result(0, String.format("[市城管工单编号]:%1$s拒签审核成功", atf.getCityTaskNum()));
//			result.setResultValue(0);
//			result.setReason("成功");
//			return result;
		}else{
			MailUti.init("回退审批处理","回退审核XML信息解析失败",atf.getCityTaskNum());
			result.setReason("回退审核XML信息解析失败");
			return result;
		}
	}
}
