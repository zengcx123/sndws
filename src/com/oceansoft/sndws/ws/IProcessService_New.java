package com.oceansoft.sndws.ws;

import javax.jws.WebService;

@WebService
public  interface IProcessService_New {
	
	
	/**
	 * 
	 * @param SenderCode   发送方平台代码
	 * @param ReceiverCode 接收方平台代码
	 * @param OperationCode 接口类型编码
	 * @param MessageInfo  传递消息的数据内容  ,  承载传递的数据内容，包含案件主单、操作单，以XML形式存在;
	 * @return
	 */
	public String processMessage (String SenderCode,
			String ReceiverCode,String OperationCode,
			String MessageInfo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
