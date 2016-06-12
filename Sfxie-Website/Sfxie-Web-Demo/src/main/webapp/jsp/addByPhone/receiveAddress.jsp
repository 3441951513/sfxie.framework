<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%String path = request.getContextPath();  %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>零花钱收货地址新增</title>
<meta name="viewport" content="width=device-width" />
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"  name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<meta http-equiv="pragma" content="no-cache"> 
<link rel="stylesheet" type="text/css" href="<%=path %>/jsp/addByPhone/css/common.css">
<script src="<%=path %>/jsp/addByPhone/js/jquery-2.0.0.min.js" type="text/javascript"></script>
<script src="<%=path %>/jsp/addByPhone/js/city.js" type="text/javascript"></script>
<script src="<%=path %>/jsp/addByPhone/js/common.js" type="text/javascript"></script>
</head>

<body>
<div class="main">
	<!--Header Begin-->
    <div class="header">
    	<h2>零花钱收货地址新增</h2>
    </div>
    <!--Container Begin-->
    <div class="container">
        <div class="form-table">
	        <div align="center">
	            <span style="color: red;" id="tip">${message}</span>
	        </div>
        	<form action="<%=path %>/springmvc/addByPhone/receiveAddress/add" method="get" id="receivingForm">
            	<ul>
                	<li>
                    	<div class="form-key">收货人：</div>
                        <div class="form-value">
                        	<input type="text" class="form-must form-input" id="userName" name="userName" placeholder="请输入收货人姓名"/>
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
                    	<div class="form-key">收货地址：</div>
                        <div class="form-value form-value-min">
                        	<select class="form-must form-select form-select-province" id="userProvince" name="userProvince" placeholder="请选择省份" ></select>
                            <p class="form-alert"></p>
                        </div>
                        <div class="form-value form-value-min form-select-city">
                        	<select class="form-must form-select" id="userCity" name="userCity" placeholder="请选择城市" ></select>
                            <p class="form-alert"></p>
                        </div>
                        <div class="form-value form-value-min">
                        	<select class="form-must form-select" id="userArea" name="userArea" placeholder="请选择地区" ></select>
                            <p class="form-alert"></p>
                        </div>
                    </li>
                    <li>
                    	<div class="form-key">收货地址：</div>
                        <div class="form-value">
                        	<textarea class="form-must form-textArea" id="userAddress" name="userAddress" placeholder="请输入街道小区门牌号"></textarea>
                            <p class="form-alert"></p>
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
