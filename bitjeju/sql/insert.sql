
insert into member values (member_seq.nextval||member_seq.currval,'text30@email.com','철수23',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text31@email.com','철수24',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text32@email.com','철수25',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text33@email.com','철수26',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text34@email.com','철수27',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text35@email.com','철수28',2,'password','01012341234','UI/UX 개발자과정');
insert into member values (member_seq.nextval||member_seq.currval,'text36@email.com','철수29',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text37@email.com','철수30',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text38@email.com','철수31',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text39@email.com','철수32',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text40@email.com','철수33',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text41@email.com','철수34',2,'password','01012341234','산업기사취득과정A');
insert into member values (member_seq.nextval||member_seq.currval,'text42@email.com','철수35',2,'password','01012341234','산업기사취득과정A');

delete from member where lvl=2;

commit;
insert into GRADE values (88, 70, 78, 79);
insert into GRADE values (99, 70, 78, 79);
insert into GRADE values (1010, 88, 86, 89);
insert into GRADE values (1111, 90, 98, 99);
insert into GRADE values (1212, 60, 68, 79);
insert into GRADE values (1313, 70, 48, 39);
update member set LECTURE='산업기사취득과정A' where num = 1010;
update member set LECTURE='산업기사취득과정A' where num = 1111;
update member set LECTURE='UI/UX 개발자과정' where num = 1212;
update member set LECTURE='UI/UX 개발자과정' where num = 1313;

	
