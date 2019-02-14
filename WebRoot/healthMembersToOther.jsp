<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>访问限制页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path %>/web/css/accessRestrictions.css" type="text/css"></link>
	<!--[if lte IE 8]>
	<style type="text/css">
	h2 em{color:#e4ebf8;}
	</style>
	<![endif]-->
	<script type="text/javascript">
	//logo跳转方法
function logoJump(userid)
	{
		alert(userid);
	if(userid=="1")
	{
		window.location="<%=path%>/web/healthMembers/personalCenter/update.jsp?navi=4&userType=1";
	}
	if(userid=="3")
	{
		window.location="<%=path%>/web/hospital/update.jsp?userType="+userid+"&navi=4";
	}
	if(userid=="4")
	{
		window.location="<%=path%>/web/sumict/hospitalAudit.jsp?userType=4&navi=2&hospital=&pageNoc=1";
	}
	if(userid=="2")
	{
		window.location="<%=path%>/web/doctor/treatment/list.jsp?userType="+userid+"&navi=4";
	}
		
	}
	
function cancellation(){
	if(confirm("确定要注销吗?")){
		window.location.href="<%=path%>/LoginAction_cancellation.do?userType=${param.userType}";
	}
}
	</script>
  </head>
  
<body>
	 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:logoJump('${param.userType}');"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" title="社区医疗平台" /></a>
            </div>
            <div class="topLink right addrtitle"></div>
     </div> 
    <h1></h1>
    <p class="link">
        返回
        <a href="javascript:history.go(-1);">&#9666;上一页</a>|
        去
        <c:if test="${param.userType eq 1}">
			健康会员
		</c:if>
		<c:if test="${param.userType eq 2}">
			医院管理
		</c:if>
		<c:if test="${param.userType eq 4}">
			三墨后台
		</c:if>
        <a href="javascript:logoJump('${param.userType}')">&#9666;首页</a>
        |
        <a href="javascript:cancellation();">&#9666;注销</a>
		<c:if test="${param.userType eq 1}">
			健康会员
		</c:if>
		<c:if test="${param.userType eq 2}">
			医院管理
		</c:if>
		<c:if test="${param.userType eq 4}">
			三墨后台
		</c:if>用其他用户登录！
    </p>
    <dl class="texts">
        <dt>三墨社区医疗平台访问注意事项：</dt>
<dd>
            <ul>
                <li>不要通过当前用户去访问其他用户页面！</li>
                <li>不要擅自修改URL地址！</li>
                <li>不要恶意攻击本站！</li>
                <li>否则您一定没好果子吃！</li>
            </ul>
        </dd>
    </dl>

    </span></span></span></p>
    <!--footer-->
<div class="wd txt_center" style="width: 100%;margin: 10px auto;text-align: center;position: relative;border-top: solid;border-color: #4a74b5;border-top-width: 1px;">
    <div class="navPageBottom" style="margin-top: 10px;">关于三墨</div>
    <div class="copyright addrtitle" style="padding-top:4px;">
        &copy; 2011 - 2016
    </div>
</div>
</body>
</html>
