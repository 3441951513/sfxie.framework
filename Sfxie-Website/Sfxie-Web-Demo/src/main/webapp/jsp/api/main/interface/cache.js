//帮助接口
apiRootArray.push({
	name:'刷新缓存',
	id:'cache',
	isCache:true
});

apiArray.push({
	parentId:'cache',
	name:'刷新广告缓存',
	id:'refleshAd',
	url:'/api3/cache/reflesh/ad',
	type:'POST'
});
apiArray.push({
	parentId:'cache',
	name:'刷新系统配置缓存',
	id:'refleshSysConfigInit',
	url:'/api3/cache/reflesh/sysConfigInit',
	type:'POST'
});
apiArray.push({
	parentId:'cache',
	name:'刷新主配置',
	id:'refleshMainConfigInit',
	url:'/api3/cache/reflesh/mainConfigInit',
	type:'POST'
});
apiArray.push({
	parentId:'cache',
	name:'刷新商品列表',
	id:'refleshGoodsInit',
	url:'/api3/cache/reflesh/goodsInit',
	type:'POST'
});