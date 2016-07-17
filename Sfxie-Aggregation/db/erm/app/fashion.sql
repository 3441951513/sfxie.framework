SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sfxie_app_bar_shopkeeper;
DROP TABLE IF EXISTS sfxie_shopping_puton;
DROP TABLE IF EXISTS sfxie_shopping_bar_ad;
DROP TABLE IF EXISTS sfxie_app_bar;
DROP TABLE IF EXISTS sfxie_shopping_ad_material;
DROP TABLE IF EXISTS sfxie_shopping_ad;
DROP TABLE IF EXISTS sfxie_app_shopkeeper;
DROP TABLE IF EXISTS sfxie_cache_db_partition;
DROP TABLE IF EXISTS sfxie_location_geographic;
DROP TABLE IF EXISTS sfxie_shopping_discount;
DROP TABLE IF EXISTS sfxie_shopping_goods;
DROP TABLE IF EXISTS sfxie_shopping_material_at;
DROP TABLE IF EXISTS sfxie_shopping_material;
DROP TABLE IF EXISTS sfxie_shopping_inventory;
DROP TABLE IF EXISTS sfxie_shopping_inventory_type;
DROP TABLE IF EXISTS sfxie_shopping_plan;




/* Create Tables */

-- 栏位
CREATE TABLE sfxie_app_bar
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(50) COMMENT '名称',
	-- Y-有效,N-无效
	validable char DEFAULT 'Y' COMMENT '是否有效 : Y-有效,N-无效',
	order_ int(5) COMMENT '排序',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	bar_url varchar(200) COMMENT '栏位对应的url',
	-- 从地理位置表中取code字段
	province varchar(64) COMMENT '省份 : 从地理位置表中取code字段',
	-- 从地理位置表中取code字段
	city varchar(64) COMMENT '城市 : 从地理位置表中取code字段',
	-- 从地理位置表中取code字段
	town varchar(64) COMMENT '城镇 : 从地理位置表中取code字段',
	village varchar(64) COMMENT '乡村',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '栏位' DEFAULT CHARACTER SET utf8;


-- 栏位店主关联表
CREATE TABLE sfxie_app_bar_shopkeeper
(
	id_ int(13) NOT NULL COMMENT '主键',
	bar_id int(13) COMMENT '栏位id',
	shopkeeper_id int(13) COMMENT '店主表id',
	-- S-审核通过,F-审核不通过
	audit_state char DEFAULT 'F' COMMENT '审核状态 : S-审核通过,F-审核不通过',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '栏位店主关联表' DEFAULT CHARACTER SET utf8;


-- 店主表
CREATE TABLE sfxie_app_shopkeeper
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	shopkeeper_name varchar(50) COMMENT '店主名称',
	-- 格式:年月日+4位顺序数字组成
	shopkeeper_code char(12) COMMENT '店主编码 : 格式:年月日+4位顺序数字组成',
	-- 代表编码
	code_ varchar(64) COMMENT '编码 : 代表编码',
	description_ varchar(500) COMMENT '描述',
	-- 从地理位置表中取code字段
	province varchar(64) COMMENT '省份 : 从地理位置表中取code字段',
	-- 从地理位置表中取code字段
	city varchar(64) COMMENT '城市 : 从地理位置表中取code字段',
	-- 从地理位置表中取code字段
	town varchar(64) COMMENT '城镇 : 从地理位置表中取code字段',
	village varchar(64) COMMENT '乡村',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '店主表' DEFAULT CHARACTER SET utf8;


-- 数据库分区字段映射表 : 用于系统初始化时调用缓存,并且提供给系统所有数据分区使用;
-- 系统数据的分区主要根据shopk
CREATE TABLE sfxie_cache_db_partition
(
	shopkeeper_id int(12) NOT NULL COMMENT '店主表id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	description_ varchar(500) COMMENT '描述',
	PRIMARY KEY (shopkeeper_id)
) ENGINE = InnoDB COMMENT = '数据库分区字段映射表 : 用于系统初始化时调用缓存,并且提供给系统所有数据分区使用;系统数据的分区主要根据shopk' DEFAULT CHARACTER SET utf8;


-- 地理位置表
CREATE TABLE sfxie_location_geographic
(
	id_ int(13) NOT NULL COMMENT '主键',
	name varchar(50) COMMENT '名称',
	code_ varchar(64) COMMENT '编码',
	-- 父级id
	parent_id int(13) COMMENT '父id : 父级id',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表' DEFAULT CHARACTER SET utf8;


-- 广告
CREATE TABLE sfxie_shopping_ad
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(50) NOT NULL COMMENT '名称',
	shopkeeper_id int(13) COMMENT '店主表id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	create_user varchar(64) NOT NULL COMMENT '记录创建人',
	create_time datetime NOT NULL COMMENT '记录创建时间',
	update_user varchar(64) COMMENT '记录更新人',
	update_time datetime COMMENT '记录更新时间',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '广告' DEFAULT CHARACTER SET utf8;


-- 广告素材关联表
CREATE TABLE sfxie_shopping_ad_material
(
	id_ int(13) NOT NULL COMMENT '主键',
	ad_id int(13) COMMENT '广告id',
	material_id int(13) COMMENT '素材表id',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '广告素材关联表' DEFAULT CHARACTER SET utf8;


-- 栏位广告关联表/投放信息表
CREATE TABLE sfxie_shopping_bar_ad
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	bar_id int(13) NOT NULL COMMENT '栏位id',
	ad_id int(13) NOT NULL COMMENT '广告id',
	-- Y-有效,N-无效
	validable char DEFAULT 'Y' NOT NULL COMMENT '是否有效 : Y-有效,N-无效',
	name varchar(50) NOT NULL COMMENT '名称',
	plan_id int(13) COMMENT '投放计划表id',
	price_id int(13) COMMENT '折扣表id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	order_ int(5) COMMENT '排序',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '栏位广告关联表/投放信息表' DEFAULT CHARACTER SET utf8;


-- 折扣表
CREATE TABLE sfxie_shopping_discount
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	size_ varchar(10) COMMENT '尺寸大小',
	color_ varchar(10) COMMENT '颜色',
	-- 如果折扣率为空,则按照现行价格
	price_ int(8) COMMENT '现行价格 : 如果折扣率为空,则按照现行价格',
	rate_ float COMMENT '折扣率',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '折扣表' DEFAULT CHARACTER SET utf8;


-- 商品表 : 只有被放入购物车的广告才能称为商品
CREATE TABLE sfxie_shopping_goods
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '商品表 : 只有被放入购物车的广告才能称为商品' DEFAULT CHARACTER SET utf8;


-- 库存表
CREATE TABLE sfxie_shopping_inventory
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 代表编码
	code_ varchar(64) COMMENT '编码 : 代表编码',
	primary_price_ decimal(10,2) COMMENT '原价',
	count_ int(11) COMMENT '库存量',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	inventory_type_id int(13) COMMENT '库存类型表id',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '库存表' DEFAULT CHARACTER SET utf8;


-- 库存类型
CREATE TABLE sfxie_shopping_inventory_type
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 父级id
	parent_id int(13) COMMENT '父id : 父级id',
	name varchar(50) COMMENT '名称',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '库存类型' DEFAULT CHARACTER SET utf8;


-- 素材
CREATE TABLE sfxie_shopping_material
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	material_name varchar(100) NOT NULL COMMENT '素材名称',
	image_url varchar(200) COMMENT '图片url',
	-- Y-有效,N-无效
	validable char DEFAULT 'Y' COMMENT '是否有效 : Y-有效,N-无效',
	position_ char COMMENT '素材位置',
	inventory_id int(13) COMMENT '库存id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	create_user varchar(64) COMMENT '记录创建人',
	create_time datetime COMMENT '记录创建时间',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '素材' DEFAULT CHARACTER SET utf8;


-- 素材属性关联表
CREATE TABLE sfxie_shopping_material_at
(
	id_ int(13) NOT NULL COMMENT '主键',
	material_id int(13) NOT NULL COMMENT '素材id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '素材属性关联表' DEFAULT CHARACTER SET utf8;


-- 投放计划表
CREATE TABLE sfxie_shopping_plan
(
	id_ int(13) NOT NULL COMMENT '主键',
	name varchar(50) COMMENT '名称',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	create_user varchar(64) NOT NULL COMMENT '记录创建人',
	update_user varchar(64) NOT NULL COMMENT '记录更新人',
	create_time datetime COMMENT '记录创建时间',
	update_time datetime COMMENT '记录更新时间',
	shopkeeper_id int(12) COMMENT '店主表id',
	-- S-审核通过,F-审核不通过
	audit_state char COMMENT '审核状态 : S-审核通过,F-审核不通过',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '投放计划表' DEFAULT CHARACTER SET utf8;


-- 广告投放表
CREATE TABLE sfxie_shopping_puton
(
	id_ int(13) NOT NULL COMMENT '主键',
	puton_start_time datetime NOT NULL COMMENT '投放开始时间',
	puton_end_time datetime NOT NULL COMMENT '投放结束时间',
	-- Y-有效,N-无效
	validable char DEFAULT 'Y' NOT NULL COMMENT '是否有效 : Y-有效,N-无效',
	bar_ad_id int(13) NOT NULL COMMENT '栏位广告关联表id',
	db_partition_number varchar(13) NOT NULL COMMENT '数据库分区字段',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '广告投放表' DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE sfxie_app_bar_shopkeeper
	ADD FOREIGN KEY (bar_id)
	REFERENCES sfxie_app_bar (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_bar_ad
	ADD FOREIGN KEY (bar_id)
	REFERENCES sfxie_app_bar (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_app_bar_shopkeeper
	ADD FOREIGN KEY (shopkeeper_id)
	REFERENCES sfxie_app_shopkeeper (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_ad
	ADD FOREIGN KEY (shopkeeper_id)
	REFERENCES sfxie_app_shopkeeper (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_ad_material
	ADD FOREIGN KEY (ad_id)
	REFERENCES sfxie_shopping_ad (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_bar_ad
	ADD FOREIGN KEY (ad_id)
	REFERENCES sfxie_shopping_ad (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_puton
	ADD FOREIGN KEY (bar_ad_id)
	REFERENCES sfxie_shopping_bar_ad (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_bar_ad
	ADD FOREIGN KEY (price_id)
	REFERENCES sfxie_shopping_discount (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_material
	ADD FOREIGN KEY (inventory_id)
	REFERENCES sfxie_shopping_inventory (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_inventory
	ADD FOREIGN KEY (inventory_type_id)
	REFERENCES sfxie_shopping_inventory_type (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_ad_material
	ADD FOREIGN KEY (material_id)
	REFERENCES sfxie_shopping_material (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_material_at
	ADD FOREIGN KEY (material_id)
	REFERENCES sfxie_shopping_material (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sfxie_shopping_bar_ad
	ADD FOREIGN KEY (plan_id)
	REFERENCES sfxie_shopping_plan (id_)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



