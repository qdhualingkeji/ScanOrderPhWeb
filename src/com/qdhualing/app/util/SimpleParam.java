package com.qdhualing.app.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SimpleParam {
	
	SimpleParam ()
	{
		
	}
	
	//�õ���ǰϵͳʱ���ʽΪ yyyy-MM-dd HH:mm:ss
	public static String getDateForYMDHMS(Date dateval)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  df.format(new java.util.Date() ).toString();		
	}
  //�õ���ǰϵͳʱ��
	public static String getDateForYMD(Date dateval)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return  df.format(new java.util.Date() ).toString();		
	}
		
}
