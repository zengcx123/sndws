/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ���й����ݿƼ�����ɽ·1��
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: ���ݹ���ͳһ�û�����ƽ̨1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:IProcess.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:06:11 PM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * ������ : ���ݹ���ͳһ�û�����ƽ̨
 * <p>
 * ���ڲ���: ����/����������������
 * <p>
 * <p>
 */
package com.oceansoft.sndws.processor;

import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.entity.base.Result;

/**
 * ��������ӿ�
 * 
 * @author chenw
 * 
 */
public interface IProcess {
	/**
	 * ����������
	 * 
	 * @param msg
	 *            ��װ������Ϣ��Ϣ����
	 * @throws Exception
	 */
	Result process(Message msg) throws Exception;
}
