package com.oceansoft.sndws.dao;

public interface ICaseTempDao {

	/**
	 * ��V_CASE_LIST_BEFORE��ͼ��ѯ��Ȼ�����CASE_LIST_BEFORE_TEMP��</br>
	 * �˷��������COPYTO_TEMPCASELIST�洢���̣��ô洢���̵������ǣ�<br>
	 * ����caseId��ѯ�������CASE_LIST_BEFORE_TEMP���д��ڼ�¼</br>
	 * ����CASE_LIST_BEFORE_TEMP����ɾ���˼�¼</br>
	 * Ȼ���V_CASE_LIST_BEFORE��ͼ�и���caseId����һ�����ݵ�CASE_LIST_BEFORE_TEMP��</br>
	 * <b>TODO: ע�⣺������ӻ��������ͼ���ֶΣ������ͬ���޸�CASE_LIST_BEFORE_TEMP���ű���ֶ�</b>
	 * @author:yixin 2014-1-7 ����3:41:53
	 * @param:
	 * @return:
	 */
	public boolean copyFromViewListToTemp(String caseId);
}
