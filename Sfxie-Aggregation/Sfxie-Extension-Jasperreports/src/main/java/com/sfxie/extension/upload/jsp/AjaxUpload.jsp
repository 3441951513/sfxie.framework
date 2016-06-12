<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/cms/common/taglibs.jsp" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${ctx}/static/js/plugin/jquery-ui/css/redmond/jquery-ui.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/golive-business.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${ctx}/static/js/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugin/jquery-ui/js/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugin/jquery-ui/js/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/plugin/jquery-ui/js/ui/jquery.ui.progressbar.js"></script>
	<script src="${ctx}/static/js/plugin/form/jquery.form.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/common/common.js"></script>
	<script type="text/JavaScript">
		//关闭窗体
		function closeWin(){
			var type = '${type}';
			var values = new Array();
			var divs = $('div[name="DivContentName"]');
			for(var i=0;i<divs.length;i++){
				if($(divs[i]).data('record')){ 
					$(divs[i]).data('record')
					values.push($(divs[i]).data('record'));
				}
			}
			var returnObject = {
					type : type || "single",
					values : values
			};
			/* if (window.opener != undefined) {
	    	  window.opener.returnValue = returnObject;
			}else {  
			    parent.window.returnValue = returnObject;  
			}
			window.top.frames.close();
			 */
// 			 console.log("returnObject");
// 			 console.log(returnObject);
			window.parent.returnValue = returnObject;
		}
		$(document).ready(function() {
			initUploadTable();
       	});
		
		//上传文件时获取上传文件状态定时任务集合
		uploadInterval = [];
		
		//设置单条行上传文件的按钮单击事件
        function uploadForm(idTag){
        	var type = '${type}';
        	//文件上传事件
    		$("#"+idTag+"Upload").click(function () {
    			var uploadFileId =idTag+'File';
    			if(!$("#"+uploadFileId).val())
                        	alert("未选择文件！请按右边的浏览按钮选择文件！");
    			else{
    				ajaxUploadFile(idTag);
    				uploadInterval[idTag] = setInterval(ajaxUploadStatus,500,idTag);  
    			}
    			
            });
    		//文件删除事件
    		$("#"+idTag+"Delete").click(function () {
    			var record = $("#"+idTag+'DivContent').data('record');
    			if(record){
    				deleteFile(record);
    			}else{
    				if(type == GoLive.AjaxUpload.TYPE_MULTY){
		    			$("#"+idTag+'DivContent').empty().remove();
    				}
    			}
            });
    		//清理文件事件
    		$("#"+idTag+"Clear").click(function () {
    			var data = $("#"+idTag+'DivContent').data('record');
    			if(data){
    				data['dbSavePath']='';
    				data['state']='0';
    				$("#"+idTag+'DivContent').data('record',data)
    			}
    			$( "#" +idTag+"Upload").attr("disabled",false);
    			$("#"+idTag+'File').val('');
            });
    	}
		//文件上传动作
        function ajaxUploadFile(idTag){
        		var filePath = window.parent.uploadFileParams.filePath;
        		console.log(window.parent.uploadFileParams);
        		console.log("filePath: "+filePath);
	            $("#"+idTag+"Form").ajaxSubmit({
	                url: "${ctx}/ajaxUpload-upload.action",
	                type: "POST",
	                dataType: 'json',  
	                cache:'false',
	                data:{fileTimeTag:idTag,filepath: filePath || 'material'},
	                success: function (data) {
	                },
	                error: function () {
	                }
	            });
	            $( "#"+idTag+"Div" ).progressbar({
					value: false,
					change: function() {
						$( "#" +idTag+"Label").text( $( "#"+idTag+"Div").progressbar( "value" ) + "%" );
					},
					complete: function() {
						$(  "#" +idTag+"Label" ).text( "上传完成!" );
					}
				});
        }
		//文件删除动作
        function deleteFile(record){
        	GoLive.ajax({
	  			  url:  "${ctx}/ajaxUpload-delete.action",
	  			  dataType:"json",
	  			  data:{
		  				'dbSavePath': record.dbSavePath,
		  				fileTimeTag: record.fileTimeTag
	  			  },
	  			  success: function(data){
	  				  if(data.success){
	  					  //文件已经上传状态(加载出来的记录)
	  					  if(record.state=='4'){
		  					 	$('#'+data['fileTimeTag']+'Span').addClass('golive-display-none');
		  					 	$('#'+data['fileTimeTag']+'SpanLabel').addClass('golive-display-none');
		  						$('#'+data['fileTimeTag']+'File').removeClass('golive-display-none');
		  						$('#'+data['fileTimeTag']+'Clear').removeClass('golive-display-none');
		  						$('#'+data['fileTimeTag']+'Upload').removeClass('golive-display-none');
		  						$("#"+record['fileTimeTag']+'DivContent').data('record',null);
	  					  }
	  					//文件已经上传成功
	  					  else if(record.state=='2'){
	  						$( "#" +record['fileTimeTag']+"Upload").attr("disabled",false);
  							$( "#" +record['fileTimeTag']+"File").attr("disabled",false);
  							$( "#" +record['fileTimeTag']+"Clear").attr("disabled",false);
  							$( "#" +record['fileTimeTag']+"File").val('');
  							$("#"+record['fileTimeTag']+'DivContent').data('record',null);
  							progressbar(record['fileTimeTag'],0,0);
  							$( "#" +record['fileTimeTag']+"Label").text('');
	  					  }
	  				  }
	  			  }
	  		});
        }
		//上传文件时实时获取文件状态,并且设置进度条
        function ajaxUploadStatus(idTag){
        	GoLive.ajax({
	  			  url:  "${ctx}/ajaxUpload-status.action",
	  			  dataType:"json",
	  			  data:{
		  				fileTimeTag:idTag,
		  				filepath:'material'
	  			  },
	  			  success: function(data){
	  					if(!data){
	  						$( "#" +idTag+"Label" ).text( "准备上传......" );
	  					}else{
		  					var readedBytes = parseInt(data['readedBytes']);
		  					var totalBytes = parseInt(data['totalBytes']);
	  						if(data['state'] == '2' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,readedBytes,totalBytes);
	  							$( "#" +idTag+"Upload").attr("disabled",true);
	  							$( "#" +idTag+"File").attr("disabled",true);
	  							$( "#" +idTag+"Clear").attr("disabled",true);
			  				}else if(data['state'] == '1' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,0,0);
			  					$( "#" +idTag+"Label"  ).text( "上传出错!" );
			  				}else if(data['state'] == '3' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,0,0);
			  					var errorHtml = '<span class="">文件限制上传,您只能上传[{0}]!</span>';
			  					$( "#" +idTag+"Label"  ).html( errorHtml.format($( "#" +idTag+"Input").val()) );
			  				}else{
			  					progressbar(idTag,readedBytes,totalBytes);
			  				}
	  						
	  						data['fileTimeTag'] = idTag;
	  						$("#" +idTag+'DivContent').data('record',data);
	  					}
	  			  }
	  		});
        }
		//根据读写文件字节数和文件大小设置进度条
        function progressbar(idTag,readedBytes,totalBytes){  
        	var iPerc = (readedBytes > 0) ? (readedBytes / totalBytes) * 100 : 0; // percentages  
        	$("#"+idTag+"Div" ).progressbar( "value", iPerc );
       	} 
		//初始化上传文件组件表格
       	function initUploadTable(){
       		var type = "${type}";
       		//上传单个文件
       		if(type=='multy'){
       			;
       		}else{
       			$('#addFileFormBTN').remove();
       		}
   			
//    			var fileUrls = window.dialogArguments.fileUrls;
			var fileUrls = window.parent.uploadFileParams.fileUrls;
			if(fileUrls && fileUrls.length>0){
				for(var h=0;h<fileUrls.length;h++){
		   			var idTag = '' + new Date().getTime();
					var record = {
						dbSavePath:fileUrls[h],
						state : "4",
						fileTimeTag: idTag
					};
					var temp = $(createOldForm(idTag,fileUrls[h],"已经上传!"));
					$(temp).data('record',record);
					$('#contentId').append(temp);
					uploadForm(idTag);
				}
			}else{
				var idTag = '' + new Date().getTime();
	   			var formString = createForm(idTag);
	   			$('#contentId').append($(formString));
	   			uploadForm(idTag);
			}
			
       	}
		//创建单上传文件表单
       	function createForm(idTag){
//        		var validations = window.dialogArguments.validations;
			var validations = window.parent.uploadFileParams.validations;
       		var formString = '<div id="{0}DivContent" name="DivContentName">'+
								'	<form id="{0}Form" method="post" enctype="multipart/form-data" >'+
								'       <input id="{0}Input" type="hidden" value="{1}" name="validations">'+
								'		<table>'+
									'		<col width="40%">'+
									'		<col width="35%">'+
									'		<col width="25%">'+
									'		<tbody>'+
									'			<tr>'+
									'				<td><input style="padding-left: 10px;" type="file" id="{0}File" name="upload" /></td>'+
									'				<td><div id="{0}Div" style="width:300px;"><div id="{0}Label" class="progress-label"></div></div></td>'+
									'				<td><button type="button" style="padding-right: 10px;" id="{0}Upload">上传</button>'+
									'					<button type="button" style="padding-right: 10px;" id="{0}Clear">清除路径</button>'+
									'					<button type="button" style="padding-right: 10px;" id="{0}Delete">删除</button>'+
									'				</td>'+
									'			</tr>'+
									'		</tbody>'+
								'		</table>'+
								' 	</form>'+
							 '</div>';
			return formString.format(idTag,validations);
       	}
      //创建单上传文件表单
       	function createOldForm(idTag,path,stateText){
//        		var validations = window.dialogArguments.validations;
			var validations = window.parent.uploadFileParams.validations;
       		var formString = '<div id="{0}DivContent" name="DivContentName">'+
								'	<form id="{0}Form" method="post" enctype="multipart/form-data" >'+
								'       <input id="{0}Input" type="hidden" value="{1}" name="validations">'+
								'		<table>'+
									'		<col width="40%">'+
									'		<col width="35%">'+
									'		<col width="25%">'+
									'		<tbody>'+
									'			<tr>'+
									'				<td><input style="padding-left: 10px;" type="file" id="{0}File" name="upload" class="golive-display-none" />'+
									' 					<span id="{0}Span" style="font-size:12px;">{2}</span>'+
									'				</td>'+
									'				<td>'+
									'					<div id="{0}Div" style="width:300px;">'+
									'						<div id="{0}Label" class="progress-label"></div>'+
									' 						<span style="padding-left: 10px;" type="file" id="{0}SpanLabel">{3}</span>'+
									'					</div>'+
									'				</td>'+
									'				<td><button type="button" style="padding-right: 10px;" id="{0}Upload"  class="golive-display-none">上传</button>'+
									'					<button type="button" style="padding-right: 10px;" id="{0}Clear"  class="golive-display-none" >清除路径</button>'+
									'					<button type="button" style="padding-right: 10px;" id="{0}Delete">删除</button>'+
									'				</td>'+
									'			</tr>'+
									'		</tbody>'+
								'		</table>'+
								' 	</form>'+
							 '</div>';
			return formString.format(idTag,validations,path,stateText);
       	}
       	function addFileForm(){
       		var idTag = ''+new Date().getTime();
   			var formString = createForm(idTag);
   			$('#contentId').append($(formString));
   			uploadForm(idTag);
       	}
	</script>
</head>
<body>

	<div class="ajaxUpload-close">
		<!-- <input type="button" value="关   闭" onclick="closeWin()"  alt="关闭窗体" style="width:120px;font-size:14px;"/>&nbsp; -->
		<input type="button" id="addFileFormBTN" value="添加文件" onclick="addFileForm()" alt="添加文件" />&nbsp;
	</div>
	<div id="contentId" class="ajaxUpload-progressbar">
		<table id="table">
			<col width="40%">
			<col width="35%">
			<col width="25%">
			<thead>
				<tr><th>文件</th><th>上传进度</th><th>操作</th></tr>
			</thead>
		</table>
	</div>
</body>
</html>
