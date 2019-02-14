package com.qdhualing.app.util;

public class TypeConversion {
	
	TypeConversion()
	{
		
	}
	
	//将string类型转换为int类型
	public static int stringToInt (String s)
	{
		Integer i ;
		i = Integer.valueOf(s);
		return i.intValue();
	}
	
	//将int转换为string
	public static String intToString (int i)
	{
		Integer integer = new Integer(i);
		return integer.toString();	
	}
	
	//将string转换为float
	public static float stringToFloat (String floatString)
	{
		Float f;
		f = Float.valueOf(floatString);
		return f.floatValue();
		
	}
	//将float转换为String
	public static String floatToString (float floatval)
	{
		Float f = new Float(floatval);
		return f.toString();		
	}
	//将String 转换为sql.date 
	public static java.sql.Date stringToSqlDate(String theDate)
	{
		return  java.sql.Date.valueOf(theDate);
	}
	
	//将sql.date转换为String
	public static String sqlDateToString (java.sql.Date theDate )
	{
		return theDate.toString();
	}
	
	
}
