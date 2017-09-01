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
	 * 实体类转XML
	 * @param object
	 */
	public static String Object2Xml(Object object){
		StringWriter writer = new StringWriter(); 
		try {
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			// 格式化输出  
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			// 编码格式,默认为utf-8
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
			// 是否省略xml头信息
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
			marshaller.marshal(object, writer);
		} catch (JAXBException e) {
			LOGGER.error(e);
			MailUti.init("实体类转XML",""+e,"");
			e.printStackTrace();
		}
		System.out.println("write:   "+writer);
		return writer.toString();		
	}
	
	/**
	 * Xml转实体类
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
			MailUti.init("Xml转实体类",""+e,"");
			e.printStackTrace();
			return null;
		}
	}
}
