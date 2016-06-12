package com.qycloud.oatos.ty.department;

import javax.jws.WebService;


@WebService
public interface DepartmentService {
	
	boolean updateTheOrg(String org);
	
	boolean updateOrgsCode(String org);

}
