package com.oceansoft.sndws.ws;

import javax.jws.WebService;

@WebService
public  interface IProcessService_New {
	
	
	/**
	 * 
	 * @param SenderCode   ���ͷ�ƽ̨����
	 * @param ReceiverCode ���շ�ƽ̨����
	 * @param OperationCode �ӿ����ͱ���
	 * @param MessageInfo  ������Ϣ����������  ,  ���ش��ݵ��������ݣ�������������������������XML��ʽ����;
	 * @return
	 */
	public String processMessage (String SenderCode,
			String ReceiverCode,String OperationCode,
			String MessageInfo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
