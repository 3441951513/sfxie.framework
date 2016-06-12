<link rel="stylesheet" type="text/css" href="${ctx}/static/js/ui/jquery-easyui-1.4.2/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/ui/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="${ctx}/static/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ui/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ui/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
	.report-loading-none{
		display: none;
	}
	.report-loading-display{
		display: block;
		position: absolute;
		left: 500px;
		top: 300px;
	}
	.report-paging-width{
		width:100%;
	}
</style>
<SCRIPT type="text/javascript">
	$(document).ready(function () {
		var formContentDive = $('#formContentDivId');
		formContentDive.append($('#${queryFormId}'));
		var queryObj = Report.getQueryObj();
		generateParentPageParameters(queryObj);
	});
	/**
	 * 获取另外一个页面url传过来的参数(返回数组)
	 * var requestObj = new _getQueryObj();
	 * @return {TypeName} 
	 */
	function _getQueryObj() {
	   var url = decodeURI(window.location.search);
	   var theRequest = new Object();
	   if (url.indexOf("?") != -1) {
	      var str = url.substr(1);
	      strs = str.split("&");
	      for(var i = 0; i < strs.length; i ++) {
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
	      }
	   }
	   _getWholeLocationHref();
	   return theRequest;
	}
	/**
	 * 获取当前页面的名称
	 * @return {pageName} 
	 */
	function _getWholeLocationHref(){
	     var strUrl=location.href;
	     var arrUrl=strUrl.split("/");
	     var strPage=arrUrl[arrUrl.length-1];
	     return strPage;
	 }
	/**
	 * 执行返回动作
	 * 2015年8月6日上午9:09:40
	 * @param retrunPageUrl
	 * @returns
	 */
	function returnParentPageFunc(retrunPageUrl){
		var data = DomUtil.getJSONObjectFromForm('queryParametersListForm');
		data['isReturnPage'] = true;
		var obj = {
				url:retrunPageUrl,
				paramObj:data
		};
		_$returnPageHref(obj['url'],obj['paramObj']);
	}
	function _$returnPageHref(url,params){
		var parameterString = "";
		for(var p in params){
			if(p.indexOf('jjjjj')>=0){
				if(parameterString==""){
					parameterString = "?"+p+"="+params[p];
				}else{
					parameterString = parameterString +"&"+p+"="+params[p];
				}
			}
		}
		if(parameterString){
			window.location.href = url+parameterString+"&isRetrunPage=true";
		}
	}
	/**
	 * 记录返回上一页的参数
	 * 2015年8月6日上午9:10:17
	 * @param queryObj
	 * @returns
	 */
	function generateParentPageParameters(queryObj){
		var jspName = Report.getJspName();
		var position = jspName.indexOf("?");
		if(position>0)
			jspName = jspName.substring(0,position);
		for(var p in queryObj){
			if(p.indexOf("jjjjj"+jspName)<0 && p.indexOf("jjjjj")==0){
				var temp=document.getElementById("queryParametersListForm");
				var opt=document.createElement("input");
				opt.name=p;
				opt.type='hidden';
				opt.value=queryObj[p];
				temp.appendChild(opt);
			}
		}
	}
	function securityBtn(map,url){
		if(map){
			for(var key in map){
				$("#"+key.replace(url,"")).hide();
			}
		}
	}
	/**
	 * 导出html报表页面
	 * 2015年8月6日上午9:27:55
	 *
	 * any
	 * @param exportDataType
	 * @returns
	 */
	function doHtmlReport(exportDataType){
		var queryFormId = '${queryFormId}';
		var paginationObj = $('#pp').pagination('options','pageNumber');	
		var pageNumber = paginationObj.pageNumber;
		var pageSize = paginationObj.pageSize;
		Report.doReport({
			queryFormId:queryFormId,
			contentId:'contentId',
			paginationId:'pp',
			centextPath:'${ctx}',
			data:{
				isIgnorePage:"true",
				pageSize:pageSize,
				pageNumber:pageNumber,
				exportDataType:exportDataType,
				exportFileType:'html',
				register:'${reportDealer}'
			}
		});
	}
	/**
	 * 设置返回页面的初始参数
	 * 2015年8月6日上午9:27:13
	 * @returns
	 */
	function setReturnPageParameters(btnType){
		if(btnType == 'returnPage'){
			var paginationObj = $('#pp').pagination('options','pageNumber');	
			var queryObj = Report.getQueryObj();
			var jspName = Report.getJspName();
			var position = jspName.indexOf("?");
			if(position>0)
				jspName = jspName.substring(0,position);
			if(queryObj){
				for(var p in queryObj){
					if(p.indexOf("jjjjj"+jspName)==0){
						var elementName = p.replace("jjjjj"+jspName+".","");
						if(elementName == "pageSize"){
							paginationObj.pageSize = queryObj[p];
						}else if(elementName == "pageNumber"){
							paginationObj.pageNumber = queryObj[p];
						}else{
							var element = document.getElementsByName(elementName)[0];
							if(element)
								element.value = queryObj[p];
						}
					}
				}
			}
		}
	}
	function doExportReport(exportDataType){
		var paginationObj = $('#pp').pagination('options','pageNumber');
		var pageNumber = paginationObj.pageNumber;
		var pageSize = paginationObj.pageSize;
		Report.doReport({
			queryFormId:'${queryFormId}',
			contentId:'contentId',
			paginationId:'pp',
			centextPath:'${ctx}',
			data:{
				isIgnorePage:"true",
				pageSize:pageSize,
				pageNumber:pageNumber,
				exportDataType:exportDataType,
				exportFileType:$('#exportType').val(),
				register:'${reportDealer}'
			}
		});
	}
	function onSelectPage(pageNumber, pageSize){
		doHtmlReport('single');
	}
	Report = new Object();
	Report.doReport = _$doReport;
	Report.getQueryObj = _getQueryObj;
	Report.getJspName = _getWholeLocationHref;
	function _$doReport(config){
		var buttonListChildren = $('#buttonList').children().clone( true );
		if(config['queryFormId']){
			var data = DomUtil.getJSONObjectFromForm(config['queryFormId']);
			if(config['data'])
				$.extend(config['data'],data);
			else 
				config['data'] = data;
		}
		config['data']['paramMap.formParameter'] = encodeURI(_$obj2str(data));
		config['dataType'] =  "text";
		config.url = config.centextPath+'/report/doReport.action';
		config['async']=false;
		config['data']['paramMap.exportFileType']= config['data']['exportFileType'];
		config['data']['paramMap.isIgnorePage']= config['data']['isIgnorePage'];
		var jspName = Report.getJspName();
		var position = jspName.indexOf("?");
		if(position>0)
			jspName = jspName.substring(0,position);
		config['data']['paramMap.jspName'] = jspName;
		_setRetrunPageParameters(config['data']);
		if(config['data']['exportFileType'] && config['data']['exportFileType']=='html'){
			config['dataType'] =  "json";
			_$reportAjax(config,editHtmlSuccessFunc,null);
		}else{
			config['paramObj'] = config['data'];
			_$reportlocation(config);
		}
		if($('#buttonList').children().length==0){
			$('#buttonList').empty();
			$('#buttonList').append(buttonListChildren);
		}
		function editHtmlSuccessFunc(config,response){
			var _config = {
					showType:'slide',
					style:{
		                right:'',
		                top:document.body.scrollTop+document.documentElement.scrollTop,
		                bottom:''
		            }, 
		            title :'操作提示',
		            timeout:1000,
		    		icon:'info'
			};
			if(response['total']==0){
				_config.msg = '<span style="color:red;">暂无数据</span>',
				$.messager.show(_config);
			}else{
				var dataGrid = $('#'+config.paginationId);
				var paginationObj = dataGrid.pagination('options','pageNumber');
				var pageSize = paginationObj.pageSize;
				var pageNumber = paginationObj.pageNumber;
				if(pageNumber==0){
					pageNumber = 1;
				}
				var total = response['total'];
				var leftCount = total - (pageSize*(pageNumber-1));
				if(pageSize >= leftCount){
					pageSize = leftCount;
				}
				_config.msg = '<span style="color:blue;">当前页查询出'+pageSize+'条数据</span>';
				$.messager.show(_config);
				dataGrid.pagination({
					total: response.total
				});
				var re1 = /<body[\S|\s| |\n|\r|\t|\f|\cX|\b|\v|\0|\w|\W|\d|\D]*<\/body>/g;  
				var bodyStartRe = /<body[\S|\s| |\n|\r|\t|\f|\cX|\b|\v|\0|\w|\W|\d|\D]*>\s/;
				var ddsdf = re1.exec(response.content)[0];
				var contents = ddsdf.substring(ddsdf.indexOf('>')+1,ddsdf.indexOf('</body>'));
				$("#"+config['contentId']).html('');
				contents = contents.replace(/<![if[\s|\S]*endif]>/,"");
				var contentDom = $(contents);
				var contentDeleteTds = contentDom.find('td[width="50%"]');
				var contentTable =  contentDom.find('table');
				contentDeleteTds.remove();
				contentTable.css({width:'100%'});
				$("#"+config['contentId']).append(contentDom);
			}
			$('#loadingContentId').removeClass('report-loading-display');
			$('#loadingContentId').addClass('report-loading-none');
		}
	}
	
	function _$reportAjax(config,successFunc,errorFunc){
		$("#"+config['contentId']).empty();
		$('#loadingContentId').removeClass('report-loading-none');
		$('#loadingContentId').addClass('report-loading-display');
		var result ; 
		var ajaxObj = {
		  cache: false,
		  dataType:  "json",
		  type:"POST",
		  success: function(response){
			  var result =  successFunc(config,response);
		  },
		  error:function(response){
			  alert('服务器内部处理出错！');
		  }
		};
		
		if(config['data'].pageNumber == 0){
			config['data'].pageNumber = 1;
		}
		
		$.extend(ajaxObj,config);
		$.ajax(ajaxObj);
		return result;
	}
	
	DomUtil = new Object();
	DomUtil.getJSONObjectFromForm = _getJSONObjectFromForm;
	function _getJSONObjectFromForm(formId,inCludeField,prefix){
		var obj = {};
		var parametersListForm = document.getElementById(formId);
		if(parametersListForm){
			var array = parametersListForm.elements;
			if(inCludeField)
				inCludeFields = inCludeField.split(',');
			for(var i=0;i<array.length;i++){
				if(inCludeField){
					if( array[i].name){
						var flag = false;
						for(var j=0;j< inCludeFields.length;j++){
							if((prefix||'')+inCludeFields[j]!= ''+array[i].name){
							}else{
								flag = true;
								break;
							}
						}
						if(flag && array[i].value) {
							obj[array[i].name]	= array[i].value ;
						}
					}
				}else{
					if(array[i].name)
						obj[array[i].name]	= array[i].value ;
				}
			}
		}
		return obj;
	}
	/**
	 * 设置返回页面的参数
	 * 2015年8月6日上午11:06:00
	 * @param data
	 * @returns
	 */
	function _setRetrunPageParameters(data){
		var queryParametersListForm = document.getElementById("queryParametersListForm");
		if(queryParametersListForm){
			var array = queryParametersListForm.elements;
			for(var i=0;i<array.length;i++){
				if(array[i].name)
					data[array[i].name]	= array[i].value ;
			}
		}
	}
	function _$downloadStatus(idTag){
		$.ajax({
			  url: '${ctx}/report/status.action',
			  dataType:"json",
			  data:{
				  downloadTag: idTag
			  },
			  success: function(data){
					if(data['state'] == '2' ){
	  					clearInterval(downloadStatusFlag);
	  					$('#loadingContentId').removeClass('report-loading-display');
			    		$('#loadingContentId').addClass('report-loading-none');
	  				}else if(data['state'] == '1' ){
	  					clearInterval(downloadStatusFlag);
	  					$('#loadingContentId').removeClass('report-loading-display');
			    		$('#loadingContentId').addClass('report-loading-none');
			    		alert("下载出错,请重新下载!");
	  				}
			  }
		});
	}
	function _$reportlocation(obj){
		_$winReportPostHref(obj['url'],obj['paramObj']);
	}
	function _$winReportPostHref(url,params){
		var idTag = '' + new Date().getTime();
		params['downloadTag']=idTag;
		$('#loadingContentId').removeClass('report-loading-none');
		$('#loadingContentId').addClass('report-loading-display');
		$('form[name="exportForm"]').remove();
		var temp=document.createElement("form");
		temp.action=url;
		temp.name = 'exportForm';
		temp.method="post";
		temp.style.display="none";
		if(params != null){
			for(var x in params) {
				var opt=document.createElement("input");
				opt.name=x;
				opt.type='hidden';
				opt.value=params[x];
				temp.appendChild(opt);
			}
		}
		$('body').append(temp);
		temp.submit(function(e){
		    var postData = $(this).serializeArray();
		    var formURL = $(this).attr("action");
		    $.ajax({
		        url : formURL,
		        type: "POST",
		        async:true,
		        data : postData/*,
		        success:function(data, textStatus, jqXHR){
		        	$('#loadingContentId').removeClass('report-loading-display');
		    		$('#loadingContentId').addClass('report-loading-none');
		        },
		        error: function(jqXHR, textStatus, errorThrown) {
		        	console.log('error');
		        },
		        complete: function(jqXHR, textStatus){
		        	console.log('complete');
		        }*/
		    });
		    e.preventDefault();
		    e.unbind(); 
		});
		downloadStatusFlag = setInterval(_$downloadStatus,500,idTag); 
	}
	
	function _$obj2str(o) {
	     if (o == undefined) {
	         return null;
	     }
	     var r = [];
	     if (typeof o == "string") {
	    	 if(!o) {
	    		 return '""';
	    	 }
	    	 return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
	     }
	     if (typeof o == "object") {
	         if (!o.sort) {
	             for (var i in o)
	                 r.push("\"" + i + "\":" + _$obj2str(o[i]));
	             if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
	                 r.push("toString:" + o.toString.toString());
	             }
	             r = "{" + r.join() + "}";
	         } else {
	             for (var i = 0; i < o.length; i++)
	                 r.push(_$obj2str(o[i]));
	             r = "[" + r.join() + "]";
	         }
	         return r;
	     }
	     return o.toString().replace(/\"\:/g, '":""');
	 }
	
</SCRIPT>