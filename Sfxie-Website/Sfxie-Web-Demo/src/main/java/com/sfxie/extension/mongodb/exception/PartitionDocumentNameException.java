package com.sfxie.extension.mongodb.exception;


public class PartitionDocumentNameException extends MongodbException {

	public PartitionDocumentNameException(String errorMsg) {
		super(errorMsg+"实体类的mongodb分表名称出错,请确认分表名称规则!");
	}

}
