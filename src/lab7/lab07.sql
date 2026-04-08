
CREATE Database lab07;

USE lab07;

CREATE TABLE Address (
    address_id INT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    zipcode VARCHAR(10)
);


create TABLE Department (
dept_id INT primary key,
name VARCHAR(50) not NULL
);



create TABLE Employee (
    emp_id INT primary key,
    name VARCHAR(50) not NULL,
    salary INT,
    address_id INT references Address(address_id),
    dept_id INT references Department(dept_id)
);




create TABLE Project (
    project_id INT primary key,
    project_name VARCHAR(50),
    estimated_days INT,
    location VARCHAR(50)
);

create TABLE Employee_Project (
    emp_id INT references Employee(emp_id),
    project_id INT references Project(project_id),
    primary key(emp_id,project_id)
);


-- *** 1. Insert Data into Address Table ***
INSERT INTO Address (address_id, city, state, zipcode) VALUES
(1, 'Fairfield', 'IA', '52556'),
(2, 'Iowa City', 'IA', '52440'),
(3, 'Morrison', 'IL', '61270'),
(4, 'Orlando', 'FL', '34565'),
(5, 'Tampa', 'FL', '31765');
-- *** 2. Insert Data into Department Table ***
INSERT INTO Department (dept_id, name) VALUES
(1, 'Tech'),
(2, 'HR'),
(3, 'Finance'),
(4, 'Marketing');

-- *** 3. Insert Data into Project Table ***
INSERT INTO Project (project_id, project_name, estimated_days, location)
VALUES
(1, 'X', 180, 'FL'),
(2, 'Y', 60, 'FL'),
(3, 'Z', 80, 'IA');
-- *** 4. Insert Data into Employee Table ***
-- NOTE: This depends on Address (address_id) and Department (dept_id) being populated first.
INSERT INTO Employee (emp_id, name, salary, address_id, dept_id) VALUES
(111, 'Zaineh', 100000, 1, 1),
(112, 'Yasmeen', 160000, 2, 4),
(113, 'Mira', 140000, 3, 3),
(114, 'Shimaa', 200000, 4, 2),
(115, 'Dean', 150000, 5, 1);
-- *** 5. Insert Data into Employee_Project Table ***
-- NOTE: This depends on Employee (emp_id) and Project (project_id) being populated first.
INSERT INTO Employee_Project (emp_id, project_id) VALUES
(115, 1),
(115, 2),
(115, 3),
(114, 1),
(114, 3),
(111, 1),
(111, 2);


-- A. Selection:
select name, salary from employee;

select project_name from Project
    where location = 'FL';

select emp_id, project_id from Employee_Project
    where project_id = 1;

select distinct(state) from Address;

select name, salary from Employee
    where salary < 150000;

select project_name, estimated_days FROM Project
    ORDER BY estimated_days DESC;

select distinct emp_id from Employee_Project;


-- B. Aggregates and Grouping:
select avg(salary) as average_salary from Employee;

select max(estimated_days) as estimated_days from Project;

select dept_id, SUM(salary) as total_salary from employee
    group by dept_id;

select dept_id,salary from employee
    group by dept_id,salary
    having AVG(salary) > 150000;

-- C. Joins:
select e.emp_id , e."name" ,e.salary ,a.city from Employee e
    join address a on e.address_id = a.address_id;

select * from Department d
    left join Employee e on d.dept_id = e.dept_id;

select e."name" as employee_name ,p.project_name from employee e
	inner join employee_project ep on ep.emp_id = e.emp_id
	inner join project p on ep.project_id = p.project_id;

--D. Subqueries

select name from Employee
    where salary = (select MAX(salary) from employee);

SELECT name FROM Employee
    WHERE emp_id IN (
        SELECT emp_id FROM Employee_Project ep
            JOIN Project p ON ep.project_id = p.project_id
            WHERE p.estimated_days = 180
    );

select project_id from project
    where estimated_days > (select AVG(estimated_days) from project );


