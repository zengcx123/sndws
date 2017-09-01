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
 * �ļ���:Constant.java
 * <p>
 * �����ʱ��: Jun 6, 2013 2:01:45 PM
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
package com.oceansoft.sndws.util;

import org.springframework.util.Assert;

/**
 * ��������
 * 
 * @author chenw
 * 
 */
public class Constant {
	//add by yixin
	//TODO:���ô�ǹܽӿڷ���
	//public static final String WS_SND = "http://10.44.66.135:8181/sndmanager/snd/caseReceive.ws";//ԭ�ӿ�
	public static final String WS_SND = "http://10.44.66.136/snd/caseReceive.ws";
	public static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"gb2312\"?>";
	public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String ATTACHMENT_PATH = "D:/sndws/attachment/";
	/** ���Ĺ�����ת */
	public static final String ATAF_0001 = "ATAF0001";
	/** ���Ŵ�����Ϣ */
	public static final String ATAF_0101 = "ATAF0101";
	/** ���Ļط���Ϣ */
	public static final String ATAF_0105 = "ATAF0105";
	/** �����ٽ�����Ϣ */
	public static final String ATAF_0107 = "ATAF0107";
	/** ����ת������Ϣ */
	public static final String ATAF_0108 = "ATAF0108";//add by yixin ������ת���칤������
	/** ������ʱ������Ϣ */
	public static final String ATAF_0109 = "ATAF0109";
	/** ������ʱ�����Ϣ */
	public static final String ATAF_0111 = "ATAF0111";
	/** �������벻�ط���Ϣ */
	public static final String ATAF_0117 = "ATAF0117";
	/** ������˲��ط���Ϣ */
	public static final String ATAF_0118 = "ATAF0118";
	/** �������뻺����Ϣ */
	public static final String ATAF_0119 = "ATAF0119";
	/** ������˻�����Ϣ */
	public static final String ATAF_0120 = "ATAF0120";
	/** ���Ž��������Ϣ */
	public static final String ATAF_0121 = "ATAF0121";
	/** ���Ķ��칤����Ϣ */
	public static final String ATAF_0122 = "ATAF0122";
	/** ������д���������Ϣ */
	public static final String ATAF_0123 = "ATAF0123";
	/** ������д��������Ϣ */
	public static final String ATAF_0124 = "ATAF0124";
	/** ���Ŵ𸴼�������Ϣ */
	public static final String ATAF_0125 = "ATAF0125";
	/** ������˾�ǩ��Ϣ */
	public static final String ATAF_01182="ATAF01182";
	/** �������ķ��͹���������Ϣ */
	public static final String ATAF_0203="ATAF0203";
	/** ������� */
	public static final String ATAF_02="ATAF02";
	public static final String ATAF_03="ATAF03";
	public static final String ATAF_04="ATAF04";
	public static final String ATAF_05="ATAF05";
	public static final String ATAF_06="ATAF06";
	public static final String ATAF_07="ATAF07";
	/** ͼ�� */
	public static final String ANNEX_PIC = "1";
	/** ��Ƶ�ļ� */
	public static final String ANNEX_VIDEO = "2";
	/** ��Ƶ�ļ� */
	public static final String ANNEX_AUDIO = "3";
	/** ��ִ���ļ� */
	public static final String ANNEX_EXE = "4";
	/** �ı��ļ� */
	public static final String ANNEX_TXT = "5";
	/** ���� */
	public static final String ANNEX_OTHERS = "6";
	/** λ��ͼ */
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
