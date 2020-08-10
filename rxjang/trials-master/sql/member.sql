drop table member;

create table member(						
	num number primary key, 				--회원번호
	id_email varchar2(50) unique not null,  --이메일을 아이디로씀
	name varchar2(15),						--회원이름
	lvl number(1) default 1,				--등급
	password varchar2(15) not null, 		--비밀번호 영문+숫자조합
	phone number,							--전화번호
	lecture varchar2(30),					--강좌명 
	foreign key(lvl) references bitjejudept(lvl) on delete cascade
);

select * from MEMBER;

insert into member values (1111, 'tmsisj@email.com','형진',6,'tmsisj',01012341234,'');
insert into member values (2222, 'sales@email.com','이영업',4,'password',01012341234, null);
insert into member values (3333, 'staff@email.com','김행정',5,'password',01012341234, null);
insert into member values (4444, 'teacher@email.com','김영조',3,'password',01012341234, null);
insert into member values (5555, 'test@email.com','김일반',1,'password',01012341234, null);

insert into member values (6666, 'text1@email.com','철수',2,'password',01012341234,'JAVA');
insert into member values (7777, 'text2@email.com','영희',2,'password',01012341234,'JAVA');
insert into member values (8888, 'text3@email.com','짱구',2,'password',01012341234,'JAVA');
