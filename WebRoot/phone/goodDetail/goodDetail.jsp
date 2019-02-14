<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String productName=request.getParameter("productName");
	productName=new String(productName.getBytes("ISO-8859-1"),"UTF-8");
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
var num = 1;
var token='${sessionScope.token}';

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
    updateTotalPriceAndNumber(1);
}

function updateTotalPriceAndNumber(amount){
	var price='${param.price}';
	$("#foodAmount_div").text(amount);
	$("#totalPrice_div").text(price * amount);
	$("#zongjia_div").text(price * amount);
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
	var collectState = '${param.collectState}';
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
   	          goodDetail.data.good.collectState=0;
   	          shoucangImgUrl=path+"/phone/image/014.jpg";
   	          $("#sciu_div").attr("src",shoucangImgUrl);
   	          alert("已取消收藏");
   	        }
   	        else if (data.code == 100 & good.collectState == 0) {
   	          goodDetail.data.good.collectState = 1;
   	          shoucangImgUrl=path+"/phone/image/020.png";
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
	
}
</script>
<title>Insert title here</title>
</head>
<body>
<div class='main_div'>
  <div class='title_div'>
    <%=productName %>
  </div>
  <img class='imgUrl_img' src='${param.imgUrl}' style='width:100%;height:200px;'/>
  <div class='name_sc_div' style='width:100%;height:50px;line-height:50px;'>
    <div class='productName_div' style='margin-left:20px;color:#333;'><%=productName %></div>
    <div class='shoucang_div' style='float:right;margin-top:-50px;margin-right:20px;color:#747474;'>收藏</div>
    <img class="sciu_div" id="sciu_div" src="" onclick="shouCang()" style='width:20px;height:20px;float:right;margin-top:-35px;margin-right:65px;'/>
  </div>
  <div class='zhpf_msv_div' style='width:100%;height:50px;line-height:50px;'>
    <div class='zhpf_div' style='width:85px;margin-left:20px;color:#777;'>综合评分:</div>
    <img class="xx_img" id="xxa_img" src="" style='width:20px;height:20px;margin-top:-35px;margin-left:110px;position:absolute;'/>
    <img class="xx_img" id="xxb_img" src="" style='width:20px;height:20px;margin-top:-35px;margin-left:135px;position:absolute;'/>
    <img class="xx_img" id="xxc_img" src="" style='width:20px;height:20px;margin-top:-35px;margin-left:160px;position:absolute;'/>
    <img class="xx_img" id="xxd_img" src="" style='width:20px;height:20px;margin-top:-35px;margin-left:185px;position:absolute;'/>
    <img class="xx_img" id="xxe_img" src="" style='width:20px;height:20px;margin-top:-35px;margin-left:210px;position:absolute;'/>
    <div class="msv_div" style='width:120px;height:50px;line-height:50px;margin-top:-50px;margin-left:250px;color:#818181;position:absolute;'>
      月销量${param.monthlySalesVolume}份
    </div>
  </div>
  <div class='price_opt_div' style='width:100%;height:50px;line-height:50px;'>
    <div class='price_div' style='width:85px;margin-left:20px;color:#d75571;'>
      ${param.price}元
    </div>
    <div class='option_div'>
      <img class='jian_img' src='<%=path %>/phone/image/017.png' data-index='{{index}}' onclick="jianGood()"></img>
      <input class="sum_input" id="sum_input" value='{{sum}}'></input>
      <img class='add_img' src='<%=path %>/phone/image/018.png' data-index='{{index}}' onclick="addGood()"></img>
    </div>
  </div>
  <div class='tclb_div'>
    <div class='tclb_text_div'>套餐列表</div>
  </div>
  <div class='price_zj_div'>
    <div class='price_div'>套餐价:${param.price}</div>
    <div class="zongjia_div" id="zongjia_div">总价:{{zongjia}}</div>
  </div>
  <div class='spjj_div'>
    <div class='spjj_text_div'>商品简介</div>
  </div>
  <div style='width:100%;'>
  </div>
  <div style='width:100%;height:40px;'>
  </div>
  <div class='space_div'>
  </div>
  <div class='bottom_div'>
    <img class='yidian_img' src='<%=path %>/phone/image/019.png'></img>
    <div class="foodAmount_div" id="foodAmount_div">
      {{foodAmount}}
    </div>
    <div class='vs_div'></div>
    <div class='yd_tp_div'>
      <div class='yidian_div'>
        已点
      </div>
      <div class="totalPrice_div" id="totalPrice_div">
        {{totalPrice}}
      </div>
    </div>
    <div class='jrddlb_div' onclick="addFoodToList()">
      加入订单列表
    </div>
  </div>
</div>
</body>
</html>