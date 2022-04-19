create table employee(
    id bigint not null auto_increment primary key,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    active boolean not null,
    created date not null
);
create table employee_assessment(
    id bigint not null auto_increment primary key,
    employeeId bigint not null,
    assessment text not null,
    created date not null
);