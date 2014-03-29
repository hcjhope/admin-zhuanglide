-- MYSQL创建test数据库，如果mysql中存在该库，则注释该行
CREATE DATABASE test;

-- 切库
USE test;


-- 创建3个用户 write 全部权限、read01、read02 只读权限
grant all privileges on test.* to 'write'@'localhost' identified by 'write1234';
grant all privileges on test.* to 'write'@'%' identified by 'write1234';
grant select on test.* to 'read01'@'localhost' identified by 'read1234';
grant select on test.* to 'read01'@'%' identified by 'read1234';
grant select on test.* to 'read02'@'localhost' identified by 'read1234';
grant select on test.* to 'read02'@'%' identified by 'read1234';





-- 创建test表
CREATE TABLE `test` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='test';


CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';