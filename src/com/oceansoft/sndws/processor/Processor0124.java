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
 * �ļ���:Processor0124.java
 * <p>
 * �����ʱ��: Jun 8, 2013 12:02:04 AM
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

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.ATAF0124;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;

/**
 * ������д��������Ϣ<br>
 * ���Ľ������ļ��������͸�Эͬ�칫��λ
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0124 implements IProcess {
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;

	public Result process(Message msg) {
		ATAF0124 doc = msg.getBody().getDocument(ATAF0124.class);
		Assert.notNull(doc, "Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("�������[%1$s]�����ڣ��޷����м������ش�", doc.getOpDigNumGather()));
		}
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setDisposal_result("��ر�ţ�" + doc.getAttiNum());
		detail.setNote("���ļ������ش�");
		detail.setDisposal_info("�����Ա��" + doc.getSH_OPER() + " ��������" + doc.getDreason() + " ��д���ʱ��:"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(doc.getSH_TIME()));
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status(base.getCase_status());
		detaildao.save(detail);
		return new Result(String.format("[�гǹܹ������]:%1$s���Ķ�������ش��ɹ�", doc.getOpDigNumGather()));

	}
}
