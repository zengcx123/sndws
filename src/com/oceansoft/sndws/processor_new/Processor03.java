package com.oceansoft.sndws.processor_new;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF03;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * 
 * �᰸֪ͨ�ӿ�
 * 
 *
 */
@Component
public class Processor03 implements IProcess {

	@Resource
	private ICaseInfoDao basedao;
	
	@Resource
	private ICaseDetailDao detaildao;
	
	public Result process(Object o) {

		Result result = new Result();
		ATAF03 atf = (ATAF03)o;
		if(null != atf){
			// 1.�������������
			CaseInfo base = basedao.findByCode(atf.getCityTaskNum());
			if (null == base) {
				result.setReason("��ţ�"+atf.getCityTaskNum()+"�Ĺ��������ڣ��޷����н᰸��������");
				return result;
			}
			base.setExt_char(atf.getCityTaskNum());//�гǹܱ��
			base.setSatisfaction_degree(atf.getSatisfactionlevel());//�������ʱ��Ϊ��			
			//����
			if(atf.getEndCaseType().equals("2")){
				base.setCase_status("0303");
				basedao.updateSatifaction(base);
			}
				
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());//�������
			detail.setNote("�гǹܹ����ط�");//�ڵ㱸ע
			detail.setDisposal_info(atf.getEndCaseOpinion());//�ڵ㴦����Ϣ
			detail.setDisposal_result("");//�ڵ㴦�ý��
			detail.setRef_no(atf.getCityTaskNum());//�ο���
			detail.setCreate_time(new Date());//�ڵ������ʼʱ��
			detail.setSatisfactionlevel(atf.getSatisfactionlevel());//�����
			detail.setReturnvisitopinion(atf.getReturnvisitopinion()); //�ط����
			detail.setOperator("218");//����Ա
			detail.setRecanalyse(atf.getRecanalyse());//Υ���᰸��ʽ

			if(atf.getEndCaseType().equals("2")){
				detail.setCase_status("0303");//����״̬
				detaildao.save(detail);
			}
			
			return new Result(0, String.format("[�гǹܹ������]:%1$s�᰸֪ͨ��˳ɹ�", atf.getCityTaskNum()));
//			result.setResultValue(0);
//			result.setReason("�ɹ�");
//			return result;
		}else{
			MailUti.init("�᰸֪ͨ�ӿ�","�᰸����XML��Ϣ����ʧ��",atf.getCityTaskNum());
			result.setReason("�᰸����XML��Ϣ����ʧ��");
			return result;
		}
	}

}
