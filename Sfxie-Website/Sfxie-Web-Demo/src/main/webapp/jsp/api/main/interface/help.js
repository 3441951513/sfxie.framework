//帮助接口
apiRootArray.push(
		{
		    name:'帮助',
		    id:'help'
		}
);

apiArray.push({
    parentId:'help',
    name:'获取产品指南',
    id:'getUserGuide',
    url:'/help/getUserGuide',
    type:'POST',
    xmlParam:'',
	developer:"喻龙斌"
}
);