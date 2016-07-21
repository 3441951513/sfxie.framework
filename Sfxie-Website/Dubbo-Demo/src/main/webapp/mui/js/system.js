(function(own){
	
	var SfxieMui = new Object();
	SfxieMui.ajax = _$ajax;
	
	function _$ajax(configs){
		var _configs = {
			dataType:'json',//服务器返回json格式数据
			type:'post',//HTTP请求类型
			timeout:10000,//超时时间设置为10秒；
			headers:{'Content-Type':'application/json'}	,              
			success:function(data){
				//服务器返回响应，根据响应结果，分析是否登录成功；
			},
			error:function(xhr,type,errorThrown){
				//异常处理；
			}
		};
		mui.extend(_configs,configs);
		mui.ajax(_configs.url,_configs);
	}
	/**
	 * 判断是否已经登录成功，否的话就跳转到登录页面
	 */
	function judgelogin() {
		//测试语句
		localStorage.removeItem('user');
		//判断是否已经登录成功//localstorage在页面关闭的时候也同样存在，sessionstorage页面关闭数据不存在
		if (!localStorage.getItem('user')) {
			console.log('judgelogin');
			var loginView = mui.preload({
				url:'mine/login.html',
				id:'mine/login.html',
				styles:{
					top:'0px',
					bottom:'0px'
				}
			});
			loginView.show();
		}
	}
	
})(window);
