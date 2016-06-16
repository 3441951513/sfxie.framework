<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>

<html>
<head>
    <%@include file="/common/meta.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="jquery-ui.min.css" rel="stylesheet" type="text/css"/>
	<link href="sfxie-business.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="jquery-upload-all-mini.js"></script>
	<script type="text/JavaScript">
		var __sto = setTimeout;    
		window.setTimeout = function(callback,timeout,param){    
		    var args = Array.prototype.slice.call(arguments,2);    
		    var _cb = function(){  
		    	if(callback)
		    		callback.apply(null,args);    
		    }    
		    __sto(_cb,timeout);    
		};   
		var __sti = setInterval;
		window.setInterval = function(callback,timeout,param){    
		    var args = Array.prototype.slice.call(arguments,2);    
		    var _cb = function(){  
		    	if(callback)
		    		callback.apply(null,args);    
		    }    
		    return __sti(_cb,timeout);    
		};
		//关闭窗体
		function closeWin(){
// 			var type = '${type}';
			var type = window.parent.uploadFileParams.type;
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
			initFileTip();
       	});
		
		//上传文件时获取上传文件状态定时任务集合
		uploadInterval = [];
		
		//设置单条行上传文件的按钮单击事件
        function uploadForm(idTag){
//         	var type = '${type}';
			var type = window.parent.uploadFileParams.type;

        	//文件上传事件
    		$("#"+idTag+"Upload").click(function () {
    			var uploadFileId =idTag+'File';
    			if(!$("#"+uploadFileId).val())
                        	alert("未选择文件！请按左边的按钮选择文件！");
    			else{
    				$('#'+idTag+'Upload').attr('disabled',true);
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
    				if(type == Sfxie.AjaxUpload.TYPE_MULTY){
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
//     			$( "#" +idTag+"Upload").attr("disabled",false);
    			$("#"+idTag+'File').val('');
    			$( "#" +idTag+"Upload").removeAttr("disabled");
            });
    	}
		//文件上传动作
        function ajaxUploadFile(idTag){
        		var filePath = window.parent.uploadFileParams.filePath;
        		var maxLength = window.parent.uploadFileParams.maxLength;
	            $("#"+idTag+"Form").ajaxSubmit({
	                url: "${serverPath}/ossFileUpload/upload",
	                type: "POST",
	                dataType: 'json',  
	                cache:'false',
	                data:{fileTimeTag:idTag,filepath: filePath || 'material',maxLength:maxLength},
	                success: function (data) {
	                },
	                error: function () {
	                }
	            });
	            $( "#"+idTag+"Div" ).progressbar({
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
        	Sfxie.ajax({
	  			  url:  "${serverPath}/ossFileUpload/delete.action",
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
        	Sfxie.ajax({
	  			  url:  "${serverPath}/ossFileUpload/status",
	  			  dataType:"json",
	  			  data:{
		  				fileTimeTag:idTag,
		  				filepath:'material'
	  			  },
	  			  success: function(data){
	  					if(!data){
	  						if(!$( "#" +idTag+"File").attr('hadFinished')){
		  						$( "#" +idTag+"Label" ).text( "准备上传......" );
	  						}
	  					}else{
		  					var readedBytes = parseInt(data['readedBytes']);
		  					var totalBytes = parseInt(data['totalBytes']);
	  						if(data['state'] == '2' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,readedBytes,totalBytes);
	  							$( "#" +idTag+"File").attr('hadFinished',true);
	  							$( "#" +idTag+"Upload").attr("disabled",true);
	  							$( "#" +idTag+"File").attr("disabled",true);
	  							$( "#" +idTag+"Clear").attr("disabled",true);
			  				}else if(data['state'] == '1' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,0,0);
			  					$( "#" +idTag+"Upload").removeAttr("disabled");
			  					$( "#" +idTag+"Label"  ).text( "上传出错!" );
			  				}else if(data['state'] == '4' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,0,0);
			  					$( "#" +idTag+"Label"  ).text( data['statusMsg']);
			  				}else if(data['state'] == '3' ){
			  					clearInterval(uploadInterval[idTag]);
			  					progressbar(idTag,0,0);
			  					var errorHtml = '<span class="">文件限制上传,您只能上传[{0}]!</span>';
			  					$('#'+idTag+'Upload').removeAttr('disabled');
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
//        		var type = "${type}";
			
			var type = window.parent.uploadFileParams.type;
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
					Sfxie.Thread.sleep(2);
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
       		var maxFileNumber = window.parent.uploadFileParams.maxFileNumber;
       		if($('div[name="DivContentName"]') && (maxFileNumber <= $('div[name="DivContentName"]').length)){
       			alert('您最多能添加'+maxFileNumber+'个文件！');
       			return ;
       		}
       		var idTag = ''+new Date().getTime();
   			var formString = createForm(idTag);
   			$('#contentId').append($(formString));
   			uploadForm(idTag);
       	}
       	function initFileTip(){
       		var validations = window.parent.uploadFileParams.validations;
       		var maxLength = window.parent.uploadFileParams.maxLength;
       		var text = '';
       		if(maxLength){
       			var text = '上传文件最大限制：'+(maxLength/1024)+'MB; ';
       		}
       		if(validations && validations.length>0){
       			var text = text+'上传文件格式：'+validations.join(',');
       		}
       		$('#fileTipId').text(text);
       	}
	</script>
</head>
<body>

	<div class="ajaxUpload-close">
		<!-- <input type="button" value="关   闭" onclick="closeWin()"  alt="关闭窗体" style="width:120px;font-size:14px;"/>&nbsp; -->
		<input type="button" id="addFileFormBTN" value="添加文件" onclick="addFileForm()" alt="添加文件" />&nbsp;
		<span id="fileTipId" style="font-size: 10px;color: red;"></span>
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
