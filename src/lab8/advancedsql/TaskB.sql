-- B. Adding an Index

explain analyze select * from Employee

CREATE INDEX idx_employee_name ON Employee (name);

explain analyze select * from Employee

--drop index if exists idx_employee_name

