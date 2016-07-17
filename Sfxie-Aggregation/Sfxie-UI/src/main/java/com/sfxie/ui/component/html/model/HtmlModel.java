package com.sfxie.ui.component.html.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlContent;
import com.sfxie.ui.component.base.model.ComponentModel;
import com.sfxie.ui.component.base.model.EventModel;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.html.visitor.HtmlDefaultModelVisitor;
import com.sfxie.utils.CollectionUtil;
import com.sfxie.utils.ReflectUtils;
import com.sfxie.utils.StringUtils;

/**
 * html标签实体模型基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午9:06:14 2015年9月17日
 * @example		
 *
 */
public class HtmlModel extends ComponentModel   implements Comparable<HtmlModel>{
	
	public HtmlModel(){
		this._uuid = UUID.randomUUID().toString();
	}
	
	private HtmlModelVisitor htmlModelVisitor;
	/**	标签顺序	*/
//	protected int order;
	
//	public static String css = "thumbnail sfxie-mainpage-thumbnail";
	/**	主样式名称	*/
	private String css;
	/** 额外样式名称	*/
	protected String additionCss ;
	/**	事件列表	*/
	private List<EventModel> eventList;
	/** html元素的title属性*/
	private String title;
	/** html元素的style属性*/
	private String style;
	/** 元素的内容*/
	private String content;
	/** 元素的高度*/
	private String height;
	/** 元素的宽度*/
	private String width;
	/** 子标签内容	*/
//	private List<HtmlModel> child;
	
	private String id;
	
	public Set<HtmlModel> child ;
	
	private Integer order;
	
	private String _uuid;

	@HtmlAttribute(name="class",additionalMethod={"getAdditionCss"})
	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getAdditionCss() {
		return additionCss;
	}

	public void setAdditionCss(String additionCss) {
		this.additionCss = additionCss;
	}

	public List<EventModel> getEventList() {
		return eventList = CollectionUtil.nullRetureNewList(eventList);
	}

	public void setEventList(List<EventModel> eventList) {
		this.eventList = eventList;
	}
	@HtmlAttribute
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@HtmlAttribute
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@HtmlContent
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@HtmlAttribute
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	@HtmlAttribute
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 生成整个html标签字符串
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:33:11 2015年9月17日
	 * @return	
	 *
	 */
	public String html(){
		return getHtmlModelVisitor().visit(this);
	}
	/**
	 * 生成标签属性字符串
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:32:58 2015年9月17日
	 * @return	
	 *
	 */
	public String attributes(){
		List<Method> list = new ArrayList<Method>();
		List<Class<?>> classList = new ArrayList<Class<?>>();
		ReflectUtils.getBeanAllMethods(list,this.getClass() ,classList , null);
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<list.size();i++){
			Method method = list.get(i);
			 try {
				HtmlAttribute htmlAttribute = method.getAnnotation(HtmlAttribute.class);
				if(null!=htmlAttribute){
					Object o = list.get(i).invoke(this);
					String value = htmlAttribute.value();
					String attrName = method.getName().replaceFirst("get", "");
					attrName = attrName.replaceFirst(String.valueOf(attrName.charAt(0)), (String.valueOf(attrName.charAt(0))).toLowerCase());
					String name = htmlAttribute.name();
					if(name.equals("")){
						name = attrName;
					}
					if((null!=o && !o.toString().equals("")) || !value.equals("")){
						sb.append(name).append("=\"");
						//处理class属性
						if(htmlAttribute.name().equals("class")){
							Object defaultClass = ReflectUtils.getFieldValue("defaultClass", this);
							if(null!=defaultClass && StringUtils.isNotEmpty(defaultClass.toString())){
								sb.append(defaultClass).append(" ");
							}
						}
						if(null!=o && !o.toString().equals("")){
							sb.append(o);
						}else{
							sb.append(value);
						}
						String[] additionalMethod = htmlAttribute.additionalMethod();
						if(additionalMethod.length>0){
							for(int h=0;h<additionalMethod.length;h++){
								attrName = additionalMethod[h].replaceFirst("get", "");
								attrName = attrName.replaceFirst(String.valueOf(attrName.charAt(0)), (String.valueOf(attrName.charAt(0))).toLowerCase());
								o = ReflectUtils.getFieldValue(attrName, this);
								if(null!=o && !o.equals("")){
									sb.append(" ").append(o);
								}
							}
						}
						sb.append("\" ");
					}else{
						//处理class属性
						if(htmlAttribute.name().equals("class")){
							Method defaultClassMethod = this.getClass().getMethod("defaultClass", null);
							Method additionCssMethod = this.getClass().getMethod("getAdditionCss", null);
							o = defaultClassMethod.invoke(this, null);
							if(null!=o && StringUtils.isNotEmpty(o.toString())){
								sb.append("class").append("=\"").append(o);
								o = additionCssMethod.invoke(this, null);
								if(null!=o && StringUtils.isNotEmpty(o.toString())){
									sb.append(" ").append(o);
								}
								sb.append("\" ");
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return sb.toString();
	}
	/**
	 * 生成标签内容
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:03:20 2015年9月18日
	 * @return	
	 *
	 */
	public String content(){
		List<Method> list = new ArrayList<Method>();
		List<Class<?>> classList = new ArrayList<Class<?>>();
		ReflectUtils.getBeanAllMethods(list,this.getClass() ,classList , null);
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<list.size();i++){
			Method method = list.get(i);
			 try {
				 HtmlContent htmlContent = method.getAnnotation(HtmlContent.class);
				 if(null!=htmlContent){
					String attrName = method.getName().replaceFirst("get", "");
					attrName = attrName.replaceFirst(String.valueOf(attrName.charAt(0)), (String.valueOf(attrName.charAt(0))).toLowerCase());
					String content = (String) ReflectUtils.getFieldValue(attrName, this);
					sb.append(null==content?"":content);
				 }
			 }catch(Exception e){
			 }
		}
		if(CollectionUtil.isNotEmpty(this.getChild())){
			for(HtmlModel html : this.getChild()){
				html.setHtmlModelVisitor(this.getHtmlModelVisitor());
				sb.append(html.html());
			}
			/*for(int i=0;i<this.getChild().size();i++){
				this.getChild().get(i).setHtmlModelVisitor(this.getHtmlModelVisitor());
				sb.append(this.getChild().get(i).html());
			}*/
		}
		return sb.toString();
	}

	public HtmlModelVisitor getHtmlModelVisitor() {
		if(null==htmlModelVisitor)
			htmlModelVisitor = new HtmlDefaultModelVisitor();
		return htmlModelVisitor;
	}

	public void setHtmlModelVisitor(HtmlModelVisitor htmlModelVisitor) {
		this.htmlModelVisitor = htmlModelVisitor;
	}

	/*public List<HtmlModel> getChild() {
		return child = CollectionUtil.nullRetureNewList(child);
	}

	public void setChild(List<HtmlModel> child) {
		this.child = child;
	}*/

	
	public String get_uuid() {
		return _uuid;
	}

	public Set<HtmlModel> getChild() {
		if(null == child){
			child = new TreeSet<HtmlModel>();
		}
		return child;
	}

	public void setChild(Set<HtmlModel> child) {
		this.child = child;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	@Override
	public String accept(HtmlModelVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	@Override
	public String defaultClass() {
		return null;
	}
	
	
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@HtmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(HtmlModel o) {
		if(null==this.order){
			return 1;
		}
		return this.order - o.order;
	}
	
	public HtmlModel addChild(HtmlModel htmlMode){
		getChild().add(htmlMode);
		return this;
	}
}
