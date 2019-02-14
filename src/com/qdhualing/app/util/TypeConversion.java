package com.qdhualing.app.util;

public class TypeConversion {
	
	TypeConversion()
	{
		
	}
	
	//��string����ת��Ϊint����
	public static int stringToInt (String s)
	{
		Integer i ;
		i = Integer.valueOf(s);
		return i.intValue();
	}
	
	//��intת��Ϊstring
	public static String intToString (int i)
	{
		Integer integer = new Integer(i);
		return integer.toString();	
	}
	
	//��stringת��Ϊfloat
	public static float stringToFloat (String floatString)
	{
		Float f;
		f = Float.valueOf(floatString);
		return f.floatValue();
		
	}
	//��floatת��ΪString
	public static String floatToString (float floatval)
	{
		Float f = new Float(floatval);
		return f.toString();		
	}
	//��String ת��Ϊsql.date 
	public static java.sql.Date stringToSqlDate(String theDate)
	{
		return  java.sql.Date.valueOf(theDate);
	}
	
	//��sql.dateת��ΪString
	public static String sqlDateToString (java.sql.Date theDate )
	{
		return theDate.toString();
	}
	
	
}
