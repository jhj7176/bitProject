drop table attend;
drop table grade;
drop table lectures;
drop table notice;
drop table member;
drop sequence member_seq;

create sequence member_seq;
create table member(
	mnum number primary key,
	id_email varchar2(50) unique not null,
	name varchar2(15),
	dept varchar2(20) default '橾奩�蛾�',
	deptno number(1) default 1,
	password varchar2(15) not null,
	phone number,
	lecture varchar2(30)
);

create table attend(
	mnum number primary key,
	name varchar2(40),
	id_email varchar2(50), 
	att number default 0,
	late number default 0,
	absent number default 0,
	foreign key(mnum) references member(mnum) on delete cascade,
	foreign key(id_email) references member(id_email) on delete cascade
);

create table grade(
	mnum number primary key,
	exam1 number,
	exam2 number,
	exam3 number,
	name varchar2(15),
	id_email varchar2(50),
	foreign key(mnum) references member(mnum) on delete cascade,
	foreign key(id_email) references member(id_email) on delete cascade
);  

create table lectures(
	lecture_name varchar2(50) primary key,
	start_day date,
	end_day date,
	mnum number,
	name varchar2(15),
	lecture_room number,
	foreign key(mnum) references member(mnum) on delete cascade
);

create table notice(
	num number primary key,
	title varchar2(100) not null,
	writer varchar2(50) not null,
	wtime date,
	content varchar2(3000),
	ref number,
	serial number,
	lev	number,
	filename varchar2(255)
);



insert into member values (member_seq.nextval||member_seq.currval, 'text1@email.com','繹熱1','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text2@email.com','繹熱2','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text3@email.com','繹熱3','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text4@email.com','繹熱4','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text5@email.com','繹熱5','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text6@email.com','繹熱6','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text7@email.com','繹熱7','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text8@email.com','繹熱8','熱鬼儅',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text9@email.com','繹熱9','熱鬼儅',2,'password',01012341234,'JAVA');

select * from member;

insert into attend (mnum, name) values (11, 'AAA');
insert into attend (mnum, name) values (22, 'BBB');
insert into attend (mnum, name) values (33, 'CCC');
insert into attend (mnum, name) values (44, 'DDD');
insert into attend (mnum, name) values (55, 'EEE');
insert into attend (mnum, name) values (66, 'FFF');
insert into attend (mnum, name) values (77, 'GGG');
insert into attend (mnum, name) values (88, 'HHH');
insert into attend (mnum, name) values (99, 'III');

select * from attend;