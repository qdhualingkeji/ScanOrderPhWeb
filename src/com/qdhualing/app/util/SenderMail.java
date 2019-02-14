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
		//�����ռ���Email
		message.setTo(email);
		//����email����
	    message.setText("�װ���"+realName+",������������ҽ��ƽ̨��Ա,"+"�˺ţ�"+idCard+",����:"+password+"��");
	    
	    try {
	      mailSender.send(message);
	    } catch (MailException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
//	     ���Է���Email
//	  public static void main(String[] args) {
//	  	ApplicationContext context = new ClassPathXmlApplicationContext(
//		    "applicationContext.xml");  //�������д˶���ʱ���쳣log4j....ֻ�赼��log4j ��jar����
//		  SenderMail senderMail = (SenderMail) context.getBean("testMailSender");
//		  senderMail.sendMail();
//	 } 

}