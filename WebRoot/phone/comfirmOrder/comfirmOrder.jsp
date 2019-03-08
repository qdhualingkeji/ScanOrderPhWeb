<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport">
<link href="<%=path %>/phone/comfirmOrder/css/comfirmOrder.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var path='<%=path %>';
var mount = 0;
var money = 0;
var productStr = "";
var discountAmount=0;
var remark;
var orderAmount=20;
var discountCouponId=0;
//var shopId="82";
//var seatName="4";
var shopId='${sessionScope.shopId}';
var seatName='${sessionScope.zhuoNo}';
var token='${sessionScope.token}';

var pay; 
var type = "xiadan";
var orderedFoodList=[];
//var type = '${requestScope.type}';
/*
let orderedFood = { productList: [] }
comfirmOrder.setData({
  orderedFood: orderedFood
});
comfirmOrder.initMenuInfo();
comfirmOrder.getMineInfo();
*/
$(function(){
	if (type =="xiadan")
	  pay = "确认下单";
	else if (type == "tiaodan")
	  pay = "确认调单";
	$("#bottompay_div").text(pay);  
	$("#zhuohao_div").text(seatName);
	initMenuInfo();
	getMineInfo();
});

function getMineInfo(){
	
}

function initMenuInfo(){
	$.post(path+"/phoneAction_initMenuInfo.action",
		function(res){
			console.log(res);
			if(res.code==100){
				var ofListDiv=$("#ofList_div");
				orderedFoodList=res.orderedFoodList;
				for(var i=0;i<orderedFoodList.length;i++){
					ofListDiv.append("<div class=\"item_div\">"
						      +"<div class=\"foodName_div\">"+orderedFoodList[i].productName+"</div>"
						      +"<div class=\"foodPrice_div\">"+orderedFoodList[i].price+"元</div>"
						      +"<div class=\"foodMount_div\">"+orderedFoodList[i].quantity+"</div>"
						    +"</div>");
				}
			}
			calulateMoneyAndAmount();
		}
	);
}

function calulateMoneyAndAmount(){
	var productList = orderedFoodList;
    for (var i = 0; i < productList.length;i++){
      mount += productList[i].quantity;
      money += productList[i].price * productList[i].quantity;
      if (i < (productList.length - 1)) {
        productStr += convertFoodToString(productList[i]) + ",";
      } 
      else {
        console.log("productStr111==="+productStr);
        productStr += convertFoodToString(productList[i]);
        console.log("productStr222==="+productStr);
      }
    }
    productStr = "[" + productStr + "]";
    refreshUI();
    console.log("productStr==="+productStr);
}

function convertFoodToString(food){
	console.log("food===" + JSON.stringify(food));
    var newFood = { productId: "", productName: "", quantity: "", price: "" };
    newFood.productId = food.id;
    newFood.productName = food.productName;
    newFood.quantity = food.quantity;
    newFood.price = food.price;
    console.log("newFood===" + JSON.stringify(newFood));
    return JSON.stringify(newFood);
}

function refreshUI(){
	$("#foodamount_div").text(mount+"份");
	$("#foodAmount_div").text(mount);
	$("#moneyamount_div").text("共"+money+"元");
	$("#totalPrice_div").text(money+"元");
	$("#totalAmount").text("总价:"+money+"元");
	$("#shiFu").text("总价:"+money+"元");
}

function bottompay(){
	if (type == "xiadan")
      commitOrderBtn();
    else if (type == "tiaodan")
      comfirmTiaoDan();
}

function commitOrderBtn(){
	discountAmount=0;
    remark ="微辣";
    var shiFu=$("#shiFu").text();
    orderAmount=shiFu.substring(3,shiFu.length-1);
    var jsonStr = createJsonStr();
    //var jsonStr = "[{productId:47,productName:美味鸡腿堡,quantity:2,price:10.0}]";
    console.log("jsonStr===" + jsonStr);
    
    $.post(path+"/phoneAction_confirmOrderButton.action",
   		{shopId: shopId, remark: remark, jsonProductList: jsonStr, discountAmount: discountAmount, seatName: seatName, orderAmount: orderAmount, discountCouponId: discountCouponId, token:token},
   		function(res){
   			console.log("res==="+JSON.stringify(res));
   			var result=res.result;
   			if(result.code==100){
   				alert("订单:"+result.data+",下单"+result.message);
   				location.href=path+"/phoneAction_toSelectSeat.action?shopId="+shopId;
   			}
   			else{
   				alert(result.message);
   			}
   		}
	);
    
    /*
    wx.request({
      url: rootIP+"confirmOrderButton",
      method: 'POST',
      data: { shopId: shopId, remark: remark, jsonProductList: jsonStr, discountAmount: discountAmount, seatName: seatName, orderAmount: orderAmount, discountCouponId: discountCouponId, token:token},
      header: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      success: function (res) {
        console.log("res==="+JSON.stringify(res));
        var data = res.data;
        //console.log("data==="+data);
        if (data.code == 100) {
          wx.setStorageSync("orderNumber",data.data);
          wx.showToast({
            title: '下单成功',
            duration:2000
          })
          wx.navigateTo({
            url: '/pages/dcMain/dcMain'
          })
        }
        else{
          wx.showToast({
            title: '下单失败',
            duration: 2000
          })
        }
      }
    })
    */
}

function comfirmTiaoDan(){
	orderNumber = '${sessionScope.orderNumber}';
    //orderNumber ="1901055929510278";
    //productStr ="[{productId:47,productName:美味鸡腿堡,quantity:1,price:10.0}]";
    console.log("productStr===" + productStr);
    
    $.post(path+"/phoneAction_enterAdjustOrder.action",
   		{orderNumber: orderNumber, shopId: shopId, seatName: seatName, jsonProductList: productStr, token:token},
   		function(res){
   			console.log(res);
   		}
	);
    
    /*
    wx.request({
      url: rootIP+"enterAdjustOrder",
      method: 'POST',
      data: { orderNumber: orderNumber, shopId: shopId, seatName: seatName, jsonProductList: productStr, token:token},
      header: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      success: function (res) {
        console.log(res);
        var data = res.data;
        console.log(data);
        if (data.code == 100) {
          wx.showToast({
            title: '发送调单请求成功，请等待商家确认',
            duration:2000
          })
          wx.navigateTo({
            url: '/pages/dcMain/dcMain',
          })
        }
        else{
          wx.showToast({
            title: '商家未接单，无法调单',
            duration: 2000
          })
        }
      }
    })
    */
}

function createJsonStr(){
	var result="";
    result+="[";
    var productList=orderedFoodList;
    for (var i = 0; i < productList.length;i++){
      result += convertFoodToString(productList[i])+",";
    }
    result=result.substring(0, result.length-1);
    result += "]";
    return result;
}
</script>
<title>确认订单</title>
</head>
<body style="margin: 0px;">
<div style='width:100%;'>
  <div class="qrdd_div">
    确认订单
  </div>
  <div class="back_div" onclick="history.go(-1);">返回</div>
  <div class="top_div">
    <img class="imgUrl_img" src="<%=path %>/phone/image/024.jpg"></img>
    <div class="nickName_div"></div>
    <div class="show_location_div">
      <img class="zhuohao_img" src="<%=path %>/phone/image/021.png"></img>
      <div class="zhuohaoTit_div">桌号</div>
      <div class="zhuohao_div" id="zhuohao_div"></div>
    </div>
    <div class="consume_div">
      <div class="foodamount_div" id="foodamount_div"></div>
      <div class="moneyamount_div" id="moneyamount_div"></div>
    </div>
  </div>
  <div class="ydsp_div">
  	<span class="ydsp_span">已点商品</span>
  </div>
  <div class="ofList_div" id="ofList_div">
  </div>
  <div class="totalAmount_div">
    <div class="totalAmount" id="totalAmount">
    </div>
  </div>
  <div class="shiFu_div">
    <div class="shiFu" id="shiFu">
    </div>
  </div>
  <div class="space_div">
  </div>
  <div class="bottom_div">
    <img class="yidian_img" src="<%=path %>/phone/image/019.png"></img>
    <div class="foodAmount_div" id="foodAmount_div">
    </div>
    <div class='vs_div'></div>
    <div class='yd_tp_div'>
      <div class='yidian_div'>
        已点
      </div>
      <div class="totalPrice_div" id="totalPrice_div">
      </div>
    </div>
    <div class="bottompay_div" id="bottompay_div" onclick="bottompay()">
    </div>
  </div>
</div>
</body>
</html>