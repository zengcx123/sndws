package test.com.oceansoft.sndws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oceansoft.sndws.ws.IProcessService_New;
import com.oceansoft.sndws.ws.impl.PrcessService_New;

public class Test {
	private static final Logger log = LoggerFactory.getLogger(Test.class);
	public static void main(String arg[]){
//		IProcessService_New i = new PrcessService_New();
//		String MessageInfo = "<?xml version='1.0' encoding='GBK' standalone='yes'?><ROOTMAIN><CASEMAIN><SECTIONTASKNUM>区级平台任务号</SECTIONTASKNUM><CITYTASKNUM>市级平台任务号</CITYTASKNUM><EVENTSRCCODE>问题来源编号</EVENTSRCCODE><EVENTTYPECODE>问题类型编号</EVENTTYPECODE><MAINTYPECODE>大类编号</MAINTYPECODE><SUBTYPECODE>小类编号</SUBTYPECODE><NEWINSTCONDCODE>立案条件编号</NEWINSTCONDCODE><DISTRICTCODE>所属城区编号</DISTRICTCODE><STREETCODE>所属街道编号</STREETCODE><COMMUNITYCODE>所属社区编号</COMMUNITYCODE><COORDINATEX></COORDINATEX><COORDINATEY></COORDINATEY><ADDRESS>位置说明</ADDRESS><EVENTDESC>问题描述</EVENTDESC><REGISTTIME></REGISTTIME><PATROLNAME>上报监督员姓名</PATROLNAME><PATROLTEL></PATROLTEL><RETURNVISITFLAG>回访标识</RETURNVISITFLAG><URGENTLEVEL></URGENTLEVEL><REPLYIN2HOURSFLAG></REPLYIN2HOURSFLAG><LOCKEDFLAG>锁单标识</LOCKEDFLAG></CASEMAIN><CASEOPERATONDETAIL><SECTIONTASKNUM>区级平台任务号</SECTIONTASKNUM><CITYTASKNUM>市级平台任务号</CITYTASKNUM><REQUEST>任务分派要求</REQUEST><TIMELIMIT></TIMELIMIT><DISPATCHHUMAN>任务分派人</DISPATCHHUMAN><DISPATCHHUMANTEL></DISPATCHHUMANTEL><DISPATCHTIME></DISPATCHTIME><MEMO>备注</MEMO><ATTACHMENT><ITEM><ATTACHPATH></ATTACHPATH><ATTACHTYPE></ATTACHTYPE><ATTACHNAME></ATTACHNAME></ITEM><ITEM><ATTACHPATH></ATTACHPATH><ATTACHTYPE></ATTACHTYPE><ATTACHNAME></ATTACHNAME></ITEM></ATTACHMENT></CASEOPERATONDETAIL></ROOTMAIN>";
//		String result = i.processMessage("00", "03", "02", MessageInfo);
//		System.out.println(result);
		
	
		log.error("调用市平台接口错误,接口编号：" + ",工单号：" 
				+ ",xml："  + ",开始重发");

	}	
}
