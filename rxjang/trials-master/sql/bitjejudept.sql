drop table bitjejudept;

create table bitjejudept(
	dept varchar2(20) primary key,
	lvl number unique not null
);
--부서와 권한레벨을 가진 테이블, 6개의 부서로 나뉜다. 

insert into bitjejudept values ('일반회원',1);
insert into bitjejudept values ('수강생',2);
insert into bitjejudept values ('강사',3);
insert into bitjejudept values ('영업',4);
insert into bitjejudept values ('행정',5);
insert into bitjejudept values ('관리자',6);

select * from bitjejudept;