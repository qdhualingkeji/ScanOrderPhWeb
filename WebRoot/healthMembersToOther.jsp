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
	if(confirm("ȷ��Ҫע����?")){
		window.location.href="<%=path%>/LoginAction_cancellation.do?userType=${param.userType}";
	}
}
	</script>
  </head>
  
<body>
	 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:logoJump('${param.userType}');"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" title="����ҽ��ƽ̨" /></a>
            </div>
            <div class="topLink right addrtitle"></div>
     </div> 
    <h1></h1>
    <p class="link">
        ����
        <a href="javascript:history.go(-1);">&#9666;��һҳ</a>|
        ȥ
        <c:if test="${param.userType eq 1}">
			������Ա
		</c:if>
		<c:if test="${param.userType eq 2}">
			ҽԺ����
		</c:if>
		<c:if test="${param.userType eq 4}">
			��ī��̨
		</c:if>
        <a href="javascript:logoJump('${param.userType}')">&#9666;��ҳ</a>
        |
        <a href="javascript:cancellation();">&#9666;ע��</a>
		<c:if test="${param.userType eq 1}">
			������Ա
		</c:if>
		<c:if test="${param.userType eq 2}">
			ҽԺ����
		</c:if>
		<c:if test="${param.userType eq 4}">
			��ī��̨
		</c:if>�������û���¼��
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
