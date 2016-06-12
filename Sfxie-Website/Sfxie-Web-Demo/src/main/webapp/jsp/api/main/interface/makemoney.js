
apiRootArray.push({
	name:'赚钱模块',
	id:'makemoney',
	developer:"谢声锋"
});

apiArray.push({
	parentId:'makemoney',
	name:'获取赚钱广告列表',
	id:'getAdMakeMoneyList',
	url:'/api3/makemoney/getAdMakeMoneyList',
	type:'POST',
	xmlParam:'params/common/Request.json',
	developer:"谢声锋"
});
apiArray.push({
	parentId:'makemoney',
	name:'获取试题列表',
	id:'getAdQuestionList',
	url:'/api3/makemoney/getAdQuestionList',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋"
});
apiArray.push({
	parentId:'makemoney',
	name:'试题判断',
	id:'judgeAdQuestionAnswer',
	url:'/api3/makemoney/judgeAdQuestionAnswer',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋"
});
apiArray.push({
	parentId:'makemoney',
	name:'汇报奖励',
	id:'renderAdReward',
	url:'/api3/makemoney/renderAdReward',
	type:'POST',
	fileType:'xml',
	developer:"谢声锋"
});


