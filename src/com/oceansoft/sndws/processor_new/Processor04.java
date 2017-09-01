package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.entity.ATAF01182;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF04;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * ������������
 * @author liyang
 *
 */
@Component
public class Processor04 implements IProcess{

	@Resource
	private ICaseInfoDao basedao;
	
	@Resource
	private ICaseDetailDao detaildao;
	
	@Resource
	private ICaseTempDao tempDao;
	
	public Result process(Object o) {
		
		Result result = new Result();
		ATAF04 atf = (ATAF04)o;
		if(null != atf){
			CaseInfo base = basedao.findByCode(atf.getCityTaskNum());
			if (null == base) {
				result.setReason("��ţ�"+atf.getCityTaskNum()+"�Ĺ���������,�޷���ɻ�����������");
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());
			detail.setNote("�гǹܹ�����˾�ǩ");
			detail.setDisposal_result(0==atf.getReplyResult() ? "��ͬ��" : "ͬ��");
			detail.setDisposal_info(atf.getReplyOpinion());
			//detail.setDisposal_info("�����Ա��" + atf.getReplyHuman() + " ��˽����"+ ("0".equals(atf.getReplyResult()) ? "��ͬ��" : "ͬ��") + " ��� ʱ��:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atf.getReplyTime()));
			detail.setRef_no(atf.getCityTaskNum());
			detail.setCreate_time(new Date());		
			detail.setCase_status(0==atf.getReplyResult() ? "0401" : "0303");
			detail.setOperator("218");
			
			detaildao.save(detail);
			XtCaseInfo xtcaseInfo=new XtCaseInfo();
			xtcaseInfo.setExtChar(base.getExt_char());
			//�����ͬ��״̬��Ϊ����ǲ״̬��ͬ����Ϊ�Ѱ�״̬
			xtcaseInfo.setCaseStatus(0==atf.getReplyResult() ? "0401" : "0303");
			basedao.updateStatus(xtcaseInfo); //����
			tempDao.copyFromViewListToTemp(base.getCase_id());
			return new Result(0, String.format("[�гǹܹ������]:%1$s��ǩ��˳ɹ�", atf.getCityTaskNum()));
//			result.setResultValue(0);
//			result.setReason("�ɹ�");
//			return result;
		}else{
			MailUti.init("������������","�������XML��Ϣ����ʧ��",atf.getCityTaskNum());
			result.setReason("�������XML��Ϣ����ʧ��");
			return result;
		}
	}
}
