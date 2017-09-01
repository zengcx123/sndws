package com.oceansoft.sndws.entity.bean_new;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.aop.aspectj.SimpleAspectInstanceFactory;
/**
 * 2.2.14 ����/���б���רҵ���Ű������  �ĵ��汾��1.6
 */
@XmlRootElement(name="ITEM")
public class Process {

	/** ������ɺ���������ε�λ���� **/
	private String taskdispatchunit;
	/** �������ʱ�� **/
	//private String taskdispatchtime;
	private Date taskdispatchtime;
	/** ������ʱ�� **/
	//private String taskfeedbacktime;
	private Date taskfeedbacktime;
	/** ��������� **/
	private String taskfeedbackopinion;
	
	
	
	
	public Process() {
	
	}



	@XmlElement(name="TASKDISPATCHUNIT")
	public String getTaskdispatchunit() {
		return taskdispatchunit;
	}




	public void setTaskdispatchunit(String taskdispatchunit) {
		this.taskdispatchunit = taskdispatchunit;
	}



	@XmlElement(name="TASKDISPATCHTIME")
	public Date getTaskdispatchtime() {
		
		return taskdispatchtime;
	}




	public void setTaskdispatchtime(Date taskdispatchtime) {
		this.taskdispatchtime = taskdispatchtime;
	}


	
	@XmlElement(name="TASKFEEDBACKTIME")
	public Date getTaskfeedbacktime() {
		return taskfeedbacktime;
	}




	public void setTaskfeedbacktime(Date taskfeedbacktime) {
		this.taskfeedbacktime = taskfeedbacktime;
	}



	@XmlElement(name="TASKFEEDBACKOPINION")
	public String getTaskfeedbackopinion() {
		return taskfeedbackopinion;
	}




	public void setTaskfeedbackopinion(String taskfeedbackopinion) {
		this.taskfeedbackopinion = taskfeedbackopinion;
	}

	
	
	
}
