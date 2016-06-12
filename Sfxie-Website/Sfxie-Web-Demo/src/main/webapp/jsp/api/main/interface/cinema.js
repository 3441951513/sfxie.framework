//院线接口
apiRootArray.push({
	name:'院线模块',
	id:'cinema',
	developer:"谢声锋"
});

apiArray.push({
	parentId:'cinema',
	name:'获取院线电影列表',
	id:'getCinemaFilmList',
	url:'/api3/cinema/getCinemaFilmList',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋",
	deprecated:false
});