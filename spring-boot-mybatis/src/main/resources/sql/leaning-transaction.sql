USE demo;

DROP TABLE balance;
CREATE TABLE `balance` (
  `id`      INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) UNSIGNED NOT NULL,
  `money`   DECIMAL(10, 2)   NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户余额表';

insert into balance(`user_id`,`money`) values (3,19);

show VARIABLES like '%commit%';

SELECT *
FROM balance;

SET AUTOCOMMIT = 0; # 禁止自动提交
# SET AUTOCOMMIT = 1; # 开启自动提交

# -------------------------------- 事物提交 --------------------------------
BEGIN ;
insert into balance(`user_id`,`money`) values (3,122);

# 打开一个新的MySQL链接查询balance表并没有刚刚插入的数据，因为失误还没有提交
SELECT * FROM balance;
COMMIT ;

# 提交后在新MySQL链接中查询到了刚刚commit的数据
SELECT * FROM balance;

# -------------------------------- 事物回滚 --------------------------------
BEGIN ;
insert into balance(`user_id`,`money`) values (3,122);

SELECT * FROM balance;
ROLLBACK ;


