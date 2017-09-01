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
 * �ļ���:Processor0001.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:06:03 PM
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
import org.springframework.util.StringUtils;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ITaskInfoDao;
import com.oceansoft.sndws.entity.ATAF0111;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean.TaskInfo;

/**
 * <b>������ʱ�����Ϣ</b><br>
 * ����ʱ�����������ˣ�ͬ������ӳ�ʱʱ�ޣ���ͬ�ⲻ���ӳ�ʱʱ�ޡ�
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0111 implements IProcess {

	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;
	
	@Resource
	private ITaskInfoDao taskInfoDao;

	public Result process(Message msg) {
		
		ATAF0111 doc = msg.getBody().getDocument(ATAF0111.class);
		Assert.notNull(doc, "Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		if (null == base) {
			return new Result(Result.FAILURE, String.format("�������[%1$s]�����ڣ��޷����й�����ʱ���", doc.getOpDigNumGather()));
		}
		//���������
		String caseid = base.getCase_id();
		String taskid = taskInfoDao.getLatestTaskInfoForDelay(caseid);//��ȡ����һ����¼��taskid
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskId(taskid);
		taskInfo.setAuditor12345(doc.getSH_OPER());
		taskInfo.setAudit12345Endtime(doc.getDelaydate());
		taskInfo.setAudit12345Time(doc.getSH_TIME());
		if(1 ==  doc.getArgee_flag()){//ͬ��
			taskInfo.setAudit12345Desc("ͬ��");
		}else if(2 == doc.getArgee_flag()){//��ͬ��
			taskInfo.setAudit12345Desc("��ͬ��");
		}else{
		}
		taskInfo.setTaskStatus("0703");
		taskInfoDao.updateTaskInfo(taskInfo);
		
		
		CaseDetail detail = new CaseDetail();
		detail.setCase_id(base.getCase_id());
		detail.setDisposal_info("��������");
		if(1 ==  doc.getArgee_flag()){//ͬ��
			detail.setDisposal_result("1");
		}else if(2 == doc.getArgee_flag()){//��ͬ��
			detail.setDisposal_result("2");
		}else{
		}
		detail.setRef_no(doc.getOpDigNumGather());
		detail.setCreate_time(new Date());
		detail.setOperator("218");
		detail.setCase_status("0703");
		detaildao.save(detail);
		return new Result(String.format("[�гǹܹ������]:%1$s��ʱ��˳ɹ�", doc.getOpDigNumGather()));
		
		
		/*
		String result=null;
		ATAF0111 doc=msg.getBody().getDocument(ATAF0111.class);
		Assert.notNull(doc,"Message is not null");
		CaseInfo base = basedao.findByCode(doc.getOpDigNumGather());
		CaseDetail xtCaseDetail= new CaseDetail();
		TaskInfo xtTaskInfo = new TaskInfo();
		
		if ("1".equals(doc.getArgee_flag())) {
			result = "ͬ��";
			
		} else if ("2".equals(doc.getArgee_flag())) {
			result = "��ͬ��";
		}
		xtCaseDetail.setCase_status("0703");
		xtTaskInfo.setTaskStatus("0703");
	

	
	xtCaseDetail.setCreate_time(doc.getSH_TIME());
	// ����ǲ�ͬ����ô����ʱʱ����nullֵ����ʱ�򲻱�����Ϣ
	if (doc.getDelaydate() != null) {
		xtCaseDetail.setExpTime(doc.getDelaydate()); // ��ʱ��ʱ��
	}

	// ������ʱ��Сʱ��������exp_number
	// ����ʼʱ��
	Date taskStartTime = xtTaskInfo.getStartTime();
	Long expNumber = new Long(0);
	if (null != doc.getDelaydate()) {
		expNumber = ataf0111.getDelaydate().getTime() - taskStartTime.getTime();
	}
	// ת����Сʱ
	Long expHours = expNumber / 1000 / 60 / 60;
	xtCaseDetail.setExpNumber(new Double(expHours.toString()));

	xtCaseDetail.setDisposal_result(doc.getArgee_flag());

	xtCaseDetail.setDisposal_info(result);
	xtCaseDetail.setExp_char(doc.getSH_OPER());
	xtCaseDetail.setRef_no(xtTaskInfo.getTaskId());
	// ��ʱʹ��ϵͳ����Ա���˺�
	xtCaseDetail.setOperator("218");
	// ����������Ϣ
	xtTaskInfo.setAudit12345Desc(result);
	xtTaskInfo.setAudit12345Time(ataf0111.getShTime());
	xtTaskInfo.setAuditor12345(ataf0111.getShOper());
	xtTaskInfo.setAudit12345Endtime(ataf0111.getDelayDate());
	getCaseDetailEntityDao().save(xtCaseDetail);
	getTaskInfoEntityDao().update(xtTaskInfo);
	
	*/

	}
}
