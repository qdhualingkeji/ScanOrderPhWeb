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
<link href="<%=path %>/phone/dcMain/css/dcMain.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var path='<%=path %>';
var strJiaCai='${requestScope.jiacai}';
var orderNumber='${sessionScope.orderNumber}';
var foodMount = 0;
var shopId='82';
//var shopId='${sessionScope.shopId}';
var token='${sessionScope.token}';
var goodsListArr=[];
var categoryListLength=0;
$(function(){
	getShopShowInfoById();
	getCategoryList();
	setTimeout("getGoodsListByCategoryId('')","3000");
	setTimeout(function(){
		//alert(goodsListArr);
	},"3000");
});

function getShopShowInfoById(){
	$.post(path+"/phoneAction_getShopShowInfoById.action",
		{shopId: shopId},
		function(res){
			var result=res.result;
			if (result.code == 100){
				$("#logoUrl_img").attr("src",result.data.logoUrl);
				$("#shopName_div").text(result.data.shopName);
				$("#locationAddress_div").text(result.data.locationAddress);
			}
		}
	);
}

function getCategoryList(){
	/*
	wx.request({
	      url: rootIP+"getCategoryList",
	      method: 'POST',
	      data: { shopId: shopId},
	      header: {
	        'content-type': 'application/x-www-form-urlencoded',
	      },
	      success:function(res){
	        var data = res.data;
	        if(data.code==100){
	          let categoryList=data.data;
	          dcMain.setData({
	            categoryList: categoryList
	          });
	          //console.log(dcMain.data.categoryList[0].id);
	          //var categoryId = dcMain.data.categoryList[0].id;
	          let goodsListArr=[];
	          for (let i = 0; i < categoryList.length;i++){
	            wx.request({
	              url: rootIP+"getGoodsListByCategoryId",
	              method: 'POST',
	              data: { categoryId: categoryList[i].id, token: token},
	              header: {
	                'content-type': 'application/x-www-form-urlencoded',
	              },
	              success: function (res) {
	                var data = res.data;
	                if (data.code == 100) {
	                  let goodsList = data.data;
	                  for (let j = 0; j < goodsList.length; j++) {
	                    goodsList[j].quantity = 0;
	                    goodsList[j].display = "none";
	                  }
	                  goodsListArr=goodsListArr.concat(goodsList);
	                  if (i == categoryList.length - 1) {
	                    dcMain.initFoodQuantity(goodsListArr);
	                  }
	                }
	              }
	            })
	          }
	        }
	      },
	      */
	      $.post(path+"/phoneAction_getCategoryList.action",
    		  {shopId: shopId},
    		  function(res){
    			  var result=res.result;
   				  if (result.code == 100){
					var categoryListDiv=$("#categoryList_div");   					  
   					var categoryList=result.data;
   					categoryListLength=categoryList.length;
   					for(var i=0;i<categoryListLength;i++){
   						categoryListDiv.append("<div class=\"item selected\" id=\"category"+categoryList[i].id+"\" onclick=\"getGoodsListByCategoryId(this.id)\">"
   							+categoryList[i].categoryName
   							+"</div>");
   						getGoodsListByCategoryId("category"+categoryList[i].id);
   					}
   					
   		            for (var i = 0; i < categoryList.length;i++){
   		        	  /*
	   		            wx.request({
	   		              url: rootIP+"getGoodsListByCategoryId",
	   		              method: 'POST',
	   		              data: { categoryId: categoryList[i].id, token: token},
	   		              header: {
	   		                'content-type': 'application/x-www-form-urlencoded',
	   		              },
	   		              success: function (res) {
	   		                var data = res.data;
	   		                if (data.code == 100) {
	   		                  let goodsList = data.data;
	   		                  for (var j = 0; j < goodsList.length; j++) {
	   		                    goodsList[j].quantity = 0;
	   		                    goodsList[j].display = "none";
	   		                  }
	   		                  goodsListArr=goodsListArr.concat(goodsList);
	   		                  if (i == categoryList.length - 1) {
	   		                    dcMain.initFoodQuantity(goodsListArr);
	   		                  }
	   		                }
	   		              }
	   		            })
 	   		            */

   		        	  
   		            }
   				  }
    		  }
	      );
}
	
function initFoodQuantity(foodsList){
	if(strJiaCai=="jiacai"){
      for (var i = 0; i < foodsList.length;i++){
        let food=foodsList[i];
        let iter = getApp().getAllSelectedFood();
        for (var j = 0; j < iter.length; j++) {
          if (food.categoryId == iter[j].categoryId & food.id == iter[j].id) {
            food.quantity = iter[j].quantity;
            break;
          }
        }
      }

      dcMain.setData({
        goodsList: foodsList
      });

      getGoodsListByCategoryId("");
      dcMain.calulateMoneyAndAmount();
    }
    else{
      $.post(path+"/phoneAction_getOrderDetailsByOrderNumber.action",
   		  {orderNumber: orderNumber, shopId: shopId, token:token},
   		  function(res){
   			var result=res.result;
		    if (result.code == 100){
		    	var productList = result.data.productList;
	            for (var i = 0; i < foodsList.length; i++){
	              var food = foodsList[i];
	              for (var j = 0; j < productList.length; j++) {
	                let product = productList[j];
	                if ((food.categoryId == product.categoryId) & (food.id == product.id)) {
	                  //food.quantity = product.quantity;
	                  $("#goodsList_div div[id='"+product.id+"'] .count_input").val(product.quantity);
	                  break;
	                }
	              }
	            }
		    }
		    
		    getGoodsListByCategoryId("");
	        calulateMoneyAndAmount();
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
          //console.log(res);
          var data = res.data;
          if (data.code == 100) {
            var productList = data.data.productList;
            for (var i = 0; i < foodsList.length; i++){
              var food = foodsList[i];
              for (var j = 0; j < productList.length; j++) {
                let product = productList[j];
                if ((food.categoryId == product.categoryId) & (food.id == product.id)) {
                  food.quantity = product.quantity;
                  break;
                }
              }
            }

          }

          dcMain.setData({
            goodsList: foodsList
          });

          dcMain.getGoodsListByCategoryId();
          dcMain.calulateMoneyAndAmount();
        }
      })
      */
    }
}
	
function getGoodsListByCategoryId(categoryId){
	if(categoryId==""){
		categoryId = $("#categoryList_div .item").eq(0).attr("id").substring(8);
	}
	else
    	categoryId = categoryId.substring(8);
	var goodsListDiv=$("#goodsList_div");
	goodsListDiv.empty();
    /*
    for (var i = 0; i < goodsListArr.length;i++){
      if (goodsListArr[i].categoryId == categoryId){
    		alert($("#goodsList_div .item[categoryid='"+categoryId+"']").eq(0).css("display"));
    	$("#goodsList_div .item[categoryid='"+categoryId+"']").css("display","block");
        //goodsList[i].display="block";
      }
      else{
      	$("#goodsList_div .item[categoryid='"+categoryId+"']").css("display","none");
        //goodsList[i].display = "none";
      }
    }
    dcMain.setData({
      goodsList: goodsList
    });
    */
    if(goodsListArr[categoryId]==undefined){
       $.ajaxSetup({async:false});
       $.post(path+"/phoneAction_getGoodsListByCategoryId.action",
   		{categoryId: categoryId, token: token},
   		function(res){
			  	  var result=res.result;
				  if (result.code == 100){
					  var goodsList = result.data;
					  var goodsDiv=$("<div></div>");
	                  for (var i = 0; i < goodsList.length; i++) {
	                    //goodsList[j].quantity = 0;
	                    //goodsList[j].display = "none";
	                    
	                	goodsDiv.append("<div class=\"item\" id=\"item"+goodsList[i].id+"\" categoryId=\""+goodsList[i].categoryId+"\" categoryName=\""+goodsList[i].categoryName+"\">"
	                	+"<img class=\"goods_img\" src=\""+goodsList[i].imgUrl+"\" onclick=\"goGoodsdetail('"+goodsList[i].id+"','"+goodsList[i].productName+"','"+goodsList[i].imgUrl+"','"+goodsList[i].monthlySalesVolume+"','"+goodsList[i].price+"','"+goodsList[i].collectState+"','"+goodsList[i].grade+"')\"></img>"
	                	+"<div class=\"productName_div\">"+goodsList[i].productName+"</div>"
		                +"<div class=\"price_div\">￥"+goodsList[i].price+"</div>"
		   		        +"<div class=\"option_div\">"
		   		        +"<img class=\"remove_img\" src=\""+path+"/phone/image/002.png\" ontouchstart=\"removeGood('"+goodsList[i].id+"')\"></img>"
		   		        +"<input class=\"count_input\" value=\"0\"></input>"
		   		        +"<img class=\"add_img\" src=\""+path+"/phone/image/003.png\" ontouchstart=\"addGood('"+goodsList[i].id+"')\"></img>"
		   		        +"</div>"
		   		        +"</div>");
	                	//alert(goodsListDiv.html());
	                  }
	                  
	                  goodsListArr[categoryId]=goodsDiv.html();
	                  /*
	                  goodsListArr=goodsListArr.concat(goodsList);
	                  if (i == categoryList.length - 1) {
	                    initFoodQuantity(goodsListArr);
	                  }
		              */
				  }
				  if($("#categoryList_div .item").length==categoryListLength){
					  initFoodQuantity(goodsListArr);					  
				  }
       	}
       );
    }
    else{
    	goodsListDiv.html(goodsListArr[categoryId]);
    }
}

function goGoodsdetail(id,productName,imgUrl,monthlySalesVolume,price,collectState,grade){
	location.href=path+"/phone/goodDetail/goodDetail.jsp?id="+id+"&productName="+productName+"&imgUrl="+imgUrl+"&monthlySalesVolume="+monthlySalesVolume+"&price="+price+"&collectState="+collectState+"&grade="+grade;
}

function addGood(id){
	var countInp=$("#goodsList_div #item"+id+" .count_input");
	var count=countInp.val();
	countInp.val(++count);
	chooseGood(id,count);
	showModify();
}

function removeGood(id){
	var countInp=$("#goodsList_div #item"+id+" .count_input");
	var count=countInp.val();
	if(count<=0)
		return;
	else
		countInp.val(--count);
	showModify();
}

function chooseGood(id,count){
	var categoryId=$("#goodsList_div #item"+id).attr("categoryId");
	$(goodsListArr[categoryId]).each(function(){
		var goodsId=$(this).attr("id").substring(4);
		if(id==goodsId){
			var html=$(this).html();
			$(this).find("input[class='count_input']").attr("value",count);
			goodsListArr[categoryId]=goodsListArr[categoryId].replace(html,$(this).html());
			//console.log("==="+($(goodsListArr[categoryId]).eq(0).html()==html));
		}
	});
	//console.log(goodsListArr[categoryId]);
}

function showModify(){
	foodMount = 0;
	calulateMoneyAndAmount();
}

function calulateMoneyAndAmount(){
	var mount = 0, price = 0;

	$("#categoryList_div .item").each(function(){
		var categoryId=$(this).attr("id").substring(8);
		var goods=$("#goodsList_div .item[categoryid='"+categoryId+"']");
		$(goods).each(function(i){
			mount += parseInt($(this).find("input[class='count_input']").val());
		    price += $(this).find("div[class='price_div']").text().substring(1)*parseInt($(this).find("input[class='count_input']").val());
		});
	});
	$("#ftm_div").text(mount);
	$("#sum_price_div").text("￥"+price);
}

function quJieSuan(){
	var gsList=[];
	$("#categoryList_div .item").each(function(){
		var categoryId=$(this).attr("id").substring(8);
		var goods=$(goodsListArr[categoryId]);
		$(goods).each(function(){
			var g = { categoryId: "", categoryName: "", id: "", quantity: "", imgUrl: "", price: "", productName:""};
			g.categoryId=categoryId;
			g.categoryName=$(this).attr("categoryName");
		    g.id=$(this).attr("id").substring(4);
		    g.quantity = $(this).find("input[class='count_input']").val();
		    g.imgUrl=$(this).find("img[class='goods_img']").attr("src");
		    g.price=$(this).find("div[class='price_div']").text().substring(1);
		    g.productName=$(this).find("div[class='productName_div']").text();
			//console.log(g);
		    gsList.push(g);
		});
		
	});
	addFoodToList(gsList);
}

function addFoodToList(goodsList){
	checkIfAlreadyExistOrder(goodsList);
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

function goOrder(){
	location.href=path+"/phone/orderDetail/orderDetail.jsp";
}
</script>
<title>Insert title here</title>
</head>
<body style="margin: 0px;">
<div class="main_div">
  <div class="logo_div">
    <img class="logoUrl_img" id="logoUrl_img"></img>
    <div class="shopName_div" id="shopName_div"></div>
    <div class="locationAddress_div" id="locationAddress_div"></div>
  </div>
  <div class="categoryList_div" id="categoryList_div"  wx:for-items="{{categoryList}}">
    <!-- 
    <div class="item selected" id="category{{item.id}}" catchtap='getGoodsListByCategoryId'>
      {{item.categoryName}}
    </div>
     -->
  </div>
    <div class="goodsList_div" id="goodsList_div" wx:for-items="{{goodsList}}">
      <!-- 
      <div class="item" categoryId="{{item.categoryId}}" style='display:{{item.display}};' data-categoryId='{{item.categoryId}}'>
        <img class="goods_img" src="{{item.imgUrl}}" data-index='{{index}}' catchtap='goGoodsdetail'></img>
        <div class="productName_div">{{item.productName}}</div>
        <div class="price_div">￥{{item.price}}</div>
        <div class="option_div">
          <img class="remove_img" src="<%=path %>/phone/image/002.png" data-index='{{index}}' catchtap='removeGood'></img>
          <input class="count_input" value='{{item.quantity}}'></input>
          <img class="add_img" src="<%=path %>/phone/image/003.png" data-index='{{index}}' catchtap='addGood'></img>
        </div>
      </div>
       -->
    </div>
  <div class='space_div'></div>
  <div class='bottom_div'>
    <img class="gwc_img" src="<%=path %>/phone/image/004.png"></img>
    <div class="ftm_div" id="ftm_div">
    </div>
    <div class='qjs_div' onclick="quJieSuan()">
    去结算
    </div>
    <div class="sum_price_div" id="sum_price_div">
    </div>
  </div>
  <div class='bottom2_div'>
    <div class='but_div'>
      <div class='dc_div'>
        <div class='dc_img_div'>
          <img class='dc_img' src="<%=path %>/phone/image/022.png"></img>
        </div>
        <div class='dc_text_div'>
          点菜
        </div>
      </div>
      <div class='dd_div' onclick="goOrder()">
        <div class='dd_img_div'>
          <img class='dd_img' src="<%=path %>/phone/image/023.png"></img>
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