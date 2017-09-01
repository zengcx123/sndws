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
 * 文件名:Constant.java
 * <p>
 * 类产生时间: Jun 6, 2013 2:01:45 PM
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

import org.springframework.util.Assert;

/**
 * 解析常量
 * 
 * @author chenw
 * 
 */
public class Constant {
	//add by yixin
	//TODO:调用大城管接口服务
	//public static final String WS_SND = "http://10.44.66.135:8181/sndmanager/snd/caseReceive.ws";//原接口
	public static final String WS_SND = "http://10.44.66.136/snd/caseReceive.ws";
	public static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"gb2312\"?>";
	public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String ATTACHMENT_PATH = "D:/sndws/attachment/";
	/** 中心工单批转 */
	public static final String ATAF_0001 = "ATAF0001";
	/** 部门处理信息 */
	public static final String ATAF_0101 = "ATAF0101";
	/** 中心回访信息 */
	public static final String ATAF_0105 = "ATAF0105";
	/** 中心再交办信息 */
	public static final String ATAF_0107 = "ATAF0107";
	/** 中心转交办信息 */
	public static final String ATAF_0108 = "ATAF0108";//add by yixin 增加了转交办工单类型
	/** 部门延时申请信息 */
	public static final String ATAF_0109 = "ATAF0109";
	/** 中心延时审核信息 */
	public static final String ATAF_0111 = "ATAF0111";
	/** 部门申请不回访信息 */
	public static final String ATAF_0117 = "ATAF0117";
	/** 中心审核不回访信息 */
	public static final String ATAF_0118 = "ATAF0118";
	/** 部门申请缓办信息 */
	public static final String ATAF_0119 = "ATAF0119";
	/** 中心审核缓办信息 */
	public static final String ATAF_0120 = "ATAF0120";
	/** 部门解除缓办信息 */
	public static final String ATAF_0121 = "ATAF0121";
	/** 中心督办工单信息 */
	public static final String ATAF_0122 = "ATAF0122";
	/** 中心填写督办意见信息 */
	public static final String ATAF_0123 = "ATAF0123";
	/** 中心填写监控意见信息 */
	public static final String ATAF_0124 = "ATAF0124";
	/** 部门答复监控意见信息 */
	public static final String ATAF_0125 = "ATAF0125";
	/** 中心审核拒签信息 */
	public static final String ATAF_01182="ATAF01182";
	/** 便民中心发送工单补充信息 */
	public static final String ATAF_0203="ATAF0203";
	/** 任务分派 */
	public static final String ATAF_02="ATAF02";
	public static final String ATAF_03="ATAF03";
	public static final String ATAF_04="ATAF04";
	public static final String ATAF_05="ATAF05";
	public static final String ATAF_06="ATAF06";
	public static final String ATAF_07="ATAF07";
	/** 图像 */
	public static final String ANNEX_PIC = "1";
	/** 视频文件 */
	public static final String ANNEX_VIDEO = "2";
	/** 音频文件 */
	public static final String ANNEX_AUDIO = "3";
	/** 可执行文件 */
	public static final String ANNEX_EXE = "4";
	/** 文本文件 */
	public static final String ANNEX_TXT = "5";
	/** 其他 */
	public static final String ANNEX_OTHERS = "6";
	/** 位置图 */
	public static final String ANNEX_MAP = "7";

	public static final String ANNEX_TYPE(String fileName) {
		Assert.notNull(fileName, "fileName is null");
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
		if (suffix.matches("JPE?G")) {
			return ANNEX_PIC;
		} else if (suffix.matches("3GP|MP4|AVI|WMV")) {
			return ANNEX_VIDEO;
		} else if (suffix.matches("MP3|WMA")) {
			return ANNEX_AUDIO;
		} else if (suffix.matches("EXE")) {
			return ANNEX_EXE;
		} else {
			return ANNEX_MAP;
		}
	}

	public static void main(String[] args) {
		System.out.println(ANNEX_TYPE("WAVB20120720142947.avi"));
	}
}
