package com.oceansoft.sndws.dao;

import com.oceansoft.sndws.entity.bean.TaskInfo;

/**
 * add by yixin ����һ����taskinfo����в����Ľӿ�
 * @author Administrator
 *
 */
public interface ITaskInfoDao {
    
    /**
     * ���������
     * @param taskInfo
     * @return
     */
    public int updateTaskInfo (TaskInfo taskInfo);
    
    /**
     * ��ȡ���µ�һ����ʱ��¼�Ĺ���
     * @return
     */
    public String getLatestTaskInfoForDelay(String caseid);
}
