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
function logoJump()
	{
		window.location="<%=path%>/";

	}
	</script>
  </head>
  
<body>
	 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:logoJump();"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" title="社区医疗平台" /></a>
            </div>
            <div class="topLink right addrtitle"></div>
     </div> 
    <h1></h1>
    <p class="link">
        返回
        <a href="javascript:history.go(-1);">&#9666;上一页</a>|
        去
        <a href="javascript:logoJump()">&#9666;首页</a>

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
