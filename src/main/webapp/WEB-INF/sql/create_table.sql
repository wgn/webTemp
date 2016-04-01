
create database base default character set utf8 collate utf8_bin;

CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(64) DEFAULT NULL COMMENT '名字',
   `birthday` date DEFAULT NULL COMMENT '生日',
   `sex` char(1) DEFAULT NULL COMMENT '性别',
   `address` varchar(256) DEFAULT NULL COMMENT '地址',
   `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
   `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB  DEFAULT CHARSET=utf8
 ;
 
 
 
 
 
 
 
 
 
 
 
 
 