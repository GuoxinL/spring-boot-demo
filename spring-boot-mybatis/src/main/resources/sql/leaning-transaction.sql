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

INSERT INTO balance (`user_id`, `money`) VALUES (3, 19);

SHOW VARIABLES LIKE '%commit%';

SELECT *
FROM balance;

SET AUTOCOMMIT = 0; # 禁止自动提交
# SET AUTOCOMMIT = 1; # 开启自动提交

# -------------------------------- 事物提交 --------------------------------
BEGIN;
INSERT INTO balance (`user_id`, `money`) VALUES (3, 122);

# 打开一个新的MySQL链接查询balance表并没有刚刚插入的数据，因为失误还没有提交
SELECT *
FROM balance;
COMMIT;

# 提交后在新MySQL链接中查询到了刚刚commit的数据
SELECT *
FROM balance;
COMMIT;
# -------------------------------- 事物回滚 --------------------------------
BEGIN;
INSERT INTO balance (`user_id`, `money`) VALUES (3, 122);

SELECT *
FROM balance;
ROLLBACK;

CREATE TABLE t (
  a INT,
  PRIMARY KEY (a)
)
  ENGINE = innodb;

BEGIN ;

INSERT INTO t SELECT 1;
INSERT INTO t SELECT 1;
SELECT * FROM t;
# 可以看到，插入第二条记录的时候，db抛出了1062错误，但是并没有自动回滚，能查出前一条
# insert的记录，这个时候需要我们手动commit或者rollback