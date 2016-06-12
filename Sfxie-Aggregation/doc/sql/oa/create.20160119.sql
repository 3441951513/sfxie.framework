------------------------------------------------------------------全局表------------------------------------------------------------------
CREATE TABLE sfxie_sys_company
(
	id_ varchar(64) NOT NULL COMMENT '记录主键',
	company_code varchar(64) NOT NULL UNIQUE COMMENT '公司代码',
	company_name_cn varchar(250) NOT NULL COMMENT '公司中文名称',
	company_name_en varchar(250) COMMENT '公司英文名称',
	address varchar(300) COMMENT '公司地址',
	tel varchar(60) COMMENT '公司电话',
	fax varchar(60) COMMENT '公司传真',
	url varchar(100) COMMENT '主页URL',
	email varchar(60) COMMENT 'email',
	remark varchar(200) COMMENT '备注',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user varchar(32) COMMENT '最后修改人',
	update_time datetime COMMENT '最后修改时间',
	sequence_no decimal(8) COMMENT '排序字段',
	is_valid char COMMENT '是否有效',
	short_name_cn varchar(50) COMMENT '公司中文名称简称',
	short_name_en varchar(50) COMMENT '公司英文名称简称',
	company_level decimal(2) COMMENT '公司级别',
	create_company_id varchar(50) NOT NULL COMMENT '创建公司',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '公司基础信息表' DEFAULT CHARACTER SET utf8;
CREATE TABLE sfxie_sys_organizition
(
	id_ varchar(64) NOT NULL COMMENT '记录主键',
	is_valid char DEFAULT 'Y' COMMENT '是否有效',
	invalid_date datetime COMMENT '无效时间',
	create_time datetime NOT NULL COMMENT '创建时间',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	update_time datetime COMMENT '最后修改时间',
	update_user varchar(32) COMMENT '最后修改人',
	sequence_no decimal(8) COMMENT '排序字段',
	company_code varchar(64) NOT NULL COMMENT '公司代码',
	parent_company_code varchar(64) NOT NULL COMMENT '公司代码',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '组织架构表' DEFAULT CHARACTER SET utf8;
------------------------------------------------------------------全局表------------------------------------------------------------------


------------------------------------------------------------------分片表------------------------------------------------------------------
CREATE TABLE sfxie_sys_department
(
	id_ varchar(64) NOT NULL COMMENT '记录主键',
	department_code varchar(64) NOT NULL UNIQUE COMMENT '部门代码',
	department_name varchar(100) COMMENT '部门名称',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user varchar(32) COMMENT '最后修改人',
	update_time datetime COMMENT '最后修改时间',
	is_valid char COMMENT '是否有效',
	sequence_no decimal(8) COMMENT '排序字段',
	parent_id varchar(32) COMMENT '父主键',
	create_company_id varchar(50) COMMENT '创建公司',
	company_code varchar(64) NOT NULL COMMENT '公司代码',
	parent_code varchar(64) COMMENT ' 父节点代码',
	partition_company varchar(8) NOT NULL COMMENT '分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '部门表' DEFAULT CHARACTER SET utf8;


CREATE TABLE sfxie_sys_post
(
	id_ varchar(64) NOT NULL COMMENT '记录主键',
	post_code varchar(32) NOT NULL UNIQUE COMMENT '岗位代码',
	department_id varchar(64) NOT NULL COMMENT '部门主键',
	post_name varchar(50) COMMENT '岗位名称',
	sequence_no decimal(8) COMMENT '排序字段',
	post_level char COMMENT '岗位级别',
	create_time datetime NOT NULL COMMENT '创建时间',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	update_time datetime COMMENT '最后修改时间',
	update_user varchar(32) COMMENT '最后修改人',
	company_id varchar(32) COMMENT '公司主键',
	parent_id varchar(32) COMMENT '父主键',
	is_valid char COMMENT '是否有效',
	create_company_id varchar(50) COMMENT '创建公司',
	partition_company varchar(8) NOT NULL COMMENT '分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '岗位表' DEFAULT CHARACTER SET utf8;



CREATE TABLE sfxie_sys_userinfo
(
	user_id varchar(32) NOT NULL COMMENT '用户代码',
	user_password varchar(50) NOT NULL COMMENT '用户密码',
	is_valid char COMMENT '是否有效',
	create_time datetime NOT NULL COMMENT '创建时间',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	update_user varchar(32) COMMENT '最后修改人',
	update_time datetime COMMENT '最后修改时间',
	sequence_no decimal(8) COMMENT '排序字段',
	is_superman char DEFAULT 'N' NOT NULL COMMENT '是否为超级管理员',
	create_company_id varchar(50) NOT NULL COMMENT '创建公司',
	sex char COMMENT '用户性别',
	partition_company varchar(8) NOT NULL COMMENT '分区字段',
	PRIMARY KEY (user_id)
) ENGINE = InnoDB COMMENT = '用户表' DEFAULT CHARACTER SET utf8;


CREATE TABLE sfxie_sys_user_relation
(
	id_ varchar(64) NOT NULL COMMENT '记录主键',
	user_id varchar(32) NOT NULL COMMENT '用户代码',
	user_title char COMMENT '用户职位',
	is_valid char COMMENT '是否有效',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_time datetime COMMENT '最后修改时间',
	update_user varchar(32) COMMENT '最后修改人',
	create_user varchar(32) NOT NULL COMMENT '记录创建人',
	create_company_id varchar(50) NOT NULL COMMENT '创建公司',
	email varchar(60) NOT NULL COMMENT 'email',
	phone varchar(20) COMMENT '手机号',
	user_name_cn varchar(60) NOT NULL COMMENT '用户中文名',
	user_name_en varchar(60) COMMENT '用户英文名称',
	sequence_no decimal(8) COMMENT '排序字段',
	user_type char COMMENT '用户类型',
	is_default char COMMENT '是否默认',
	company_code varchar(64) COMMENT '公司代码',
	post_code varchar(32) COMMENT '岗位代码',
	department_code varchar(64) COMMENT '部门代码',
	partition_company varchar(8) NOT NULL COMMENT '分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '人员档案-关系表' DEFAULT CHARACTER SET utf8;



ALTER TABLE sfxie_sys_department
	ADD FOREIGN KEY (company_code)
	REFERENCES sfxie_sys_company (company_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_organizition
	ADD FOREIGN KEY (parent_company_code)
	REFERENCES sfxie_sys_company (company_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_organizition
	ADD FOREIGN KEY (company_code)
	REFERENCES sfxie_sys_company (company_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_user_relation
	ADD FOREIGN KEY (company_code)
	REFERENCES sfxie_sys_company (company_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_post
	ADD FOREIGN KEY (department_id)
	REFERENCES sfxie_sys_department (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_user_relation
	ADD FOREIGN KEY (department_code)
	REFERENCES sfxie_sys_department (department_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_user_relation
	ADD FOREIGN KEY (post_code)
	REFERENCES sfxie_sys_post (post_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_sys_user_relation
	ADD FOREIGN KEY (user_id)
	REFERENCES sfxie_sys_userinfo (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;
------------------------------------------------------------------分片表------------------------------------------------------------------

------------------------------------------------------------------初始化数据------------------------------------------------------------------

-- 初始化公司表数据
INSERT INTO `sfxie_sys_company` (`ID_`, `COMPANY_CODE`, `COMPANY_NAME_CN`, `COMPANY_NAME_EN`, `ADDRESS`, `TEL`, `FAX`, `URL`, `EMAIL`, `REMARK`, `CREATE_USER`, `CREATE_TIME`, `UPDATE_USER`, `UPDATE_TIME`, `SEQUENCE_NO`, `IS_VALID`, `SHORT_NAME_CN`, `SHORT_NAME_EN`, `COMPANY_LEVEL`, `CREATE_COMPANY_ID`) 
VALUES ('1111111111111', 'companyTestCode0', '测试数据插入公司0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sfxie', '2016-01-19 11:11:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '-1');
INSERT INTO `sfxie_sys_company` (`ID_`, `COMPANY_CODE`, `COMPANY_NAME_CN`, `COMPANY_NAME_EN`, `ADDRESS`, `TEL`, `FAX`, `URL`, `EMAIL`, `REMARK`, `CREATE_USER`, `CREATE_TIME`, `UPDATE_USER`, `UPDATE_TIME`, `SEQUENCE_NO`, `IS_VALID`, `SHORT_NAME_CN`, `SHORT_NAME_EN`, `COMPANY_LEVEL`, `CREATE_COMPANY_ID`) 
VALUES ('1111111111112', 'companyTestCode1', '测试数据插入公司1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sfxie', '2016-01-19 11:11:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '-1');

-- 初始化用户表数据
INSERT INTO `sfxie_sys_userinfo` (`USER_ID`, `USER_PASSWORD`, `IS_VALID`, `CREATE_TIME`, `CREATE_USER`, `UPDATE_USER`, `UPDATE_TIME`, `SEQUENCE_NO`, `IS_SUPERMAN`, `CREATE_COMPANY_ID`, `SEX`, `PARTITION_COMPANY`) 
VALUES ('sfxie', '123456', 'Y', '2016-01-19 11:11:11', 'admin', NULL, NULL, NULL, 'Y', 'companyTestCode0', NULL, '00000000');
INSERT INTO `sfxie_sys_userinfo` (`USER_ID`, `USER_PASSWORD`, `IS_VALID`, `CREATE_TIME`, `CREATE_USER`, `UPDATE_USER`, `UPDATE_TIME`, `SEQUENCE_NO`, `IS_SUPERMAN`, `CREATE_COMPANY_ID`, `SEX`, `PARTITION_COMPANY`) 
VALUES ('test', '123456', 'Y', '2016-01-19 11:11:11', 'admin', NULL, NULL, NULL, 'Y', 'companyTestCode1', NULL, '00000001');
--添加一数据库分片节点后再添加一条数据
INSERT INTO `sfxie_sys_userinfo` (`USER_ID`, `USER_PASSWORD`, `IS_VALID`, `CREATE_TIME`, `CREATE_USER`, `UPDATE_USER`, `UPDATE_TIME`, `SEQUENCE_NO`, `IS_SUPERMAN`, `CREATE_COMPANY_ID`, `SEX`, `PARTITION_COMPANY`) 
VALUES ('lishi', '123456', 'Y', '2016-01-19 11:11:11', 'admin', NULL, NULL, NULL, 'Y', 'companyTestCode1', NULL, '00000002');

