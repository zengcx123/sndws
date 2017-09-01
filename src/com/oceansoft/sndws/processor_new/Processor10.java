package com.oceansoft.sndws.processor_new;
//signInCity

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.*;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF09;
import com.oceansoft.sndws.entity.bean_new.ATAF10;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class Processor10 implements IProcess {
	@Resource
	private ICaseInfoDao basedao;
	@Resource
	private ICaseDetailDao detaildao;
	@Resource
	private ICaseTempDao tempDao;
	@Resource
	private IAttachmentDao attdao;
	@Resource
	private IWorkflowDao flowdao;

	public Result process(Object o) {
		Result result= new Result();
		ATAF10 atf = (ATAF10) o;
		if(null !=atf){

			CaseInfo base = basedao.findByCode(atf.getCityTasKnum());
			String status=basedao.getStatus(atf.getSectionTasKnum());
			if (null == base) {
				return new Result(1, String.format("工单编号[%1$s]不存在，无法进行更新案件处理", atf.getCityTasKnum()));
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());			
			detail.setOperator(atf.getOpthuMan());
			detail.setCreate_time(atf.getOptTime());
			detail.setDisposal_info(atf.getOptopinion());
			detail.setNote(atf.getMemo());
			detail.setNoticetype(atf.getNoticeType());

			detaildao.save(detail);
			tempDao.copyFromViewListToTemp(base.getCase_id());

			return new Result(0, String.format("[市城管工单编号]:%1$s业务通知单成功", atf.getCityTasKnum()));

		}else{
			MailUti.init("业务通知单","业务通知单XML信息解析失败",atf.getCityTasKnum());
			result.setReason("业务通知单信息解析失败");
			return result;
		}
	
	}

}
	
