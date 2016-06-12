var SfxieFramework = new Object();
(function(S){
	S.VERSION = "1";
})(SfxieFramework);


SfxieFramework.Request = new Object();
(function(R){
	R.ajax = function(configs){
		var config = {
			type:"post",
			async:true
		};
		$.extend(true, config, configs);
		$.ajax(config);
	};
})(SfxieFramework.Request);



/*<?xml version="1.0" encoding="utf-8"?>
<request website="http://xxxx" pro_version="0.0.1" app_version="0.0.1">
	<parameter iname="getLotteryEntranceInfo" apktype="1"		language="zh" region="CN">
		<device dnum="120799599" didtoken="a12eacf12213" devmodel="rtd299x_tv030"			dver="x" devtype="1" clienttype="TCL-CN-RT95-E5700M-UDM" mac="408BF6F92D2E"			deviceid="" />
		<user userid="10114" token="a213" />
	</parameter>
</request>*/