# drop table fac;

create table fac(
    fac_id varchar(10) primary key,
    name varchar(20),
    email varchar(30)
);

#alter table fac rename column id to fac_id;

select * from fac;

# drop table stu;
create table stu(
    stu_id varchar(10) primary key,
    name varchar(20),
    email varchar(30),
    special_id varchar(10) references spec(spec_id)
);

#alter table stu rename column id to stu_id;

select * from stu;

# drop table cou;
create table cou(
    cou_id varchar(10) primary key,
    name varchar(20),
    credit int,
    faculty_id varchar(10) references fac(fac_id)
);
select * from cou;

# drop table spec;
create table spec(
    spec_id varchar(10) primary key,
    name varchar(20),
    credit int
);
select * from spec;


# drop table spec_cou;
create table spec_cou(
    course_id varchar(10) references cou(cou_id),
    special_id varchar(10) references spec(spec_id),
    constraint prim_key primary key (course_id,special_id)
);
select * from spec_cou;

# drop table stu_cou;
create table stu_cou(
    course_id varchar(10) references cou(cou_id),
    student_id varchar(10) references stu(stu_id),
    constraint prim_key primary key (course_id,student_id)
);
select * from stu_cou;