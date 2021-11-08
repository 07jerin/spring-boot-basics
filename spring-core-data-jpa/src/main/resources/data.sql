 

--Table creation is required only for JDBC and not for JPA for in memory DB
create table person (

id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);



insert into person (id, name, location, birth_date) values(1, 'A', 'L1', sysdate());
insert into person (id, name, location, birth_date) values(2, 'B', 'L2', sysdate());
insert into person (id, name, location, birth_date) values(3, 'C', 'L3', sysdate());