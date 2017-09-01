package com.oceansoft.sndws.processor_new;
//signInCity
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.*;
import com.oceansoft.sndws.entity.bean_new.ATAF02;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import org.springframework.stereotype.Component;

import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF09;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
@Component
public class Processor09 implements IProcess {
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

	@Override
	public Result process(Object o) {
		Result result= new Result();
		ATAF09 atf = (ATAF09) o;
		if(null !=atf){

			CaseInfo base = basedao.findByCode(atf.getCityTasKnum());
			String status=basedao.getStatus(atf.getSectionTasKnum());
			if (null == base) {
				return new Result(1, String.format("工单编号[%1$s]不存在，无法进行更新案件处理", atf.getCityTasKnum()));
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());			
			//detail.setNote("市城管工单更新问题描述");
			detail.setNote(atf.getMemo()+"--市城管工单更新问题描述");
			detail.setDisposal_info(atf.getEventDesc()+"--市城管工单更新问题描述");
			detail.setSatisfactionlevel(atf.getSatisfactionlevel());
			detail.setEventDesc(atf.getEventDesc());
			detail.setOperator("218");
			detail.setCreate_time(new Date());
			detail.setCase_status(status);
			
			detaildao.save(detail);
			tempDao.copyFromViewListToTemp(base.getCase_id());

			List<Attachment_New> attachments = atf.getAttachment();

			if(null != attachments && attachments.size()>0){
				//保存附件
				String ids = attdao.save2(atf.getAttachment());

				//保存主表信息
				flowdao.saveCaseAndWorkflow(makeCaseInfo(base.getCase_id(),ids), "218");
			}

			return new Result(0, String.format("[市城管工单编号]:%1$s更新问题描述成功", atf.getCityTasKnum()));
					
		
		}else{
			MailUti.init("更新问题描述","更新问题描述XML信息解析失败",atf.getCityTasKnum());
			result.setReason("更新问题描述信息解析失败");
			return result;
		}
	
	}

	public XtCaseInfo makeCaseInfo(String caseId, String ids){
		XtCaseInfo caseInfo = new XtCaseInfo();
		caseInfo.setAttachList(ids);;
		return caseInfo;
	}
}
	
