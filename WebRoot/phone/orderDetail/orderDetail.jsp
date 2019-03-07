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
<link href="<%=path %>/phone/orderDetail/css/orderDetail.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var path='<%=path %>';
//var orderNumber='${sessionScope.orderNumber}';
var orderNumber="1903066055210284";
var shopId='${sessionScope.shopId}';
var seatName='${sessionScope.zhuoNo}';
var token='${sessionScope.token}';

$(function(){
	getOrderDetailsByOrderNumber();
});

function getOrderDetailsByOrderNumber(){
	$.post(path+"/phoneAction_getOrderDetailsByOrderNumber.action",
		{orderNumber: orderNumber, shopId: shopId, token:token},
		function(res){
			console.log(res);
			var result = res.result;
	        if (result.code == 100){
	          var orderState = result.data.orderState;
	          var paid, cook, finished, stateTip;
	          if(orderState==0){
	            paid = "未付款";
	            cook = "未开始";
	            finished = "未开始";
	            stateTip ="未付款";
	          }
	          else if (orderState == 1) {
	            paid = "已付款";
	            cook = "烹饪中";
	            finished = "未完成";
	            stateTip = "烹饪中";
	          }
	          else if (orderState == 2) {
	            paid = "已付款";
	            cook = "已完成";
	            finished = "已完成";
	            stateTip = "已完成";
	          }
	          
	          $("#paid_div").text(paid);
	          $("#cook_div").text(cook);
	          $("#finished_div").text(finished);
	          $("#stateTip_div").text(stateTip);
	          $("#orderNumber_div").text("订单:"+orderNumber);
	          $("#orderState_inp").val(orderState);

	          $("#orderTime_div").text(result.data.orderTime);
	          
	          var productListDiv=$("#productList_div");
	          var productList=result.data.productList;
	          var length=productList.length;
	          for(var i=0;i<length;i++){
		          productListDiv.append("<div class=\"item_div\">"
	        		  +"<div class=\"productName_div\">"+productList[i].productName+"</div>"
	        		  +"<div class=\"price_div\">"+productList[i].price+"元</div>"
	        		  +"<div class=\"quantity_div\">"+productList[i].quantity+"</div>"
	        		  +"</div>");
	          }
	          $("#ydsp_div").text("已点商品("+length+")");
	          $("#committedTime_div").text("提交订单已:"+result.data.commitTime);

	          let totalMount=0, totalConsume=0;
	          for(var i=0;i<length;i++){
	            totalMount += productList[i].quantity;
	            totalConsume += productList[i].quantity*productList[i].price;
	          }
	          
	          $("#totalMount_span").text(totalMount);
	          $("#totalConsume_div").text(totalConsume+"元");
	        }
		}
	);
	
	/*
	wx.request({
	      url: rootIP+"getOrderDetailsByOrderNumber",
	      method: 'POST',
	      data: { orderNumber: orderNumber, shopId: shopId, token:token},
	      header: {
	        'content-type': 'application/x-www-form-urlencoded',
	      },
	      success: function (res) {
	        console.log(res);
	        var data = res.data;
	        if (data.code == 100){
	          let orderState = data.data.orderState;
	          let paid, cook, finished, stateTip;
	          if(orderState==0){
	            paid = "未付款";
	            cook = "未开始";
	            finished = "未开始";
	            stateTip ="未付款";
	          }
	          else if (orderState == 1) {
	            paid = "已付款";
	            cook = "烹饪中";
	            finished = "未完成";
	            stateTip = "烹饪中";
	          }
	          else if (orderState == 2) {
	            paid = "已付款";
	            cook = "已完成";
	            finished = "已完成";
	            stateTip = "已完成";
	          }
	          orderDetail.setData({
	            orderState: orderState,
	            paid: paid,
	            cook: cook,
	            finished: finished,
	            stateTip: stateTip,
	            orderNumber: orderNumber
	          });

	          orderDetail.setData({
	            orderTime: data.data.orderTime
	          });

	          orderDetail.setData({
	            productList: data.data.productList,
	            productListLength: data.data.productList.length,
	            commitTime: data.data.commitTime
	          });

	          let totalMount=0, totalConsume=0;
	          let length = orderDetail.data.productListLength;
	          let productList=orderDetail.data.productList;
	          for(let i=0;i<length;i++){
	            totalMount += productList[i].quantity;
	            totalConsume += productList[i].quantity*productList[i].price;
	          }

	          orderDetail.setData({
	            totalMount: totalMount,
	            totalConsume: totalConsume
	          });
	        }
	      }
	    })
	    */
}

function tiaoDan(){
	console.log("orderNumber===" + orderNumber);
    if (orderNumber != null & orderNumber!=""){
      location.href=path+"/phone/orderedList/orderedList.jsp?type=tiaodan";
    }
    else{
      alert("尚未初始化下单信息");
    }
}

function cuiDan(){
	if (orderNumber != null & orderNumber != ""){
      //如果商家已接单
      var orderState=$("#orderState_inp").val();
      if (orderState==1){
        var time = getReduceTimePeriod();
        if(time>10){
          orderDetail.cuiDanBtn();
        }
        else{
          alert("美食正在烹饪，请不要频繁催单哦，" + (10 - time) + "分钟后再尝试吧~");
        }
      }
      else{
    	alert("商家尚未接单，无法催单");
      }
    }
    else{
      alert("尚未初始化下单信息");
    }
}

function getReduceTimePeriod(){
   var lastDate = 0;
   var date=new Date();
   var nowDate=date.getTime();
   var periodTime=nowDate-lastDate;
   var minute=periodTime/1000/60;
   return minute;
}

function cuiDanBtn(){
	$.post(path+"/phoneAction_reminderInterface.action",
		{orderNumber: orderNumber},
		function(res){
			console.log(res);
	        var result = res.result;
	        if (result.code == 100) {
	          alert("催单成功");
	        }
	        else{
	          alert("商家未接单");
	        }
		}
	);
	
	/*
	wx.request({
      url: rootIP+"reminderInterface",
      method: 'POST',
      data: { orderNumber: orderNumber},
      header: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      success: function (res) {
        console.log(res);
        var data = res.data;
        if (data.code == 100) {
          wx.showToast({
            title: '催单成功',
            duration:2000
          })
        }
        else{
          wx.showToast({
            title: '商家未接单',
            duration: 2000
          })
        }
      }
    })
    */
}

function goDianCai(){
	location.href=path+"/phoneAction_toDcMain.action?seatName="+seatName;
}
</script>
<title>Insert title here</title>
</head>
<body>
<div class='main_div'>
  <div class='ddxq_div'>
    订单详情
  </div>
  <div class='state_div'>
    <div class='space1_div'></div>
    <input type="hidden" id="orderState_inp"/>
    <div class='state_middle_div'>
      <img class='paid_img' src='<%=path %>/phone/image/005.png'></img>
      <div class="paid_div" id="paid_div">
        {{paid}}
      </div>
      <div class='line1_div'></div>
      <img class='cook_img' src='<%=path %>/phone/image/006.png'></img>
      <div class="cook_div" id="cook_div">
        {{cook}}
      </div>
      <div class='line2_div'></div>
      <img class='finished_img' src='<%=path %>/phone/image/007.png'></img>
      <div class="finished_div" id="finished_div">
        {{finished}}
      </div>
    </div>
    <div class='tishi_div'>
      您点的菜已经告诉后厨!他们正在用心烹制
    </div>
  </div>
  <div class='order_div'>
    <div class="orderNumber_div" id="orderNumber_div">订单:{{orderNumber}}</div>
    <div class="orderTime_div" id="orderTime_div">{{orderTime}}</div>
    <div class="stateTip_div" id="stateTip_div">{{stateTip}}</div>
  </div>
  <div class='ydsp_div' id="ydsp_div">
    已点商品({{productListLength}})
  </div>
  <div class="productList_div" id="productList_div" wx:for-items="{{productList}}">
  	<!-- 
    <div class="item_div">
      <div class="productName_div">{{item.productName}}</div>
      <div class="price_div">{{item.price}}元</div>
      <div class="quantity_div">{{item.quantity}}</div>
    </div>
     -->
  </div>
  <div class='tjdd_div'>
    <div class="committedTime_div" id="committedTime_div">提交订单已:{{commitTime}}</div>
    <div class="totalMount_div" id="totalMount_div">共<span id="totalMount_span"></span>件合计:
      <div class="totalConsume_div" id="totalConsume_div"></div>
    </div>
  </div>
  <!-- 
  <div class='tdcd_div'>
    <div class='cd_div' onclick="cuiDan()">
      <img class='cd_img' src='<%=path %>/phone/image/009.png'></img>
      <div class='cd_text_div'>催单</div>
    </div>
    <div class='td_div' onclick="tiaoDan()">
      <img class='td_img' src='<%=path %>/phone/image/008.png'></img>
      <div class='td_text_div'>调单</div>
    </div>
  </div>
   -->
  <div style='width:100%;height:20px;background-color:#ededed;'></div>
  <div class='space2_div'></div>
  <div class='bottom_div'>
    <div class='but_div'>
      <div class='dc_div' onclick="goDianCai()">
        <div class='dc_img_div'>
          <img class='dc_img' src='<%=path %>/phone/image/010.png'></img>
        </div>
        <div class='dc_text_div'>
          点菜
        </div>
      </div>
      <div class='dd_div'>
        <div class='dd_img_div'>
          <img class='dd_img' src='<%=path %>/phone/image/011.png'></img>
        </div>
        <div class='dd_text_div'>
          订单
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>