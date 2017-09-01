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
 * �ļ���:XmlUtil.java
 * <p>
 * �����ʱ��: Jun 6, 2013 1:33:43 PM
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

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.oceansoft.sndws.entity.ATAF0121;
import com.oceansoft.sndws.entity.base.Document;

/**
 * ת��������
 * 
 * @author chenw
 * 
 */
public class ConvertUtil {
	/**
	 * ����תXML
	 * 
	 * @param obj
	 *            ʵ�����
	 * @return XML�ĵ�
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 */
	public static String obj2Xml(Object obj) throws IllegalArgumentException, IllegalAccessException,
			IntrospectionException, InvocationTargetException {
		Class<?> clazz = obj.getClass();
		Class<?> superClazz = clazz.getSuperclass();
		StringBuffer sb = new StringBuffer();
		if (Document.class.getName().equals(superClazz.getName())) {
			Field[] sfs = superClazz.getDeclaredFields();
			for (Field f : sfs) {
				genFieldXml(obj, superClazz, sb, f);
			}
		}
		Field[] fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			genFieldXml(obj, clazz, sb, f);
		}
		return sb.toString();
	}

	private static void genFieldXml(Object obj, Class<?> clazz, StringBuffer sb, Field f)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		if (!Modifier.isStatic(f.getModifiers())) {
			String name = f.getName();
			String type = f.getType().getSimpleName();
			PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
			Method getMethod = pd.getReadMethod();// ���get����
			Object value = getMethod.invoke(obj);
			if ("String".equals(type) || "int".equals(type) || "long".equals(type)) {
				sb.append("<").append(name).append(">").append(null == value ? "" : value).append("</").append(name)
						.append(">");
			} else if ("Date".equals(type)) {
				value = ("Date".equals(type) && null != value) ? new SimpleDateFormat(Constant.DATE_PATTERN)
						.format(value) : "";
				sb.append("<").append(name).append(">").append(value).append("</").append(name).append(">");
			}
		}
	}

	/**
	 * ��XML�ĵ�ת��Ϊʵ�����
	 * 
	 * @param obj
	 *            ʵ�����
	 * @param value
	 *            ʵ������Ա����ֵ
	 */
	public static void xml2Obj(Object obj, Map<String, String> value) {
		Class<?> clazz = obj.getClass();
		Class<?> superClazz = clazz.getSuperclass();
		Field[] fs = clazz.getDeclaredFields();
		HashMap<String, Method> msmap = new HashMap<String, Method>();
		Method[] ms = clazz.getMethods();
		for (Method m : ms) {
			if (m.getName().startsWith("set")) {
				msmap.put(m.getName(), m); // �Ѿ������˸����а��������Է�����
			}
		}
		// ���෽��
		if (Document.class.getName().equals(superClazz.getName())) {
			Field[] sfs = superClazz.getDeclaredFields();
			for (Field f : sfs) {
				assignFieldValue(obj, value, msmap, f);
			}
		}
		// ��ǰ�෽��
		for (Field f : fs) {
			assignFieldValue(obj, value, msmap, f);
		}
	}

	private static void assignFieldValue(Object obj, Map<String, String> value, HashMap<String, Method> msmap, Field f) {
		if (!Modifier.isStatic(f.getType().getModifiers())) {
			String _fn = f.getName();
			String _smn = genMethodName(_fn);// ���ɶ�Ӧ�ֶ�set��������
			String _type = f.getType().getSimpleName();
			try {
				if (msmap.keySet().contains(_smn)) {
					Method m = msmap.get(_smn);
					String val = value.get(_fn);
					if (null == val) {
						return;
					}
					if ("String".equals(_type)) {
						m.invoke(obj, val);
					} else if ("long".equals(_type)) {
						m.invoke(obj, Long.valueOf(val));
					} else if ("int".equals(_type)) {
						m.invoke(obj, Integer.valueOf(val));
					} else if ("Date".equals(_type) && null != value) {
						m.invoke(obj, new SimpleDateFormat(Constant.DATE_PATTERN).parse(val));
					} else if ("boolean".equals(_type)) {
						m.invoke(obj, Boolean.valueOf(val));
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException,
			IntrospectionException, InvocationTargetException {
		obj2Xml(new ATAF0121());
	}

	/**
	 * ����set����ǩ��
	 * 
	 * @param fieldName
	 *            �ֶ�����
	 * @return set����ǩ��
	 */
	private static String genMethodName(String fieldName) {
		return String.format("set%1$s%2$s", fieldName.substring(0, 1).toUpperCase(), fieldName.substring(1));
	}

	/**
	 * �ֽ�����ת�ļ�
	 * 
	 * @param bytes
	 * @param fileName
	 * @return
	 */
	public static File genFileFromByte(byte[] bytes, String fileName) {
		BufferedOutputStream bos = null;
		File file = null;
		try {
			file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
			bos.flush();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bos) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}
}
