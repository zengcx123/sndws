package com.oceansoft.sndws.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

public class ObjectAndXmlHandle {
	private static Logger LOGGER = Logger.getLogger(ObjectAndXmlHandle.class);
	/**
	 * ʵ����תXML
	 * @param object
	 */
	public static String Object2Xml(Object object){
		StringWriter writer = new StringWriter(); 
		try {
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			// ��ʽ�����  
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			// �����ʽ,Ĭ��Ϊutf-8
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
			// �Ƿ�ʡ��xmlͷ��Ϣ
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
			marshaller.marshal(object, writer);
		} catch (JAXBException e) {
			LOGGER.error(e);
			MailUti.init("ʵ����תXML",""+e,"");
			e.printStackTrace();
		}
		System.out.println("write:   "+writer);
		return writer.toString();		
	}
	
	/**
	 * Xmlתʵ����
	 * @param <T>
	 * @param xml
	 * @param clazz
	 * @return
	 */
	public static <T> T parseXml2Object(String xml,Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			InputSource is = new InputSource();
			StringReader xmlStr = new StringReader(xml);
			is.setCharacterStream(xmlStr);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			T t = (T) unmarshaller.unmarshal(is);
			return t;

		} catch (JAXBException e) {
			LOGGER.error(e);
			MailUti.init("Xmlתʵ����",""+e,"");
			e.printStackTrace();
			return null;
		}
	}
}
