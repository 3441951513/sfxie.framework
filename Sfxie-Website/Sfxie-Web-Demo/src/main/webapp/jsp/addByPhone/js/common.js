var Verify = {
	mobileReg : /^1[34578]\d{9}$/,
	mobileErrorText : "请填写正确的手机号码",
	codeLength : 4,
	codeErrorText : "请填写4位验证码"
}

var WebSite = {
	init : function(){
		$(".form-must").val("");
		$(".form-btn").removeAttr("disabled");
		
		$(".form-must").on("input change blur keyup",function(){
			var _self = $(this);
			if($.trim(_self.val())==""){
				_self.siblings(".form-alert").html(_self.attr("placeholder"));
				_self.siblings(".form-alert").show();
			}
			else{
				switch(_self.attr("id")){
					case "userMobile":
						if(!Verify.mobileReg.test($.trim(_self.val()))){
							_self.siblings(".form-alert").html(Verify.mobileErrorText);
							_self.siblings(".form-alert").show();
						}
						else{
							_self.siblings(".form-alert").html("");
							_self.siblings(".form-alert").hide();
						}
						break;
					case "userCode":
						if(($.trim(_self.val())).length<Verify.codeLength){
							_self.siblings(".form-alert").html(Verify.codeErrorText);
							_self.siblings(".form-alert").show();
						}
						else{
							_self.siblings(".form-alert").html("");
							_self.siblings(".form-alert").hide();
						}
						break;
					default : 
						_self.siblings(".form-alert").html("");
						_self.siblings(".form-alert").hide();
						break;	
				}
			}
		});
		
		$("#btnCode").on("click",function(){
			$("#userMobile").change();
			if($("#userMobile").siblings(".form-alert").css("display")=="none"){
				$("#btnCode").prop("disabled",true);
				$.ajax({
					url : lhqURL+"/springmvc/addByPhone/register/sendDynamicPwd",
					type : "post",
			        data : {phone:$("#userMobile").val()},
			        dataType : 'json',
					success: function(data){
						//console.log(data);
						if(data.state == '1'){
							var againTime = 60;
							var timeInterval = setInterval(function(){
								againTime--;
								$("#btnCode").val(againTime);
								if(againTime==0){
									$("#btnCode").val("获取验证码");
									$("#btnCode").removeAttr("disabled");
									$("#btnCode").removeClass("btn-disalbed");
									clearInterval(timeInterval);
								}
							},1000);
							$("#btnCode").val(againTime);
							$("#btnCode").addClass("btn-disalbed");
							alert("验证码已发送至您手机,请注意接收!");
						}else{
							if(data.msg != '' && typeof(data.msg) != 'undefined'){
								alert(data.msg);
							}else{
								alert("发送失败,请联系管理员!")
							}
							$("#btnCode").removeAttr("disabled");
						}
					},
					error:function(){
						alert("系统异常,请联系管理员!")
						$("#btnCode").removeAttr("disabled");
					}	
				})	
			}
			else{
				alert($("#userMobile").siblings(".form-alert").html());
			}
		})
		
		$(".item-head").on("click",function(){
			$(".item-head").removeClass("item-head-sel");
			$(this).addClass("item-head-sel");
		})
		
		$("#btnSubmit").on("click",function(){
			$(".form-must").blur();
			if($(".form-alert:visible").length==0){
				return true;	
			}
			return false;	
		})
	}	
}

$(function(){
	WebSite.init();
})