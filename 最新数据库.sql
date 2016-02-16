
create database meeting;

use meeting;

create table dept
(
   did int auto_increment,   
   dname varchar(20),
   primary key(did)
)auto_increment 1 default charset=utf8;
insert into dept values (1,'软件工程师');
insert into dept values (2,'T3工程师');
insert into dept values (3,'人力管理');



create table emp
(
   eid int auto_increment,
   names varchar(30) not null,
   ename varchar(30) not null,
   epasswd varchar(20) not null,
   ephone varchar(20),
   email varchar(20),
   did  int,
   s_privilege tinyint default 0,
   primary key(eid),
  foreign key (did)references dept(did)
)auto_increment 1 default charset=utf8;
insert into emp values(1,'zkh','daybreak1','123456','110','redxun@163.com',1,0);
insert into emp values(2,'zk','day2','123456','110','redxun@163.com',1,0);
insert into emp values(3,'zh','break3','123456','110','redxun@163.com',1,0);
insert into emp values(4,'zgh','daybreak4','123456','110','redxun@163.com',1,0);
insert into emp values(5,'zkyg','day5','123456','110','redxun@163.com',1,0);
insert into emp values(6,'ztgh','break6','123456','110','redxun@163.com',1,0);
insert into emp values(7,'zkhq','daybreak11','123456','110','redxun@163.com',1,0);
insert into emp values(8,'zkw','day21','123456','110','redxun@163.com',1,0);
insert into emp values(9,'zhe','break31','123456','110','redxun@163.com',1,0);
insert into emp values(10,'zghs','daybreak41','123456','110','redxun@163.com',1,0);
insert into emp values(11,'zkygx','day51','123456','110','redxun@163.com',1,0);
insert into emp values(12,'ztghz','break61','123456','110','redxun@163.com',1,0);
insert into emp values(13,'zkh2','daybreak12','123456','110','redxun@163.com',1,0);
insert into emp values(14,'zk2','da2y2','123456','110','redxun@163.com',1,0);
insert into emp values(15,'zh2','br2eak3','123456','110','redxun@163.com',1,0);
insert into emp values(16,'zgh2','da2ybreak4','123456','110','redxun@163.com',1,0);
insert into emp values(17,'zkyg2','da2y5','123456','110','redxun@163.com',1,0);
insert into emp values(18,'ztgh2','brea2k6','123456','110','redxun@163.com',1,0);
insert into emp values(19,'zkhq2','day2break11','123456','110','redxun@163.com',1,0);
insert into emp values(20,'zkw2','day221','123456','110','redxun@163.com',1,0);
insert into emp values(21,'zhe2','bre2ak31','123456','110','redxun@163.com',1,0);
insert into emp values(22,'zghs2','daybr2eak41','123456','110','redxun@163.com',1,0);
insert into emp values(23,'zkygx2','day521','123456','110','redxun@163.com',1,0);
insert into emp values(24,'ztghz2','break261','123456','110','redxun@163.com',1,0);


create table room
(
    rid varchar(20) primary key ,
    rname varchar(20),
    maxnum int,
    rstate int,
   rremark varchar(100)
);
insert into room values ('1','第一会议室',12,1,'本会议室测试使用情况1 启用');
insert into room values ('2','第二会议室',8,1,'本会议室测试使用情况2 启用');
insert into room values ('3','第三会议室',6,0,'本会议室测试使用情况3 停用');
insert into room values ('4','第四会议室',8,-1,'本会议室测试使用情况4 删除');


create table meet
(
  mname varchar(20) primary key,
  mnumber int,
  mstarttime timestamp,
  mendtime timestamp,
  appointtime timestamp,
  rid varchar(20),
  mremark varchar(50),
  memps varchar(100),
  mstate int default 1,
  cancelreason varchar(100),
  appointmentid int,
  foreign key (rid)references room(rid),
  foreign key (appointmentid)references emp(eid)
  );
  
  insert into meet values ('google交流会',12,'2012-11-23 12:00:00','2012-11-23 14:00:00','2012-11-22 10:00:00','1','会议说明','1#2#3',1,'取消说明',1);
  insert into meet values ('baidu交流会',13,'2012-11-25 12:00:00','2012-11-25 14:00:00','2012-11-21 10:00:00','1','会议说明3','1#2#3',1,'取消说明3',1);
  insert into meet values ('qianqian交流会',13,'2015-7-15 12:00:00','2015-7-15 14:00:00','2012-11-21 10:00:00','1','会议说明3','1#2#3',-1,'取消说明3',1);
