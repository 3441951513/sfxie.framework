CREATE TABLE `test_storm_statics_channel` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键 : 主键',
  `channel_id` int(11) DEFAULT '0' COMMENT '渠道id',
  `channel_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT NULL,
  `china_time` varchar(8) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL COMMENT '板块类型',
  `tp` int(11) DEFAULT '0' COMMENT '曝光时长(单位秒)',
  `reward` int(8) DEFAULT '0' COMMENT '奖励',
  `reward_type` char(1) DEFAULT NULL COMMENT '奖励类型',
  `PartitionDate` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4495 DEFAULT CHARSET=utf8;

