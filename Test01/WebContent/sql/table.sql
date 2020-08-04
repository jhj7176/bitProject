drop table attend;
create table attend(
	num number primary key,
	name varchar2(40) not null,
	att number default 0,
	late number default 0,
	absent number default 0
);
insert into attend (num, name) values (11, 'AAA');
insert into attend (num, name) values (22, 'BBB');
insert into attend (num, name) values (33, 'CCC');
insert into attend (num, name) values (44, 'DDD');
commit

select * from attend;