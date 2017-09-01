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
 * 文件名:BeanUtil.java
 * <p>
 * 类产生时间: Jun 8, 2013 11:37:14 AM
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
package com.oceansoft.sndws.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * Spring容器Bean工具类<br>
 * 用于从Spirng容器中获取已经实例化的Bean
 * 
 * @author chenw
 * 
 */
@Component
public class BeanUtil implements BeanFactoryAware {
	private static BeanFactory bf;

	public void setBeanFactory(BeanFactory bf) throws BeansException {
		BeanUtil.bf = bf;
	}

	public static <T> T getBean(Class<T> type) {
		return bf.getBean(type);
	}
}
