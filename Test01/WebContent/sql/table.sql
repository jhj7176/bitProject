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
	dept varchar2(20) default '일반회원',
	deptno number(1) default 1,
	password varchar2(15) not null,
	phone number,
	lecture varchar2(30)
);

create table attend(
	mnum number, --회원테이블의 회원번호 FK 
	attdate date,	--출석체크 날짜
	attendance varchar2(10), --출성정보(출석, 지각, 결석, 조퇴)
 	--att number default 0,
	--late number default 0,
	--absent number default 0,
	foreign key(mnum) references member(mnum) on delete cascade --회원테이블 회원번호 외래키지정	
);
--기본 테이블 스키마. 필수만 표기함. 컬럼 추가 가능 

select * from (select to_char(attdate) as charattdate, mnum, attendance from attend) where mnum=22 and charattdate='20/08/05';
--8월5일 22번학생의 출석정보 (출석 or 지각 or 결석 or 조퇴)

update attend set attendance = 'late' where mnum = 22 and to_char(attdate) = '20/08/05';
--8월5일 오전 출석체크에서 22번 학생 없어서 결석으로 insert
--8월5일 22번학생 9시 이후에 출석함
--8월5일 22번학생 결석>>지각으로 변경

select count(*) from attend where mnum = 11 and attendance='att';--11번학생의 출석일수
select count(*) from attend where mnum = 11;					--11번학생의 총 수업일수






insert into attend (mnum) values (11);
insert into attend (mnum) values (22);
insert into attend (mnum) values (33);
insert into attend (mnum) values (44);
insert into attend (mnum) values (55);
insert into attend (mnum) values (66);
insert into attend (mnum) values (77);
insert into attend (mnum) values (88);
insert into attend (mnum) values (99);

select * from attend;
select * from attend where mnum=22;
--select count(*) from attend where attdate between '2020-08-05 00:00:00' and '2020-08-05 23:59:59';



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



insert into member values (member_seq.nextval||member_seq.currval, 'text1@email.com','철수1','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text2@email.com','철수2','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text3@email.com','철수3','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text4@email.com','철수4','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text5@email.com','철수5','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text6@email.com','철수6','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text7@email.com','철수7','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text8@email.com','철수8','수강생',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text9@email.com','철수9','수강생',2,'password',01012341234,'JAVA');

select * from member;

insert into attend (mnum,attdate,attendance) values (11,sysdate,'att');

