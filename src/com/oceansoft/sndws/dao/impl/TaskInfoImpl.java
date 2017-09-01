package com.oceansoft.sndws.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oceansoft.sndws.dao.ITaskInfoDao;
import com.oceansoft.sndws.entity.bean.TaskInfo;
/**
 * add by yixin 审批DAO实现类
 * @author Administrator
 *
 */
@Repository
public class TaskInfoImpl implements ITaskInfoDao{

	@Resource
	private NamedParameterJdbcTemplate npjt;
	@Resource
	private JdbcTemplate jt;
	
	
	
	@Override
	public int updateTaskInfo(final TaskInfo taskInfo) {
		String sql = 	"UPDATE XT_TASK_INFO T\n" +
						"   SET T.TASK_STATUS        = :taskstatus,\n" + 
						"       T.AUDIT12345_DESC    = :audit12345desc,\n" + 
						"       T.AUDITOR12345       = :audit12345,\n" + 
						"       T.AUDIT12345_ENDTIME = to_date(:audit12345endtime,'yyyy-mm-dd hh24:mi:ss'),\n" + 
						"       T.AUDIT12345_TIME    = to_date(:audit12345time,'yyyy-mm-dd hh24:mi:ss') \n" + 
						" WHERE T.TASK_ID = :taskid";
		int state = jt.update(sql, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				SimpleDateFormat df = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
				ps.setString(1, taskInfo.getTaskStatus());
				ps.setString(2, taskInfo.getAudit12345Desc());
				ps.setString(3, taskInfo.getAuditor12345());
				ps.setString(4, df.format(taskInfo.getAudit12345Endtime()));
				ps.setString(5, df.format(taskInfo.getAudit12345Time()));
				ps.setString(6, taskInfo.getTaskId());
			}
		});
		return state;
	}
	
	@Override
	public String getLatestTaskInfoForDelay(String caseid) {
		String sql =
			"SELECT C.TASK_ID\n" +
			"  FROM (SELECT T.TASK_ID\n" + 
			"          FROM XT_TASK_INFO T\n" + 
			"         WHERE T.CASE_ID = :caseid \n" + 
			"           AND T.CURRENT_DELAY = 'C'\n" + 
			"           AND T.TASK_STATUS = '0702'\n" + 
			"         ORDER BY T.ASSIGN_TIME DESC) C\n" + 
			" WHERE ROWNUM = 1 ";
		List<Map<String , Object>> list =  jt.queryForList(sql,caseid);
		String taskid = "";
		if(null != list && list.size()>0){
			taskid = list.get(0).get("TASK_ID")==null ? "" : list.get(0).get("TASK_ID").toString();
		}
		return taskid;
	}

}
