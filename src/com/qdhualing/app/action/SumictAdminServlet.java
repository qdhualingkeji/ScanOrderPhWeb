package com.qdhualing.app.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SumictAdminServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action=request.getParameter("action");
		if("backup".equals(action)){
			try {
				this.backupData(request,response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void backupData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SmartUploadException {
		// TODO Auto-generated method stub
		File buFile=new File("e:/buChc.sql");
		if(!buFile.exists()){
			buFile.createNewFile();
		}
		
		String strDate=null;
		try {

			Runtime rt = Runtime.getRuntime();

			//备份用如下命令即可，其它的保持不变
			String cmd ="mysqldump -h 127.0.0.1 -uroot -proot chc > e:/buChc.sql"; //一定要加 -h localhost(或是服务器IP地址)

			//还原用如下命令

			//String cmd ="mysql -h localhost -uroot -proot spmanage < e:/mysql.sql"; //一定要加 -h localhost(或是服务器IP地址)

			Process process =rt.exec("cmd /c " + cmd);

			InputStreamReader isr = new InputStreamReader(process.getErrorStream());

			LineNumberReader input = new LineNumberReader(isr);

			String line;

			isr.close();

			input.close();

			} catch (IOException e) {

			e.printStackTrace();

			}
		
		InputStream is = new FileInputStream(buFile);
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		
		StringBuffer sb=new StringBuffer();
		while (true) {
			String line = br.readLine();
			if(line==null)
				break;
			sb.append(line+"\r\n");
		}
		String str = sb.toString();
		java.io.File file=new java.io.File("c:/Tomcat 6.0/webapps/CommunityHealth/web/uploadImages/chc.sql");
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fos=new FileOutputStream(file);
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		osw.write(str);
		osw.flush();
		is.close();
		isr.close();
		br.close();
		fos.close();
		osw.close();
		

		SmartUpload su=new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setContentDisposition(null);
		su.downloadFile("e:/buChc.sql");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
