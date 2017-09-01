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
 * �汾: JavaEE�������1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:SQLUtil.java
 * <p>
 * �����ʱ��: Jun 14, 2013 1:04:58 PM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email: javacspring@gmail.com
 * <p>
 * ������:JavaEE�������
 * <p>
 * ���ڲ���: ����/����������������
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
