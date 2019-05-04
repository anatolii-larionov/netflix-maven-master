CREATE SCHEMA netflix_oss;

CREATE TABLE employee (
    id varchar (100) PRIMARY KEY ,
    first_name varchar (20) NOT NULL ,
    last_name varchar (20) NOT NULL ,
    email varchar (20) NOT NULL ,
    workspace_id varchar (20) NOT NULL 
);

CREATE TABLE workspace (
    id varchar (100) PRIMARY KEY ,
    unit int NOT NULL ,
    seat int NOT NULL ,
    serial_number varchar (50) NOT NULL ,
    os_family varchar (10) NOT NULL 
);

--INSERT INTO employee(id, first_name, last_name, email, workspace_id)
--VALUES  ('1', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '1') ,
--        ('2', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '2') ,
--        ('3', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '3') ,
--        ('4', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '4') ,
--        ('5', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '5') ,
--        ('6', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '6') ,
--        ('7', 'Ivan', 'Ivanov', 'Ivan_Ivanov@cor.com', '7') ;
--INSERT INTO workspace(id, unit, seat, serial_number, os_family)
--VALUES  ('1', 1, 1, '12345qw23der', 'LINUX') ,
--        ('2', 1, 2, '1e2342wecrom', 'WINDOWS') ,
--        ('3', 2, 3, '122346qwerom', 'LINUX') ,
--        ('4', 3, 4, '12eww345qwer', 'WINDOWS') ,
--        ('5', 2, 5, '12we3345qrom', 'LINUX') ,
--        ('6', 1, 6, '12sda345qrom', 'WINDOWS') ,
--        ('7', 1, 7, '12345qweweom', 'OSX') ;

SELECT * FROM employee;
SELECT * FROM workspace;

-- To clear table
DELETE FROM employee;
DELETE FROM workspace;