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
<link href="<%=path %>/phone/orderedList/css/orderedList.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var foodMount=0;
var type;
var path='<%=path %>';
var type='${requestScope.type}';
//var shopId='82';
var shopId='${sessionScope.shopId}';
var orderNumber='${sessionScope.orderNumber}';
var token;
$(function(){
	getOrderDetailsByOrderNumber();
});

function getOrderDetailsByOrderNumber(){
	$.post("phoneAction_getOrderDetailsByOrderNumberOL.action",
		{orderNumber: orderNumber, shopId: shopId, token:token},
		function(result){
	        //let productList=[];
	        console.log(result);
		    if (result.code == 100){
		    	var productListDiv=$("#productList_div");
		    	var productList=result.data.productList;
		    	for(var i=0;i<productList.length;i++){
		    		if(i==0){
		    			productListDiv.append("<div class=\"categoryName_div\">"
		    					+"<span class=\"categoryName_span\">"
		    			        +productList[i].categoryName
		    			        +"</span>"
		    			        +"</div>");
		    		}
		    		else if(productList[i].categoryId!=productList[i-1].categoryId){
		    			productListDiv.append("<div class=\"categoryName_div\">"
		    					+"<span class=\"categoryName_span\">"
		    			        +productList[i].categoryName
		    			        +"</span>"
		    			        +"</div>");
		    		}
		    		productListDiv.append("<div class=\"item_div\" id=\"item"+productList[i].id+"\">"
		    			      +"<img class=\"imgUrl_img\" src=\""+productList[i].imgUrl+"\"></img>"
		    			      +"<div class=\"productName_div\">"+productList[i].productName+"</div>"
		    			      +"<div class=\"price_div\">"+productList[i].price+"元</div>"
		    			      +"<div class=\"option_div\">"
		    			        +"<img class=\"reduce_img\" src=\""+path+"/phone/image/012.png\" ontouchstart=\"reduceProduct("+productList[i].id+")\"></img>"
		    			        +"<input class=\"quantity_input\" value=\""+productList[i].quantity+"\"></input>"
		    			        +"<img class=\"plus_img\" src=\""+path+"/phone/image/013.png\" ontouchstart=\"plusProduct("+productList[i].id+")\"></img>"
		    			        +"<div class=\"delete_div\" ontouchstart=\"deleteProduct("+productList[i].id+")\">移除</div>"
		    			      +"</div>"
		    			    +"</div>");
		    	}
		    }
		    calulateMoneyAndAmount();
		}
	);
}

function reduceProduct(id){
	var input=$("#productList_div #item"+id).find("input[class^='quantity_input']");
	var quantity=input.val();
	if (quantity<=1)
      return
    else{
		input.val(--quantity);
		$.post("phoneAction_reduceProduct.action",
			{id:id,quantity:quantity},
			function(res){
				console.log("res==="+res);
				if(res.result==1){
					showModify();
				}
			}
		);
    }
}

function plusProduct(id){
	var input=$("#productList_div #item"+id).find("input[class^='quantity_input']");
	var quantity=input.val();
	input.val(++quantity);
	$.post("phoneAction_plusProduct.action",
		{id:id,quantity:quantity},
		function(res){
			console.log(res);
			if(res.result==1){
				showModify();
			}
		}
	);
}

function deleteProduct(id){
	console.log("id==="+id);
	$("#productList_div div[id='item"+id+"']").remove();
	$.post("phoneAction_deleteProduct.action",
		{id:id},
		function(res){
			console.log(res);
			if(res.result==1){
				showModify();
			}
		}
	);
}

function showModify(){
	foodMount=0;
	var productItems=$("#productList_div .item_div");
    for (var i = 0; i < productItems.length; i++) {
      foodMount += productItems.eq(i).find("input[class='quantity_input']").val();
    }
    calulateMoneyAndAmount();
}

function calulateMoneyAndAmount(){
	var mount = 0, price=0;
	var productItems=$("#productList_div .item_div");
    var length=productItems.length;
    for(var i=0;i<length;i++){
      mount+=parseInt(productItems.eq(i).find("input[class='quantity_input']").val());
  	  //console.log("mount==="+mount);
      var priceText=productItems.eq(i).find("div[class='price_div']").text();
      priceText=priceText.substring(0,priceText.length-1)
      price+=priceText*productItems.eq(i).find("input[class='quantity_input']").val();
    }
    $("#foodTypeMount_div").text(mount+"份");
    $("#foodMoney_div").text("共"+price+"元");
    foodMount = mount;
}

function jiaCai(){
	location.href='<%=path%>'+"/phone/dcMain/dcMain.jsp?jiacai=jiacai";
}

function confirm(){
	if (foodMount <= 0){
      alert("食品数量不符合要求");
    }
    else{
    	location.href='<%=path%>'+"/phone/comfirmOrder/comfirmOrder.jsp?type="+type;
    }
}
</script>
<title>已点列表</title>
</head>
<body style="margin: 0px;background-color: #f0f0f2;">
<div class='main_div'>
  <div class='ydlb_div'>
    已点列表
  </div>
  <div class="productList_div" id="productList_div">
  </div>
  <div class="space_div"></div>
  <div class="bottom_div">
    <div class="jiaCai_div" onclick="jiaCai()">
      加菜
    </div>
    <div class="moneyAndAmount_div">
      <div class="foodTypeMount_div" id="foodTypeMount_div"></div>
      <div class="foodMoney_div" id="foodMoney_div"></div>
    </div>
    <div class='confirm_div' onclick="confirm()">
      确认
    </div>
  </div>
</div>
</body>
</html>