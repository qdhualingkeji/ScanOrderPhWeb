package com.qdhualing.app.appGeteway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是远程服务器接口集合类
 * **/
@Controller
@RequestMapping(value="/json")
public class JsonResponse {
	
	Logger log = Logger.getLogger(JsonResponse.class);

	/**
	 * 请求远程服务器接口前缀常量
	 * **/
	private static final String URL="http://210.22.91.77:29015/v1/token/access";
	
	@RequestMapping(value="/access.action")
	@ResponseBody
	public Map<String, Object> access(String merchantCode, String terminalCode, String systemTraceNum, 
			String transactionAmount, String transactionCurrencyCode, String merchantOrderId, 
			String merchantRemark, String payMode, String payCode) {
		
		Map<String, Object> resultMap = null;
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("merchantCode", merchantCode));
		params.add(1, new BasicNameValuePair("terminalCode", terminalCode));
		params.add(2, new BasicNameValuePair("systemTraceNum", systemTraceNum));
		params.add(3, new BasicNameValuePair("transactionAmount", transactionAmount));
		params.add(4, new BasicNameValuePair("transactionCurrencyCode", transactionCurrencyCode));
		params.add(5, new BasicNameValuePair("merchantOrderId", merchantOrderId));
		params.add(6, new BasicNameValuePair("merchantRemark", merchantRemark));
		params.add(7, new BasicNameValuePair("payMode", payMode));
		params.add(8, new BasicNameValuePair("payCode", payCode));
		try {
			resultMap=getRespJson(URL, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@RequestMapping(value="/jiHuo2.action")
	@ResponseBody
	public Map<String, Object> jiHuo2() {
		
		Map<String, Object> resultMap = null;
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("merchantCode", "123456789900081"));
		params.add(1, new BasicNameValuePair("terminalCode", "00810001"));
		params.add(2, new BasicNameValuePair("systemTraceNum", "222222"));
		try {
			resultMap=getRespJson("http://210.22.91.77:29015/v1/poslink/transaction/activeterminal", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@RequestMapping(value="/getOrderForm.action")
	@ResponseBody
	public Map<String, Object> getOrderForm(String url, String roomNo) {
		
		log.info("JsonResponse.getOrderForm.url = " + url);
		log.info("JsonResponse.getOrderForm.roomNo = " + roomNo);
		
		Map<String, Object> resultMap = null;
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("roomNo", roomNo));
		try {
			resultMap=getRespJson(url, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@RequestMapping(value="/updateOrder.action")
	@ResponseBody
	public Map<String, Object> updateOrder(String url, String deptNo, String roomNo, String payWay,
			String feeAll, String cardNo, String billNo, String staffsCode, String nowJF, String leftTotal) {
		
		log.info("JsonResponse.updateOrder.url = " + url);
		log.info("JsonResponse.updateOrder.deptNo = " + deptNo);
		log.info("JsonResponse.updateOrder.roomNo = " + roomNo);
		log.info("JsonResponse.updateOrder.payWay = " + payWay);
		log.info("JsonResponse.updateOrder.feeAll = " + feeAll);
		log.info("JsonResponse.updateOrder.cardNo = " + cardNo);
		log.info("JsonResponse.updateOrder.billNo = " + billNo);
		log.info("JsonResponse.updateOrder.staffsCode = " + staffsCode);
		log.info("JsonResponse.updateOrder.nowJF = " + nowJF);
		log.info("JsonResponse.updateOrder.leftTotal = " + leftTotal);
		
		Map<String, Object> resultMap = null;
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("deptNo", deptNo));
		params.add(1, new BasicNameValuePair("roomNo", roomNo));
		params.add(2, new BasicNameValuePair("payWay", payWay));
		params.add(3, new BasicNameValuePair("feeAll", feeAll));
		params.add(4, new BasicNameValuePair("cardNo", cardNo));
		params.add(5, new BasicNameValuePair("billNo", billNo));
		params.add(6, new BasicNameValuePair("staffsCode", staffsCode));
		params.add(7, new BasicNameValuePair("nowJF", nowJF));
		params.add(8, new BasicNameValuePair("leftTotal", leftTotal));
		try {
			resultMap=getRespJson(url, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@RequestMapping(value="/remindersDish.action")
	@ResponseBody
	public Map<String, Object> remindersDish(String url, String billNo, String deptNo, 
			String roomNo, String staffsCode, String courseNo) {
		
		log.info("JsonResponse.remindersDish.url = " + url);
		log.info("JsonResponse.remindersDish.billNo = " + billNo);
		log.info("JsonResponse.remindersDish.deptNo = " + deptNo);
		log.info("JsonResponse.remindersDish.roomNo = " + roomNo);
		log.info("JsonResponse.remindersDish.staffsCode = " + staffsCode);
		log.info("JsonResponse.remindersDish.courseNo = " + courseNo);
		
		Map<String, Object> resultMap = null;
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("billNo", billNo));
		params.add(0, new BasicNameValuePair("deptNo", deptNo));
		params.add(0, new BasicNameValuePair("roomNo", roomNo));
		params.add(0, new BasicNameValuePair("staffsCode", staffsCode));
		params.add(0, new BasicNameValuePair("courseNo", courseNo));
		
		try {
			resultMap=getRespJson(url, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	public Map<String, Object> getRespJson(String url,List<NameValuePair> params) throws Exception {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		//POST的URL
		//建立HttpPost对象
		HttpPost httppost=new HttpPost(url);
		httppost.addHeader("Authorization", "AppId=f0ec96ad2c3848b5b810e7aadf369e2f, Timestamp=20170825165329, Nonce=1857459, Signature=02Xd0HUkaG5F4pFthYpp2vCSggHWWk6E3SfuMDreStU=");
		//添加参数
		if(params!=null)
			httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
		//设置编码
		HttpResponse response=new DefaultHttpClient().execute(httppost);
		//发送Post,并返回一个HttpResponse对象
		//if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
			String result=EntityUtils.toString(response.getEntity());
			//得到返回的字符串,打印输出
			System.out.println("result==============="+result);
			jsonMap.put("result", result);
		//}
		return jsonMap;
	}
}
