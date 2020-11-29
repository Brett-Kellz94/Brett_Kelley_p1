drop table employee;
create table employee (
employeeid int not null,
first_name varchar(100) not null,
last_name varchar(100) not null,
title varchar(100) not null,
supervisorid int,
employee_type int not null 
);

insert into employee (employeeid, first_name, last_name, title, supervisorid, employee_type) values (1, 'Brendan', 'Frasier', 'Sales Associate', 2, 1);
insert into employee (employeeid, first_name, last_name, title, supervisorid, employee_type) values (2, 'Rita', 'Smith', 'Retail Manager', 3, 2);
insert into employee (employeeid, first_name, last_name, title, employee_type) values (3, 'Alex', 'Murphy', 'Department Manager',  3);
insert into employee (employeeid, first_name, last_name, title, employee_type) values (4, 'Pete', 'Michaels', 'Benefits Coordinator', 4);
insert into employee (employeeid, first_name, last_name, title, supervisorid, employee_type) values (5, 'Marsha', 'Davis', 'Secretary', 3, 1);

drop table login_info;
create table login_info ( employeeid int not null,
account_password varchar (10),
employee_type int,
constraint pk_employeeid primary key (employeeid));

insert into login_info (employeeid, account_password, employee_type) values (1, 'password', 1);
insert into login_info (employeeid, account_password, employee_type) values (2, 'password', 2);
insert into login_info (employeeid, account_password, employee_type) values (3, 'password', 3);
insert into login_info (employeeid, account_password, employee_type) values (4, 'password', 4);
insert into login_info (employeeid, account_password, employee_type) values (5, 'password', 1);

drop table request;
create table request (
requestid serial not null,
employeeid int not null,
request_date date not null,
event_date date not null,
description varchar(100),
training_cost numeric(10,2),
type_of_event varchar(100),
attachment bytea,
supervisor_approval varchar(100),
department_head_approval varchar(100),
benco_approval varchar(100),
constraint pk_requestid primary key (requestid));

drop table final_grade;
create table final_grade (
gradeid serial,
requestid int not null,
grading_format varchar (100),
final_grade varchar (30) not null,
upload bytea,
constraint pk_grade primary key (gradeid));

drop table award;
create table award ( 
awardid serial not null,
requestid int not null,
employeeid int not null,
award_amount numeric (10,2),
constraint pk_awardid primary key (awardid));

