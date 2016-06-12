package com.sfxie.soa.modules.dubbo.service.provider.rest;


import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.sfxie.soa.modules.dubbo.service.provider.pojo.Entity;


@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Path("testRestful")
public interface RestfulService {
	@GET
	@Path("getEntity")
	public Entity getEntity( );
	@GET
    @Path("{id : \\d+}")
	public Entity getUser(@PathParam("id") @Min(value=1L, message="User ID must be greater than 1") Long id/*, HttpServletRequest request*/);

}