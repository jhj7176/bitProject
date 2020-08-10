drop table grade;
drop table board2;
drop table lectures;
drop table attendance;
drop table member;--member테이블의 num을 다른데서 참조하므로 항상 drop을 마지막에 해줘야함
drop table bitjejudept;
drop sequence member_seq;
drop sequence lectures_seq;


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

create sequence member_seq;
create table member(						--회원테이블
	num number primary key, 				--회원번호
	id_email varchar2(50) unique not null,  --이메일을 아이디로씀
	name varchar2(15),						--회원이름
	dept varchar2(20) default '일반회원',		--회원명
	lvl number(1) default 1,				--등급
	password varchar2(15) not null, 		--비밀번호 영문+숫자조합
	phone number,							--전화번호
	lecture varchar2(30),					--강좌명 
	foreign key(dept) references bitjejudept(dept) on delete cascade,
	foreign key(lvl) references bitjejudept(lvl) on delete cascade
);

select * from MEMBER;
select * from member where dept='수강생';

insert into member values (member_seq.nextval||member_seq.currval, 'tmsisj@email.com','형진','관리자',6,'tmsisj',01012341234,'');
insert into member values (member_seq.nextval||member_seq.currval, 'sales@email.com','이영업','영업',4,'password',01012341234, null);
insert into member values (member_seq.nextval||member_seq.currval, 'staff@email.com','김행정','행정',5,'password',01012341234, null);
insert into member values (member_seq.nextval||member_seq.currval, 'teacher@email.com','김영조','강사',3,'password',01012341234, null);
insert into member values (member_seq.nextval||member_seq.currval, 'test@email.com','일반','일반회원',1,'password',01012341234, null);

insert into member values (member_seq.nextval||member_seq.currval, 'text2@email.com','철수2','수강생',2,'password',01012341234,'JAVA');


create table attendance( --출석테이블
	nalja date not null,
	num number,
	state varchar2(10), --출석 지각 결석 조퇴
	foreign key(num) references member(num) on delete cascade --foreign key지정. member테이블 num참조
);

insert into attendance values('2020-08-04',11,'attend');
insert into attendance values('2020-08-04',22,'attend');
insert into attendance values('2020-08-04',33,'absent');


commit;

select * from attendance;

create table grade(  			--성적테이블
	num number primary key,		--회원번호로 누군지 식별함. 멤버테이블 num참조
	exam1 number,				--시험성적
	exam2 number,
	exam3 number,
	foreign key(num) references member(num) on delete cascade
);  

create sequence lectures_seq;
create table lectures(								--강좌테이블
	lecture_name varchar2(50),			--강좌명
	start_day date,									--교육기간
	end_day date,
	num number,										--회원번호/./담당강사의 회원번호가 들어감
	lecture_room number,							--강의실번호
	lecture_num number  primary key,
	foreign key(num) references member(num) on delete cascade
);


insert into lectures values ('산업기사취득과정A',sysdate,sysdate,22,401,lectures_seq.nextval);
insert into lectures values ('UI/UX 개발자 과정',sysdate,sysdate,22,401,lectures_seq.nextval);
insert into lectures values ('안드로이드 개발자 과정',sysdate,sysdate,22,401,lectures_seq.nextval);



create table board2(									--기본적인 게시판 테이블
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