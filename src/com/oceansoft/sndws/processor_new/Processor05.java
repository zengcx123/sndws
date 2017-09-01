package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.dao.ITaskInfoDao;
import com.oceansoft.sndws.dao.IWorkflowDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean.TaskInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF05;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;

/**
 * ��������
 */
@Component
public class Processor05 implements IProcess {
    @Resource
    private ICaseInfoDao basedao;
    @Resource
    private ICaseDetailDao detaildao;
    @Resource
    private ICaseTempDao tempDao;
    @Resource
    private ITaskInfoDao taskInfoDao;
    @Resource
    private IWorkflowDao flowdao;

    @Override
    public Result process(Object o) {
        Logger logger = Logger.getLogger(Processor05.class);
        Result result = new Result();
        ATAF05 atf = (ATAF05) o;
        if (null != atf) {

            CaseInfo base = basedao.findByCode(atf.getCityTasKnum());
            if (null == base) {
                return new Result(1, String.format("�������[%1$s]�����ڣ��޷�������ʱ", atf.getCityTasKnum()));
            }

            String caseid = base.getCase_id();
            String taskid = taskInfoDao.getLatestTaskInfoForDelay(caseid);//��ȡ����һ����¼��taskid
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.setTaskId(taskid);
            taskInfo.setAuditor12345(atf.getReplyHuman());
            taskInfo.setAudit12345Endtime(atf.getNewEndTime());
            taskInfo.setAudit12345Time(atf.getReplyTime());
            if (1 == atf.getReplyResult()) {//ͬ��(0==atf.getReplyResult() ? "��ͬ��" : "ͬ��");11
                taskInfo.setTaskStatus("0704");
                taskInfo.setAudit12345Desc("ͬ��");
            } else if (0 == atf.getReplyResult()) {//��ͬ��
                taskInfo.setAudit12345Desc("��ͬ��");
                taskInfo.setTaskStatus("0705");
            } else {
            }
            //taskInfo.setCurrentDelay("P");

            taskInfoDao.updateTaskInfo(taskInfo);

            CaseDetail detail = new CaseDetail();
            detail.setCase_id(base.getCase_id());
            detail.setDisposal_info(atf.getReplyOpinion());
            if (1 == atf.getReplyResult()) {//ͬ��
                detail.setDisposal_result(atf.getReplyOpinion());
            } else if (0 == atf.getReplyResult()) {//��ͬ��
                detail.setDisposal_result(atf.getReplyOpinion());
            } else {

            }
            detail.setRef_no(atf.getCityTasKnum());
            detail.setCreate_time(new Date());
            detail.setOperator("218");
            detail.setCase_status("0704");
            detaildao.save(detail);
            XtCaseInfo caseInfo = new XtCaseInfo();
            caseInfo.setCaseId(caseid);
            caseInfo.setCaseStatus("0403");
            //������ʱ��
            caseInfo.setExtDate(atf.getNewEndTime());
            detaildao.update2(caseInfo);

            return new Result(0, String.format("[�гǹܹ������]:%1$s��ʱ��˳ɹ�", atf.getCityTasKnum()));

        } else {
            MailUti.init("��ʱ���", "������ʱXML��Ϣ����ʧ��", atf.getCityTasKnum());
            result.setReason("������ʱXML��Ϣ����ʧ��");
            return result;
        }
    }
}
//CaseDetail detail = new CaseDetail();
//detail.setCase_id(base.getCase_id());
//detail.setNote("�гǹܹ�����ʱ");
////ͬ��״̬��Ϊ��ʱ������ȷ�ϣ�0704����������Ϊ�����У�0403��
//detail.setCase_status(0==atf.getReplyResult() ? "0403" : "0704");
//
//detail.setDisposal_result("0".equals(atf.getReplyResult()) ? "��ͬ��" : "ͬ��");
//detail.setDisposal_info("�����Ա��" + atf.getReplyHuman() + " ��˽����"
//		+ ("0".equals(atf.getReplyResult()) ? "��ͬ��" : "ͬ��") + " ��� ʱ��:"
//		+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atf.getReplyTime()));
//
//detail.setCreate_time(new Date());
//detail.setOperator("218");
//detaildao.save(detail);
//XtCaseInfo xtcaseInfo=new XtCaseInfo();
//xtcaseInfo.setExtChar(base.getExt_char());
////ͬ��״̬��Ϊ��ʱ������ȷ�ϣ�0704����������Ϊ�����У�0403��
//xtcaseInfo.setCaseStatus(0==atf.getReplyResult() ? "0403" : "0704");
//basedao.updateStatus(xtcaseInfo);
//tempDao.copyFromViewListToTemp(base.getCase_id());
//return new Result(0, String.format("[�гǹܹ������]:%1$s��ʱ��˳ɹ�", atf.getCityTasKnum()));
//		
////result.setResultValue(0);
////result.setReason("�ɹ�");
////return result;
//}else{
//result.setReason("��Ϣ����ʧ��");
//return result;
//}
