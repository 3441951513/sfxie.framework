package com.sfxie.ui.extjs5.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.sfxie.ui.extjs5.annotation.ExtjsGridDataHandle;
import com.sfxie.ui.extjs5.grid.entity.ColumnEntity;
import com.sfxie.ui.extjs5.grid.entity.FieldEntity;
import com.sfxie.ui.extjs5.i18n.Extjs5I18nHolder;
import com.sfxie.ui.extjs5.mybatis.MybatisQueryConditionThreadLocal;
import com.cniemp.utils.ReflectUtils;
import com.cniemp.utils.StringUtils;


@ControllerAdvice
public class ExtjsController implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType,
			MediaType selectedContentType, Class selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		ExtjsGridDataHandle extjsGridDataHandle = returnType.getMethod().getAnnotation(ExtjsGridDataHandle.class);
		if(null!=extjsGridDataHandle){
			return createDataConstructs(body);
		}
		return body;
	}
	/*@RequestMapping(params = "method=getOperatorList",method = RequestMethod.POST)
	public  @ResponseBody Object getOperatorList(@RequestParam("limit")Integer limit,@RequestParam("start")Integer start,
			@RequestParam("otherParamMap")String otherParamMap,@RequestParam("queryCondition")String queryCondition){
		
//		List<SysFunctionDTO> sysFunctionList = this.menuServiceImpl.getSysFunctionChildList(parentFunctionNo);
		Map paramMap = JSONUtil.fromJSON(otherParamMap, Map.class);
		List<DynamicGridQueryEntity> filter = PageQeruyHepler.createConditions(queryCondition);
		String sql = SqlConstants.query_operator;
		QueryPager queryPager = this.pageQueryServiceImpl.queryList(filter, sql, start, limit, OperatorDTO.class);
		return DynamicGridDataMapper.createDataConstructs(OperatorDTO.class, queryPager,paramMap);
	}*/
	
	/**
	 * 构造extjs4动态列表数据，包括列头、数据
	 * @param dtoCls
	 * @param queryPager
	 * @param paramMap
	 * @return
	 */
	private static Map<String,Object> createDataConstructs(Object result){
		
		Class dtoCls = MybatisQueryConditionThreadLocal.get().getEntityClass();
		Map<String,Object> data = new HashMap<String,Object> ();
		//用户对应的国际化语言
//		String language = MybatisQueryConditionThreadLocal.get().getI18nLanguage();
		String language = "ZH-CN";
		
		List<String> usingFields = MybatisQueryConditionThreadLocal.get().getUsingFields();
		System.out.println(MybatisQueryConditionThreadLocal.get());
		boolean forceFit = MybatisQueryConditionThreadLocal.get().getForceFit();
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
					if(map.get("type").toString().equals("long")){
						fieldEntity.setType("number");
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
								columnEntity.setHeader(null!=language?((Map)titleMap).get(language).toString():map.get("name").toString());
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
						if(map.get("type").toString().equals("long")){
							columnEntity.setType("number");
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
				if(map.get("type").toString().equals("long")){
					map.put("type","number");
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
						columnEntity.setHeader(null!=language?((Map)titleMap).get(language).toString():map.get("name").toString());
					else
						columnEntity.setHeader(titleMap.toString().equals("")?map.get("name").toString():titleMap.toString());
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
				if(map.get("type").toString().equals("long")){
					columnEntity.setType("number");
				}
				columns.add(columnEntity);
			}
		}
		metaData.put("fields", fieldsDtoMap);
		metaData.put("columns", columns);
		data.put("metaData", metaData);
		data.put("records", result);
		data.put("totalCount", MybatisQueryConditionThreadLocal.get().getTotal());
		data.put("success", true);
		return data;
	}
}
