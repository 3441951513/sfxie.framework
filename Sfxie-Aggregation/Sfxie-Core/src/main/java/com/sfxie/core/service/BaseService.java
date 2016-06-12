package com.sfxie.core.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务基类,继承此类的服务类已经被事务控制.
 * 
 * @author XIESHENGFENG
 * @since 2013-06-23
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
public class BaseService {
}
