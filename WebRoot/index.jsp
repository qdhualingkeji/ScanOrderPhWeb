<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>医疗社区平台</title>
<link rel="stylesheet" href="<%=path%>/web/css/hospitalReg.css" type="text/css"></link>
<link href="<%=path %>/web/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>  

 <div style="height:46px; margin-top: 20px;border-bottom: solid;border-color: #4a74b5;border-bottom-width: 1px;" id="topDataTd">
        	<div style="float: left;margin-left: 100px;">
            	<a href="javaScript:jump('${param.userid}');"><img src="<%=path %>/web/images/logo.png" class="qqmaillogo" style="border:none;background:transparent none repeat scroll 0% 0%"  title="社区医疗平台" /></a>
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
          <span class="btn1" title="健康会员入口">健康会员</span>
          <span class="btn2" title="社区医生入口">社区医生</span>
          <span class="btn3" title="医院管理入口">医院管理</span>
          <span class="btn4" title="三墨信息">关于三墨</span>
      </div>
      
      <div class="index_menu">
        <div class="index_menu_item menuItem1"><a href="<%=path%>/web/index/login.jsp?userid=1"><img src="<%=path %>/web/images/menu_pic1.jpg" width="258" height="112" alt="健康会员登录/注册入口" style="border:none;background:transparent none repeat scroll 0% 0%"/></a>
          <div class="clearfix">
            健康会员入口：您好！亲爱的健康会员，你可以点击此入口进行注册和登录，在完成注册后您可登录管理您的就诊情况，以及一系列的健康信息和健康档案，对您的健康了如指掌。
          </div>
        </div>
        <div class="index_menu_item menuItem2"><a href="<%=path%>/web/index/login.jsp?userid=2"><img src="<%=path %>/web/images/menu_pic2.jpg" width="258" height="112" alt="社区医生登录入口" style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
             社区医生入口：医生你好，为了方便您的诊断，您可以从此入口登录以后对会员进行就诊和管理自己的资料信息。
          </div>
        </div>
        <div class="index_menu_item menuItem3"><a href="<%=path%>/web/index/login.jsp?userid=3"><img src="<%=path %>/web/images/menu_pic3.jpg" width="258" height="112" alt="医院管理登录/注册入口" style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
			医院管理入口：尊敬的医院管理人员，使用本系统您可以轻松的对医院的财务，库存，员工进行统一化管理实时了解医院的动态信息，方便医院对各方面的管理和操作。
          </div>
        </div>
        <div class="index_menu_item menuItem4"><a href="<%=path%>/web/index/login.jsp?userid=4"><img src="<%=path %>/web/images/menu_pic4.jpg" width="258" height="112" alt="关于三墨"  style="border:none;background:transparent none repeat scroll 0% 0%" /></a>
          <div class="clearfix">
         	 关于三墨：三墨信息技术有限公司是依托军工的高新技术企业，公司创始人原为总参某部高级技术人才，多年从事军事尖端高新技术研发。合伙创始人具有多年一线研发经验，并有海外留学和知名信息技术公司从业背景，均为知名高校信息技术专业博士或硕士学历。
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript" src="<%=path%>/web/js/jquery-1.8.1.min.js"></script> 
<script type="text/javascript" src="<%=path%>/web/js/banner.js"></script> 
<!--footer-->
<div class="wd txt_center" style="width: 100%;margin: 10px auto;text-align: center;position: relative;border-top: solid;border-color: #4a74b5;border-top-width: 1px;">
    <div class="navPageBottom" style="margin-top: 10px;">关于三墨</div>
    <div class="copyright addrtitle" style="padding-top:4px;">
        &copy; 2011 - 2016
    </div>
</div>
</body>
</html>