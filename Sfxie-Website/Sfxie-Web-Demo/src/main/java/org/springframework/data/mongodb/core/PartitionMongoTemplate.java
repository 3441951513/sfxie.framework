package org.springframework.data.mongodb.core;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import com.sfxie.extension.mongodb.annotation.IMongodbPartitionDocumentName;
import com.sfxie.extension.mongodb.annotation.PartitionDocument;
import com.sfxie.extension.mongodb.exception.PartitionDocumentNameException;
import com.mongodb.Mongo;

public class PartitionMongoTemplate extends MongoTemplate {

	/**
	 * Constructor used for a basic template configuration
	 * 
	 * @param mongo must not be {@literal null}.
	 * @param databaseName must not be {@literal null} or empty.
	 */
	public PartitionMongoTemplate(Mongo mongo, String databaseName) {
		super(new SimpleMongoDbFactory(mongo, databaseName), null);
	}

	/**
	 * Constructor used for a template configuration with user credentials in the form of
	 * {@link org.springframework.data.authentication.UserCredentials}
	 * 
	 * @param mongo must not be {@literal null}.
	 * @param databaseName must not be {@literal null} or empty.
	 * @param userCredentials
	 */
	public PartitionMongoTemplate(Mongo mongo, String databaseName, UserCredentials userCredentials) {
		super(new SimpleMongoDbFactory(mongo, databaseName, userCredentials));
	}

	/**
	 * Constructor used for a basic template configuration.
	 * 
	 * @param mongoDbFactory must not be {@literal null}.
	 */
	public PartitionMongoTemplate(MongoDbFactory mongoDbFactory) {
		super(mongoDbFactory, null);
	}

	/**
	 * Constructor used for a basic template configuration.
	 * 
	 * @param mongoDbFactory must not be {@literal null}.
	 * @param mongoConverter
	 */
	public PartitionMongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter) {
		super(mongoDbFactory, mongoConverter) ;
	}
	@Override
	String determineCollectionName(Class<?> entityClass) {
		PartitionDocument partitionDocument = entityClass.getAnnotation(PartitionDocument.class);
		if(null!=partitionDocument){
			String collectionPartitionName = null;
			try {
				Object obj = partitionDocument.partitionName().newInstance();
				if(obj instanceof IMongodbPartitionDocumentName){
					collectionPartitionName = ((IMongodbPartitionDocumentName)obj).partitionName();
				}
			} catch (Exception e) {
				throw new PartitionDocumentNameException(entityClass.getName());
			} 
			return collectionPartitionName;
		}else{
			String collectionName = super.determineCollectionName(entityClass);
			return  collectionName;
		}
		
	}
}
