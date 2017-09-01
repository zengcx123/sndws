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
 * 文件名:Processor0001.java
 * <p>
 * 类产生时间: Jun 7, 2013 11:06:03 PM
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.log4j.Logger;
import org.codehaus.xfire.util.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.IAttachmentDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.IWorkflowDao;
import com.oceansoft.sndws.entity.ATAF0001;
import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;
import com.oceansoft.sndws.util.Constant;
import com.oceansoft.sndws.util.ConvertUtil;

/**
 * <b>中心工单批转业务处理器</b><br>
 * 为中心批转业务，批转给各协同办公单位。该类型有可能发送附件（电子文档）。
 * 
 * @author chenw
 * 
 */
@Component
public class Processor0001 implements IProcess {
	private static Logger logger = Logger.getLogger(Processor0001.class);
	@Resource
	private ICaseInfoDao casedao;
	@Resource
	private IAttachmentDao attdao;
	@Resource
	private IWorkflowDao flowdao;

	//private Logger logger = Logger.getLogger(Processor0001.class);
	
	public Result process(Message msg) throws Exception  {
		
		ATAF0001 doc = msg.getBody().getDocument(ATAF0001.class);
		Assert.notNull(doc,"工单为空");
		String caseCode = doc.getOpDigNumGather();// 市城管局工单唯一编号
		//logger.info(String.format("[类型]:ATAF0001,[编号]:%1$s", caseCode));
		
		
		
		
		// 1.数据完整性校验
		// 2.判断此工单是否已存在
		int num = casedao.getTotalNum(caseCode);
		if (num > 0) {
			return new Result(Result.FAILURE, String.format("[结果]:失败,[类型]:ATAF0001,[编号]:%1$s,[原因]：%2$s", caseCode,
					"工单已存在！"));
		}
		// 3.生成案件编号
		String caseId = casedao.getCaseId();
		
		/*
		// 4.生成工作流编号
		String wfid = flowdao.getWorkFlowId();
		
		*/
		
		
		
		// 5.保存数据
		try{
			if (null != msg.getBody().getAttchments() && msg.getBody().getAttchments().size() > 0) {
				String ids = attdao.save(msg.getBody().getAttchments());
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,ids), "218");
				//casedao.save(processData(doc, caseId, ids, wfid));
			} else {
				//casedao.save(processData(doc, caseId, "", wfid));
				flowdao.saveCaseAndWorkflow(makeCaseInfo(doc,caseId,""), "218");
			}
			logger.info("=============解析并保存市城管工单ATAF0001成功，工单号是：==============="+caseCode);
		}catch(Exception e){
			logger.error("=============保存市城管工单ATAF0001至业务平台出错！！！，工单号是：==============="+caseCode);
			logger.error("2=====>>>"+e);
			return new Result(Result.FAILURE, String.format("[结果]:失败,[类型]:ATAF0001,[编号]:%1$s",caseCode));
		}
		//logger.info("==============接收市城管ATAF0001工单  "+doc.getOpDigNumGather()+"  成功");
		// 7.生成消息
		return new Result(String.format("[结果]:成功,[类型]:ATAF0001,[编号]:%1$s", caseId));
		
		
			
			//logger.error(sw.toString());
			//logger.error("==============接收市城管ATAF0001工单  "+doc.getOpDigNumGather()+"  出错");
		
		
	}
		
	

	/**
	 * 保存工单
	 * 
	 * @param doc
	 * @param caseId
	 * @param ids
	 * @param workflowId
	 * @return
	 */
	private Map<String, Object> processData(ATAF0001 doc, String caseId, String ids, String workflowId) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("case_id", caseId);
		params.put("case_name", doc.getAcceptMode() + doc.getAcceptSource());
		params.put("ext_char", doc.getOpDigNumGather());
		params.put("ext_number", 1);
		params.put("case_status", "0101");
		params.put("case_level", "3");
		params.put("ext_date", doc.getDisposalTime());
		params.put("refuse_otime", doc.getRefuseOverTime());
		params.put("pos_x", 0);
		params.put("pos_y", 0);
		params.put("region_id", "321011      ");
		params.put("attach_list", ids);
		params.put("ques_resource", "09");
		params.put("ques_channel", "04");
		params.put("workflow_id", workflowId);
		params.put("question_desc", "" + doc.getAcceptCaseCondition());
		params.put("case_code", doc.getOpSerialNumber());
		params.put("case_type", "0301");
		params.put("occur_time", doc.getAccTime());// 市局工单受理时间
		String pos = doc.getURBAN() + doc.getSTREET() + doc.getDoorplateNum();
		params.put("position_desc", "".equals(pos) ? "无" : pos);
		params.put("bgCode", "321011");
		params.put("region_id", "321011");
		//params.put("region_id", "321011");
		params.put("reporter_desc", doc.getKHXM());
		params.put("isdispatch", "0");
		//add by yixin 由于在真实库中没有applycount这个字段，所以将此删除
		//params.put("applycount", "0");
		params.put("eff_range_desc", doc.getURBAN());
		params.put("note", doc.getRemark());
		params.put("reporter", doc.getKHXM());
		params.put("report_time", new Date());// 此时间记录上报到大城管时的系统时间
		params.put("register_time", new Date());// 此时间记录上报到大城管时的系统时间
		params.put("reporter_info", doc.getLXFS());
		params.put("org_list", "城市管理局");
		params.put("curr_org", "373");
		return params;
	}
	
	//add by yixin
	public XtCaseInfo makeCaseInfo(ATAF0001 doc,String caseId,String ids){
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

	/**
	 * 附件处理
	 * 
	 * @param attchments
	 */
	@SuppressWarnings("unused")
	private void processAttachemnt(List<Attachment> attachments) {
		if (null != attachments && 0 < attachments.size()) {
			for (Attachment att : attachments) {
				if (null != att && !"null".equals(att.getContent())) {
					byte[] content = Base64.decode(att.getContent());
					ConvertUtil.genFileFromByte(
							content,
							String.format("%1$s%2$s.%3$s", Constant.ATTACHMENT_PATH, att.getFileName(),
									att.getContentType()));
				}
			}
		}
	}
	
	
}
