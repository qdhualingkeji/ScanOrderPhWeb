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
		//����spring����
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		backup();
	}

	
	
	/**   
     * ���ݼ���һ��sql�ļ��Ƿ�����������ļ��õ�һ���жϷ������Ѹ�sql�ļ��ֱ��ü��±���ultra   
     * edit�򿪣�������������ľ�����û�����룬����������������Դ�ļ�������sql�ļ��ı����ʽ��Σ�Ҳ����db�ı����ʽ��Σ�   
     */    
    public static void backup() {     
        try {     
            Runtime rt = Runtime.getRuntime();     
    
            // ���� mysql �� cmd:     
            Process child = rt     
                    .exec("C:/Program Files/MySQL/MySQL Server 5.0/bin/mysqldump -uroot -proot  chc city cityName");// ���õ�������Ϊutf8�����������utf8     
                
            // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����     
            InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������     

            InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������     
                
            String inStr;     
            StringBuffer sb = new StringBuffer("");     
            String outStr;     
            // ��Ͽ���̨�����Ϣ�ַ���     
            BufferedReader br = new BufferedReader(xx);     
            while ((inStr = br.readLine()) != null) {     
                sb.append(inStr + "\r\n");     
            }     
            outStr = sb.toString();  
                
            // Ҫ�����������õ�sqlĿ���ļ���     
            FileOutputStream fout = new FileOutputStream(     
                    "d:/chc.sql");     
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");     
            writer.write(outStr);     
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���     
            writer.flush();     
    
            // �����ǹر����������     
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
    * ����   
    *   
    */    
   public static void load() {     
       try {     
           String fPath = "d:/xytx.sql";     
           Runtime rt = Runtime.getRuntime();     
   
           // ���� mysql �� cmd:     
           Process child = rt.exec("C:/Program Files/MySQL/MySQL Server 5.0/bin/mysql.exe -uroot -proot xytx ");     
           OutputStream out = child.getOutputStream();//����̨��������Ϣ��Ϊ�����     
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
           // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���     
           writer.flush();     
           // �����ǹر����������     
           out.close();     
           br.close();     
           writer.close();     
   
           
       } catch (Exception e) {     
           e.printStackTrace();     
       } 
   }

   
   }    
