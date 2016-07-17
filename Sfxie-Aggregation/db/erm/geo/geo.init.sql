-- 生成国家数据
delete from sfxie_geo_country;
Insert  INTO sfxie_geo_country(country_name,level,create_time) values('中国',0,now());
-- 生成省份数据
delete from sfxie_geo_province;
Insert  INTO sfxie_geo_province(province_name,country_name,level,create_time) SELECT t.`name`,'中国',1,NOW() FROM t_prov_city_area_street t where t.parentId = 0;

-- 生成城市数据
delete from sfxie_geo_city;
Insert  INTO sfxie_geo_city (city_name,create_time,level,province_name) 
SELECT s.`name`,NOW(),s.`level`,t.`name` from t_prov_city_area_street s  ,(SELECT t.`code`,t.`name`  FROM t_prov_city_area_street t where t.`level` = 1) t
where s.parentId = t.`code` and s.`level` = 2;

-- 生成城镇/区数据
delete from sfxie_geo_district;
Insert  INTO sfxie_geo_district (district_name,create_time,level,city_name) 
SELECT s.`name`,NOW(),s.`level`,t.`name` from t_prov_city_area_street s  ,(SELECT t.`code`,t.`name`  FROM t_prov_city_area_street t where t.`level` = 2) t
where s.parentId = t.`code` and s.`level` = 3;

-- 生成城街道数据
delete from sfxie_geo_district;
Insert  INTO sfxie_geo_street (street_name,create_time,level,district_name) 
SELECT s.`name`,NOW(),s.`level`,t.`name` from t_prov_city_area_street s  ,(SELECT t.`code`,t.`name`  FROM t_prov_city_area_street t where t.`level` = 3) t
where s.parentId = t.`code` and s.`level` = 4;
