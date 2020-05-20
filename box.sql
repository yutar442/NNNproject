create table box(
boxnum number(2) primary key check(boxnum<11),
id varchar2(10),
item1 varchar2(21),
item2 varchar2(21),
item3 varchar2(21),
pw number(6)
)




create table person(
id varchar2(10) primary key,
name varchar2(10),
ph number(11)
)


drop table person
insert into person (id, name, ph) values('k001', 'jms1', 01011111111)

select * from PERSON
select * from box

delete from person where id = k001

insert into box (boxnum, id, item1, item2, item3, pw) values(2, 'k002', '±è', '°íµî¾î', '±ïµÎ±â', 54321)

insert into box (boxnum, id, item1, item2, item3, pw) values(3, 'k001', '¼Ò', '°³', '¾ç', 12345)
select person.id, person.name, box.item1, box.item2, box.item3 from person inner join box on person.id = box.id

