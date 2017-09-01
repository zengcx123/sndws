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
 * 版本: JavaEE基础框架1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:SQLUtil.java
 * <p>
 * 类产生时间: Jun 14, 2013 1:04:58 PM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email: javacspring@gmail.com
 * <p>
 * 所在组:JavaEE基础框架
 * <p>
 * 所在部门: 电信/国土——技术二部
 * <p>
 * <p>
 */
package com.oceansoft.sndws.util;

import java.util.Iterator;
import java.util.Map;

import org.springframework.util.Assert;

public class SQLUtil {

	public static String genInsertSQL(String tableName, Map<String, Object> params) {
		Assert.notNull(tableName, "Table name is null");
		Iterator<String> itor = params.keySet().iterator();
		StringBuffer ps = new StringBuffer();
		while (itor.hasNext()) {
			String key = itor.next();
			ps.append(key);
			if (itor.hasNext()) {
				ps.append(",");
			}
		}
		return String.format("INSERT INTO %1$s (%2$s) VALUES (%3$s)", tableName, ps.toString().toUpperCase(), ":"
				+ ps.toString().replaceAll(",", ",:"));
	}

}
