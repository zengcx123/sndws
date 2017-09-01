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
 * 市平台工单分派进程处理
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
							
					//市城管对于区城管回退申请不成功的单子或者结案审核不通过的单子会再次调用派遣接口    0303废案状态      0603结案状态
					if("0303".equals(caseStatus)||"0603".equals(caseStatus)){
//					if(!"0303".equals(caseStatus)&&!"0603".equals(caseStatus)){
						List<Process> processList =atf.getCaseOperatonDetail().getProcess();
						
						attdao.save3(processList,caseId);
						
						XtCaseInfo caseInfo2 = new XtCaseInfo();
						caseInfo2.setCaseStatus("0401");	
						
						CaseInfo base = basedao.findByCode(atf.getCaseOperatonDetail().getCityTaskNum());
						
						if (null == base) {
							result.setReason("编号："+atf.getCaseOperatonDetail().getCityTaskNum()+"的工单不存在，无法进行结案反馈处理");
							return result;
						}
						
						CaseDetail detail = new CaseDetail();
						detail.setCase_id(base.getCase_id());
						detail.setOperator("218");//操作员
						detail.setCase_status("0401");//案件状态
						detail.setCreate_time(new Date());						
						detail.setDisposal_info(atf.getCaseOperatonDetail().getRequest()+"在交办工单");//在交办意见
						detail.setReturnvisitopinion(atf.getCaseOperatonDetail().getReturnvisitopinion());//回访已经
						detail.setSatisfactionlevel(atf.getCaseOperatonDetail().getSatisfactionlevel());//满意度
						detaildao.save(detail);
							
							caseId=caseInfo.getCase_id();	
						//return result;
					}else{
						caseId=caseInfo.getCase_id();					
					}
				}else{
					//   初次派遣时要生成区平台案件编号
					  caseId = casedao.getCaseId();
				}
				//保存信息
				List<Attachment_New> attachments = atf.getCaseOperatonDetail().getAttachment();
			
				if(null != attachments && attachments.size()>0){
					//保存附件
					String ids = attdao.save2(atf.getCaseOperatonDetail().getAttachment());
					
					//保存主表信息
					flowdao.saveCaseAndWorkflow(makeCaseInfo(atf,caseId,ids), "218");
			
				}else{
					//更新主表信息
					XtCaseInfo caseInfo = new XtCaseInfo();
					caseInfo.setCaseId(caseId);
					caseInfo.setReply2h(atf.getCaseOperatonDetail().getArchivecond());
					detaildao.update(caseInfo);

					//保存主表信息
					flowdao.saveCaseAndWorkflow(makeCaseInfo(atf,caseId,""), "218");
				}
				//return new Result(0, String.format("[市城管工单编号]:%1$s结任务分派成功", atf.getCaseMain().getCityTaskNum()));
				result.setResultValue(0);
				result.setReason("成功");
				return result;
			}catch(Exception e){
				LOGGER.error(e);
				MailUti.init("任务分配","任务分配XML信息解析失败",atf.getCaseMain().getCityTaskNum());
				e.printStackTrace();
				result.setReason(e.getClass().getName());
				return result;
			}
			
		}else{
			result.setReason("工单分派XML信息解析失败");
			return result;
		}
	}
	
	/**
	 * 将消息实例统一转换成XtCaseInfo对象，用于存储
	 * @param at ATAF02实例
	 * @param caseId 区平台任务号
	 * @param ids 附件
	 * @return XtCaseInfo
	 */
	public XtCaseInfo makeCaseInfo(ATAF02 at,String caseId,String ids){
		XtCaseInfo caseInfo = new XtCaseInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caseInfo.setCaseId(caseId);//区级平台任务号
		caseInfo.setExtChar(at.getCaseMain().getCityTaskNum());//市级平台任务号
		caseInfo.setQuesResource("09");//问题来源
		//大小类
		String sbjbh=at.getCaseMain().getEventTypeCode();//事部件编号
		if("01".equals(sbjbh)){
			sbjbh="02";
		}else {
			sbjbh="01";
		}
		String dalei=at.getCaseMain().getMainTypeCode().substring(1);//大类
		String xiaolei=at.getCaseMain().getSubTypeCode().substring(3);//小类
		caseInfo.setEffRangeDesc("高新区");
		//caseInfo.setPositionDesc(at.getCaseMain().getDistrictCode()+"-"+at.getCaseMain().getStreetCode()+"-"+at.getCaseMain().getCommunityCode());//地址暂时存储的是编号
		caseInfo.setPositionDesc(at.getCaseMain().getAddress());
		caseInfo.setQuesChannel("04");//问题来源渠道
		caseInfo.setExtNumber(1.0);//便民服务中心发送次数
		caseInfo.setCaseStatus("0401");//案件状态，0101：已登记
		caseInfo.setCaseLevel("3");//案件级别，3：一般案件

		caseInfo.setCaseType(at.getCaseMain().getEventTypeCode());// 问题类型
		
		caseInfo.setExtDate(at.getCaseOperatonDetail().getEndTime());//处置时限
		caseInfo.getSatisfyDegree(at.getCaseOperatonDetail().getSatisfactionlevel());
		//caseInfo.setRefuseOTime(doc.getRefuseOverTime());	
		caseInfo.setPosX(at.getCaseMain().getCoordinateX());
		caseInfo.setPosY(at.getCaseMain().getCoordinateY());
		caseInfo.setNote(at.getCaseOperatonDetail().getMemo());//备注
		caseInfo.setReporter(at.getCaseMain().getPatrolName());//上报人
		caseInfo.setReporterInfo(at.getCaseMain().getPatrolTel());//上报人电话
		caseInfo.setReportTime(at.getCaseMain().getRegistTime());// 此时间记录上报到大城管时的系统时间
		caseInfo.setRegisterTime(new Date());//区平台接收时间
		caseInfo.setRegionId("321011      ");
		caseInfo.setAttachList(ids);;
	
		caseInfo.setOccurTime(at.getCaseOperatonDetail().getDispatchTime());//任务分派时间
		//caseInfo.setAcceptopinion(at.getCaseOperatonDetail().getAcceptopinion());//便民再交办/转交办意见
		//caseInfo.setReturnvisitopinion(at.getCaseOperatonDetail().getReturnvisitopinion());//回访意见
		//caseInfo.setSatisfactionlevel(at.getCaseOperatonDetail().getSatisfactionlevel());//满意度
		
		caseInfo.setBgcode("321011");
		caseInfo.setRegionId("321011");
		caseInfo.setReportDesc(at.getCaseMain().getPatrolName()+":"+at.getCaseMain().getPatrolTel());
		//问题描述
		String mainEnt = null==at.getCaseMain().getMainTypeCode() ? "" : ("_"+at.getCaseMain().getMainTypeCode());
		String minorEnt = null==at.getCaseMain().getSubTypeCode() ? "": ("_"+at.getCaseMain().getSubTypeCode() );
		caseInfo.setQuestionDesc(at.getCaseMain().getEventdesc());	
	
		caseInfo.setScgjType("v3");
	
		caseInfo.setReturnVisitFlag(String.valueOf(at.getCaseMain().getReturnVisitFlag()));
		caseInfo.setReply2h(String.valueOf(at.getCaseMain().getReplyin2HoursFlag()));

		//拒绝时限
		caseInfo.setRefuseOTime(at.getCaseOperatonDetail().getRefusedeadline());
		//结案条件
//		caseInfo.setReply2h(at.getCaseOperatonDetail().getArchivecond());
		return caseInfo;
	}
	
}



