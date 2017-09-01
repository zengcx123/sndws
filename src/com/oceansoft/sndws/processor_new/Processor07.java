package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oceansoft.sndws.dao.IAttachmentDao;
import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF07;
import com.oceansoft.sndws.entity.bean_new.CaseMain;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * 回访审批
 */
@Component
public class Processor07 implements IProcess{
	@Resource
	private ICaseInfoDao basedao;
	@Resource
	private ICaseDetailDao detaildao;
	@Resource
	private ICaseTempDao tempDao;
	
	
	@Override
	public Result process(Object o) {
		Result result= new Result();
		ATAF07 atf = (ATAF07) o;
		if(null !=atf){

			CaseInfo base = basedao.findByCode(atf.getCityTasKnum());
			if (null == base) {
				return new Result(1, String.format("工单编号[%1$s]不存在，无法进行再交办处理", atf.getCityTasKnum()));
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());
			detail.setNote("市城管工单审核不回访");
			detail.setCase_status("1202");
			detail.setDisposal_result("2".equals(atf.getReplyResult()) ? "不同意" : "同意");
			detail.setDisposal_info("审核人员：" + atf.getReplyHuman() + " 审核结果："
					+ ("2".equals(atf.getReplyResult()) ? "不同意" : "同意") + " 审核 时间:"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atf.getReplyTime()));
			
			detail.setCreate_time(new Date());
			detail.setOperator("218");
			detaildao.save(detail);
			tempDao.copyFromViewListToTemp(base.getCase_id());
			return new Result(0, String.format("[市城管工单编号]:%1$s回访审核成功", atf.getCityTasKnum()));
					
			//result.setResultValue(0);
			//result.setReason("成功");
			//return result;
		}else{
			MailUti.init("回访审批","回访审批XML信息解析失败",atf.getCityTasKnum());
			result.setReason("回访审批信息解析失败");
			return result;
		}
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
