package com.sfxie.core.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import com.sfxie.utils.ReflectUtils;




/**
 * DTO基类.
 * 
 * @author xieshengfeng
 * 
 */
public class BaseDTO extends BaseDataObject {
	/**
	 * 不复制的属性.
	 */
	private static final String NOT_COPY_FIELD = "serialVersionUID";
	
	/**
	 * 复制DTO对象属性值到entity对象.
	 * @param dto
	 * @param entity
	 */
	public void dtoToEntity(BaseDTO dto, BaseEntity entity) {
		copyObjectPropertys(dto, entity);
	}

	/**
	 * 复制entity对象属性值到DTO对象.
	 * @param entity
	 * @param dto
	 */
	public void entityToDTO(BaseEntity entity, BaseDTO dto) {
		copyObjectPropertys(entity, dto);
	}
	
	/**
	 * 复制对象属性值，支持不同对象之间的属性值复制.
	 * 
	 * @param src
	 *             复制源.
	 * @param des
	 *             复制目标.
	 */
	public void copyObjectPropertys(Object src, Object des) {
		Collection<Field> fields = new ArrayList<Field>();
				ReflectUtils.getBeanAllFields(fields,src.getClass(),null);
		//取复制源所有属性字段.
        Field[] srcfields = new Field[fields.size()];
        fields.toArray(srcfields);//src.getClass().getDeclaredFields();
        //将复制源的数据复制到复制目标.
		for (Field field : srcfields) {
			final String fieldName = field.getName();
			//复制目标不存在的属性不处理.
			if (!fieldName.equals(NOT_COPY_FIELD) && ReflectUtils.hasField(des, fieldName)) {
				Object object = ReflectUtils.getFieldValue(fieldName, src);
				ReflectUtils.setFieldValue(des, fieldName, object);
			}
		}
	}
	/**
	 * 复制对象的不为空的属性值，支持不同对象之间的属性值复制.
	 * 
	 * @param src
	 *             复制源.
	 * @param des
	 *             复制目标.
	 */
	public void copyObjectNotNullPropertys(Object src, Object des) {
		//取复制源所有属性字段.
        Field[] srcfields = src.getClass().getDeclaredFields();
        //将复制源的数据复制到复制目标.
		for (Field field : srcfields) {
			final String fieldName = field.getName();
			//复制目标不存在的属性不处理.
			if (!fieldName.equals(NOT_COPY_FIELD) && ReflectUtils.hasField(des, fieldName)) {
				Object object = ReflectUtils.getFieldValue(fieldName, src);
				if(null!=object && !object.toString().equals(""))
					ReflectUtils.setFieldValue(des, fieldName, object);
			}
		}
	}
}
