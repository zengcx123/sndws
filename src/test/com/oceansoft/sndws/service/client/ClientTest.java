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
 * 文件名:ClientTest.java
 * <p>
 * 类产生时间: Jun 7, 2013 4:41:54 PM
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
package test.com.oceansoft.sndws.service.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.net.MalformedURLException;

import com.oceansoft.sndws.util.ClientUtil;

/**
 * 模拟测试远程调用大城管接收工单服务接口
 * 
 * @author chenw
 * 
 */
public class ClientTest {
	public static void main(String[] args) throws MalformedURLException, Exception {
		File file = new File("D:/20160307_130816781.xml");//
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB2312"));
		StringBuffer sb = new StringBuffer();
		String lin = null;
		while ((lin = br.readLine()) != null) {
			lin = lin.trim().replaceAll(">\\s<", "><").replaceAll("(\\t\\r\\n)", "");
			sb.append(lin);
			System.out.print(lin);
		}
		br.close();
		ClientUtil.getInstance().invoke(Boolean.class, "send", sb.toString().trim());
		System.out.println("\n==============================");
	}

	public static InputStream getInputStream(InputStream in) throws IOException {
		PushbackInputStream testin = new PushbackInputStream(in);
		int ch = testin.read();
		if (ch != 0xEF) {
			testin.unread(ch);
		} else if ((ch = testin.read()) != 0xBB) {
			testin.unread(ch);
			testin.unread(0xef);
		} else if ((ch = testin.read()) != 0xBF) {
			throw new IOException("错误的UTF-8格式文件");
		}
		return testin;
	}
}
