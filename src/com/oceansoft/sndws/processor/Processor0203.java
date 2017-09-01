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
		Assert.notNull(doc,"����Ϊ��");
		String caseCode = doc.getOpDigNumGather();// �гǹֹܾ���Ψһ���
		XtCaseInfo caseInfo=casedao.findXtCaseInfoByCode(caseCode);
		caseInfo.setQuestionDesc(caseInfo.getQuestionDesc()+"��������Ϣ��:"+doc.getBJContent());//������Ϣ
		casedao.updateQues(caseInfo);
		return new Result(String.format("[�гǹܹ������]:%1$s������Ϣ�ɹ�", doc.getOpDigNumGather()));
	}

}
