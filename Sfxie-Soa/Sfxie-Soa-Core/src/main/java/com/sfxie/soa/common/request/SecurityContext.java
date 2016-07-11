package com.sfxie.soa.common.request;



public class SecurityContext {
	/*public static SfxieSysUserinfo getCurrentSfxieSysUserinfo (){
		SfxieSysUserinfo user = new SfxieSysUserinfo();
		user.setCreate_company_id("00000000");
		user.setUser_id("13246779797");
		user.setUser_password("c5ae2f85bddb68f84a6bfebf97020ca7"); //13246779797
		return user;
	}*/
	
	
	
	public static SecurityUser getSecurityUser(){
		
		//测试时的代码
		return new SecurityUser(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getUserId() {
				return "13246779797";
			}

			@Override
			public String getUserPassword() {
				return "c5ae2f85bddb68f84a6bfebf97020ca7";
			}

			@Override
			public String getOrgId() {
				return "00000000";
			}};
	}
	
}

