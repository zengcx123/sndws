package com.oceansoft.sndws.processor_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oceansoft.sndws.dao.ICaseDetailDao;
import com.oceansoft.sndws.dao.ICaseInfoDao;
import com.oceansoft.sndws.dao.ICaseTempDao;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean.CaseInfo;
import com.oceansoft.sndws.entity.bean_new.ATAF06;
import com.oceansoft.sndws.entity.bean_new.Result;
import com.oceansoft.sndws.util.MailUti;
/**
 * ��������
 */
@Component
public class Processor06 implements IProcess {
	
	@Resource
	private ICaseInfoDao basedao;
	@Resource
	private ICaseDetailDao detaildao;
	@Resource
	private ICaseTempDao tempDao;	
	
	@Override
	public Result process(Object o) {
		Result result= new Result();
		ATAF06 atf = (ATAF06) o;
		if(null !=atf){

			CaseInfo base = basedao.findByCode(atf.getCityTasKnum());
			if (null == base) {
				return new Result(1, String.format("�������[%1$s]�����ڣ��޷������ٽ��촦��", atf.getCityTasKnum()));
			}
			CaseDetail detail = new CaseDetail();
			detail.setCase_id(base.getCase_id());
			detail.setNote("�гǹܹ�������");
			//detail.setCase_status("1202");
			detail.setDisposal_result("0".equals(atf.getOptType()) ? "����" : "����");
			detail.setDisposal_info("�����Ա��" + atf.getOpThuman() + " ��˽����"
					+ ( " ��� ʱ��:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atf.getOptTime())));
			
			detail.setCreate_time(new Date());
			detail.setOperator("218");
			detaildao.save(detail);
			tempDao.copyFromViewListToTemp(base.getCase_id());
			return new Result(0, String.format("[�гǹܹ������]:%1$s�����ɹ�", atf.getCityTasKnum()));
					
			//result.setResultValue(0);
			//result.setReason("�ɹ�");
			//return result;
		}else{
			MailUti.init("��������","�����������XML��Ϣ����ʧ��",atf.getCityTasKnum());
			result.setReason("��Ϣ����ʧ��");
			return result;
		}
		
		

	}

}
