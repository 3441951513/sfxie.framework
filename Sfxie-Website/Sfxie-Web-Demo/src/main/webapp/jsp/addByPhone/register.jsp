<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%String path = request.getContextPath();  %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>零花钱注册</title>
<meta name="viewport" content="width=device-width" />
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"  name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<meta http-equiv="pragma" content="no-cache"> 
<link rel="stylesheet" type="text/css" href="<%=path %>/jsp/addByPhone/css/common.css">
<script src="<%=path %>/jsp/addByPhone/js/jquery-2.0.0.min.js" type="text/javascript"></script>
<script src="<%=path %>/jsp/addByPhone/js/common.js" type="text/javascript"></script>
<script>
	var lhqURL = "<%=path %>";
</script>
</head>

<body>
<div class="main">
	<!--Header Begin-->
    <div class="header">
    	<h2>零花钱注册</h2>
    </div>
    <!--Container Begin-->
    <div class="container">
    	<div class="content-title">以下内容将确保您在零花钱购物物品的安全性<br />请您认真填写相关内容!</div>
        <div class="form-table">
	        <div align="center">
	            <span style="color: red;" id="tip">${message}</span>
	        </div>
        	<form action="<%=path %>/springmvc/addByPhone/register/add" method="get" id="loginForm">
            	<ul>
                	<li>
                    	<div class="form-key">姓名：</div>
                        <div class="form-value">
                        	<input type="text" class="form-must form-input" id="userName" name="userName" placeholder="请输入姓名"/>
                            <p class="form-alert"></p>
                        </div>
                    </li>
                	<li>
                    	<div class="form-key">手机号码：</div>
                        <div class="form-value">
                        	<input type="text" class="form-must form-input" id="userMobile" name="userMobile" maxlength="11" placeholder="请输入手机号码" />
                            <p class="form-alert"></p>
                        </div>
                    </li>
                	<li>
                    	<div class="form-key">验证码：</div>
                        <div class="form-value">
                        	<input type="text" class="form-must form-input form-code" id="userCode" name="userCode" maxlength="4" placeholder="请输入验证码"/>
                            <input type="button" class="form-btn btn-code" id="btnCode" value="获取验证码"  />
                            <p class="form-alert"></p>
                        </div>
                    </li>
                    <li>
                    	<div class="form-key">选择头像：</div>
                        <div class="form-value">
                        	<input type="radio" class="form-radio" value="${user_heads_man}" name="userHead" checked="checked" id="userHeadByMan" />
                        	<input type="radio" class="form-radio" value="${user_heads_women}" name="userHead"  id="userHeadByWomen"/>
                        	<label class="item-head item-head-sel" for="userHeadByMan"><img src="${user_heads_man_url}" /></label>
                        	<label class="item-head" for="userHeadByWomen"><img src="${user_heads_women_url}"></label>
                        </div>
                    </li>
                    <li>
                       <div class="form-submit">
                       		<input type="hidden" value="${userId}" id="userId" name="userId"/>
                            <input type="submit" class="form-btn btn-submit" id="btnSubmit" value="确认" />
                       </div>
                    </li>
                </ul>
            </form>
        </div>
    </div>
	<div class="cb"></div>
</div>
</body>
</html>
