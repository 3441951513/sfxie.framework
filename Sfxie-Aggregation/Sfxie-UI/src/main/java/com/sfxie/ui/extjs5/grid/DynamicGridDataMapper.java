package com.sfxie.ui.extjs5.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfxie.ui.extjs5.grid.entity.ColumnEntity;
import com.sfxie.ui.extjs5.grid.entity.FieldEntity;
import com.sfxie.ui.extjs5.i18n.Extjs5I18nHolder;
import com.cniemp.utils.ReflectUtils;
import com.cniemp.utils.StringUtils;


/**
 * 
 * @author XIESHENGFENG
 * 此类用于动态表格的各种数据的包装，
 * 通过包装生成正确的前台动态表格组件所需的数据
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class DynamicGridDataMapper {
	
	/**
	 * 把数据转化成符合动态表格的加载数据格式
	 * @param map
	 * @param records
	 */
	public static void mapRecords(Map map,List records,Integer totalCount){
		if(null==map.get("data"))
			map.put("data", new HashMap());
		((Map) map.get("data")).put("records", records);
		((Map) map.get("data")).put("totalCount", totalCount);
		map.put("success", true);
	}
	/**
	 * 把数据转化成符合动态表格初始化数据格式(构造表头)
	 * @param map
	 * @param records
	 */
	public static void mapConstructs(Map map,List<Map<String,Object>> fields,List<Object> columns,Class cls){
		if(null==map.get("data"))
			map.put("data", new HashMap());
		//((Map) map.get("data")).put("columns", columns);
		((Map) map.get("data")).put("dtoName", null!= cls ?cls.getSimpleName():"none");
		((Map) map.get("data")).put("fields", fields);
		
	}
	/**
	 * 构造extjs4动态列表数据，包括列头、数据
	 * @param dtoCls
	 * @param queryPager
	 * @param paramMap
	 * @return
	 */
	public static Map<String,Object> createDataConstructs(Class dtoCls,QueryPager queryPager,Map paramMap){
		
		Map<String,Object> data = new HashMap<String,Object> ();
		//用户对应的国际化语言
		String language = (String) paramMap.get("language");
		
		List<String> usingFields = (List<String>) paramMap.get("usingFields");
		boolean forceFit = (Boolean) paramMap.get("forceFit");
		Map<String,Boolean> usingFieldsMap = new HashMap<String,Boolean>();
		if(null!=usingFields)
			for(String field : usingFields){
				usingFieldsMap.put(field, true);
			}
		Map metaData = new HashMap();
		List<ColumnEntity> columns = new ArrayList<ColumnEntity>();
		List<Map> fieldsDtoMap = new ArrayList<Map>();
		List<FieldEntity> fields = new ArrayList<FieldEntity>();
		fieldsDtoMap = (List<Map>) Extjs5I18nHolder.getExtjs5I18nInfo(dtoCls).get("fields");
		List<Map<String,Object>> dtoAllFields = new ArrayList<Map<String,Object>>();		
		ReflectUtils.getBeanAllFieldAndFieldType(dtoAllFields,dtoCls, null, "name", "type");
		for(Map map : fieldsDtoMap){
			if(map.get("type").toString().equals("date")){
				map.put("type", "string");
				map.put("date", true);
			}
		}
		if(null!=usingFields && usingFields.size()>0){
			for(String usingField : usingFields){
				for(Map map : fieldsDtoMap){
					FieldEntity fieldEntity = new FieldEntity();
					fieldEntity.setName(map.get("name").toString());
					fieldEntity.setType(map.get("type").toString());
					if(map.get("type").toString().equals("date")){
						fieldEntity.setType("string");
						fieldEntity.setDate(true);
						fieldEntity.setSortType(null!=map.get("sortType")?map.get("sortType").toString():null);
					}
					fields.add(fieldEntity);
					
					
//					fieldEntity.setType("string");
//					fieldEntity.setDate(true);
//					fieldEntity.setSortType(null!=map.get("sortType")?map.get("sortType").toString():null);
					//如果用户在extjs4的view中配置了usingFields数组，执行此if语句
					if(usingField.equals(map.get("name"))){	
						ColumnEntity columnEntity = new ColumnEntity();
						if(null!=map.get("comboName")){
							columnEntity.setComboName(map.get("comboName").toString());
							columnEntity.setComboType(map.get("comboType").toString());
						}
						columnEntity.setDataIndex(map.get("name").toString());
						Object titleMap = map.get("title");
						if(null!=titleMap){
							if(titleMap instanceof Map)
								columnEntity.setHeader(null!=paramMap.get("i18nLanguage")?((Map)titleMap).get(paramMap.get("i18nLanguage")).toString():map.get("name").toString());
							else
								columnEntity.setHeader(StringUtils.isEmpty(titleMap.toString())?map.get("name").toString():titleMap.toString());
						}
						columnEntity.setType(map.get("type").toString());
						columnEntity.setTip((Boolean)map.get("tip"));
						if(null!=map.get("editor"))
							columnEntity.setEditor(map.get("editor").toString());
						if (forceFit) {
							columnEntity.setFlex(null!=map.get("flex")?(Integer)map.get("flex"):1);
		                }
						if(map.get("type").toString().equals("date")){
							columnEntity.setType("string");
							columnEntity.setDate(true);
						}
						columns.add(columnEntity);
						break;
					}
				}
			}
			
		}
		//如果用户在extjs4的view中没有配置usingFields数组，执行此else语句
		else{
			for(Map map : fieldsDtoMap){
				FieldEntity fieldEntity = new FieldEntity();
				fieldEntity.setName(map.get("name").toString());
				fieldEntity.setType(map.get("type").toString());
				if(map.get("type").toString().equals("date")){
					fieldEntity.setType("string");
					fieldEntity.setDate(true);
					fieldEntity.setSortType(null!=map.get("sortType")?map.get("sortType").toString():null);
				}
				fields.add(fieldEntity);
				
				if(map.get("type").toString().equals("date")){
					for(Map f : fieldsDtoMap){
						if(f.get("name").equals(map.get("name").toString())){
							f.put("type", "string");
							f.put("date", true);
							break;
						}		
					}
					
				}
				if(null != map.get("sortType")){
					for(Map f : fieldsDtoMap){
						if(f.get("name").equals(map.get("name").toString())){
							f.put("sortType", map.get("sortType").toString());
						}		
					}
					
				}
				ColumnEntity columnEntity = new ColumnEntity();
				if(null!=map.get("comboName")){
					columnEntity.setComboName(map.get("comboName").toString());
					columnEntity.setComboType(map.get("comboType").toString());
				}
				columnEntity.setDataIndex(map.get("name").toString());
				Object titleMap = map.get("title");
				if(null!=titleMap){
					if(titleMap instanceof Map)
						columnEntity.setHeader(null!=paramMap.get("i18nLanguage")?((Map)titleMap).get(paramMap.get("i18nLanguage")).toString():map.get("name").toString());
					else
						columnEntity.setHeader(titleMap.toString());
				}
				if(null!=map.get("editor"))
					columnEntity.setEditor(map.get("editor").toString());
				columnEntity.setType(map.get("type").toString());
				columnEntity.setTip((Boolean)map.get("tip"));
				if (forceFit){
					columnEntity.setFlex(null!=map.get("flex")?(Integer)map.get("flex"):1);
                }
				if(map.get("type").toString().equals("date")){
					columnEntity.setType("string");
					columnEntity.setDate(true);
				}
				columns.add(columnEntity);
			}
		}
		metaData.put("fields", fieldsDtoMap);
		metaData.put("columns", columns);
		data.put("metaData", metaData);
		data.put("records", queryPager.getResult());
		data.put("totalCount", queryPager.getTotalCount());
		data.put("success", true);
		return data;
	}
	/**
	 * 构造extjs4动态列表数据，包括列头、数据
	 * @param dtoCls
	 * @param queryPager
	 * @param paramMap
	 * @return
	 */
	public static Map<String,Object> createDataConstructsForJdbc(Class dtoCls,QueryPager queryPager,Map paramMap){
		
		
		return null;
	}
	/**
	 * 构造extjs4动态列表数据，包括列头、数据
	 * @param dtoCls
	 * @param queryPager
	 * @param paramMap
	 * @return
	 */
	/*public static Map<String,Object> createDataConstructs(QueryPager queryPager ){
		Map<String,Object> data = new HashMap<String,Object> ();
//		List<String> usingFields = (List<String>) paramMap.get("usingFields");
//		boolean forceFit = (Boolean) paramMap.get("forceFit");
		Map metaData = new HashMap();
		List<ColumnEntity> columns = new ArrayList<ColumnEntity>();
		List<Map> fieldsDtoMap = new ArrayList<Map>();
		
		
//		List<Map<String,Object>> dtoAllFields = new ArrayList<Map<String,Object>>();		
//		ReflectUtils.getBeanAllFieldAndFieldType(dtoAllFields,dtoCls, null, "name", "type");
		//
		metaData.put("fields", fieldsDtoMap);
		metaData.put("columns", columns);
		data.put("metaData", metaData);
		data.put("records", queryPager.getResult());
		data.put("totalCount", queryPager.getTotalCount());
		data.put("success", true);
		return data;
	}*/
}
