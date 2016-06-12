package com.qycloud.oatos.ty.user;

import javax.jws.WebService;


@WebService
public interface UserService {
	
	public boolean updateTheUser(String user);
	
	public boolean updateUsersCode(String user);
	
}
