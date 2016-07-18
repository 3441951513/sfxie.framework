package com.sfxie.extension.mybatis.template;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * mybatis模板抽象类
 * @author xiesf
 * @since 2016-07-18
 *
 */
@Repository
public abstract class MybatisTemplate {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void clearCache() {
		sqlSessionTemplate.clearCache();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Object selectOne(String statement) {
		return this.sqlSessionTemplate.selectOne(statement);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Object selectOne(String statement, Object parameter) {
		return this.sqlSessionTemplate.selectOne(statement, parameter);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Map<?, ?> selectMap(String statement, String mapKey) {
		
		return this.sqlSessionTemplate.selectMap(statement, mapKey);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Map<?, ?> selectMap(String statement, Object parameter, String mapKey) {
		return this.sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Map<?, ?> selectMap(String statement, Object parameter,
			String mapKey, RowBounds rowBounds) {
		return this.sqlSessionTemplate.selectMap(statement, parameter, mapKey,
				rowBounds);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<?> selectList(String statement) {
		return this.sqlSessionTemplate.selectList(statement);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<?> selectList(String statement, Object parameter) {
		return this.sqlSessionTemplate.selectList(statement, parameter);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<?> selectList(String statement, Object parameter,
			RowBounds rowBounds) {
		return this.sqlSessionTemplate.selectList(statement, parameter,
				rowBounds);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void select(String statement, ResultHandler handler) {
		this.sqlSessionTemplate.select(statement, handler);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void select(String statement, Object parameter, ResultHandler handler) {
		this.sqlSessionTemplate.select(statement, parameter, handler);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler) {
		this.sqlSessionTemplate
				.select(statement, parameter, rowBounds, handler);
	}

	public int insert(String statement) {
		return this.sqlSessionTemplate.insert(statement);
	}

	public int insert(String statement, Object parameter) {
		return this.sqlSessionTemplate.insert(statement, parameter);
	}

	public int update(String statement) {
		return this.sqlSessionTemplate.update(statement);
	}

	public int update(String statement, Object parameter) {
		return this.sqlSessionTemplate.update(statement, parameter);
	}

	public int delete(String statement) {
		return this.sqlSessionTemplate.delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return this.sqlSessionTemplate.delete(statement, parameter);
	}

}
