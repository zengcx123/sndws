package com.oceansoft.sndws.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean.XtAttachInfo;

/**
 * 大城管回调接口服务器接口
 * @author wyf
 *
 */
@WebService
public interface ICallbackFromWebsnd {

	/** 保存附件
	 *  @param caseInfo  需要保存的附件类
	 *  @return 操作是否成功
	 */
	public boolean saveAttachFile(String attachXml);
	
	
	//public boolean testWeb(String attachXml);
	
}
