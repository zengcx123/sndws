/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：中国苏州科技城青山路1号
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: 苏州公安统一用户管理平台1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:Processor0107.java
 * <p>
 * 类产生时间: Jun 8, 2013 12:00:43 AM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * 所在组 : 苏州公安统一用户管理平台
 * <p>
 * 所在部门: 电信/国土——技术二部
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
 * 中心再交办信息<br>
 * 监督指挥中心将业务的再交办信息发送给部门
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
		// 1.根据工单号加载上一次交办记录，如果不存在记录，则不处理
		XtCaseInfo base = casedao.findXtCaseInfoByCode(doc.getOpDigNumGather());
		if (null == base) {
			//临时 可以转交办
			// 3.生成案件编号
			String caseId = casedao.getCaseId();
			if (null != msg.getBody().getAttchments() && msg.getBody().getAttchments().size() > 0) {
				String ids = attdao.save(msg.getBody().getAttchments());
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,ids), "218");
			} else {
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,""), "218");
			}
			logger.info("=============解析并保存市城管工单ATAF0107 转交办成功，工单号是：==============="+caseCode);
			return new Result(String.format("[结果]:成功,[类型]:ATAF0001,[编号]:%1$s", caseId));
		}
		XtCaseDetail detail = new XtCaseDetail();
		detail.setNote(doc.getReturnVisitContent());
		detail.setDisposalInfo(doc.getReturnVisitContent());
		detail.setDisposalResult(doc.getPassCause());//处理结果
		detail.setRefNo(doc.getOpDigNumGather());
		detail.setCreateTime(new Date());
		detail.setOperator("218");
		detail.setCaseStatus("0401");// 代派遣
		detail.setEndTime(new Date());
		// 计算再交办延长时间(再交办时间-第一次收到的时间)
		base.setRefuseOTime(doc.getRefuseOverTime());//拒绝时限
		//2015年8月13日15:39:42 再交办 清除市里给的上报时间
		base.setReportTime(null);
		base.setQuestionDesc(base.getQuestionDesc() + " " + doc.getPassCause());// 问题描述，将再交办交办原因追加至原描述内容后
		base.setEffRangeDesc("");
		if(StringUtils.hasText(doc.getReturnVisitContent())){
			base.setNote(doc.getDispatchOpinion()+"____回访内容:"+doc.getReturnVisitContent());
		}else{
			base.setNote(doc.getDispatchOpinion());
		}
		base.setExtDate(doc.getDisposalTime());//处置时限
		base.setCaseStatus("0401");
		base.setExtNumber(base.getExtNumber());
		//2015年8月6日13:45:45 市城管再交办 添加附件功能
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
			return new Result(Result.FAILURE, String.format("工单[%1$s]再交办%2$s", base.getExtChar(), (rt ? "成功" : "失败")));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("=============保存市城管工单ATAF0107至业务平台出错！！！，工单号是：==============="+caseCode, ex);
			return new Result(Result.FAILURE, "工单再交办失败");
		}
	}
	
	public XtCaseInfo makeCaseInfo(ATAF0107 doc,String caseId,String ids){
		XtCaseInfo caseInfo = new XtCaseInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caseInfo.setCaseId(caseId);
		String caseName=doc.getAcceptType();
		caseInfo.setCaseName(caseName+"（市）");
		if("报修".equals(caseName)){
			caseInfo.setCaseType("1201");
		}else if("抢修".equals(caseName)){
			caseInfo.setCaseType("1202");
		}else if("服务求助".equals(caseName)){
			caseInfo.setCaseType("1204");
		}else if("投诉".equals(caseName)){
			caseInfo.setCaseType("1205");
		}else if("咨询".equals(caseName)){
			caseInfo.setCaseType("1206");
		}else if("建议".equals(caseName)){
			caseInfo.setCaseType("1207");
		}else if("举报".equals(caseName)){
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
		
		//add by yixin 由于在真实库中没有applycount这个字段，所以将此删除
		//caseInfo.setApplycount("0");
		
		caseInfo.setEffRangeDesc(urban);
		caseInfo.setNote(doc.getRemark());
		caseInfo.setReporter(doc.getKHXM());
		caseInfo.setReportTime(doc.getAccTime());// 此时间记录上报到大城管时的系统时间
		caseInfo.setRegisterTime(new Date());//此时间记录上报到大城管时的系统时间
		String lxfs = (null==doc.getLXFS()||"".equals(doc.getLXFS()) )? "" : doc.getLXFS();
		
		caseInfo.setReporterInfo(doc.getKHDH()+" "+lxfs);
		//caseInfo.setOrg_list("城市管理局");
		//caseInfo.setCurr_org("373");
		caseInfo.setScgjType(doc.getSystemVersion());
		return caseInfo;
	}
	
}
