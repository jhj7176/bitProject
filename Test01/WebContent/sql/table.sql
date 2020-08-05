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
insert into attend (num, name) values (55, 'EEE');
insert into attend (num, name) values (66, 'FFF');
insert into attend (num, name) values (77, 'GGG');
insert into attend (num, name) values (88, 'HHH');
insert into attend (num, name) values (00, 'III');
commit

select * from attend;