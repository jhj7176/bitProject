drop table student;
create table student(
	num number primary key,
	name varchar2(10) not null
);

insert into student values(1111,'stu1');
insert into student values(2222,'stu2');
insert into student values(3333,'stu3');
insert into student values(4444,'stu4');
insert into student values(5555,'stu5');

commit;

select * from student;