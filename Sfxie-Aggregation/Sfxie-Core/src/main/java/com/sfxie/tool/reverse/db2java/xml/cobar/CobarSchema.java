package com.sfxie.tool.reverse.db2java.xml.cobar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.utils.XmlUtils;

@XmlRootElement(name = "cobar")
public class CobarSchema {

	private Schema schema;
	
	private Map<String,String> dbMetaMap ;
	
//	private List<DataNode> dataNode;
	
//	private DataSource dataSource;
	
	
	@XmlElement(name="schema")
	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	/*@XmlElement(name="dataNode")
	public List<DataNode> getDataNode() {
		return dataNode;
	}

	public void setDataNode(List<DataNode> dataNode) {
		this.dataNode = dataNode;
	}*/

//	@XmlElement(name="dataSource")
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	public Map<String, String> getDbMetaMap() {
		if(null==dbMetaMap)
			dbMetaMap = new HashMap<String, String>();
		return dbMetaMap;
	}

	public void setDbMetaMap(Map<String, String> dbMetaMap) {
		this.dbMetaMap = dbMetaMap;
	}

	public static void main(String[] args) {
		try {
			CobarSchema cs1 = XmlUtils.unserializer(CobarSchema.class, CobarSchema.class.getResourceAsStream("schema.xml"));
			cs1.getDbMetaMap().put("dn_sfxie_os", "192.168.10.112:3306/sfxie_os");
			cs1.getDbMetaMap().put("dn_sfxie_collection", "192.168.10.112:3306/sfxie_collection");
//			LocationCobarSchema cs2 = XmlUtils.unserializer(LocationCobarSchema.class, CobarSchema.class.getResourceAsStream("schema.xml"));
			System.out.println(cs1);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
