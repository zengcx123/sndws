package com.oceansoft.sndws.processor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.entity.ATAF01182;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
@Service
public class Processor01182 implements IProcess{
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;
	
	@Resource
	private ICaseTempDao tempDao;
	
	@Override
	public Result process(Message msg) throws Exception {
		ATAF01182 doc = msg.getBody().getDocument(ATAF01182.class);
		Assert.notNull(doc, "Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("工单编号[%1$s]不存在，无法进行审批拒签处理", doc.getOpDigNumGather()));
		}
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setNote("市城管工单审核拒签");
		detail.setCase_status("1102");
		detail.setDisposal_result("2".equals(doc.getArgee_flag()) ? "不同意" : "同意");
		detail.setDisposal_info("审核人员：" + doc.getSH_OPER() + " 审核结果："
				+ ("2".equals(doc.getArgee_flag()) ? "不同意" : "同意") + " 审核 时间:"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(doc.getSH_TIME()));
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detaildao.save(detail);
		tempDao.copyFromViewListToTemp(base.getCase_id());
		return new Result(String.format("[市城管工单编号]:%1$s拒签审核成功", doc.getOpDigNumGather()));
	}

}
