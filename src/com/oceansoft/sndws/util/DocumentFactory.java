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
 * �ļ���:DocumentFactory.java
 * <p>
 * �����ʱ��: Jun 7, 2013 11:52:53 AM
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

import com.oceansoft.sndws.entity.ATAF0001;
import com.oceansoft.sndws.entity.ATAF0101;
import com.oceansoft.sndws.entity.ATAF0105;
import com.oceansoft.sndws.entity.ATAF0107;
import com.oceansoft.sndws.entity.ATAF0108;
import com.oceansoft.sndws.entity.ATAF0109;
import com.oceansoft.sndws.entity.ATAF0111;
import com.oceansoft.sndws.entity.ATAF0117;
import com.oceansoft.sndws.entity.ATAF0118;
import com.oceansoft.sndws.entity.ATAF01182;
import com.oceansoft.sndws.entity.ATAF0119;
import com.oceansoft.sndws.entity.ATAF0120;
import com.oceansoft.sndws.entity.ATAF0121;
import com.oceansoft.sndws.entity.ATAF0122;
import com.oceansoft.sndws.entity.ATAF0123;
import com.oceansoft.sndws.entity.ATAF0124;
import com.oceansoft.sndws.entity.ATAF0125;
import com.oceansoft.sndws.entity.ATAF0203;
import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.entity.base.Message;
import com.oceansoft.sndws.processor.IProcess;
import com.oceansoft.sndws.processor.Processor0001;
import com.oceansoft.sndws.processor.Processor0105;
import com.oceansoft.sndws.processor.Processor0107;
import com.oceansoft.sndws.processor.Processor0108;
import com.oceansoft.sndws.processor.Processor0111;
import com.oceansoft.sndws.processor.Processor0118;
import com.oceansoft.sndws.processor.Processor01182;
import com.oceansoft.sndws.processor.Processor0120;
import com.oceansoft.sndws.processor.Processor0122;
import com.oceansoft.sndws.processor.Processor0123;
import com.oceansoft.sndws.processor.Processor0124;
import com.oceansoft.sndws.processor.Processor0203;

/**
 * �ĵ����͹���������
 * 
 * @author chenw
 * 
 */
public class DocumentFactory {
	private static DocumentFactory INSTANCE = new DocumentFactory();

	private DocumentFactory() {
	}

	public static DocumentFactory getInstance() {
		return INSTANCE;
	}

	public Document create(String docType) {
		if (Constant.ATAF_0001.equals(docType)) {
			return new ATAF0001();
		} else if (Constant.ATAF_0101.equals(docType)) {
			return new ATAF0101();
		} else if (Constant.ATAF_0105.equals(docType)) {
			return new ATAF0105();
		} else if (Constant.ATAF_0107.equals(docType)) {
			return new ATAF0107();
		}else if (Constant.ATAF_0108.equals(docType)) {//add by yixin ������ATAF0108ת�������͵Ĺ���
			return new ATAF0108();
		}	else if (Constant.ATAF_0109.equals(docType)) {
			return new ATAF0109();
		} else if (Constant.ATAF_0111.equals(docType)) {
			return new ATAF0111();
		} else if (Constant.ATAF_0117.equals(docType)) {
			return new ATAF0117();
		} else if (Constant.ATAF_0118.equals(docType)) {
			return new ATAF0118();
		} else if (Constant.ATAF_0119.equals(docType)) {
			return new ATAF0119();
		} else if (Constant.ATAF_0120.equals(docType)) {
			return new ATAF0120();
		} else if (Constant.ATAF_0121.equals(docType)) {
			return new ATAF0121();
		} else if (Constant.ATAF_0122.equals(docType)) {
			return new ATAF0122();
		} else if (Constant.ATAF_0123.equals(docType)) {
			return new ATAF0123();
		} else if (Constant.ATAF_0124.equals(docType)) {
			return new ATAF0124();
		} else if (Constant.ATAF_0125.equals(docType)) {
			return new ATAF0125();
		} else if (Constant.ATAF_01182.equals(docType)){
			return new ATAF01182();
		} else if (Constant.ATAF_0203.equals(docType)){
			return new ATAF0203();
		}
		return null;
	}

	public IProcess create(Message msg) {
		String _type = msg.getHeader().getMessageType();
		if (Constant.ATAF_0001.equals(_type)) {
			return BeanUtil.getBean(Processor0001.class);
		} else if (Constant.ATAF_0105.equals(_type)) {
			return BeanUtil.getBean(Processor0105.class);
		} else if (Constant.ATAF_0107.equals(_type)) {
			return BeanUtil.getBean(Processor0107.class);
		} else if (Constant.ATAF_0108.equals(_type)) {//add by yixin ������ATAF0108ת�������͵Ĺ���
			return BeanUtil.getBean(Processor0108.class);
		}else if (Constant.ATAF_0111.equals(_type)) {
			return BeanUtil.getBean(Processor0111.class);
		} else if (Constant.ATAF_0118.equals(_type)) {
			return BeanUtil.getBean(Processor0118.class);
		} else if (Constant.ATAF_0120.equals(_type)) {
			return BeanUtil.getBean(Processor0120.class);
		} else if (Constant.ATAF_0122.equals(_type)) {
			return BeanUtil.getBean(Processor0122.class);
		} else if (Constant.ATAF_0123.equals(_type)) {
			return BeanUtil.getBean(Processor0123.class);
		} else if (Constant.ATAF_0124.equals(_type)) {
			return BeanUtil.getBean(Processor0124.class);
		} else if (Constant.ATAF_01182.equals(_type)){
			return BeanUtil.getBean(Processor01182.class);
		} else if (Constant.ATAF_0203.equals(_type)){
			return BeanUtil.getBean(Processor0203.class);
		}
		return null;
	}
}