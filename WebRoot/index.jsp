<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>ҽ������ƽ̨</title>
<link rel="stylesheet" href="<%=path%>/web/css/hospitalReg.css" type="text/css"></link>
<link href="<%=path %>/web/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>  

 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:jump('${param.userid}');"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" style="border:none;background:transparent none repeat scroll 0% 0%"  title="����ҽ��ƽ̨" /></a>
            </div>
            <div class="topLink right addrtitle"></div>
     </div> 
  <div class="container" id="container">
    <div class="index-banner">
      <div class="index_banner_cont">
        <div class="index_banner_scroll">
          <div> <img src="<%=path %>/web/images/2013080315151043.jpg" width="1900" height="421" alt="Banner001" /> </div>
          <div> <img src="<%=path %>/web/images/2013080315152056.jpg" width="1900" height="421" alt="Banner002" /> </div>
          <div> <img src="<%=path %>/web/images/2013080315153420.jpg" width="1900" height="421" alt="Banner003" /> </div>
        </div>
      </div>
      <div class="banner_btn">
        <div class="banner_list">
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div class="banner_span">
            <a href="javascript:void(0)"><img src="<%=path %>/web/images/2013072519022574.jpg" width="49" height="42" alt="" /></a>
            <a href="javascript:void(0)"><img src="<%=path %>/web/images/2013072519024313.jpg" width="49" height="42" alt="" /></a>
            <a href="javascript:void(0)"><img src="<%=path %>/web/images/2013072519025292.jpg" width="49" height="42" alt="" /></a>
        </div>
      </div>
      
      <div class="index-btn browser">
          <span class="btn1" title="������Ա���">������Ա</span>
          <span class="btn2" title="����ҽ�����">����ҽ��</span>
          <span class="btn3" title="ҽԺ�������">ҽԺ����</span>
          <span class="btn4" title="��ī��Ϣ">������ī</span>
      </div>
      
      <div class="index_menu">
        <div class="index_menu_item menuItem1"><a href="<%=path%>/web/index/login.jsp?userid=1"><img src="<%=path %>/web/images/menu_pic1.jpg" width="258" height="112" alt="������Ա��¼/ע�����" style="border:none;background:transparent none repeat scroll 0% 0%"/></a>
          <div class="clearfix">
            ������Ա��ڣ����ã��װ��Ľ�����Ա������Ե������ڽ���ע��͵�¼�������ע������ɵ�¼�������ľ���������Լ�һϵ�еĽ�����Ϣ�ͽ��������������Ľ�������ָ�ơ�
          </div>
        </div>
        <div class="index_menu_item menuItem2"><a href="<%=path%>/web/index/login.jsp?userid=2"><img src="<%=path %>/web/images/menu_pic2.jpg" width="258" height="112" alt="����ҽ����¼���" style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
             ����ҽ����ڣ�ҽ����ã�Ϊ�˷���������ϣ������ԴӴ���ڵ�¼�Ժ�Ի�Ա���о���͹����Լ���������Ϣ��
          </div>
        </div>
        <div class="index_menu_item menuItem3"><a href="<%=path%>/web/index/login.jsp?userid=3"><img src="<%=path %>/web/images/menu_pic3.jpg" width="258" height="112" alt="ҽԺ�����¼/ע�����" style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
			ҽԺ������ڣ��𾴵�ҽԺ������Ա��ʹ�ñ�ϵͳ���������ɵĶ�ҽԺ�Ĳ��񣬿�棬Ա������ͳһ������ʵʱ�˽�ҽԺ�Ķ�̬��Ϣ������ҽԺ�Ը�����Ĺ���Ͳ�����
          </div>
        </div>
        <div class="index_menu_item menuItem4"><a href="<%=path%>/web/index/login.jsp?userid=4"><img src="<%=path %>/web/images/menu_pic4.jpg" width="258" height="112" alt="������ī"  style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
         	 ������ī����ī��Ϣ�������޹�˾�����о����ĸ��¼�����ҵ����˾��ʼ��ԭΪ�ܲ�ĳ���߼������˲ţ�������¾��¼�˸��¼����з����ϻﴴʼ�˾��ж���һ���з����飬���к�����ѧ��֪����Ϣ������˾��ҵ��������Ϊ֪����У��Ϣ����רҵ��ʿ��˶ʿѧ����
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript" src="<%=path%>/web/js/jquery-1.8.1.min.js"></script> 
<script type="text/javascript" src="<%=path%>/web/js/banner.js"></script> 
<!--footer-->
<div class="wd txt_center" style="width: 100%;margin: 10px auto;text-align: center;position: relative;border-top: solid;border-color: #4a74b5;border-top-width: 1px;">
    <div class="navPageBottom" style="margin-top: 10px;">������ī</div>
    <div class="copyright addrtitle" style="padding-top:4px;">
        &copy; 2011 - 2016
    </div>
</div>
</body>
</html>