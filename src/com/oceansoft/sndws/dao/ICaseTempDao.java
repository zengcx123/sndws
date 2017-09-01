package com.oceansoft.sndws.dao;

public interface ICaseTempDao {

	/**
	 * 从V_CASE_LIST_BEFORE视图查询，然后插入CASE_LIST_BEFORE_TEMP表</br>
	 * 此方法会调用COPYTO_TEMPCASELIST存储过程，该存储过程的作用是：<br>
	 * 根据caseId查询，如果在CASE_LIST_BEFORE_TEMP表中存在记录</br>
	 * 则在CASE_LIST_BEFORE_TEMP表中删除此记录</br>
	 * 然后从V_CASE_LIST_BEFORE视图中根据caseId复制一份数据到CASE_LIST_BEFORE_TEMP表</br>
	 * <b>TODO: 注意：如果增加或减少了视图的字段，则必须同步修改CASE_LIST_BEFORE_TEMP这张表的字段</b>
	 * @author:yixin 2014-1-7 下午3:41:53
	 * @param:
	 * @return:
	 */
	public boolean copyFromViewListToTemp(String caseId);
}
