package com.oceansoft.sndws.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import com.oceansoft.sndws.entity.base.Document;
import com.oceansoft.sndws.util.ConvertUtil;

public class ATAF01182 extends Document{
	private String Argee_flag;//审核标识 市局审核标识1为同意2为不同意
	private String SH_OPER;//审核人员
	private Date SH_TIME;//审核时间
	public String getArgee_flag() {
		return Argee_flag;
	}
	public void setArgee_flag(String argee_flag) {
		Argee_flag = argee_flag;
	}
	public String getSH_OPER() {
		return SH_OPER;
	}
	public void setSH_OPER(String sh_oper) {
		SH_OPER = sh_oper;
	}
	public Date getSH_TIME() {
		return SH_TIME;
	}
	public void setSH_TIME(Date sh_time) {
		SH_TIME = sh_time;
	}
	@Override
	public String obj2Xml() throws IllegalArgumentException,
			IllegalAccessException, IntrospectionException,
			InvocationTargetException {
		return ConvertUtil.obj2Xml(this);
	}
	
}
