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
 * �ļ���:Processor0107.java
 * <p>
 * �����ʱ��: Jun 8, 2013 12:00:43 AM
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

import org.apache.log4j.Logger;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseDetail;
import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.IWorkflowDao;
import com.oceansoft.sndws.entity.ATAF0001;
import com.oceansoft.sndws.entity.ATAF0107;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.util.Constant;
import com.oceansoft.sndws.dao.IAttachmentDao;


/**
 * �����ٽ�����Ϣ<br>
 * �ලָ�����Ľ�ҵ����ٽ�����Ϣ���͸�����
 * 
 * @author chenw
 * 
 */
@Service
public class Processor0107 implements IProcess {
	private static Logger logger = Logger.getLogger(Processor0001.class);
	@Resource
	private ICaseInfoDao casedao;
	@Resource
	private IAttachmentDao attdao;
	@Resource
	private IWorkflowDao flowdao;

	public Result process(Message msg) throws Exception {
		ATAF0107 doc = msg.getBody().getDocument(ATAF0107.class);
		String caseCode = doc.getOpDigNumGather();
		// 1.���ݹ����ż�����һ�ν����¼����������ڼ�¼���򲻴���
		XtCaseInfo base = casedao.findXtCaseInfoByCode(doc.getOpDigNumGather());
		if (null == base) {
			//��ʱ ����ת����
			// 3.���ɰ������
			String caseId = casedao.getCaseId();
			if (null != msg.getBody().getAttchments() && msg.getBody().getAttchments().size() > 0) {
				String ids = attdao.save(msg.getBody().getAttchments());
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,ids), "218");
			} else {
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,""), "218");
			}
			logger.info("=============�����������гǹܹ���ATAF0107 ת����ɹ����������ǣ�==============="+caseCode);
			return new Result(String.format("[���]:�ɹ�,[����]:ATAF0001,[���]:%1$s", caseId));
		}
		XtCaseDetail detail = new XtCaseDetail();
		detail.setNote(doc.getReturnVisitContent());
		detail.setDisposalInfo(doc.getReturnVisitContent());
		detail.setDisposalResult(doc.getPassCause());//������
		detail.setRefNo(doc.getOpDigNumGather());
		detail.setCreateTime(new Date());
		detail.setOperator("218");
		detail.setCaseStatus("0401");// ����ǲ
		detail.setEndTime(new Date());
		// �����ٽ����ӳ�ʱ��(�ٽ���ʱ��-��һ���յ���ʱ��)
		base.setRefuseOTime(doc.getRefuseOverTime());//�ܾ�ʱ��
		//2015��8��13��15:39:42 �ٽ��� �����������ϱ�ʱ��
		base.setReportTime(null);
		base.setQuestionDesc(base.getQuestionDesc() + " " + doc.getPassCause());// �������������ٽ��콻��ԭ��׷����ԭ�������ݺ�
		base.setEffRangeDesc("");
		if(StringUtils.hasText(doc.getReturnVisitContent())){
			base.setNote(doc.getDispatchOpinion()+"____�ط�����:"+doc.getReturnVisitContent());
		}else{
			base.setNote(doc.getDispatchOpinion());
		}
		base.setExtDate(doc.getDisposalTime());//����ʱ��
		base.setCaseStatus("0401");
		base.setExtNumber(base.getExtNumber());
		//2015��8��6��13:45:45 �гǹ��ٽ��� ��Ӹ�������
		if (null != msg.getBody().getAttchments() && msg.getBody().getAttchments().size() > 0) {
			String ids = attdao.save(msg.getBody().getAttchments());
			String id=base.getAttachList();
			if(StringUtils.isEmpty(id))
				base.setAttachList(ids);
			else
				base.setAttachList(id+","+ids);
		}
		
		try {
			org.codehaus.xfire.service.Service serviceModel = new ObjectServiceFactory()
					.create(com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive.class);
			com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive service = (com.oceansoft.sndmanager.cooperate.pojo.ICaseReceive) new XFireProxyFactory()
					.create(serviceModel, Constant.WS_SND);
			boolean rt = service.setCaseByATAF0107(base, detail);
			return new Result(Result.FAILURE, String.format("����[%1$s]�ٽ���%2$s", base.getExtChar(), (rt ? "�ɹ�" : "ʧ��")));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("=============�����гǹܹ���ATAF0107��ҵ��ƽ̨�����������������ǣ�==============="+caseCode, ex);
			return new Result(Result.FAILURE, "�����ٽ���ʧ��");
		}
	}
	
	public XtCaseInfo makeCaseInfo(ATAF0107 doc,String caseId,String ids){
		XtCaseInfo caseInfo = new XtCaseInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caseInfo.setCaseId(caseId);
		String caseName=doc.getAcceptType();
		caseInfo.setCaseName(caseName+"���У�");
		if("����".equals(caseName)){
			caseInfo.setCaseType("1201");
		}else if("����".equals(caseName)){
			caseInfo.setCaseType("1202");
		}else if("��������".equals(caseName)){
			caseInfo.setCaseType("1204");
		}else if("Ͷ��".equals(caseName)){
			caseInfo.setCaseType("1205");
		}else if("��ѯ".equals(caseName)){
			caseInfo.setCaseType("1206");
		}else if("����".equals(caseName)){
			caseInfo.setCaseType("1207");
		}else if("�ٱ�".equals(caseName)){
			caseInfo.setCaseType("1208");
		}else {
			caseInfo.setCaseType("1203");
		}
		caseInfo.setExtChar(doc.getOpDigNumGather());
		caseInfo.setExtNumber(1.0);
		caseInfo.setCaseStatus("0101");
		caseInfo.setCaseLevel("3");
		caseInfo.setExtDate(doc.getDisposalTime());
		caseInfo.setRefuseOTime(doc.getRefuseOverTime());	
		caseInfo.setPosX(0.0);
		caseInfo.setPosY(0.0);
		caseInfo.setRegionId("321011      ");
		caseInfo.setAttachList(ids);
		caseInfo.setQuesResource("09");
		caseInfo.setQuesChannel("04");
		//caseInfo.setWorkflow_id(workflow_id);
		
		String mainEnt = null==doc.getMainEnt() ? "" : ("_"+doc.getMainEnt());
		String minorEnt = null==doc.getMinorEnt() ? "": ("_"+doc.getMinorEnt());
		caseInfo.setQuestionDesc("("+doc.getAcceptMode()+"_"+doc.getAcceptSource()+mainEnt+minorEnt+")"+"("+doc.getOpSerialNumber()+")"+doc.getBJContent());
		caseInfo.setCaseCode(doc.getOpSerialNumber());
		
		caseInfo.setOccurTime(doc.getAccTime());
		
		//String pos = doc.getURBAN() + doc.getSTREET() + doc.getDoorplateNum();
		String urban=(null!=doc.getURBAN()) ? doc.getURBAN() : "";
		String street=(null!=doc.getSTREET()) ? doc.getSTREET() : "";
		String community=(null!=doc.getCOMMUNITY()) ? doc.getCOMMUNITY() : "";
		String doorplatenum=(null!=doc.getDoorplateNum()) ?doc.getDoorplateNum() : "";
		String Streetlampnum = (null!=doc.getStreetlampNum()) ? doc.getStreetlampNum() : "";
		String address=(null!=doc.getAddress()) ? doc.getAddress() : "";
		String pos=address+" ("+urban+" "+street+" "+community+" "+doorplatenum+" "+Streetlampnum+") ";
		caseInfo.setPositionDesc(pos);
		caseInfo.setBgcode("321011");
		caseInfo.setRegionId("321011");
		caseInfo.setReportDesc(doc.getKHXM()+" "+doc.getKHDH());
		//caseInfo.setIsdispatch("0");
		
		//add by yixin ��������ʵ����û��applycount����ֶΣ����Խ���ɾ��
		//caseInfo.setApplycount("0");
		
		caseInfo.setEffRangeDesc(urban);
		caseInfo.setNote(doc.getRemark());
		caseInfo.setReporter(doc.getKHXM());
		caseInfo.setReportTime(doc.getAccTime());// ��ʱ���¼�ϱ�����ǹ�ʱ��ϵͳʱ��
		caseInfo.setRegisterTime(new Date());//��ʱ���¼�ϱ�����ǹ�ʱ��ϵͳʱ��
		String lxfs = (null==doc.getLXFS()||"".equals(doc.getLXFS()) )? "" : doc.getLXFS();
		
		caseInfo.setReporterInfo(doc.getKHDH()+" "+lxfs);
		//caseInfo.setOrg_list("���й����");
		//caseInfo.setCurr_org("373");
		caseInfo.setScgjType(doc.getSystemVersion());
		return caseInfo;
	}
	
}
