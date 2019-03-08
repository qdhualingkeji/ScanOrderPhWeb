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
<link href="<%=path %>/phone/goodDetail/css/goodDetail.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var path='<%=path %>';
var num = '${param.quantity}'==0?1:'${param.quantity}';
var shopId='${sessionScope.shopId}';
var token='${sessionScope.token}';
var good={id:'${param.id}',productName:'${param.productName}',imgUrl:'${param.imgUrl}',monthlySalesVolume:'${param.monthlySalesVolume}',
		price:'${param.price}',collectState:'${param.collectState}',grade:'${param.grade}',categoryId:'${param.categoryId}',categoryName:'${param.categoryName}'};

$(function(){
	$("#sum_input").val(num);
	refreshUI();
	setStarNumber();
});

function refreshUI(){
	var collectState = '${param.collectState}';
    var shoucangImgUrl;
    if (collectState==1){
      shoucangImgUrl=path+"/phone/image/020.png";
    }
    else{
      shoucangImgUrl=path+"/phone/image/014.jpg";
    }
    $("#sciu_div").attr("src",shoucangImgUrl);
    updateTotalPriceAndNumber(num);
}

function updateTotalPriceAndNumber(amount){
	var price='${param.price}';
	$("#foodAmount_div").text(amount);
	$("#totalPrice_div").text(price * amount);
	$("#zongjia_div").html("总价:"+price * amount);
    //goodDetail.data.good.quantity=num;
}

function setStarNumber(){
	var grade='${param.grade}';
    var xxaImgUrl, xxbImgUrl, xxcImgUrl, xxdImgUrl, xxeImgUrl;
    if (grade==0){
      xxaImgUrl = path+"/phone/image/015.png";
      xxbImgUrl = path+"/phone/image/015.png";
      xxcImgUrl = path+"/phone/image/015.png";
      xxdImgUrl = path+"/phone/image/015.png";
      xxeImgUrl = path+"/phone/image/015.png";
    }
    else if (grade == 1) {
      xxaImgUrl = path+"/phone/image/016.png";
      xxbImgUrl = path+"/phone/image/015.png";
      xxcImgUrl = path+"/phone/image/015.png";
      xxdImgUrl = path+"/phone/image/015.png";
      xxeImgUrl = path+"/phone/image/015.png";
    }
    else if (grade == 2) {
      xxaImgUrl = path+"/phone/image/016.png";
      xxbImgUrl = path+"/phone/image/016.png";
      xxcImgUrl = path+"/phone/image/015.png";
      xxdImgUrl = path+"/phone/image/015.png";
      xxeImgUrl = path+"/phone/image/015.png";
    }
    else if (grade == 3) {
      xxaImgUrl = path+"/phone/image/016.png";
      xxbImgUrl = path+"/phone/image/016.png";
      xxcImgUrl = path+"/phone/image/016.png";
      xxdImgUrl = path+"/phone/image/015.png";
      xxeImgUrl = path+"/phone/image/015.png";
    }
    else if (grade == 4) {
      xxaImgUrl = path+"/phone/image/016.png";
      xxbImgUrl = path+"/phone/image/016.png";
      xxcImgUrl = path+"/phone/image/016.png";
      xxdImgUrl = path+"/phone/image/016.png";
      xxeImgUrl = path+"/phone/image/015.png";
    }
    else if (grade == 5) {
      xxaImgUrl = path+"/phone/image/016.png";
      xxbImgUrl = path+"/phone/image/016.png";
      xxcImgUrl = path+"/phone/image/016.png";
      xxdImgUrl = path+"/phone/image/016.png";
      xxeImgUrl = path+"/phone/image/016.png";
    }
    $("#xxa_img").attr("src",xxaImgUrl);
    $("#xxb_img").attr("src",xxbImgUrl);
    $("#xxc_img").attr("src",xxcImgUrl);
    $("#xxd_img").attr("src",xxdImgUrl);
    $("#xxe_img").attr("src",xxeImgUrl);
}

function shouCang(){
	var collectState = good.collectState;
    if(collectState==1){
      postIsCollect(0);
    }
    else{
      postIsCollect(1);
    }
}

function postIsCollect(isCollect){
    var productId = '${param.id}';
    $.post(path+"/phoneAction_addToWishListById.action",
   		{token: token, productId: productId, state: isCollect},
   		function(res){
   			var result = res.result;
   			var shoucangImgUrl;
   	        if (result.code == 100 & good.collectState==1) {
   	          good.collectState=0;
   	          shoucangImgUrl=path+"/phone/image/014.jpg";
   	          $("#sciu_div").attr("src",shoucangImgUrl);
   	          alert("已取消收藏");
   	        }
   	        else if (result.code == 100 & good.collectState == 0) {
   	          good.collectState = 1;
   	          shoucangImgUrl=path+"/phone/image/020.png";
   	          $("#sciu_div").attr("src",shoucangImgUrl);
   	       	  alert("已收藏");
   	        }
   		}
 	);
    /*
    wx.request({
      url: rootIP+"addToWishListById",
      method: 'POST',
      data: { token: token, productId: productId, state: isCollect},
      header: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      success: function (res) {
        var data = res.data;
        //console.log(data);
        if (data.code == 100 & good.collectState==1) {
          goodDetail.data.good.collectState=0;
          goodDetail.setData({
            shoucangImgUrl:"/image/014.jpg"
          });
          wx.showToast({
            title: '已取消收藏',
            duration:2000
          })
        }
        else if (data.code == 100 & good.collectState == 0) {
          goodDetail.data.good.collectState = 1;
          goodDetail.setData({
            shoucangImgUrl: "/image/020.png"
          });
          wx.showToast({
            title: '已收藏',
            duration: 2000
          })
        }
      }
    })
    */
}

function addGood(){
	num++;
	$("#sum_input").val(num);
    updateTotalPriceAndNumber(num);
}

function jianGood(){
	//最低数量是1
    if (num <= 1){
      alert("不能再少啦！");
      return;
    }
    num--;
    $("#sum_input").val(num);
    updateTotalPriceAndNumber(num);
}

function addFoodToList(){
	var gsList=[];
	var categoryId=good.categoryId;
	var categoryName=good.categoryName;
	var id=good.id;////这个id就是产品id，productId没有用
	var quantity=parseInt($("#sum_input").val());
	var imgUrl=good.imgUrl;
	var price=good.price;
	var productName=good.productName;
	var b={categoryId:categoryId,categoryName:categoryName,id:id,quantity:quantity,imgUrl:imgUrl,price:price,productName:productName};
	gsList.push(b);
	checkIfAlreadyExistOrder(gsList);
}

function checkIfAlreadyExistOrder(gsList){
	
	$.post(path+"/phoneAction_checkIfAlreadyExistOrder.action",
		{shopId: shopId, token:token},
		function(res){
		  var result=res.result;
		  //console.log(result.code);
		  if (result.code == 100){
			nextAction(gsList,"xiadan");
		  }
		  else{
			nextAction(gsList,"tiaodan");
		  }
		}
	);
}

function nextAction(gsList, type){
	//console.log(JSON.stringify(gsList));
	var gsStr=JSON.stringify(gsList);
	var re = new RegExp("\"","g"); 
	//console.log("==="+gsStr.replace(re,"'"));
	gsStr=gsStr.replace(re,"\\\"");
	$.post(path+"/phoneAction_nextAction.action",
		{goodsJAStr:gsStr},
		function(res){
			var result=res.result;
			if(result==1)
				location.href=path+"/phoneAction_toOrderedList.action?type="+type;
		}
	);
}
</script>
<title>菜品详情</title>
</head>
<body style="margin: 0px;">
<div class="main_div">
  <div class="title_div">
    ${param.productName}
  </div>
  <div class="back_div" onclick="history.go(-1);">返回</div>
  <img class="imgUrl_img" src="${param.imgUrl}"/>
  <div class="name_sc_div">
    <div class="productName_div">${param.productName}</div>
    <div class="shoucang_div">收藏</div>
    <img class="sciu_div" id="sciu_div" src="" onclick="shouCang()"/>
  </div>
  <div class="zhpf_msv_div">
    <div class="zhpf_div">综合评分:</div>
    <img class="xx_img xxa" id="xxa_img" src="" />
    <img class="xx_img xxb" id="xxb_img" src="" />
    <img class="xx_img xxc" id="xxc_img" src="" />
    <img class="xx_img xxd" id="xxd_img" src="" />
    <img class="xx_img xxe" id="xxe_img" src="" />
    <div class="msv_div">
      月销量${param.monthlySalesVolume}份
    </div>
  </div>
  <div class="price_opt_div">
    <div class="price_div">
      ${param.price}元
    </div>
    <div class="option_div">
      <img class="jian_img" src="<%=path %>/phone/image/017.png" onclick="jianGood()"></img>
      <input class="sum_input" id="sum_input" value='{{sum}}'></input>
      <img class="add_img" src="<%=path %>/phone/image/018.png" onclick="addGood()"></img>
    </div>
  </div>
  <div class="tclb_div">
    <div class="tclb_text_div">套餐列表</div>
  </div>
  <div class="price_zj_div">
    <div class="price_div">套餐价:${param.price}</div>
    <div class="zongjia_div" id="zongjia_div">总价:{{zongjia}}</div>
  </div>
  <div class="spjj_div">
    <div class="spjj_text_div">商品简介</div>
  </div>
  <div style="width:100%;">
  </div>
  <div style="width:100%;height:40px;">
  </div>
  <div class="space_div">
  </div>
  <div class="bottom_div">
    <img class="yidian_img" src="<%=path %>/phone/image/019.png"></img>
    <div class="foodAmount_div" id="foodAmount_div">
      {{foodAmount}}
    </div>
    <div class="vs_div"></div>
    <div class="yd_tp_div">
      <div class="yidian_div">
        已点
      </div>
      <div class="totalPrice_div" id="totalPrice_div">
        {{totalPrice}}
      </div>
    </div>
    <div class="jrddlb_div" onclick="addFoodToList()">
      加入订单列表
    </div>
  </div>
</div>
</body>
</html>