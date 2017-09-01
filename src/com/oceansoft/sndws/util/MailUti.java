package com.oceansoft.sndws.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUti {
    private static final String host = "smtp.163.com";
    private static final String mail = "sos626364708@163.com";
    private static final String userName = "sos626364708@163.com";
    private static final String password = "Q700800900";
    private static Logger logger = LoggerFactory.getLogger(MailUti.class);
    private static String[] sendTo;

    static {
        sendTo = new String[]{"626364708@qq.com","854436269@qq.com"};
    }

    public static void init(String title,String content, String scaseId) {
        // 发送邮件
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(host);
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            messageHelper.setTo(sendTo);
            messageHelper.setFrom(mail);
            messageHelper.setSubject(title);
            StringBuffer sb = new StringBuffer();
            sb.append("<html><head><title>"
                    + "</title><style type='text/css'>.index{font-weight: bold;width: 100px;height: 150px;}.content{text-align: center;width: 700px;height: 150px;}</style></head><body><div align='center'>"
            +content+scaseId);
            sb.append("</div></body></html>");
            messageHelper.setText(sb.toString(), true);

        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("===>发送邮件出错2", e);

        }
        senderImpl.setUsername(userName);
        senderImpl.setPassword(password);
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");// 设置为ture，表示让服务器进行验证用户名和密码
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        try {
            senderImpl.send(mailMessage);// 发送邮件
        } catch (MailException e) {
            logger.error("===>发送邮件出错3", e);
            e.printStackTrace();
        }
    }

}