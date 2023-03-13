use book;

CREATE TABLE `tb_author`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(5) not NULL COMMENT '姓名',
    `dynasty`     int        not NULL COMMENT '朝代',
    `description` text COMMENT '介绍',
    `tags`        varchar(1024) comment '标签列表',
    `manager_id`  int      default 0 comment '最后更新的管理员id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '作者表';

CREATE TABLE `tb_dynasty`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(5) not NULL COMMENT '名称',
    `description` text COMMENT '介绍',
    `manager_id`  int      default 0 comment '最后更新的管理员id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '朝代表';

CREATE TABLE `tb_tag`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(5) not NULL COMMENT '名称',
    `description` varchar(255) COMMENT '介绍',
    `manager_id`  int      default 0 comment '最后更新的管理员id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '标签表';

CREATE TABLE `tb_book`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(5)   not NULL COMMENT '名称',
    `author`      int          not null comment '作者',
    `cover`       varchar(255) not null comment '封面',
    `pages`       int      default 1 comment '卷数量',
    `description` text COMMENT '介绍',
    `manager_id`  int      default 0 comment '最后更新的管理员id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '书籍表';

CREATE TABLE `tb_book_page`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `book_id`     int          not NULL COMMENT '书籍id',
    `page_id`     int          not null comment '卷id',
    `page_title`  varchar(127) not null comment '卷标题',
    `content`     text         not null comment '内容',
    `manager_id`  int      default 0 comment '最后更新的管理员id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT '书页表';