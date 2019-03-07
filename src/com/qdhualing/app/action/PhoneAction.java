package com.qdhualing.app.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.bean.AlreadySelectFoodData;
import com.qdhualing.app.bean.OrderFoodBean;

public class PhoneAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> resultMap;
	private String seatName;
	private String shopId;
	private String categoryId;
	private String token;
	private String orderNumber;
	private String goodsJAStr;
	private String type;
	private String remark;
	private String jsonProductList;
	private String orderAmount;
	private Integer index;
	private Integer quantity;
	private Integer id;
	private Integer discountAmount;
	private Integer discountCouponId;
	private Integer productId;
	private Integer state;
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getJsonProductList() {
		return jsonProductList;
	}

	public void setJsonProductList(String jsonProductList) {
		this.jsonProductList = jsonProductList;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getDiscountCouponId() {
		return discountCouponId;
	}

	public void setDiscountCouponId(Integer discountCouponId) {
		this.discountCouponId = discountCouponId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGoodsJAStr() {
		return goodsJAStr;
	}

	public void setGoodsJAStr(String goodsJAStr) {
		this.goodsJAStr = goodsJAStr;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * 请求远程服务器接口前缀常量
	 * **/
	//private static final String ROOT_IP = "http://120.27.5.36:8080/htkApp/API/buffetFoodAPI/";
	//private static final String ROOT_IP = "http://192.168.230.1:8088/htkApp/API/buffetFoodAPI/";
	//private static final String ROOT_IP = "http://192.168.230.1:8088/htkApp/API/buffetFoodAPI/";
	//private static final String ROOT_IP = "https://www.bainuojiaoche.com/htkApp/API/buffetFoodAPI/";
	private static final String ROOT_IP1 = "http://120.27.5.36:8080/htkApp/API/wxScanUserAPI/";
	//private static final String ROOT_IP1 = "http://127.0.0.1:8088/htkApp/API/wxScanUserAPI/";
	private static final String ROOT_IP2 = "http://120.27.5.36:8080/htkApp/API/phWebScanUserAPI/";
	//private static final String ROOT_IP2 = "http://192.168.230.1:8088/htkApp/API/phWebScanUserAPI/";
	
	//http://localhost:8080/ScanOrderPhWeb/phoneAction_toSelectSeat.action?shopId=82
	//http://localhost:8080/ScanOrderPhWeb/phoneAction_toDcMain.action?seatName=3
	//http://localhost:8080/ScanOrderPhWeb/phoneAction_toOrderedList.action
	//E:\htk_customer\app\src\main\java\com\hl\htk_customer\hldc\main
	//http://localhost:8080/ScanOrderPhWeb/phone/orderDetail/orderDetail.jsp
	
	public String toSelectSeat() {
		
		HttpSession session = getHttpSession();
		session.setAttribute("shopId", shopId);
		return SUCCESS;
	}
	
	public String toDcMain() {
		
		HttpSession session = getHttpSession();
		session.setAttribute("zhuoNo", seatName);
		
		String token=(String)session.getAttribute("token");
		if(StringUtils.isEmpty(token)) {
			String shopId=session.getAttribute("shopId").toString();
			login(shopId,seatName);
		}
		return SUCCESS;
	}
	
	public String toOrderedList() {
		
		return SUCCESS;
	}
	
	public String login(String shopId, String seatName) {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("shopId", shopId));
		params.add(1, new BasicNameValuePair("seatName", seatName));
		try {
			resultMap=getRespJson(ROOT_IP2+"login", params);
			JSONObject resultJO = (JSONObject)resultMap.get("result");
			if(resultJO.getInt("code")==100) {
				String token=resultJO.getString("data");
				System.out.println("token==="+token);
				HttpSession session = getHttpSession();
				session.setAttribute("token", token);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getShopSeatInfoById() {
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("shopId", shopId));
		try {
			resultMap=getRespJson(ROOT_IP+"getShopSeatInfoById", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getShopShowInfoById() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("shopId", shopId));
		try {
			resultMap=getRespJson(ROOT_IP1+"getShopShowInfoById", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getCategoryList() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("shopId", shopId));
		try {
			resultMap=getRespJson(ROOT_IP+"getCategoryList", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getGoodsListByCategoryId() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("categoryId", categoryId));
		params.add(1, new BasicNameValuePair("token", token));
		try {
			resultMap=getRespJson(ROOT_IP+"getGoodsListByCategoryId", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getOrderDetailsByOrderNumber() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("orderNumber", orderNumber));
		params.add(1, new BasicNameValuePair("shopId", shopId));
		params.add(2, new BasicNameValuePair("token", token));
		try {
			resultMap = new HashMap<String, Object>();
			HashMap<String, Object> codeJsonMap = new HashMap<String, Object>();
			codeJsonMap.put("code", 100);
			
			HashMap<String, Object> dataJsonMap = new HashMap<String, Object>();
			dataJsonMap.put("orderState", 0);
			dataJsonMap.put("orderTime", "1997-07-01");
			
			List<OrderFoodBean> productList = AlreadySelectFoodData.getAllFoodList();
			//String str = "[{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"47\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521421139963.jpg\",\"price\":\"10\",\"productName\":\"美味鸡腿堡\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"49\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521428838821.jpg\",\"price\":\"20\",\"productName\":\"牛肉面\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"50\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429424766.jpg\",\"price\":\"8\",\"productName\":\"寿司\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"51\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429984947.jpg\",\"price\":\"45\",\"productName\":\"生蒸五花肉\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"52\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521430362329.jpg\",\"price\":\"75\",\"productName\":\"板栗扣鸭\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"53\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521532104026.jpg\",\"price\":\"80\",\"productName\":\"泡椒鱼\"},{\"categoryId\":\"37\",\"categoryName\":\"餐具\",\"id\":\"54\",\"quantity\":\"3\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521597879066.jpg\",\"price\":\"10\",\"productName\":\"一次性餐具\"}]";
			//JSONArray orderedFoodJA = JSONArray.fromObject(str);
			//List<OrderFoodBean> productList = JSONArray.toList(orderedFoodJA,OrderFoodBean.class);
			dataJsonMap.put("productList", productList);
			dataJsonMap.put("commitTime", "1997-07-01");
			
			codeJsonMap.put("data", dataJsonMap);
			
			resultMap.put("result", codeJsonMap);
			//resultMap=getRespJson(ROOT_IP+"getOrderDetailsByOrderNumber", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getOrderDetailsByOrderNumberOL() {
		
		try {
			getOrderDetailsByOrderNumber();
			HashMap resultJO=(HashMap)resultMap.get("result");
			if(Integer.valueOf(resultJO.get("code").toString())==100){
				
			}
			List<OrderFoodBean> ofList = AlreadySelectFoodData.getAllFoodList();
			resultMap = new HashMap<String, Object>();
			resultMap.put("code", 100);
			JSONObject dataJO = new JSONObject();
			String str = "[{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"47\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521421139963.jpg\",\"price\":\"10\",\"productName\":\"美味鸡腿堡\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"49\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521428838821.jpg\",\"price\":\"20\",\"productName\":\"牛肉面\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"50\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429424766.jpg\",\"price\":\"8\",\"productName\":\"寿司\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"51\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429984947.jpg\",\"price\":\"45\",\"productName\":\"生蒸五花肉\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"52\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521430362329.jpg\",\"price\":\"75\",\"productName\":\"板栗扣鸭\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"53\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521532104026.jpg\",\"price\":\"80\",\"productName\":\"泡椒鱼\"},{\"categoryId\":\"37\",\"categoryName\":\"餐具\",\"id\":\"54\",\"quantity\":\"3\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521597879066.jpg\",\"price\":\"10\",\"productName\":\"一次性餐具\"}]";
			dataJO.put("productList", JSONArray.fromObject(ofList));
			//dataJO.put("productList", ofList);
			resultMap.put("data", dataJO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String checkIfAlreadyExistOrder() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("shopId", shopId));
		params.add(1, new BasicNameValuePair("token", token));
		try {
			resultMap=getRespJson(ROOT_IP+"checkIfAlreadyExistOrder", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String nextAction() {
		
		/*
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			System.out.println("goodsJAStr111==="+goodsJAStr);
			//goodsJAStr = new String(goodsJAStr.getBytes("gbk"), "UTF-8");
			goodsJAStr=goodsJAStr.replaceAll("\\\\\"", "\"");
			//System.out.println("goodsJAStr222==="+goodsJAStr);
			JSONArray goodsJA = JSONArray.fromObject(goodsJAStr);
			//System.out.println("goodsJA==="+goodsJA.size());
			for (int i = 0; i < goodsJA.size(); i++) {
				JSONObject goodsJO = (JSONObject)goodsJA.get(i);
				if(Integer.valueOf(goodsJO.getString("quantity"))>0&&!checkIfExist(goodsJO)){
					OrderFoodBean bean=new OrderFoodBean();
					bean.setCategoryId(goodsJO.getInt("categoryId"));
					bean.setCategoryName(goodsJO.getString("categoryName"));
					bean.setId(goodsJO.getInt("id"));
					bean.setQuantity(goodsJO.getInt("quantity"));
					bean.setImgUrl(goodsJO.getString("imgUrl"));
					bean.setPrice(goodsJO.getDouble("price"));
					bean.setProductName(goodsJO.getString("productName"));
					System.out.println("===AlreadySelectFoodData.addBean");
					AlreadySelectFoodData.addBean(bean);
				}
			}
			resultMap=new HashMap<String, Object>();
			resultMap.put("result", "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public boolean checkIfExist(JSONObject food) {
		List<OrderFoodBean> allFood = AlreadySelectFoodData.getAllFoodList();
		for (int i = 0; i < allFood.size();i++){
	      OrderFoodBean f = allFood.get(i);
	      if(Integer.valueOf(food.getString("categoryId"))==f.getCategoryId()){
	        if(Integer.valueOf(food.getString("id"))==f.getId()){
	          f.setQuantity(Integer.valueOf(food.getString("quantity")));
	          return true;
	        }
	      }
	    }
	    return false;
	}
	
	public String reduceProduct() {
		
		System.out.println("reduceProduct.id==="+id);
		System.out.println("reduceProduct.quantity==="+quantity);
		
		try {
			//AlreadySelectFoodData.getAllFoodList().get(index).setQuantity(quantity);
			List<OrderFoodBean> allFoodList = AlreadySelectFoodData.getAllFoodList();
			for (OrderFoodBean orderFoodBean : allFoodList) {
				if(id==orderFoodBean.getId()) {
					orderFoodBean.setQuantity(quantity);
				}
			}
			
			resultMap=new HashMap<String, Object>();
			resultMap.put("result", "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String plusProduct() {
		
		System.out.println("plusProduct.id==="+id);
		System.out.println("plusProduct.quantity==="+quantity);

		try {
			//AlreadySelectFoodData.getAllFoodList().get(index).setQuantity(quantity);
			List<OrderFoodBean> allFoodList = AlreadySelectFoodData.getAllFoodList();
			for (OrderFoodBean orderFoodBean : allFoodList) {
				if(id==orderFoodBean.getId()) {
					orderFoodBean.setQuantity(quantity);
				}
			}
			
			resultMap=new HashMap<String, Object>();
			resultMap.put("result", "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String deleteProduct() {
		
		System.out.println("plusProduct.id==="+id);
		
		List<OrderFoodBean> allFoodList = AlreadySelectFoodData.getAllFoodList();
		for (int i = 0; i < allFoodList.size(); i++) {
			OrderFoodBean allFood = allFoodList.get(i);
			if(id==allFood.getId()){
				allFoodList.remove(i);
				break;
			}
		}
		
		resultMap=new HashMap<String, Object>();
		resultMap.put("result", "1");
		
		return SUCCESS;
	}
	
	public String initMenuInfo() {
		
		List<OrderFoodBean> orderedFoodList = AlreadySelectFoodData.getAllFoodList();
		//String str = "[{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"47\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521421139963.jpg\",\"price\":\"10\",\"productName\":\"美味鸡腿堡\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"49\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521428838821.jpg\",\"price\":\"20\",\"productName\":\"牛肉面\"},{\"categoryId\":\"34\",\"categoryName\":\"快餐\",\"id\":\"50\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429424766.jpg\",\"price\":\"8\",\"productName\":\"寿司\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"51\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429984947.jpg\",\"price\":\"45\",\"productName\":\"生蒸五花肉\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"52\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521430362329.jpg\",\"price\":\"75\",\"productName\":\"板栗扣鸭\"},{\"categoryId\":\"36\",\"categoryName\":\"炒菜\",\"id\":\"53\",\"quantity\":\"2\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521532104026.jpg\",\"price\":\"80\",\"productName\":\"泡椒鱼\"},{\"categoryId\":\"37\",\"categoryName\":\"餐具\",\"id\":\"54\",\"quantity\":\"3\",\"imgUrl\":\"http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521597879066.jpg\",\"price\":\"10\",\"productName\":\"一次性餐具\"}]";
		//JSONArray orderedFoodJA = JSONArray.fromObject(str);
		//List<OrderFoodBean> orderedFoodList = JSONArray.toList(orderedFoodJA,OrderFoodBean.class);
		
		resultMap=new HashMap<String, Object>();
		if(orderedFoodList.size()>0){
			resultMap.put("code", 100);
			resultMap.put("orderedFoodList", orderedFoodList);
		}
		else
			resultMap.put("code", -99);
		
		return SUCCESS;
	}
	
	public String confirmOrderButton() {

		try {
			List<NameValuePair> params=new ArrayList<NameValuePair>();
			params.add(0, new BasicNameValuePair("shopId", shopId));
			params.add(1, new BasicNameValuePair("remark", remark));
			params.add(2, new BasicNameValuePair("jsonProductList", jsonProductList));
			params.add(3, new BasicNameValuePair("discountAmount", discountAmount+""));
			params.add(4, new BasicNameValuePair("seatName", seatName));
			params.add(5, new BasicNameValuePair("orderAmount", orderAmount));
			params.add(6, new BasicNameValuePair("discountCouponId", discountCouponId+""));
			params.add(7, new BasicNameValuePair("token", token));
			resultMap=getRespJson(ROOT_IP+"confirmOrderButton", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String enterAdjustOrder() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("orderNumber", orderNumber));
		params.add(1, new BasicNameValuePair("shopId", shopId));
		params.add(2, new BasicNameValuePair("seatName", seatName));
		params.add(3, new BasicNameValuePair("jsonProductList", jsonProductList));
		params.add(4, new BasicNameValuePair("token", token));
		try {
			resultMap=getRespJson(ROOT_IP+"enterAdjustOrder", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String reminderInterface() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("orderNumber", orderNumber));
		try {
			resultMap=getRespJson(ROOT_IP+"reminderInterface", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String addToWishListById() {

		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(0, new BasicNameValuePair("token", token));
		params.add(0, new BasicNameValuePair("productId", productId+""));
		params.add(0, new BasicNameValuePair("state", state+""));
		try {
			resultMap=getRespJson(ROOT_IP+"addToWishListById", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
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
			jsonMap.put("result", JSONObject.fromObject(result));
		//}
		return jsonMap;
	}
	
	public HttpSession getHttpSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;
	}
	
	public static void main(String[] args) {
		try {
			/*
			JSONArray.fromObject("[{'categoryId':'34','categoryName':'蹇','id':'47','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521421139963.jpg','price':'10','productName':'缇庡懗楦¤吙鍫?'},{'categoryId':'34','categoryName':'蹇','id':'49','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521428838821.jpg','price':'20','productName':'鐗涜倝闈?},{'categoryId':'34','categoryName':'蹇','id':'50','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429424766.jpg','price':'8','productName':'瀵垮徃'},{'categoryId':'36','categoryName':'鐐掕彍','id':'51','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521429984947.jpg','price':'45','productName':'鐢熻捀浜旇姳鑲?},{'categoryId':'36','categoryName':'鐐掕彍','id':'52','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521430362329.jpg','price':'75','productName':'鏉挎牀鎵ｉ腑'},{'categoryId':'36','categoryName':'鐐掕彍','id':'53','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521532104026.jpg','price':'80','productName':'娉℃楸?},{'categoryId':'37','categoryName':'椁愬叿','id':'54','quantity':'0','imgUrl':'http://120.27.5.36:8080/htkApp/upload/shop/buffetFood/1521597879066.jpg','price':'10','productName':'涓?鎬ч鍏?}]");
			*/
			String str = new String("涓?娆℃?ч鍏穃".getBytes("gbk"), "UTF-8");
			System.out.println("str==="+str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
