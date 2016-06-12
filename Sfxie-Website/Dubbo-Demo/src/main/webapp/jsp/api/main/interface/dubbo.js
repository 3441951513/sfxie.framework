//帮助接口
apiRootArray.push({
	name:'dubbo架构测试',
	id:'dubbo',
	isCache:false
});

apiArray.push({
	parentId:'dubbo',
	name:'业务异常测试',
	id:'exception',
	url:'/dubbo/test/exception',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	interceptor:dubboExceptionInterceptor
});
apiArray.push({
	parentId:'dubbo',
	name:'rest功能测试',
	id:'rest',
	url:'/dubbo/test/rest',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	interceptor:dubboExceptionInterceptor
});

