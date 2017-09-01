/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：中国苏州科技城青山路1号
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: 苏州公安统一用户管理平台1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:IAttachmentDaoo.java
 * <p>
 * 类产生时间: Jun 17, 2013 9:16:41 AM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * 所在组 : 苏州公安统一用户管理平台
 * <p>
 * 所在部门: 电信/国土——技术二部
 * <p>
 * <p>
 */
package com.oceansoft.sndws.dao;

import java.util.List;

import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import com.oceansoft.sndws.entity.bean_new.Process;

/**
 * 附件存储接口
 * 
 * @author chenw
 * 
 */
public interface IAttachmentDao {
	/**
	 * 附件保存
	 * 
	 * @param attachement
	 * @return 保存成功后附件编号，多个附件用逗号分割
	 */
	String save(List<Attachment> attachement);
	
	/**
	 * 附件保存新
	 * @param attachement
	 * @return
	 */
	String save2(List<Attachment_New> attachement);
	/**
	 * 2.2.14 上行/下行表单—专业部门办理过程  文档版本号1.6
	 *
	 * 
	 */


	String save3(List<Process> process, String caseId);
}
