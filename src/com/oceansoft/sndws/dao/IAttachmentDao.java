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
 * �ļ���:IAttachmentDaoo.java
 * <p>
 * �����ʱ��: Jun 17, 2013 9:16:41 AM
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
package com.oceansoft.sndws.dao;

import java.util.List;

import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import com.oceansoft.sndws.entity.bean_new.Process;

/**
 * �����洢�ӿ�
 * 
 * @author chenw
 * 
 */
public interface IAttachmentDao {
	/**
	 * ��������
	 * 
	 * @param attachement
	 * @return ����ɹ��󸽼���ţ���������ö��ŷָ�
	 */
	String save(List<Attachment> attachement);
	
	/**
	 * ����������
	 * @param attachement
	 * @return
	 */
	String save2(List<Attachment_New> attachement);
	/**
	 * 2.2.14 ����/���б���רҵ���Ű������  �ĵ��汾��1.6
	 *
	 * 
	 */


	String save3(List<Process> process, String caseId);
}
