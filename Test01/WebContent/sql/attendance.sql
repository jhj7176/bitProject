drop table attendance;

create table attendance(
	nalja date not null,
	num number,
	state varchar2(10)
);

insert into attendance values('2020-08-04',1111,'attend');
insert into attendance values('2020-08-04',2222,'attend');
insert into attendance values('2020-08-04',3333,'absent');
insert into attendance values('2020-08-04',4444,'attend');
insert into attendance values('2020-08-04',5555,'attend');

commit

select * from attendance;

select * from attendance where nalja='2020-08-03';