package com.sfxie.test.business.api3.mongodb;

import com.sfxie.extension.mongodb.annotation.IMongodbPartitionDocumentName;
import com.sfxie.utils.ApiTool;

public class TestMongodbPartitionDocumentName implements
		IMongodbPartitionDocumentName {

	@Override
	public String partitionName() {
		try {
			return ApiTool.gettablename("Mongodb_Annotation_TestPojo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
