/**
 * 2010(c) Copyright Oceansoft Information System Co.,LTD. All rights reserved.
 * <p>
 * Compile: JDK 1.6+
 * <p>
 * ��Ȩ����(C)������ŷ��������޹�˾
 * <p>
 * ��˾���ƣ�����ŷ��������޹�˾
 * <p>
 * ��˾��ַ���й����ݿƼ�����ɽ·1��
 * <p>
 * ��ַ: http://www.oceansoft.com.cn
 * <p>
 * �汾: ���ݹ���ͳһ�û�����ƽ̨1.0
 * <p>
 * ����: 090922(��ΰ)
 * <p>
 * �ļ���:AttachmentDaoImpl.java
 * <p>
 * �����ʱ��: Jun 17, 2013 9:30:09 AM
 * <p>
 * ������: 090922(��ΰ)
 * <p>
 * Email:javacspring@gmail.com
 * <p>
 * ������ : ���ݹ���ͳһ�û�����ƽ̨
 * <p>
 * ���ڲ���: ����/����������������
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
					ps.setString(9, "�гǹֹܾ���");
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
	 * ���ݵ�ַ������ݵ��ֽ���
	 * @param strUrl �������ӵ�ַ
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//ͨ����������ȡͼƬ����
			byte[] btImg = readInputStream(inStream);//�õ�ͼƬ�Ķ���������
			return btImg;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * ���������л�ȡ����
	 * @param inStream ������
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
					
						ps.setString(1, _id);//idͨ�������Զ���ȡ
						ps.setString(2, att.getAttachName());//����׺�ĸ�����
						ps.setString(3, "1");//��������
						ps.setString(4, "2");//�洢��������
						ps.setInt(5, tslob.length / 1024);//������С
						lobCreator.setBlobAsBytes(ps, 6, tslob);//��������
						ps.setString(7, att.getAttachPath()+att.getAttachName()+"");//·��
						ps.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));//�ϴ�ʱ��
						ps.setString(9, "�гǹֹܾ���");//������Դ
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


	

