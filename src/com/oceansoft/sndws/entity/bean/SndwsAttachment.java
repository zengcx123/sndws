package com.oceansoft.sndws.entity.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ��ǹܻص�sndwsʱ�ĸ�������
 * @author wyf
 *
 */
@XmlRootElement(name="SndwsAttachment")
public class SndwsAttachment {
	 List<XtAttachInfo> attaches;

	 @XmlElementWrapper(name="Attachments")
	 @XmlElement(name="Attachment")
	public List<XtAttachInfo> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<XtAttachInfo> attaches) {
		this.attaches = attaches;
	}
	 
}
