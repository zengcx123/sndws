package com.oceansoft.sndws.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean.XtAttachInfo;

/**
 * ��ǹܻص��ӿڷ������ӿ�
 * @author wyf
 *
 */
@WebService
public interface ICallbackFromWebsnd {

	/** ���渽��
	 *  @param caseInfo  ��Ҫ����ĸ�����
	 *  @return �����Ƿ�ɹ�
	 */
	public boolean saveAttachFile(String attachXml);
	
	
	//public boolean testWeb(String attachXml);
	
}
