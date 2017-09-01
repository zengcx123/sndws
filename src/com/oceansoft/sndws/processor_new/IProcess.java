package com.oceansoft.sndws.processor_new;

import com.oceansoft.sndws.entity.bean_new.Result;

public interface IProcess {

	/**
	 * 工单处理方法
	 * 
	 * @param msg
	 *            封装工单信息消息对象
	 * @throws Exception
	 */
	Result process(Object o);
}
	
	

