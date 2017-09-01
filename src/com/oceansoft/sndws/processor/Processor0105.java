/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ���й����ݿƼ�����ɽ·1��
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: ���ݹ���ͳһ�û�����ƽ̨1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:Processor0105.java
 * <p>
 * �����ʱ��: Jun 8, 2013 12:00:33 AM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * ������ : ���ݹ���ͳһ�û�����ƽ̨
 * <p>
 * ���ڲ���: ����/����������������
 * <p>
 * <p>
 */
package com.oceansoft.sndws.processor;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.ATAF0105;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;

/**
 * ���Ļط���Ϣ<br>
 * �����ط���ɣ����ط����ݺ�����̶ȷ��������Ŷ�
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0105 implements IProcess {
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;

	public Result process(Message msg) {
		ATAF0105 doc = msg.getBody().getDocument(ATAF0105.class);
		Assert.notNull(doc, "������ϢΪ��");
		// 1.�������������
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("�������[%1$s]�����ڣ��޷������ٽ��촦��", doc.getOpDigNumGather()));
		}
		base.setExt_char(doc.getOpDigNumGather());
		String _stat = doc.getSatisfaction();
		String _code = "1";
		if ("������".equals(_stat))
			_code = "2";
		else if ("һ��".equals(_stat))
			_code = "3";
		base.setSatisfaction_degree(_code);
		base.setCase_status("0606");
		basedao.updateSatifaction(base);
		// 2.��ϸ������һ��0606״̬��¼
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setNote("�гǹܹ����ط�");
		detail.setDisposal_info(doc.getReturnVisitContent());
		detail.setDisposal_result("");
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status("0606");
		detaildao.save(detail);
		return new Result(String.format("����[%1$s]�طóɹ�", doc.getOpDigNumGather()));
	}
}
