package test.com.oceansoft.sndws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oceansoft.sndws.ws.IProcessService_New;
import com.oceansoft.sndws.ws.impl.PrcessService_New;

public class Test {
	private static final Logger log = LoggerFactory.getLogger(Test.class);
	public static void main(String arg[]){
//		IProcessService_New i = new PrcessService_New();
//		String MessageInfo = "<?xml version='1.0' encoding='GBK' standalone='yes'?><ROOTMAIN><CASEMAIN><SECTIONTASKNUM>����ƽ̨�����</SECTIONTASKNUM><CITYTASKNUM>�м�ƽ̨�����</CITYTASKNUM><EVENTSRCCODE>������Դ���</EVENTSRCCODE><EVENTTYPECODE>�������ͱ��</EVENTTYPECODE><MAINTYPECODE>������</MAINTYPECODE><SUBTYPECODE>С����</SUBTYPECODE><NEWINSTCONDCODE>�����������</NEWINSTCONDCODE><DISTRICTCODE>�����������</DISTRICTCODE><STREETCODE>�����ֵ����</STREETCODE><COMMUNITYCODE>�����������</COMMUNITYCODE><COORDINATEX></COORDINATEX><COORDINATEY></COORDINATEY><ADDRESS>λ��˵��</ADDRESS><EVENTDESC>��������</EVENTDESC><REGISTTIME></REGISTTIME><PATROLNAME>�ϱ��ලԱ����</PATROLNAME><PATROLTEL></PATROLTEL><RETURNVISITFLAG>�طñ�ʶ</RETURNVISITFLAG><URGENTLEVEL></URGENTLEVEL><REPLYIN2HOURSFLAG></REPLYIN2HOURSFLAG><LOCKEDFLAG>������ʶ</LOCKEDFLAG></CASEMAIN><CASEOPERATONDETAIL><SECTIONTASKNUM>����ƽ̨�����</SECTIONTASKNUM><CITYTASKNUM>�м�ƽ̨�����</CITYTASKNUM><REQUEST>�������Ҫ��</REQUEST><TIMELIMIT></TIMELIMIT><DISPATCHHUMAN>���������</DISPATCHHUMAN><DISPATCHHUMANTEL></DISPATCHHUMANTEL><DISPATCHTIME></DISPATCHTIME><MEMO>��ע</MEMO><ATTACHMENT><ITEM><ATTACHPATH></ATTACHPATH><ATTACHTYPE></ATTACHTYPE><ATTACHNAME></ATTACHNAME></ITEM><ITEM><ATTACHPATH></ATTACHPATH><ATTACHTYPE></ATTACHTYPE><ATTACHNAME></ATTACHNAME></ITEM></ATTACHMENT></CASEOPERATONDETAIL></ROOTMAIN>";
//		String result = i.processMessage("00", "03", "02", MessageInfo);
//		System.out.println(result);
		
	
		log.error("������ƽ̨�ӿڴ���,�ӿڱ�ţ�" + ",�����ţ�" 
				+ ",xml��"  + ",��ʼ�ط�");

	}	
}
