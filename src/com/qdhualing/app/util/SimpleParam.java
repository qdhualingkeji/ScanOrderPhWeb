package com.qdhualing.app.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SimpleParam {
	
	SimpleParam ()
	{
		
	}
	
	//得到当前系统时间格式为 yyyy-MM-dd HH:mm:ss
	public static String getDateForYMDHMS(Date dateval)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  df.format(new java.util.Date() ).toString();		
	}
  //得到当前系统时间
	public static String getDateForYMD(Date dateval)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return  df.format(new java.util.Date() ).toString();		
	}
		
}
