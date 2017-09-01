package com.oceansoft.sndws.processor;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.ATAF0203;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;

@Component
public class Processor0203 implements IProcess{
	
	@Resource
	private ICaseInfoDao casedao;
	
	
	public Result process(Message msg) throws Exception {
		ATAF0203 doc = msg.getBody().getDocument(ATAF0203.class);
		Assert.notNull(doc,"工单为空");
		String caseCode = doc.getOpDigNumGather();// 市城管局工单唯一编号
		XtCaseInfo caseInfo=casedao.findXtCaseInfoByCode(caseCode);
		caseInfo.setQuestionDesc(caseInfo.getQuestionDesc()+"【补充信息】:"+doc.getBJContent());//补充信息
		casedao.updateQues(caseInfo);
		return new Result(String.format("[市城管工单编号]:%1$s补充信息成功", doc.getOpDigNumGather()));
	}

}
