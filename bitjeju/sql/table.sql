drop sequence member_seq;
drop sequence lectures_seq;
drop sequence recruit_seq;
drop sequence notice_seq;
drop sequence dataroom_seq;
drop table dataroom;
drop table notice;
drop table grade;
drop table board2;
drop table lectures;
drop table attendance;
drop table recruit;
drop table member;
drop table bitjejudept;--다른데서 참조하므로 항상 drop을 마지막에 해줘야함


create table bitjejudept(
	dept varchar2(20) primary key,
	lvl number unique not null
);
--부서와 권한레벨을 가진 테이블, 6개의 부서로 나뉜다. 

insert into bitjejudept values ('일반회원',0);
insert into bitjejudept values ('수료생',1);
insert into bitjejudept values ('수강생',2);
insert into bitjejudept values ('강사',3);
insert into bitjejudept values ('영업',4);
insert into bitjejudept values ('행정',5);
insert into bitjejudept values ('관리자',6);

select * from bitjejudept;

create sequence member_seq;
create table member(					
	num number primary key, 			
	id_email varchar2(50) unique not null,
	name varchar2(15),					
	lvl number(1) default 0,			
	password varchar2(15) not null, 	
	phone varchar2(15),					
	lecture varchar2(50),					
	foreign key(lvl) references bitjejudept(lvl)
);

commit


select * from MEMBER;
select * from member where dept='수강생';

insert into member values (member_seq.nextval||member_seq.currval, 'tmsisj@email.com','형진',6,'tmsisj',01012341234,'');
insert into member values (member_seq.nextval||member_seq.currval, 'sales@email.com','이영업',4,'password',01012341234, null);
insert into member values (member_seq.nextval||member_seq.currval, 'staff@email.com','김행정',5,'password',01012341234, null);
insert into member values (member_seq.nextval||member_seq.currval, 'teacher@email.com','김영조',3,'password','01012341234', null);
insert into member values (member_seq.nextval||member_seq.currval, 'test@email.com','일반',1,'password',01012341234, null);

insert into member values (member_seq.nextval||member_seq.currval, 'text2@email.com','철수2',2,'password',01012341234,'JAVA');

insert into member values (member_seq.nextval||member_seq.currval,'teacher4@email.com','설민석',3,'password',01012341235,null);
insert into member values (member_seq.nextval||member_seq.currval,'teacher5@email.com','황현필',3,'password',01012341235,null);
insert into member values (member_seq.nextval||member_seq.currval,'teacher6@email.com','정민재',3,'password',01012341235,null);

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
	exam3 number,					--영엽사원이 수강신청 받아주면 레벨1>>2로 올리고, 성적테이블에 이름과 넘버 insert
	foreign key(num) references member(num) on delete cascade
);  

create sequence lectures_seq;
create table lectures(								--강좌테이블 A1 B2 C3
	lecture_name varchar2(50),			--강좌명
	start_day date,									--교육기간
	end_day date,
	num number,										--회원번호/./담당강사의 회원번호가 들어감
	lecture_room number,							--강의실번호
	lecture_num number  primary key,
	foreign key(num) references member(num) on delete cascade
);

select lecture_name,start_day,end_day,num,lecture_room,lecture_num,recruit_num from lectures full outer join recruit on recruit_num = lecture_num;

insert into lectures values ('산업기사취득과정A',sysdate,sysdate,22,401,lectures_seq.nextval);
insert into lectures values ('UI/UX 개발자 과정',sysdate,sysdate,22,401,lectures_seq.nextval);
insert into lectures values ('안드로이드 개발자 과정',sysdate,sysdate,22,401,lectures_seq.nextval);



create table recruit (--모집공고게시판>>select * from lecture;>>모집공고 업로드하는 form>> 입력>>리쿠르트테이블에 insert
	recruit_file_name varchar2(200),
	recruit_num number primary key,	
	foreign key(recruit_num) references lectures(lecture_num) on delete cascade
);
insert into recruit values ('naver.png', 1);
select * from recruit;
select * from recruit natural join lectures where recruit_num = lecture_num;
--영업사원>>반배정 메뉴 누르면>> 수강신청생 목록 >>select * from member where lvl<=1 and lecture is not null;
--일반회원 lvl = 0
--수료생 --lvl =1
--수강신청버튼은 레벨이 0인 회원만 누를수있다.
--일반회원이 수강신청 버튼 눌렀을 떄, update member set lecture = '신청한강좌명' where num<=1(수료생or일반회원)


--예전날짜로 출석체크 업데이트했을때// 오늘날짜로 넘어감. 


--create table board2(									--기본적인 게시판 테이블
--	num number primary key,
--	title varchar2(100) not null,
--	writer varchar2(50) not null,
--	wtime date,
--	content varchar2(3000),
--	ref number,
--	serial number,
--	lev	number,
--	filename varchar2(255)
--);

--자료실 게시판 강사
create sequence dataroom_seq;

create table dataroom(
	drNum number primary key,
	drTitle varchar2(200) default '제목없음',
	num number,
	drDate date,
	fileName varchar2(300),
	drContent varchar2(2048),
	foreign key (num) references member(num)
);


 --공지사항 게시판
create sequence notice_seq;
create table notice(                          
   ntnum number primary key,
   title varchar2(100) not null,
   num number,
   wtime date,
   content varchar2(3000),
   foreign key (num) references member(num)
);



