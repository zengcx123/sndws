package com.oceansoft.sndws.processor_new;

import com.oceansoft.sndws.entity.bean_new.Result;

public interface IProcess {

	/**
	 * ����������
	 * 
	 * @param msg
	 *            ��װ������Ϣ��Ϣ����
	 * @throws Exception
	 */
	Result process(Object o);
}
	
	

