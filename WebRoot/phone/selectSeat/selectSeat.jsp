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
<meta content="telephone=no" name="format-detection" />
<link href="<%=path %>/phone/selectSeat/css/selectSeat.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/phone/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
var path='<%=path %>';
$(function(){
	getShopSeatInfoById();
});

function getShopSeatInfoById(){
	var shopId=82;
	$.post(
		"phoneAction_getShopSeatInfoById.action",
		{shopId: shopId},
		function (res) {
			var seatListDiv=$("#seatList_div");
			var result=res.result;
			if (result.code == 100) {
				var seatList=result.data;
				for(var i=0;i<seatList.length;i++){
					seatListDiv.append("<div style=\"width:21%;height:40px;line-height:40px;margin-top:1%;margin-left:1%;text-align:center;float:left;border:#999 solid 1px;\" onclick=\"toDcMain('"+seatList[i].seatName+"')\">"
					+seatList[i].seatName
					+"</div>");
				}
			}
		}
	,"json");
}

function toDcMain(seatName){
	location.href=path+"/phoneAction_toDcMain.action?seatName="+seatName;
}
</script>
<title>选择桌号</title>
</head>
<body>
<div style='width:100%;'>
  <div style='width:100%;height:40px;line-height:40px;text-align:center;'>请选择桌号</div>
  <div id="seatList_div" style="width:100%;">
    
  </div>
  <!--
  <button  open-type="getUserInfo" catchtap='getUserInfo'>getUserInfo</button>
  <button open-type="getPhoneNumber" bindgetphonenumber="getPhoneNumber">获取手机号</button>
  <button catchtap='wxlogin'>登录</button>
  -->
</div>
</body>
</html>