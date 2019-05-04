CREATE SCHEMA netflix_oss;

CREATE TABLE employee (
    id varchar (100) PRIMARY KEY ,
    first_name varchar (20) NOT NULL ,
    last_name varchar (20) NOT NULL ,
    email varchar (50) NOT NULL ,
    workspace_id varchar (20) NOT NULL
);

CREATE TABLE workspace (
    id varchar (100) PRIMARY KEY ,
    unit int NOT NULL ,
    seat int NOT NULL ,
    serial_number varchar (50) NOT NULL ,
    os_family varchar (10) NOT NULL
);