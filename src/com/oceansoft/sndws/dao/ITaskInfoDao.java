package com.oceansoft.sndws.dao;

import com.oceansoft.sndws.entity.bean.TaskInfo;

/**
 * add by yixin 增加一个对taskinfo表进行操作的接口
 * @author Administrator
 *
 */
public interface ITaskInfoDao {
    
    /**
     * 更新任务表
     * @param taskInfo
     * @return
     */
    public int updateTaskInfo (TaskInfo taskInfo);
    
    /**
     * 获取最新的一条延时记录的工单
     * @return
     */
    public String getLatestTaskInfoForDelay(String caseid);
}
