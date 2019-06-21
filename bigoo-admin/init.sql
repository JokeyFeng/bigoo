DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别 0男 1女',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `status` tinyint(1) NOT NULL COMMENT '状态 0锁定 1有效',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `theme` varchar(10) DEFAULT NULL COMMENT '主题',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

INSERT INTO `test_01`.`user` (`user_id`, `username`, `password`, `sex`, `dept_id`, `email`, `mobile`, `status`, `last_login_time`, `theme`, `avatar`, `description`, `create_time`, `modify_time`) VALUES ('1', 'jokey', '123456', '1', '1', '976024396@qq.com', '15625162363', '1', '2019-06-21 17:56:48', NULL, NULL, '我是帅锅', '2019-06-21 10:26:33', '2019-06-21 10:26:36');

-------------------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) NOT NULL COMMENT '上级部门ID',
  `dept_name` varchar(100) NOT NULL COMMENT '部门名称',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';
-- ----------------------------
-- Records of b_dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '0', '开发部', null, '2019-06-04 15:42:26');
INSERT INTO `dept` VALUES ('2', '1', '开发JAVA线', null, '2019-06-04 15:42:34');
INSERT INTO `dept` VALUES ('3', '1', '开发GO线', null, '2019-06-04 15:42:29');
INSERT INTO `dept` VALUES ('4', '0', '市场部', null, '2019-06-04 15:42:36');
INSERT INTO `dept` VALUES ('5', '0', '人事部', null, '2019-06-04 15:42:32');
INSERT INTO `dept` VALUES ('6', '0', '测试部', null, '2019-06-04 15:42:38');

-----------------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `key` bigint(20) NOT NULL COMMENT '键',
  `value` varchar(100) NOT NULL COMMENT '值',
  `field_name` varchar(100) NOT NULL COMMENT '字段名称',
  `table_name` varchar(100) NOT NULL COMMENT '表名',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

---------------------------------------

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `parent_id` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `permission` text COMMENT '权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `type` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COMMENT='菜单(资源)表';

INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('1', '0', '系统管理', NULL, NULL, 'system-manage-settings', '0', '1', '2019-06-21 16:39:07', NULL);
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('2', '0', '系统监控', NULL, NULL, 'system-admin-security', '0', '2', '2019-06-21 16:45:51', '2019-06-21 17:08:28');
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('3', '1', '用户管理', 'user', 'user:list', '', '0', '1', '2019-06-21 16:47:13', '2019-06-21 09:00:01');
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('4', '1', '角色管理', 'role', 'role:list', '', '0', '2', '2019-06-21 16:48:09', '2019-06-21 09:01:12');
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('5', '1', '菜单管理', 'menu', 'menu:list', '', '0', '3', '2019-06-21 16:48:57', '2019-06-21 09:01:30');
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('6', '1', '部门管理', 'dept', 'dept:list', '', '0', '4', '2019-06-21 16:57:33', '2019-06-21 09:01:40');
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('11', '3', '新增用户', NULL, 'user:add', NULL, '1', NULL, '2019-06-21 17:02:58', NULL);
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('12', '3', '修改用户', NULL, 'user:update', NULL, '1', NULL, '2019-06-21 17:04:07', NULL);
INSERT INTO `test_01`.`menu` (`menu_id`, `parent_id`, `menu_name`, `url`, `permission`, `icon`, `type`, `order_num`, `create_time`, `modify_time`) VALUES ('13', '3', '删除用户', NULL, 'user:delete', NULL, '1', NULL, '2019-06-21 17:04:58', NULL);

--- ---------------------
----     角色表      ----
-------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

INSERT INTO `test_01`.`role` (`role_id`, `role_name`, `remark`, `create_time`, `modify_time`) VALUES ('1', '超级管理员', '超级管理员', '2019-06-21 17:27:59', '2019-06-21 17:28:02');
INSERT INTO `test_01`.`role` (`role_id`, `role_name`, `remark`, `create_time`, `modify_time`) VALUES ('2', '普通用户', '普通用户', '2019-06-21 17:28:19', '2019-06-21 17:28:22');

--- ------------------------
----     权限资源      ------
----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色资源(菜单)关系表';
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '1');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '2');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '3');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '4');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '5');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '6');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '11');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '12');
INSERT INTO `test_01`.`role_menu` (`role_id`, `menu_id`) VALUES ('1', '13');

--- --------------------------
-----     用户角色   ----------
------------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';
INSERT INTO `test_01`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');

--------------------------------

DROP TABLE IF EXISTS `user_connection`;
CREATE TABLE `user_connection` (
  `userId` varchar(100) NOT NULL,
  `providerId` varchar(100) NOT NULL,
  `providerUserId` varchar(100) NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(512) NOT NULL,
  `secret` varchar(512) DEFAULT NULL,
  `refreshToken` varchar(512) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='第三方账号登录表';