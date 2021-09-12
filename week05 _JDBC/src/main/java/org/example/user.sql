# 看你的mysql现在已提供什么存储引擎:
show engines;

# 看你的mysql当前默认的存储引擎:
show variables like '%storage_engine%';

# 你要看某个表用了什么引擎(在显示结果里参数engine后面的就表示该表当前用的存储引擎):
#show create table 表名;

# 创建数据库
create database test default character set = utf8;

# 创建表结构
# CREATE TABLE `token`
# (
#     `id`            BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '主键',
#     `created_at`    DATETIME                       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `authority_id`  VARCHAR(128)                   NOT NULL COMMENT '授权主体ID',
#     `refresh_token` VARCHAR(128)                   NOT NULL COMMENT 'refresh_token',
#     `access_token`  VARCHAR(128)                   NOT NULL COMMENT 'access_token',
#     `updated_at`    DATETIME                       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`),
#     UNIQUE KEY `uniq_authority_id` (`authority_id`)
# ) ENGINE = InnoDB
#   CHARSET = utf8mb4 COMMENT ='token管理表'
use test;
## 查阅资料发现：mysql在创建表时，表名以及字段名可以不加引号，加引号的话要加反引号，即键盘数字1左边的符号，
# 同时COMMENT的内容使用正常的引号或双引而不能使用反引号，因此有如下两种正确的创建方法
CREATE TABLE `user`
(
    id       BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    username VARCHAR(128) NOT NULL COMMENT '用户姓名',
    sex      CHAR(1)      NOT NULL COMMENT '性别',
    birthday DATE         NOT NULL COMMENT '生日',
    address  varchar(128) NOT NULL COMMENT '地址',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='用户表'





