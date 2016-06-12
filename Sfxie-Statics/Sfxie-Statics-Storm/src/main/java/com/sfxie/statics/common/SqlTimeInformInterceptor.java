package com.sfxie.statics.common;


import com.sfxie.extension.logger.level.mail.MailLogger;
import com.sfxie.extension.mybatis.inform.IInformInterceptor;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.jacson.fasterxml.JsonUtil;

/**
 * sql执行时间监控报警拦截器
 * 
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:29:15 2016年3月17日
 * @example		
 * 		{"操作类型":"query","操作时间":"2016年03月17日 下午 15时28分10秒","摘要":"执行时间过长","执行时间":"3.645秒","sql语句":"select g.model from g_ad3_goods g where g.id =  1 "}
 *
 */
public class SqlTimeInformInterceptor implements IInformInterceptor {

	/**	select语句达到发邮件报警的限制时间	*/
	private Long selectWarmLimitedTime;
	/**	update语句达到发邮件报警的限制时间	*/
	private Long updateWarmLimitedTime;
	@Override
	public boolean canIntercepted(String type, Long startTimeMillionSecord,
			Long endTimeMillionSecord) {
		if(type.equals("query")){
			if((endTimeMillionSecord-startTimeMillionSecord)>getSelectWarmLimitedTime()){
				return true;
			}
		}else if(type.equals("update")) {
			if((endTimeMillionSecord-startTimeMillionSecord)>getUpdateWarmLimitedTime()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean inform(String type, String sql,
			Long startTimeMillionSecord, Long endTimeMillionSecord) {
		MailEntity mailEntity = new MailEntity();
		mailEntity.set操作类型(type);
		mailEntity.set摘要("执行时间过长");
		mailEntity.set执行时间((endTimeMillionSecord - startTimeMillionSecord));
		mailEntity.setSQL语句(sql);
//		mailEntity.set参数集合(params);
		MailLogger.mailError(MailLogger.class, JsonUtil.toJson(mailEntity).replaceAll("\\\\n", " ").replaceAll("\\\\t", " "));
		return true;
	}
	
	public Long getSelectWarmLimitedTime() {
		return null!=selectWarmLimitedTime?selectWarmLimitedTime:500;
	}

	public void setSelectWarmLimitedTime(Long selectWarmLimitedTime) {
		this.selectWarmLimitedTime = selectWarmLimitedTime;
	}

	public Long getUpdateWarmLimitedTime() {
		return null!=updateWarmLimitedTime?updateWarmLimitedTime:500;
	}

	public void setUpdateWarmLimitedTime(Long updateWarmLimitedTime) {
		this.updateWarmLimitedTime = updateWarmLimitedTime;
	}
	
	class MailEntity{
		private String 操作环境;
		private String 操作类型;
		private String 操作时间;
		private String 摘要;
		private String 执行时间;
		private String  SQL语句;
//		private Object 参数集合;
		
		
		public String get操作环境() {
			if(Context.getEnviroment().equals("product")){
				return "生产";
			}else if(Context.getEnviroment().equals("test")){
				return "测试";
			}else
				return "开发";
		}
		public String get操作类型() {
			return 操作类型;
		}
		public void set操作类型(String 操作类型) {
			this.操作类型 = 操作类型;
		}
		
		public String get操作时间() {
			return DateHelper.getChineseTime();
		}
		public String get摘要() {
			return 摘要;
		}
		public void set摘要(String 摘要) {
			this.摘要 = 摘要;
		}
		public String get执行时间() {
			return 执行时间;
		}
		public void set执行时间(Long 执行时间) {
			this.执行时间 = String.valueOf(执行时间/1000f)+"秒";
		}
		public String getSQL语句() {
			return SQL语句;
		}
		public void setSQL语句(String sQL语句) {
			SQL语句 = sQL语句;
		}
		
	}
	
	
}
