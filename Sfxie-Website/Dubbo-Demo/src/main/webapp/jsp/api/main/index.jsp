<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>接口测试系统</title>
<link rel="stylesheet" type="text/css" href="${ctx}/jsp/api/jquery-easyui-1.4.2/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/jsp/api/jquery-easyui-1.4.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/jsp/api/prettyprint/prettify.css">
<script type="text/javascript" src="${ctx}/jsp/api/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/jsp/api/jquery-easyui-1.4.2/JSON2.js"></script>
<script type="text/javascript" src="${ctx}/jsp/api/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/jsp/api/prettyprint/prettify.js"></script>

<script type="text/javascript" src="api.js"></script>
<script type="text/javascript" src="interceptor/dubbo.js"></script>
<script type="text/javascript" src="interface/dubbo.js"></script>
<script type="text/javascript" src="interface/cm.js"></script>
<style type="text/css">
	.input-div{
		width:100%;
		height: 30px;
		line-height: 30px;
	}
	.input-span{
		width:12%;
		display: block;
		float:left;
		height: 30px;
		line-height: 30px;
	}
	.input-text{
		width:93%;
		float:right;
		height: 20px;
		line-height: 20px;
	}
</style>
<script type="text/javascript">
	var flag = {};
	String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
	    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
	        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
	    } else {  
	        return this.replace(reallyDo, replaceWith);  
	    }  
	} ; 
	$(document).ready(function(){
		hostName = "http://"+window.location.host;//http://localhost:8080
		$('#inputDiv').hide();
		var treeData = [];
		for(var i=0;i<apiRootArray.length;i++){
			var root = apiRootArray[i];
			var rootNodeData = {
					id : root['id'],
					text : root['name'],
					attributes: root
				};
			var children = [];
			for(var j=0;j<apiArray.length;j++){
				var api = apiArray[j];
				if(api['parentId'] == rootNodeData['id']){
					children.push({
						text : api['name'],
						id : api['id'],
						attributes : api
					});
				}
			}
			rootNodeData['children'] = children;
			treeData.push(rootNodeData);
		}
	    $('#apiTree').tree({
	    	data : treeData,
	    	fit: true
	    });
	    
// 	    getDivText();
	    treeClick();
	});
	
	function decoratedTabElement (node){
		
		var apiId = node.attributes['id'];
		
		var ctx = "${ctx}"+"/springmvc";
		var actionUrl = ctx+node.attributes['url'];
		
		if(node.attributes['dataType']){
			$('#'+apiId+'dataType').val(node.attributes['dataType']);
		}
		
		$('#'+apiId+'InputUrl').val(actionUrl);
		$('#'+apiId+'URLId').text(hostName+actionUrl);
		var test = getParameter(node);
		var dataType = node.attributes['dataType'];
		if(test){
			if(dataType !='json'){
				test = test.replaceAll('\r','').replaceAll('\n','').replaceAll('<','&lt;').replaceAll('>','&gt;\n');
			}
		}else{
			test = "";
		}
		$('#'+apiId+'XMLId').html(test);
	    prettyPrint();
	    $('#'+apiId+'XMLId').bind({
	    	click:function(e){
	    		var parametersConfig = node['attributes']['parameters'];
	    		flag[apiId]=true;
	    		if(parametersConfig && !$.isEmptyObject(parametersConfig)){
		    		$('#'+apiId+'InputDivId').show();
	// 	    		$('#'+apiId).textbox('textbox').focus();
	// 	    		$('#'+apiId).textbox('setValue', $('#'+apiId+'XMLId').text());
					$('#'+apiId).val($('#'+apiId+'XMLId').text());
		    		$('#'+apiId+'XMLId').hide();
		    		
		    		var text = $('#'+apiId+'XMLId').text();
		    		createParamsInput(node,text);
	    		}else{
	    			$('#'+apiId+'XMLId').hide();
	    			$('#'+apiId+'InputDivId').show();
	    			$('#'+apiId).show();
	    			$('#'+apiId).val($('#'+apiId+'XMLId').text());
	    		}
	    	}
	    });
	    $('#'+apiId+'tab-tools').bind({
		    	'mouseover' : function(e){
		    		if(flag[apiId]){
			    		$('#'+apiId+'InputDivId').hide();
			    		/* var text = $('#'+apiId).val().replaceAll('\n','').replaceAll('\r','')
			    		text = text.replaceAll('<','&lt;').replaceAll('>','&gt;\n');
			    		$('#'+apiId+'XMLId').html(text);
			    		prettyPrint();
			    		$('#'+apiId+'XMLId').show(); */
			    		var text = $('#'+apiId).val();
			    		if(dataType !='json'){
			    			text = text.replaceAll('\n','').replaceAll('\r','');
				    		text = text.replaceAll('<','&lt;').replaceAll('>','&gt;\n');
			    		}
			    		removeParamsInput(node,text);
			    		flag[apiId] = false;
		    		}
		    }
    	});
	    $('#'+apiId+'InputDivId').hide();
	}
	//动态生成参数输入框
	function createParamsInput(node,text){
		var nodeId = node.attributes['id'];
		var parametersConfig = node['attributes']['parameters'];
		if(parametersConfig){
			for(var name in parametersConfig){
				if(parametersConfig[name]){
					var regex = /\w*\_*\w*="((\w*)|(\d*)|([\u4e00-\u9fa5]*))*"/g;
					var arrays = text.match(regex);
					if(arrays){
						for(var i=0;i<arrays.length;i++){
							var t = arrays[i];
							if(t.indexOf(name+'="')>=0){
								var inputString = '<div class="input-div" id="'+name+'TextDiv"  >'+name+': <input type="text" class="input-text" id="'+name+'Name" > </div>';
								$('#'+nodeId+'InputDivId').append(inputString);
								$('#'+name+'Name').attr('data',t);
							}
						}
					}
				}
			}
		} 
	}
	function removeParamsInput(node,text){
		var nodeId = node.attributes['id'];
		var parametersConfig = node['attributes']['parameters'];
		if(parametersConfig && !$.isEmptyObject(parametersConfig)){
			for(var name in parametersConfig){
				if(parametersConfig[name]){
					var regex = /\w*\_*\w*="((\w*)|(\d*)|([\u4e00-\u9fa5]*))*"/g;
					var arrays = text.match(regex);
					if(arrays){
						for(var i=0;i<arrays.length;i++){
							var t = arrays[i];
							if(t.indexOf(name+'="')>=0){
								var hiddenData = $('#'+name+'Name').attr('data');
								var textValue = $('#'+name+'Name').val();
								if(textValue){
									text = text.replaceAll(hiddenData,name+'="'+textValue+'"');
								}
								$('#'+name+'TextDiv').remove();
							}
						}
					}
				}
			}
		} else{
			$('#'+nodeId+'InputDivId').hide();
			$('#'+nodeId).hide();
		}
		$('#'+nodeId+'XMLId').html(text);
		prettyPrint();
		$('#'+nodeId+'XMLId').show();
	}
	function treeClick(){
		$('#apiTree').tree({
			onClick: function(node){
				if(node.attributes && node.attributes['parentId']){
					openMenu(node);
				}
			}
		});
	}
	function openMenu(node){
		var title = node.attributes['name'];
		var tab = $('#content').tabs('getTab',title);
		if(!tab){
			var content = getDivText(node); 
			$('#content').tabs('add',{
			    title:title,
			    content:content,
			    closable:true,
			    fit:true,
			    tools:[{
			        iconCls:'golive-icon-refresh',
			        handler:function(){
			        	var refresh_tab = $('#content').tabs('getSelected');  // get selected panel
			        	if(refresh_tab && refresh_tab.find('iframe').length > 0){  
			        	    var _refresh_ifram = refresh_tab.find('iframe')[0];  
			        	    var refresh_url = _refresh_ifram.src;  
			        	    _refresh_ifram.contentWindow.location.href=refresh_url;  
		        	    }  
			        }
			    }]
			});
			decoratedTabElement (node);
		}else{
			$('#content').tabs('select',title);
		}
	}
	function getDivText(node){
		var returnText = null;
		$.ajax({
			  url: "div.txt",
			  async:false,
			  dataType:"text",
			  success: function(data){
				  returnText = data.replaceAll('s#######s',node.attributes['id']);
			  }
		});
		return returnText;
	}
	function getParameter(node){
		var returnText = null;
		var timestamp=new Date().getTime();
		var url = '';
		var dataType = 'text';
		if(node.attributes['xmlParam']){
			url = node.attributes['xmlParam']+'?_seq='+timestamp;
		}else{
			var fileType = "json";
			if(node.attributes['fileType']){
				fileType = node.attributes['fileType'];
			}
			if(node.attributes['dataType']){
				dataType = node.attributes['dataType'];
			}
			 url = 'params/'+node.attributes['parentId']+'/'+node.attributes['id']+'.'+fileType+'?_seq='+timestamp
		}
		$.ajax({
			  url: url,
			  async:false,
			  dataType: 'text',
			  success: function(data){
				  returnText = data;
			  }
		});
		return returnText;
	}
	function contentOnUpdate (title,index){
    }
	function submitForm(apiId){
		
		var actionUrl = $('#'+apiId+'InputUrl').val();
		var param = $('#'+apiId+'XMLId').text();
		
		var contentType ='text/xml; charset=utf-8' ;
		var dataType = $('#'+apiId+'dataType').val() || "xml";
		if(dataType == 'json'){
			contentType ='application/json; charset=utf-8' ;
		}

		$.ajax({
	        "url": actionUrl,
	        "data": param,
	        "processData": false,
	        async:false,
	        "type": "POST",
	        "contentType": contentType,
	        "dataType": dataType,
	        "success": function (data, textStatus, jqXHR) {
	        	$.messager.show({
	                    title:'提示框',
	                    msg:'<span style="color:blue;">操作结束</span>',
	                    showType:'slide',
	                    timeout:2000,
	                    style:{
	                        right:'',
	                        bottom:''
	                    }
	             });
	        	if(dataType == 'xml'){
		            data = XMLtoString(data);
		        	data = data.replaceAll('<','&lt;').replaceAll('>','&gt;\n');
		    		$('#'+apiId+'OutXMLId').html(data);
	        	}else{
	        		$('#'+apiId+'OutXMLId').text(JSON.stringify(data, null, "\t"));
	        	}
	    		prettyPrint();
	        },
	        "error": function (jqXHR, textStatus, errorThrown) {
	        	if(jqXHR.status == 200 && ((jqXHR.responseText == 'ok' || jqXHR.responseText == 'OK' ) || (jqXHR.responseText == 'success' || jqXHR.responseText == 'SUCCESS' ))){
	                $.messager.show({
		                    title:'提示框',
		                    msg:'<span style="color:blue;">操作结束</span>',
		                    showType:'slide',
		                    timeout:2000,
		                    style:{
		                        right:'',
		                        bottom:''
		                    }
		             });
	                $('#'+apiId+'OutXMLId').html(jqXHR.responseText);
	        	}else{
		            $.messager.show({
	                    title:'提示框',
	                    msg:'<span style="color:blue;">操作失败</span>',
	                    showType:'slide',
	                    timeout:2000,
	                    style:{
	                        right:'',
	                        bottom:''
	                    }
	             	});
		            $('#'+apiId+'OutXMLId').html('[ajax error]' + errorThrown);
		            
	        	}
	        }
	    });
	}
	function submitAllRefleshCache(nodes){
		var ctx = "${ctx}"+"/springmvc";
		var msg = "";
		for(var i=0;i<nodes.length;i++){
			var actionUrl = ctx + nodes[i]['attributes'].url;
			var contentType ='text/xml; charset=utf-8' ;
			var dataType = nodes[i]['attributes']['dataType'] || "xml";
			if(dataType == 'json'){
				contentType ='application/json; charset=utf-8' ;
			}
			
			$.ajax({
		        "url": actionUrl,
		        "data": {},
		        "processData": false,
		        async:false,
		        "type": "POST",
		        "contentType": contentType,
		        "dataType": dataType,
		        "success": function (data, textStatus, jqXHR) {
		        	msg = "操作成功";
		        },
		        "error": function (jqXHR, textStatus, errorThrown) {
		        	if(jqXHR.status == 200 && (jqXHR.responseText == 'success' || jqXHR.responseText == 'SUCCESS' )){
		        		msg = "操作成功";
		        	}else{
		        		msg = "操作失败";
		        	}
		        }
		    });
		}
		$.messager.show({
            title:'提示框',
            msg:'<span style="color:blue;">操作成功</span>',
            showType:'slide',
            timeout:2000,
            style:{
                right:'',
                bottom:''
            }
     	});
	}
	function XMLtoString(elem) {
	    var serialized;
	    try {
	        // XMLSerializer exists in current Mozilla browsers
	        serializer = new XMLSerializer();
	        serialized = serializer.serializeToString(elem);
	    }
	    catch (e) {
	        // Internet Explorer has a different approach to serializing XML
	        serialized = elem.xml;
	    }
	    return serialized;
	}
	function treeFormat (node){
		var iscache = node.attributes['isCache'];
		var deprecated = node.attributes['deprecated'];
		var deprecatedStyle = '';
		if(deprecated){
			deprecatedStyle = 'style="text-decoration:line-through;color: gray;background-color: #DDDDDD;"'
		}
        var s = node.text;
        var developer = node.attributes['developer']?('['+node.attributes['developer'] +']') : "";
        if (node.children){
            s += '<span style="color:peru;font-size:10px;">'+developer+'</span>'+ '&nbsp;<span style="color:blue;">(' + node.children.length + ')</span>'+(iscache?'<a pId="'+node.id+'" href="#" onclick="refleshAll(this);"><span style="color:red;">刷新全部</span></a>':'');
        }else{
	        var title = node.attributes['id'];
        	s = '<span  title="'+title+'" '+deprecatedStyle+'>' + s + '</span>'+'<span style="color:peru;font-size:10px;">'+developer+'</span>';
        }
        return s;
    }
	function refleshAll(self){
		var selectedNode = $('#apiTree').tree('getSelected');
		var cacheModuleId = $(self).attr('pId');
		var nodes = $('#apiTree').tree('getRoots');
		var node = $('#apiTree').tree('find', $('#'+$(self).attr('pId')));
		for(var i=0;i<nodes.length;i++){
			if(nodes[i]['id'] == cacheModuleId){
				submitAllRefleshCache(nodes[i]['children']);
			}
		}
// 		console.log(selectedNode);
		if(selectedNode){
			$('#apiTree').tree('select', selectedNode.target);
		}
// 		e.preventDefault(); 
// 		e.stopPropagation();
	}
</script>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 100%;" data-options="fit:true">
		<div class="north" data-options="region:'north'" style="height: 65px;">
			<img src="logo.jpg">
		</div>
		<div class="copyright" data-options="region:'south'" style="height: 27px;text-align: center;">
			Copyright 2015@ 全球播（北京）有限公司
		</div>
		<div data-options="region:'west',split:true,border:false" title="接口集合" style="width: 15%;">
			<ul id="apiTree" data-options="fit:true,lines:true,formatter:treeFormat"></ul>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'">
		    <div id="content" class="easyui-tabs" data-options="fit:true,
		    onUpdate:contentOnUpdate">
		        <div title="欢迎" data-options="iconCls:'icon-help',closable:true,fit:true" style="padding:10px;">
		            		感谢您使用全球播广告接口测试系统!
		        </div>
		    </div>
		</div>
	</div>
</body>
</html>

