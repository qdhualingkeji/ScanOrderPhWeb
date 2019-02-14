package com.qdhualing.app.util;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SenderMail {

	  private MailSender mailSender;
	  private SimpleMailMessage mailMessage;
	  
	  public void TestSenderMail() {
	    
	  }
	  
	  public SimpleMailMessage getMailMessage() {
	    return mailMessage;
	  }
	  public void setMailMessage(SimpleMailMessage mailMessage) {
	    this.mailMessage = mailMessage;
	  }
	  public MailSender getMailSender() {
	    return mailSender;
	  }
	  public void setMailSender(MailSender mailSender) {
	    this.mailSender = mailSender;
	  }
	  
	  public void sendMail(String realName,String idCard,String password,String email) {
		 SimpleMailMessage message = new SimpleMailMessage(mailMessage);
		//设置收件人Email
		message.setTo(email);
		//设置email内容
	    message.setText("亲爱的"+realName+",您已申请社区医疗平台会员,"+"账号："+idCard+",密码:"+password+"。");
	    
	    try {
	      mailSender.send(message);
	    } catch (MailException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
//	     测试发送Email
//	  public static void main(String[] args) {
//	  	ApplicationContext context = new ClassPathXmlApplicationContext(
//		    "applicationContext.xml");  //若在运行此对象时报异常log4j....只需导入log4j 的jar就行
//		  SenderMail senderMail = (SenderMail) context.getBean("testMailSender");
//		  senderMail.sendMail();
//	 } 

}