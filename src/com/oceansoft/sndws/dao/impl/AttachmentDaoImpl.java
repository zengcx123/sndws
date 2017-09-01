/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * 版权所有(C)：江苏欧索软件有限公司
 * <p>
 * 公司名称：江苏欧索软件有限公司
 * <p>
 * 公司地址：中国苏州科技城青山路1号
 * <p>
 * 网址: http://www.oceansoft.com.cn
 * <p>
 * 版本: 苏州公安统一用户管理平台1.0
 * <p>
 * 作者: 090922(陈伟)
 * <p>
 * 文件名:AttachmentDaoImpl.java
 * <p>
 * 类产生时间: Jun 17, 2013 9:30:09 AM
 * <p>
 * 负责人: 090922(陈伟)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * 所在组 : 苏州公安统一用户管理平台
 * <p>
 * 所在部门: 电信/国土——技术二部
 * <p>
 * <p>
 */
package com.oceansoft.sndws.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.codehaus.xfire.util.Base64;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.oceansoft.sndws.dao.IAttachmentDao;
import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean.CaseDetail;
import com.oceansoft.sndws.entity.bean_new.Attachment_New;
import com.oceansoft.sndws.entity.bean_new.Process;
import com.oceansoft.sndws.util.Constant;

@Repository
public class AttachmentDaoImpl implements IAttachmentDao {
	@Resource
	private LobHandler lobHandler;
	@Resource
	private JdbcTemplate jt;
	

	public String save(List<Attachment> attachement) {
		StringBuffer rt = new StringBuffer();
		String sql = "INSERT INTO XT_ATTACH_INFO VALUES(?,?,?,?,?,?,?,?,?)";
		int size = attachement.size();
		for (int i = 0; i < size; i++) {
			final Attachment att = attachement.get(i);
			final byte[] tslob = getImageFromNetByUrl(att.getUrl());
			if (0 == tslob.length) {
				continue;
			}
			final String _id = jt.queryForObject("SELECT XT_ATTACH_SEQ.NEXTVAL FROM DUAL", String.class);
			jt.execute(sql.toString(), new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
				@Override
				protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException,
						DataAccessException {
					ps.setString(1, _id);
					ps.setString(2, String.format("%1$s.%2$s", att.getFileName(), att.getContentType()));
					ps.setString(3, "1");
					ps.setString(4, "2");
					ps.setInt(5, tslob.length / 1024);
					lobCreator.setBlobAsBytes(ps, 6, tslob);
					ps.setString(7, "");
					ps.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));
					ps.setString(9, "市城管局工单");
				}
			});
			rt.append(_id);
			if (i < size - 1) {
				rt.append(",");
			}
		}
		return rt.toString();
	}
	
	/**
	 * 根据地址获得数据的字节流
	 * @param strUrl 网络连接地址
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 从输入流中获取数据
	 * @param inStream 输入流
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len=inStream.read(buffer)) != -1 ){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

	@Override
	public String save2(List<Attachment_New> attachement) {
		StringBuffer rt = new StringBuffer();
		String sql = "INSERT INTO XT_ATTACH_INFO VALUES(?,?,?,?,?,?,?,?,?)";
		int size = attachement.size();
		for (int i = 0; i < size; i++) {
			final Attachment_New att = attachement.get(i);		
			final byte[] tslob = getImageFromNetByUrl(att.getAttachPath()+att.getAttachName());
			if(null != tslob){
				if (0 == tslob.length) {
					continue;
				}
				final String _id = jt.queryForObject("SELECT XT_ATTACH_SEQ.NEXTVAL FROM DUAL", String.class);
				jt.execute(sql.toString(), new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
					@Override
					protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException,
							DataAccessException {
					
						ps.setString(1, _id);//id通过序列自动获取
						ps.setString(2, att.getAttachName());//带后缀的附件名
						ps.setString(3, "1");//附件类型
						ps.setString(4, "2");//存储数据类型
						ps.setInt(5, tslob.length / 1024);//附件大小
						lobCreator.setBlobAsBytes(ps, 6, tslob);//附件内容
						ps.setString(7, att.getAttachPath()+att.getAttachName()+"");//路径
						ps.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));//上传时间
						ps.setString(9, "市城管局工单");//附件来源
					}
				});
				rt.append(_id);
				if (i < size - 1) {
					rt.append(",");
				}
			}else{
				rt.append("");
			}
		}
		return rt.toString();
	}



	@Override
	public String save3(List<Process> process ,String caseId) {
	StringBuffer rt = new StringBuffer();
	String _id =UUID.randomUUID().toString().replace("-", "");
		
		int size = process.size();
		for (int i = 0; i < size; i++) {
			final Process at = process.get(i);
				String sql = "INSERT INTO PROCESS_INFO VALUES('"+_id+"','"+at.getTaskdispatchunit()+"','"+at.getTaskdispatchtime()+"','"+at.getTaskfeedbacktime()+"','"+at.getTaskfeedbackopinion()+"','"+caseId+"')";
			jt.execute(sql);		
										}
		return rt.toString();		
	}


		
			

			}


	

