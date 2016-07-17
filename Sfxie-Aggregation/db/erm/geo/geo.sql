SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sfxie_geo_city;
DROP TABLE IF EXISTS sfxie_geo_country;
DROP TABLE IF EXISTS sfxie_geo_detail;
DROP TABLE IF EXISTS sfxie_geo_district;
DROP TABLE IF EXISTS sfxie_geo_province;
DROP TABLE IF EXISTS sfxie_geo_street;




/* Create Tables */

-- 地理位置表-城市
CREATE TABLE sfxie_geo_city
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	city_code varchar(16) COMMENT '城市编码',
	city_name varchar(32) COMMENT '城市名称',
	create_time datetime COMMENT '记录创建时间',
	mail_code varchar(6) COMMENT '邮编编码',
	province_code varchar(16) COMMENT '省份编码',
	province_name varchar(32) COMMENT '省份名称',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-城市' DEFAULT CHARACTER SET utf8;


-- 地理位置表-国家
CREATE TABLE sfxie_geo_country
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	country_code varchar(16) COMMENT '国家编码',
	country_name varchar(32) COMMENT '国家名称',
	create_time datetime COMMENT '记录创建时间',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-国家' DEFAULT CHARACTER SET utf8;


-- 地理位置表-详细方位
CREATE TABLE sfxie_geo_detail
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	poi_code varchar(32) COMMENT '建筑物编码',
	poi_name varchar(50) COMMENT '建筑物名称',
	full_name varchar(200) COMMENT '建筑物全名',
	create_time datetime COMMENT '记录创建时间',
	street_code varchar(16) COMMENT '街道编码',
	street_name varchar(100) COMMENT '街道名称',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-详细方位' DEFAULT CHARACTER SET utf8;


-- 地理位置表-区
CREATE TABLE sfxie_geo_district
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	district_code varchar(16) COMMENT '区编码',
	district_name varchar(64) COMMENT '区名称',
	create_time datetime COMMENT '记录创建时间',
	city_code varchar(16) COMMENT '城市编码',
	city_name varchar(32) COMMENT '城市名称',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-区' DEFAULT CHARACTER SET utf8;


-- 地理位置表-省
CREATE TABLE sfxie_geo_province
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	province_code varchar(16) COMMENT '省份编码',
	province_name varchar(32) COMMENT '省份名称',
	create_time datetime COMMENT '记录创建时间',
	country_code varchar(16) COMMENT '国家编码',
	country_name varchar(32) COMMENT '国家名称',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-省' DEFAULT CHARACTER SET utf8;


-- 地理位置表-街道
CREATE TABLE sfxie_geo_street
(
	id_ int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
	street_code varchar(16) COMMENT '街道编码',
	street_name varchar(100) COMMENT '街道名称',
	create_time datetime COMMENT '记录创建时间',
	district_code varchar(16) COMMENT '区编码',
	district_name varchar(64) COMMENT '区名称',
	level char COMMENT '地理位置级别',
	PRIMARY KEY (id_)
) ENGINE = InnoDB COMMENT = '地理位置表-街道' DEFAULT CHARACTER SET utf8;



