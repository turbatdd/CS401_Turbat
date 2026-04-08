-- A. Creating a Database View
create view EmployeeDetails as
select distinct
    e.emp_id,
    e.salary,
    e."name" as employee_name,
    d."name" as dept_name,
    p.project_name
from 	employee e
            join department d  on e.dept_id = d.dept_id
            join employee_project ep  on ep.emp_id = e.emp_id
            join project p on ep.project_id  = p.project_id
group by e.emp_id ,e.salary ,e."name" ,d."name", p.project_name


select * from employeedetails e
