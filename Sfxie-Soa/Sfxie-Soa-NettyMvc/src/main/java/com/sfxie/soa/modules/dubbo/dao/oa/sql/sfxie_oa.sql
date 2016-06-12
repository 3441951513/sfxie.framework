/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : sfxie_oa

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2016-05-25 13:32:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sfxie_sys_action
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_action`;
CREATE TABLE `sfxie_sys_action` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `action_name` varchar(50) DEFAULT NULL COMMENT '动作名称',
  `action_url` varchar(100) DEFAULT NULL COMMENT '动作资源',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `param_flag` varchar(100) DEFAULT NULL COMMENT '置参数标记',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单代码',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动作操作表';

-- ----------------------------
-- Records of sfxie_sys_action
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_authorization
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_authorization`;
CREATE TABLE `sfxie_sys_authorization` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `company_code` varchar(64) DEFAULT NULL COMMENT '公司代码',
  `department_code` varchar(64) DEFAULT NULL COMMENT '部门代码',
  `post_code` varchar(32) DEFAULT NULL COMMENT '岗位代码',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `create_user` varchar(32) DEFAULT NULL COMMENT '记录创建人',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色授权表';

-- ----------------------------
-- Records of sfxie_sys_authorization
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_auth_data
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_auth_data`;
CREATE TABLE `sfxie_sys_auth_data` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色主键',
  `resource_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `resource_code` varchar(32) NOT NULL COMMENT '资源代码',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `sql_` varchar(2000) DEFAULT NULL COMMENT '数据权限sql查询语句',
  `role_menu_id` varchar(32) DEFAULT NULL COMMENT '角色菜单关联表id',
  `dealer_class` varchar(200) DEFAULT NULL COMMENT 'java处理类',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据权限表';

-- ----------------------------
-- Records of sfxie_sys_auth_data
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_auth_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_auth_role_menu`;
CREATE TABLE `sfxie_sys_auth_role_menu` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `role_menu_id` varchar(64) DEFAULT NULL COMMENT '角色菜单关联表id',
  `auth_data_id` varchar(64) DEFAULT NULL COMMENT '数据权限表id',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `company_role_id` varchar(32) DEFAULT NULL COMMENT '公司角色关联表id',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据权限角色菜单关联表';

-- ----------------------------
-- Records of sfxie_sys_auth_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_company`;
CREATE TABLE `sfxie_sys_company` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `company_code` varchar(64) NOT NULL COMMENT '公司代码',
  `company_name_cn` varchar(250) NOT NULL COMMENT '公司中文名称',
  `company_name_en` varchar(250) DEFAULT NULL COMMENT '公司英文名称',
  `address` varchar(300) DEFAULT NULL COMMENT '公司地址',
  `tel` varchar(60) DEFAULT NULL COMMENT '公司电话',
  `fax` varchar(60) DEFAULT NULL COMMENT '公司传真',
  `url` varchar(100) DEFAULT NULL COMMENT '主页URL',
  `email` varchar(60) DEFAULT NULL COMMENT 'email',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `short_name_cn` varchar(50) DEFAULT NULL COMMENT '公司中文名称简称',
  `short_name_en` varchar(50) DEFAULT NULL COMMENT '公司英文名称简称',
  `company_level` decimal(2,0) DEFAULT NULL COMMENT '公司级别',
  `create_company_id` varchar(50) NOT NULL COMMENT '创建公司',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `company_code` (`company_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司基础信息表';

-- ----------------------------
-- Records of sfxie_sys_company
-- ----------------------------
INSERT INTO `sfxie_sys_company` VALUES ('153e6cf4-2dd2-4912-9e1c-555175c686c9', 'sfxie153e6cf4-2dd2-4912-9e1c-555175c686c9', '测试', 'test', null, null, null, null, null, null, 'sfxie', '2016-04-20 13:55:44', null, null, null, null, null, null, null, '153e6cf4-2dd2-4912-9e1c-555175c686c9');
INSERT INTO `sfxie_sys_company` VALUES ('49dfbf86-4570-4109-baa1-cb571bd3ea71', 'sfxie', '测试', 'test', null, null, null, null, null, null, 'sfxie', '2016-04-20 13:49:34', null, null, null, null, null, null, null, '49dfbf86-4570-4109-baa1-cb571bd3ea71');

-- ----------------------------
-- Table structure for sfxie_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_department`;
CREATE TABLE `sfxie_sys_department` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `department_code` varchar(64) NOT NULL COMMENT '部门代码',
  `department_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父主键',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `company_code` varchar(64) NOT NULL COMMENT '公司代码',
  `parent_code` varchar(64) DEFAULT NULL COMMENT ' 父节点代码',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `department_code` (`department_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sfxie_sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_menu`;
CREATE TABLE `sfxie_sys_menu` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `menu_code` varchar(32) NOT NULL COMMENT '菜单代码',
  `system_id` varchar(64) DEFAULT NULL COMMENT '关联system_id',
  `auth_data_id` varchar(32) DEFAULT NULL COMMENT '数据权限id',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `menu_name_tw` varchar(50) DEFAULT NULL COMMENT '繁体菜单名称',
  `webside` varchar(10) DEFAULT NULL COMMENT '网站标识',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父主键',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `all_parent_id` char(1) DEFAULT NULL COMMENT 'all_parent_id',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `menu_code` (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sfxie_sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_organizition
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_organizition`;
CREATE TABLE `sfxie_sys_organizition` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `invalid_date` datetime DEFAULT NULL COMMENT '无效时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `company_code` varchar(64) NOT NULL COMMENT '公司代码',
  `parent_company_code` varchar(64) NOT NULL COMMENT '公司代码',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构表';

-- ----------------------------
-- Records of sfxie_sys_organizition
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_post`;
CREATE TABLE `sfxie_sys_post` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `post_code` varchar(32) NOT NULL COMMENT '岗位代码',
  `department_id` varchar(64) NOT NULL COMMENT '部门主键',
  `post_name` varchar(50) DEFAULT NULL COMMENT '岗位名称',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `post_level` char(1) DEFAULT NULL COMMENT '岗位级别',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `company_id` varchar(32) DEFAULT NULL COMMENT '公司主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父主键',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `post_code` (`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';

-- ----------------------------
-- Records of sfxie_sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_post_role
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_post_role`;
CREATE TABLE `sfxie_sys_post_role` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `post_code` varchar(32) NOT NULL COMMENT '岗位代码',
  `role_code` varchar(32) NOT NULL COMMENT '角色代码',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `post_code` (`post_code`,`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位角色关联表';

-- ----------------------------
-- Records of sfxie_sys_post_role
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_role`;
CREATE TABLE `sfxie_sys_role` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `role_code` varchar(32) NOT NULL COMMENT '角色代码',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `role_name_en` varchar(50) DEFAULT NULL COMMENT '角色英文名称',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sfxie_sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_role_action
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_role_action`;
CREATE TABLE `sfxie_sys_role_action` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `action_id` varchar(64) NOT NULL COMMENT '操作主键',
  `role_menu_id` varchar(64) NOT NULL COMMENT '角色菜单关联表id',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `company_role_id` varchar(32) DEFAULT NULL COMMENT '公司角色关联表id',
  `param_flag` varchar(100) DEFAULT NULL COMMENT '参数标记',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sfxie_sys_role_action';

-- ----------------------------
-- Records of sfxie_sys_role_action
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_role_menu`;
CREATE TABLE `sfxie_sys_role_menu` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `company_role_id` varchar(32) DEFAULT NULL COMMENT '公司角色关联表id',
  `create_company_id` varchar(50) DEFAULT NULL COMMENT '创建公司',
  `oraginal_role_menu_id` varchar(64) DEFAULT NULL COMMENT '继承的角色菜单id',
  `role_code` varchar(32) NOT NULL COMMENT '角色代码',
  `menu_code` varchar(32) NOT NULL COMMENT '菜单代码',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sfxie_sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_system
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_system`;
CREATE TABLE `sfxie_sys_system` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `system_code` varchar(32) NOT NULL COMMENT '系统代码',
  `system_name` varchar(200) DEFAULT NULL COMMENT '系统名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `sys_url` varchar(2000) DEFAULT NULL COMMENT 'sys_url',
  `sys_inner_url` varchar(2000) DEFAULT NULL COMMENT 'sys_inner_url',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '记录创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `system_code` (`system_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表';

-- ----------------------------
-- Records of sfxie_sys_system
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_userinfo`;
CREATE TABLE `sfxie_sys_userinfo` (
  `user_id` varchar(32) NOT NULL COMMENT '用户代码',
  `user_password` varchar(50) NOT NULL COMMENT '用户密码',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `is_superman` char(1) NOT NULL DEFAULT 'N' COMMENT '是否为超级管理员',
  `create_company_id` varchar(50) NOT NULL COMMENT '创建公司',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sfxie_sys_userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_user_relation`;
CREATE TABLE `sfxie_sys_user_relation` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户代码',
  `user_title` char(1) DEFAULT NULL COMMENT '用户职位',
  `is_valid` char(1) DEFAULT NULL COMMENT '是否有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `create_user` varchar(32) NOT NULL COMMENT '记录创建人',
  `create_company_id` varchar(50) NOT NULL COMMENT '创建公司',
  `email` varchar(60) NOT NULL COMMENT 'email',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_name_cn` varchar(60) NOT NULL COMMENT '用户中文名',
  `user_name_en` varchar(60) DEFAULT NULL COMMENT '用户英文名称',
  `sequence_no` decimal(8,0) DEFAULT NULL COMMENT '排序字段',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `is_default` char(1) DEFAULT NULL COMMENT '是否默认',
  `company_code` varchar(64) DEFAULT NULL COMMENT '公司代码',
  `post_code` varchar(32) DEFAULT NULL COMMENT '岗位代码',
  `department_code` varchar(64) DEFAULT NULL COMMENT '部门代码',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员档案-关系表';

-- ----------------------------
-- Records of sfxie_sys_user_relation
-- ----------------------------

-- ----------------------------
-- Table structure for sfxie_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sfxie_sys_user_role`;
CREATE TABLE `sfxie_sys_user_role` (
  `id_` varchar(64) NOT NULL COMMENT '记录主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户代码',
  `owner_company_code` varchar(64) DEFAULT NULL COMMENT '上一级公司',
  `is_valid` char(1) DEFAULT 'Y' COMMENT '是否有效',
  `user_info_relation_id` varchar(32) DEFAULT NULL COMMENT '用户关联表id',
  `role_code` varchar(32) NOT NULL COMMENT '角色代码',
  `partition_company` varchar(8) NOT NULL COMMENT '分区字段',
  PRIMARY KEY (`id_`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sfxie_sys_user_role
-- ----------------------------
