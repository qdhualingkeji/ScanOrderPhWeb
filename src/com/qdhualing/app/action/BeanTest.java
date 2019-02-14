package com.qdhualing.app.action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BeanTest {
	
	public static void main(String[] args) {
		//创建spring容器
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		backup();
	}

	
	
	/**   
     * 备份检验一个sql文件是否可以做导入文件用的一个判断方法：把该sql文件分别用记事本和ultra   
     * edit打开，如果看到的中文均正常没有乱码，则可以用来做导入的源文件（不管sql文件的编码格式如何，也不管db的编码格式如何）   
     */    
    public static void backup() {     
        try {     
            Runtime rt = Runtime.getRuntime();     
    
            // 调用 mysql 的 cmd:     
            Process child = rt     
                    .exec("C:/Program Files/MySQL/MySQL Server 5.0/bin/mysqldump -uroot -proot  chc city cityName");// 设置导出编码为utf8。这里必须是utf8     
                
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行     
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流     

            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码     
                
            String inStr;     
            StringBuffer sb = new StringBuffer("");     
            String outStr;     
            // 组合控制台输出信息字符串     
            BufferedReader br = new BufferedReader(xx);     
            while ((inStr = br.readLine()) != null) {     
                sb.append(inStr + "\r\n");     
            }     
            outStr = sb.toString();  
                
            // 要用来做导入用的sql目标文件：     
            FileOutputStream fout = new FileOutputStream(     
                    "d:/chc.sql");     
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");     
            writer.write(outStr);     
            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免     
            writer.flush();     
    
            // 别忘记关闭输入输出流     
            in.close();     
            xx.close();     
            br.close();     
            writer.close();     
            fout.close();     
    
              
    
        } catch (Exception e) {     
            e.printStackTrace();     
        }     
    
    }     



    /**   
    * 导入   
    *   
    */    
   public static void load() {     
       try {     
           String fPath = "d:/xytx.sql";     
           Runtime rt = Runtime.getRuntime();     
   
           // 调用 mysql 的 cmd:     
           Process child = rt.exec("C:/Program Files/MySQL/MySQL Server 5.0/bin/mysql.exe -uroot -proot xytx ");     
           OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流     
           String inStr;     
           StringBuffer sb = new StringBuffer("");     
           String outStr;     
           BufferedReader br = new BufferedReader(new InputStreamReader(     
                   new FileInputStream(fPath), "utf8"));     
           while ((inStr = br.readLine()) != null) {     
               sb.append(inStr + "\r\n");     
           }     
           outStr = sb.toString();     
   
           OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");     
           writer.write(outStr);     
           // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免     
           writer.flush();     
           // 别忘记关闭输入输出流     
           out.close();     
           br.close();     
           writer.close();     
   
           
       } catch (Exception e) {     
           e.printStackTrace();     
       } 
   }

   
   }    
