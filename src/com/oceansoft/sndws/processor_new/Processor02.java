package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.IAttachmentDao;
import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.IWorkflowDao;

import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF02;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import com.oceansoft.sndws.entity.bean_new.CaseOperatonDetail;
import com.oceansoft.sndws.entity.bean_new.Process;

import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;

/**
 * ��ƽ̨�������ɽ��̴���
 * @author liyang
 *
 */
@Component
public class Processor02 implements IProcess {

	@Resource
	private ICaseInfoDao casedao;
	
	@Resource
	private IAttachmentDao attdao;
	
	@Resource
	private IWorkflowDao flowdao;
	
	@Resource
	private ICaseInfoDao basedao;

	@Resource
	private ICaseDetailDao detaildao;
	
	private static Logger LOGGER = Logger.getLogger(Processor02.class);
	@SuppressWarnings("unchecked")
	public Result process(Object o) {
		
		Result result= new Result();
		ATAF02 atf = (ATAF02) o;
		if(null !=atf){
			try{
				
				String cityTaskNum = atf.getCaseMain().getCityTaskNum();
				int num = casedao.getTotalNum(cityTaskNum);	
				String caseId="";
				if(num>0){
					CaseInfo  caseInfo= casedao.findByCode(cityTaskNum);
					String caseStatus= caseInfo.getCase_status();
							
					//�гǹܶ������ǹܻ������벻�ɹ��ĵ��ӻ��߽᰸��˲�ͨ���ĵ��ӻ��ٴε�����ǲ�ӿ�    0303�ϰ�״̬      0603�᰸״̬
					if("0303".equals(caseStatus)||"0603".equals(caseStatus)){
//					if(!"0303".equals(caseStatus)&&!"0603".equals(caseStatus)){
						List<Process> processList =atf.getCaseOperatonDetail().getProcess();
						
						attdao.save3(processList,caseId);
						
						XtCaseInfo caseInfo2 = new XtCaseInfo();
						caseInfo2.setCaseStatus("0401");	
						
						CaseInfo base = basedao.findByCode(atf.getCaseOperatonDetail().getCityTaskNum());
						
						if (null == base) {
							result.setReason("��ţ�"+atf.getCaseOperatonDetail().getCityTaskNum()+"�Ĺ��������ڣ��޷����н᰸��������");
							return result;
						}
						
						CaseDetail detail = new CaseDetail();
						detail.setCase_id(base.getCase_id());
						detail.setOperator("218");//����Ա
						detail.setCase_status("0401");//����״̬
						detail.setCreate_time(new Date());						
						detail.setDisposal_info(atf.getCaseOperatonDetail().getRequest()+"�ڽ��칤��");//�ڽ������
						detail.setReturnvisitopinion(atf.getCaseOperatonDetail().getReturnvisitopinion());//�ط��Ѿ�
						detail.setSatisfactionlevel(atf.getCaseOperatonDetail().getSatisfactionlevel());//�����
						detaildao.save(detail);
							
							caseId=caseInfo.getCase_id();	
						//return result;
					}else{
						caseId=caseInfo.getCase_id();					
					}
				}else{
					//   ������ǲʱҪ������ƽ̨�������
					  caseId = casedao.getCaseId();
				}
				//������Ϣ
				List<Attachment_New> attachments = atf.getCaseOperatonDetail().getAttachment();
			
				if(null != attachments && attachments.size()>0){
					//���渽��
					String ids = attdao.save2(atf.getCaseOperatonDetail().getAttachment());
					
					//����������Ϣ
					flowdao.saveCaseAndWorkflow(makeCaseInfo(atf,caseId,ids), "218");
			
				}else{
					//����������Ϣ
					XtCaseInfo caseInfo = new XtCaseInfo();
					caseInfo.setCaseId(caseId);
					caseInfo.setReply2h(atf.getCaseOperatonDetail().getArchivecond());
					detaildao.update(caseInfo);

					//����������Ϣ
					flowdao.saveCaseAndWorkflow(makeCaseInfo(atf,caseId,""), "218");
				}
				//return new Result(0, String.format("[�гǹܹ������]:%1$s��������ɳɹ�", atf.getCaseMain().getCityTaskNum()));
				result.setResultValue(0);
				result.setReason("�ɹ�");
				return result;
			}catch(Exception e){
				LOGGER.error(e);
				MailUti.init("�������","�������XML��Ϣ����ʧ��",atf.getCaseMain().getCityTaskNum());
				e.printStackTrace();
				result.setReason(e.getClass().getName());
				return result;
			}
			
		}else{
			result.setReason("��������XML��Ϣ����ʧ��");
			return result;
		}
	}
	
	/**
	 * ����Ϣʵ��ͳһת����XtCaseInfo�������ڴ洢
	 * @param at ATAF02ʵ��
	 * @param caseId ��ƽ̨�����
	 * @param ids ����
	 * @return XtCaseInfo
	 */
	public XtCaseInfo makeCaseInfo(ATAF02 at,String caseId,String ids){
		XtCaseInfo caseInfo = new XtCaseInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caseInfo.setCaseId(caseId);//����ƽ̨�����
		caseInfo.setExtChar(at.getCaseMain().getCityTaskNum());//�м�ƽ̨�����
		caseInfo.setQuesResource("09");//������Դ
		//��С��
		String sbjbh=at.getCaseMain().getEventTypeCode();//�²������
		if("01".equals(sbjbh)){
			sbjbh="02";
		}else {
			sbjbh="01";
		}
		String dalei=at.getCaseMain().getMainTypeCode().substring(1);//����
		String xiaolei=at.getCaseMain().getSubTypeCode().substring(3);//С��
		caseInfo.setEffRangeDesc("������");
		//caseInfo.setPositionDesc(at.getCaseMain().getDistrictCode()+"-"+at.getCaseMain().getStreetCode()+"-"+at.getCaseMain().getCommunityCode());//��ַ��ʱ�洢���Ǳ��
		caseInfo.setPositionDesc(at.getCaseMain().getAddress());
		caseInfo.setQuesChannel("04");//������Դ����
		caseInfo.setExtNumber(1.0);//����������ķ��ʹ���
		caseInfo.setCaseStatus("0401");//����״̬��0101���ѵǼ�
		caseInfo.setCaseLevel("3");//��������3��һ�㰸��

		caseInfo.setCaseType(at.getCaseMain().getEventTypeCode());// ��������
		
		caseInfo.setExtDate(at.getCaseOperatonDetail().getEndTime());//����ʱ��
		caseInfo.getSatisfyDegree(at.getCaseOperatonDetail().getSatisfactionlevel());
		//caseInfo.setRefuseOTime(doc.getRefuseOverTime());	
		caseInfo.setPosX(at.getCaseMain().getCoordinateX());
		caseInfo.setPosY(at.getCaseMain().getCoordinateY());
		caseInfo.setNote(at.getCaseOperatonDetail().getMemo());//��ע
		caseInfo.setReporter(at.getCaseMain().getPatrolName());//�ϱ���
		caseInfo.setReporterInfo(at.getCaseMain().getPatrolTel());//�ϱ��˵绰
		caseInfo.setReportTime(at.getCaseMain().getRegistTime());// ��ʱ���¼�ϱ�����ǹ�ʱ��ϵͳʱ��
		caseInfo.setRegisterTime(new Date());//��ƽ̨����ʱ��
		caseInfo.setRegionId("321011      ");
		caseInfo.setAttachList(ids);;
	
		caseInfo.setOccurTime(at.getCaseOperatonDetail().getDispatchTime());//�������ʱ��
		//caseInfo.setAcceptopinion(at.getCaseOperatonDetail().getAcceptopinion());//�����ٽ���/ת�������
		//caseInfo.setReturnvisitopinion(at.getCaseOperatonDetail().getReturnvisitopinion());//�ط����
		//caseInfo.setSatisfactionlevel(at.getCaseOperatonDetail().getSatisfactionlevel());//�����
		
		caseInfo.setBgcode("321011");
		caseInfo.setRegionId("321011");
		caseInfo.setReportDesc(at.getCaseMain().getPatrolName()+":"+at.getCaseMain().getPatrolTel());
		//��������
		String mainEnt = null==at.getCaseMain().getMainTypeCode() ? "" : ("_"+at.getCaseMain().getMainTypeCode());
		String minorEnt = null==at.getCaseMain().getSubTypeCode() ? "": ("_"+at.getCaseMain().getSubTypeCode() );
		caseInfo.setQuestionDesc(at.getCaseMain().getEventdesc());	
	
		caseInfo.setScgjType("v3");
	
		caseInfo.setReturnVisitFlag(String.valueOf(at.getCaseMain().getReturnVisitFlag()));
		caseInfo.setReply2h(String.valueOf(at.getCaseMain().getReplyin2HoursFlag()));

		//�ܾ�ʱ��
		caseInfo.setRefuseOTime(at.getCaseOperatonDetail().getRefusedeadline());
		//�᰸����
//		caseInfo.setReply2h(at.getCaseOperatonDetail().getArchivecond());
		return caseInfo;
	}
	
}



