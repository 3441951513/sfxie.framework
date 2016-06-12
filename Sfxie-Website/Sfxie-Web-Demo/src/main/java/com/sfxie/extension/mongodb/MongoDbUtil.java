package com.sfxie.extension.mongodb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.sfxie.core.server.IServerInitCall;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.utils.jacson.codehaus.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MongoDbUtil implements IServerInitCall{
	
	 /** 
     * MongoClient的实例代表数据库连接池，是线程安全的，可以被多线程共享，客户端在多线程条件下仅维持一个实例即可 
     * Mongo是非线程安全的，目前mongodb API中已经建议用MongoClient替代Mongo 
     */  
      
    private static DB db = null;
    /** 
     *  
     * 私有的构造函数 
     */  
    private MongoDbUtil(){  
        
    }  
    /**	降序	*/
    public static int INDEX_DESC = 0;
    /**	升序	*/
    public static int INDEX_ASC= 1;
    /**
     * 统一获取分表名称
     * @TODO	
     * @param table
     * 			表名
     * @return	
     *  	table+yyyyMMdd
     *
     */
    public static String getDividedTableName(String table){
    	//获取日活用户分表名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		String tableName = table+today;
		return tableName;
    }
      
    /********单例模式声明开始，采用饿汉式方式生成，保证线程安全********************/  
      
    //类初始化时，自行实例化，饿汉式单例模式  
    private static MongoDbUtil mongoDbUtil = null;  
    /** 
     *  
     * 方法名：getMongoDbUtilInstance 
     * 创建时间：2014-8-30 下午04:29:26 
     * 描述：单例的静态工厂方法 
     * @return 
     */  
    public static MongoDbUtil getMongoDbUtilInstance(){  
    	if(null== mongoDbUtil){
    		mongoDbUtil = new MongoDbUtil();
    		if(db == null){  
    			try {  
    				MongoTemplate mongoTemplate = (MongoTemplate) Context.getBeanByName("mongoTemplate");
    				db = mongoTemplate.getDb();
    			} catch (MongoException e){
    				e.printStackTrace();  
    			}  
    			
    		}  
    	}
        return mongoDbUtil;  
    }  
      
    /************************单例模式声明结束*************************************/  

    /**
	 * 插入
	 * @param tableName 表名
	 * @param obj 插入的数据对象
	 */
	public DBCollection getCollection(String tableName){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    return coll;
	}
	
	/**
	 * 更新文档
	 * @TODO	
	 * @param tableName
	 * 			文档名称
	 * @param queryObject	
	 * 			查询对象
	 * @param updateObject
	 * 			更新值对象
	 * @return	
	 *
	 */
	public Object update(String tableName,DBObject queryObject,DBObject updateObject){
	    DBCollection coll = db.getCollection(tableName);
	    WriteResult result = coll.update(queryObject, toDBObject(updateObject));
	    return result;
	}
	
	/**
	 * 插入
	 * @param tableName 表名
	 * @param obj 插入的数据对象
	 */
	public void insert(String tableName,Object obj){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    coll.insert(toDBObject(obj));
	    System.out.println( "----------" + tableName + " insert success! ---------");
	}
	
	/**
	 * 插入文档
	 * @param tableName 文档名
	 * @param obj 插入的文档对象
	 * @param indexs 文档的索引,如果首次插入数据则生成相应的索引
	 */
	public void insert(String tableName,Object obj,int descOrAsc,String... indexs){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
		boolean isExists = isExists(tableName);
	    DBCollection coll = db.getCollection(tableName);
	    coll.insert(toDBObject(obj));
	    if (!isExists) { // 不存在
	    	createIndexs(isExists,tableName,INDEX_ASC, indexs);
	    }
	    System.out.println( "----------" + tableName + " insert success! ---------");
	}
	
	/**
	 * 批量插入
	 * @param tableName 表名
	 * @param insertList 插入的数据对象List
	 */
	public void insertBath(String tableName,List<DBObject> insertList){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    coll.insert(insertList);
	    System.out.println( "----------" + tableName + " insert success! ---------");
	}
	
	
	/**
	 * 查询所有数据
	 * @param tableName 表名
	 */
	public void findAll(String tableName){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}
	}
	
	/**
	 * 
	 * 带条件查询一条数据
	 * @param tableName 表名
	 * @param docFind 查询条件 
	 * @return
	 */
	public DBObject findOne(String tableName,BasicDBObject docFind){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    DBObject findResult = coll.findOne(docFind);
	    return findResult;
	}
	
	/**
	 * 判断表是否存在
	 * @param tableName 表名
	 * @return true 存在 false 不存在
	 */
	public boolean isExists(String tableName){
	    DBCollection coll = db.getCollection(tableName);
	    if (coll.count() == 0) {
		    return false;
		}
	    return true;
	}
	
	/**
	 * 创建索引
	 * @param tableName 表名
	 * @param col 列名
	 */
	public void createIndex(String tableName,String col){
	    DBCollection coll = db.getCollection(tableName);
	    coll.createIndex(new BasicDBObject(col, 1)); // 1代表升序
	    System.out.println( "----------" + tableName + "["+col+"]"+" create index! ---------");
	}
	/**
	 * 创建索引
	 * @param tableName 表名
	 * @param indexs 列名
	 */
	public void createIndexs(boolean isExists,String tableName,int descOrAsc,String... indexs){
		if(!isExists){
			for(String index : indexs){
				DBCollection coll = db.getCollection(tableName);
				coll.createIndex(new BasicDBObject(index, descOrAsc)); // 1代表升序
				System.out.println( "----------" + tableName + "["+index+"]"+" create index! ---------");
			}
		}
	}
	
	/**
	 * 删除所有数据
	 * @param tableName 表名
	 */
	public void deleteAll(String tableName){
	    // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
	    DBCollection coll = db.getCollection(tableName);
	    DBCursor dbCursor = coll.find();
	    for (DBObject dbObject : dbCursor) {
	        coll.remove(dbObject);
	    }
	    System.out.println( "----------" + tableName + " delete success! ---------");
	}
	
	
	/**
	 * 将普通Object对象转换成mongodb的DBObject对象
	 * 
	 * @param obj
	 * @return
	 */
	public DBObject toDBObject(Object obj) {
	    String json = JsonUtil.toJSON(obj);
	    return (DBObject) JSON.parse(json);
	}

	@Override
	public <T> T init() {
		MongoDbUtil.getMongoDbUtilInstance();
		return null;
	}
}
