use auth;
show tables;
# drop table tb_sys_roles;
# drop table tb_sys_users;
# drop table tb_sys_permissions;
# drop table tb_sys_users_roles;
# drop table tb_sys_roles_permissions;


CREATE TABLE `tb_sys_user`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `account`     varchar(45)  DEFAULT NULL COMMENT '账号',
    `password`    varchar(45)  DEFAULT NULL COMMENT '密码',
    `sex`         tinyint(1)   DEFAULT '0' COMMENT '性别 0男 1女',
    `id_card`     varchar(225) DEFAULT NULL COMMENT '身份证',
    `email`       varchar(45)  DEFAULT NULL COMMENT '邮箱',
    `phone`       varchar(45)  DEFAULT NULL COMMENT '电话',
    `status`      tinyint(1)   DEFAULT '0' COMMENT '状态(0启用 1冻结 2删除)',
    `create_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
    `last_time`   datetime     DEFAULT NULL COMMENT '最后登录时间',
    `salt`        varchar(45)  DEFAULT NULL COMMENT '加密盐值',
    `age`         int(3)       DEFAULT NULL COMMENT '年龄',
    `secret`      char(16) COMMENT '个人账号密钥',
    `manager`     tinyint      default 0 comment '0-普通用户 1-普通管理员 2-超级管理员',
    `update_time` datetime     DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_sys_role`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `name`        varchar(100) DEFAULT NULL COMMENT '角色名称',
    `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
    `available`   tinyint(1)   DEFAULT NULL COMMENT '是否锁定(0否 1是)',
    `create_time` datetime     DEFAULT NULL COMMENT '角色创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
CREATE TABLE `tb_sys_permission`
(
    `id`          bigint(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
    `name`        varchar(100) DEFAULT NULL COMMENT '权限名称',
    `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
    `url`         varchar(255) DEFAULT NULL COMMENT '权限访问路径',
    `type`        tinyint(1)   DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
    `order`       int(3)       DEFAULT NULL COMMENT '排序',
    `icon`        varchar(50)  DEFAULT NULL COMMENT '图标',
    `status`      tinyint(1)   DEFAULT '0' COMMENT '状态：0有效；1删除',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
CREATE TABLE `tb_sys_users_role`
(
    `id`      bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表id',
    `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
    `role_id` bigint(11) DEFAULT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `tb_sys_roles_permission`
(
    `id`            bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限关系表id',
    `role_id`       bigint(11) DEFAULT NULL COMMENT '角色id',
    `permission_id` bigint(11) DEFAULT NULL COMMENT '权限id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
