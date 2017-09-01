package com.oceansoft.sndws.ws.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.jws.WebService;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfo;
import com.oceansoft.sndws.entity.base.Attachment;
import com.oceansoft.sndws.entity.bean.SndwsAttachment;
import com.oceansoft.sndws.entity.bean.XtAttachInfo;
import com.oceansoft.sndws.util.ObjectAndXmlHandle;
import com.oceansoft.sndws.ws.ICallbackFromWebsnd;

/** 
 * 大城管回调接口服务器接口实现类
 * @author wyf
 *
 */
@Service
@WebService(serviceName="websndCallback",endpointInterface="com.oceansoft.sndws.ws.ICallbackFromWebsnd")
public class CallbackFromWebsnd  implements ICallbackFromWebsnd {

	//@Override
	/**public boolean saveAttachFile(String attachXml) {
		
		SndwsAttachment sndAtt=	ObjectAndXmlHandle.parseXml2Object(attachXml, SndwsAttachment.class);
		List<XtAttachInfo> attaches=sndAtt.getAttaches();
		
		if(null!=attaches&&attaches.size()>0){
			System.out.println("有"+attaches.size()+"个文件需要保存");
			for(XtAttachInfo attach:attaches){
				byte [] fileBytes =attach.getAcontent();
		        String filePath="D:\\sndStreet_image\\"+attach.getAname();			       
		        System.out.println("开始保存文件："+attach.getAname());
		        File attchFile=new File(filePath);
		        if(!attchFile.exists()){
		        	attchFile.mkdirs();
		        }
				BufferedOutputStream out=null;		
				try {					
					out=new BufferedOutputStream(new FileOutputStream(attchFile));
					out.write(fileBytes);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}finally{
					try {
						out.close();
					} catch (IOException e) {				
						e.printStackTrace();
						return false;
					}
				}				
				return false;
			}
		 }
		
		return true;
		}
**/
	@Override
	public boolean saveAttachFile(String attachXml) {
		SndwsAttachment sndAtt=	ObjectAndXmlHandle.parseXml2Object(attachXml, SndwsAttachment.class);
		List<XtAttachInfo> attaches=sndAtt.getAttaches();
		System.out.println("attaches:"+attaches.size());
		
		if(null!=attaches&&attaches.size()>0){
			System.out.println("1有"+attaches.size()+"个文件需要保存");
			
			for(XtAttachInfo attach:attaches){				
				byte [] fileBytes =attach.getAcontent();	
				File disctionary= new File("D:\\sndStreet_image\\"+attach.getCaseId()+"\\");
				if(!disctionary.exists()){
					 disctionary.mkdirs();
			        }
		        String filePath=disctionary.getAbsolutePath()+"\\"+attach.getAname();			       
		        System.out.println("开始保存文件："+attach.getAname());
		        File attchFile=new File(filePath);
		       
				BufferedOutputStream out=null;		
				try {					
					out=new BufferedOutputStream(new FileOutputStream(attchFile));
					out.write(fileBytes);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}finally{
					try {
						if(null!=out){
							out.close();
						}						
					} catch (IOException e) {				
						e.printStackTrace();
						return false;
					}
				}				
			}
			
			
		 }
		
		return true;
	}
		
		
        public static void main(String[] args) {
        	File disctionary= new File("D:\\sndStreet_image\\");
			 if(!disctionary.exists()){
				 disctionary.mkdirs();
		        }
	        String filePath=disctionary.getAbsolutePath();
	        System.out.println(filePath);
        }
}
