package com.qdhualing.app.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class QsUtil {

	@SuppressWarnings({"unchecked","unused"})
	public static String createXml(String rootName,List data)
	{
		if(data==null || data.size()==0)
		{
			return null;
		}
		Class clazz = data.get(0).getClass();
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		sb.append("<").append(rootName).append(">");
		
		for(int i=0;i<data.size();i++)
		{
			String startElement = "<"+clazz.getSimpleName();
			Field[] fields = clazz.getDeclaredFields();
			
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if(!method.getName().startsWith("get") || !Modifier.isPublic(method.getModifiers())|| method.getReturnType()==void.class)
				{
					continue;
				}			
				//获得属性名并把首字母转换为小写
				String attrName=method.getName().substring(3);
				attrName=attrName.substring(0, 1).toLowerCase()+attrName.substring(1);
				Object attrValue=null;	
				try {
					attrValue=method.invoke(data.get(i), null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startElement += " "+attrName+"=\""+attrValue+"\"";
				
			}
		/*	for (Field field : fields) {
				String fieldName=field.getName();
				
				String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				
				Object fieldValue;
				try {
					fieldValue = clazz.getMethod(methodName, null).invoke(data.get(i), null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				startElement += " "+fieldName+"=\""+fieldValue+"\"";
			}
			*/
			startElement +=">";
			String endElement = "</"+clazz.getSimpleName()+">";
			
			sb.append(startElement).append(endElement);
		}
		
		sb.append("</").append(rootName).append(">");
		
		return sb.toString();
		
	}
}
