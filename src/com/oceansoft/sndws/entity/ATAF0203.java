package com.oceansoft.sndws.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

public class ATAF0203 extends Document {
	private String BJContent;
	
	public String getBJContent() {
		return BJContent;
	}

	public void setBJContent(String content) {
		BJContent = content;
	}

	@Override
	public String obj2Xml() throws IllegalArgumentException,
			IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}
}
