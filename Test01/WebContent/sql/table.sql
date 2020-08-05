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
	dept varchar2(20) default '�Ϲ�ȸ��',
	deptno number(1) default 1,
	password varchar2(15) not null,
	phone number,
	lecture varchar2(30)
);

create table attend(
	mnum number, --ȸ�����̺��� ȸ����ȣ FK 
	attdate date,	--�⼮üũ ��¥
	attendance varchar2(10), --�⼺����(�⼮, ����, �Ἦ, ����)
 	--att number default 0,
	--late number default 0,
	--absent number default 0,
	foreign key(mnum) references member(mnum) on delete cascade --ȸ�����̺� ȸ����ȣ �ܷ�Ű����	
);
--�⺻ ���̺� ��Ű��. �ʼ��� ǥ����. �÷� �߰� ���� 

select * from (select to_char(attdate) as charattdate, mnum, attendance from attend) where mnum=22 and charattdate='20/08/05';
--8��5�� 22���л��� �⼮���� (�⼮ or ���� or �Ἦ or ����)

update attend set attendance = 'late' where mnum = 22 and to_char(attdate) = '20/08/05';
--8��5�� ���� �⼮üũ���� 22�� �л� ��� �Ἦ���� insert
--8��5�� 22���л� 9�� ���Ŀ� �⼮��
--8��5�� 22���л� �Ἦ>>�������� ����

select count(*) from attend where mnum = 11 and attendance='att';--11���л��� �⼮�ϼ�
select count(*) from attend where mnum = 11;					--11���л��� �� �����ϼ�






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



insert into member values (member_seq.nextval||member_seq.currval, 'text1@email.com','ö��1','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text2@email.com','ö��2','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text3@email.com','ö��3','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text4@email.com','ö��4','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text5@email.com','ö��5','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text6@email.com','ö��6','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text7@email.com','ö��7','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text8@email.com','ö��8','������',2,'password',01012341234,'JAVA');
insert into member values (member_seq.nextval||member_seq.currval, 'text9@email.com','ö��9','������',2,'password',01012341234,'JAVA');

select * from member;

insert into attend (mnum,attdate,attendance) values (11,sysdate,'att');

