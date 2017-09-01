package com.oceansoft.sndws.entity.bean_new;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 任务分派
 */
@XmlRootElement(name="ROOTMAIN")
public class ATAF02 {
	
	/**案件主单部分**/
	private CaseMain caseMain;
	
	/**案件操作单详情**/
	private CaseOperatonDetail caseOperatonDetail;
	
	
	public ATAF02() {
		
	}

	@XmlElement(name="CASEMAIN")
	public CaseMain getCaseMain() {
		return caseMain;
	}

	public void setCaseMain(CaseMain caseMain) {
		this.caseMain = caseMain;
	}

	@XmlElement(name="CASEOPERATONDETAIL")
	public CaseOperatonDetail getCaseOperatonDetail() {
		return caseOperatonDetail;
	}

	public void setCaseOperatonDetail(CaseOperatonDetail caseOperatonDetail) {
		this.caseOperatonDetail = caseOperatonDetail;
	}
}
