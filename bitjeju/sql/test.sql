select lecture_name, name, lecture_num, num, lecture_room, start_day, end_day from lectures natural join member where lecture_num=2



delete from lectures where lecture_name='�׽�Ʈ3' and lecture_num=8;

insert into member values (member_seq.nextval||member_seq.currval,'teacher4@email.com','���μ�','����',3,'password',01012341235,null);
insert into member values (member_seq.nextval||member_seq.currval,'teacher5@email.com','Ȳ����','����',3,'password',01012341235,null);
insert into member values (member_seq.nextval||member_seq.currval,'teacher6@email.com','������','����',3,'password',01012341235,null);
select * from member;
select * from lectures;
select * from BITJEJUDEPT;
commit;


select * from member full outer join grade on member.num = GRADE.num where num = 4848;

select * from lectures where lecture_name=(select lecture from member where num=1010);

select * from lectures natural join member;

select * from member natural join grade where num =1010;
select * from attendance where num = 1010;

select lecture_name, lecture_num, lecture_room, name, start_day, end_day from lectures natural join member where lecture_name=(select lecture from member where num=1313);



insert into member values (member_seq.nextval||member_seq.currval,'tttt','tttt',0,'asdf1234',01011111111,null);
















