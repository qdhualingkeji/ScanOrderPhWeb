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
    
    <title>��������ҳ��</title>
    
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
	//logo��ת����
function logoJump()
	{
		window.location="<%=path%>/";

	}
	</script>
  </head>
  
<body>
	 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:logoJump();"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" title="����ҽ��ƽ̨" /></a>
            </div>
            <div class="topLink right addrtitle"></div>
     </div> 
    <h1></h1>
    <p class="link">
        ����
        <a href="javascript:history.go(-1);">&#9666;��һҳ</a>|
        ȥ
        <a href="javascript:logoJump()">&#9666;��ҳ</a>

    </p>
    <dl class="texts">
        <dt>��ī����ҽ��ƽ̨����ע�����</dt>
<dd>
            <ul>
                <li>��Ҫͨ����ǰ�û�ȥ���������û�ҳ�棡</li>
                <li>��Ҫ�����޸�URL��ַ��</li>
                <li>��Ҫ���⹥����վ��</li>
                <li>������һ��û�ù��ӳԣ�</li>
            </ul>
        </dd>
    </dl>

    </span></span></span></p>
    <!--footer-->
<div class="wd txt_center" style="width: 100%;margin: 10px auto;text-align: center;position: relative;border-top: solid;border-color: #4a74b5;border-top-width: 1px;">
    <div class="navPageBottom" style="margin-top: 10px;">������ī</div>
    <div class="copyright addrtitle" style="padding-top:4px;">
        &copy; 2011 - 2016
    </div>
</div>
</body>
</html>
