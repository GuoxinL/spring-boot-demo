use demo;
CREATE  TABLE  student (
  id  INT(10)  NOT NULL  UNIQUE  PRIMARY KEY  ,
  name  VARCHAR(20)  NOT NULL ,
  sex  VARCHAR(4)  ,
  birth  YEAR,
  department  VARCHAR(20) ,
  address  VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  score (
  id  INT(10)  NOT NULL  UNIQUE  PRIMARY KEY  AUTO_INCREMENT ,
  stu_id  INT(10)  NOT NULL ,
  c_name  VARCHAR(20) ,
  grade  INT(10)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO student VALUES( 901,'张老大', '男',1985,'计算机系', '北京市海淀区');
INSERT INTO student VALUES( 902,'张老二', '男',1986,'中文系', '北京市昌平区');
INSERT INTO student VALUES( 903,'张三', '女',1990,'中文系', '湖南省永州市');
INSERT INTO student VALUES( 904,'李四', '男',1990,'英语系', '辽宁省阜新市');
INSERT INTO student VALUES( 905,'王五', '女',1991,'英语系', '福建省厦门市');
INSERT INTO student VALUES( 906,'王六', '男',1988,'计算机系', '湖南省衡阳市');

INSERT INTO score VALUES(NULL,901, '计算机',98);
INSERT INTO score VALUES(NULL,901, '英语', 80);
INSERT INTO score VALUES(NULL,902, '计算机',65);
INSERT INTO score VALUES(NULL,902, '中文',88);
INSERT INTO score VALUES(NULL,903, '中文',95);
INSERT INTO score VALUES(NULL,904, '计算机',70);
INSERT INTO score VALUES(NULL,904, '英语',92);
INSERT INTO score VALUES(NULL,905, '英语',94);
INSERT INTO score VALUES(NULL,906, '计算机',90);
INSERT INTO score VALUES(NULL,906, '英语',85);

# LIMIT n,m 表示从n开始取m条
SELECT * FROM student LIMIT 1,3;

#查询计算机系和英语系的学生的信息
SELECT * FROM student WHERE department IN ('计算机系','英语系');

#查询18-28的学生信息
SELECT id,name,sex,2017-birth as age,department,address
FROM student
WHERE 2017-birth BETWEEN 18 AND 28;

SELECT id,name,sex,2017-birth as age,department,address
FROM student
WHERE 2017-birth >= 18 AND 2017-birth <= 28;

# 从student表中查询每个院系有多少人
SELECT department, count(id)
FROM student
GROUP BY department;

#从score表中查询每个科目的最高分
SELECT c_name,MAX(grade) FROM score
GROUP BY c_name;

#查询李四的考试科目（c_name）和考试成绩（grade）
SELECT c.c_name,c.grade FROM score c,student s WHERE s.id=c.stu_id AND s.name='李四';

SELECT c.c_name,c.grade FROM student s LEFT JOIN score c on c.stu_id=s.id WHERE s.name='李四';

# 用连接的方式查询所有学生的信息和考试信息
SELECT student.id,name,sex,birth,department,address,c_name,grade
FROM student,score
WHERE student.id=score.stu_id;

SELECT * FROM score;
SELECT * FROM student;

# 计算每个学生的总成绩
SELECT s.id,s.name,sum(c.grade) FROM student s, score c
WHERE s.id=c.stu_id
GROUP BY s.id;

# 计算每个考试科目的平均成绩
SELECT c_name,avg(grade) as avg_grade FROM score
GROUP BY c_name
ORDER BY avg_grade DESC;

# 查询计算机成绩低于95的学生信息
SELECT s.id,s.name,s.department,s.birth,s.address,s.sex FROM student s, score c
WHERE s.id=c.stu_id AND c_name='计算机' AND grade <95;

# 查询同时参加计算机和英语考试的学生的信息
SELECT d.* FROM student d,score b, score c
WHERE d.id=b.stu_id
      AND b.c_name='计算机'
      AND d.id=c.stu_id
      AND c.c_name='英语';

# 将计算机考试成绩按从高到低进行排序
SELECT s.*,c.grade FROM student s, score c
WHERE s.id=c.stu_id AND c.c_name='计算机'
ORDER BY c.grade DESC

# 从student表和score表中查询出学生的学号，然后合并查询结果
select id FROM student
UNION
SELECT stu_id FROM score;

# 查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
SELECT s.name, s.department, c.c_name,c.grade FROM student s, score c
WHERE s.id=c.stu_id AND (s.name LIKE '王%' OR s.name LIKE '张%')


# 查询都是湖南的学生的姓名、年龄、院系和考试科目及成绩

SELECT s.name,2017-s.birth, s.department, s.address, c.c_name, c.grade
FROM student s, score c
WHERE s.id=c.stu_id AND s.address LIKE '湖南%'