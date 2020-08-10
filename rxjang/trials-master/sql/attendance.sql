drop table attendance;

create table attendance( --출석테이블
	nalja date not null,
	num number,
	state varchar2(15), --출석 지각 결석 조퇴
	foreign key(num) references member(num) on delete cascade --foreign key지정. member테이블 num참조
);

insert into attendance values('2020-08-04',6666,'출석');
insert into attendance values('2020-08-04',7777,'출석');
insert into attendance values('2020-08-04',8888,'결석');

commit;

select * from attendance;