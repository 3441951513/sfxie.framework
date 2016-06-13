//帮助接口
apiRootArray.push({
	name:'中心管理系统',
	id:'cm',
	isCache:false
});

apiArray.push({
	parentId:'cm',
	name:'用户登录',
	id:'login',
	url:'/cm/login',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	interceptor:dubboExceptionInterceptor
});
apiArray.push({
	parentId:'cm',
	name:'用户注销',
	id:'logout',
	url:'/cm/logout',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	interceptor:dubboExceptionInterceptor
});
apiArray.push({
	parentId:'cm',
	name:'用户注册',
	id:'register',
	url:'/cm/register',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	interceptor:dubboExceptionInterceptor
});