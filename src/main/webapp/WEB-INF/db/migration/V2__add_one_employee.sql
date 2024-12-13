BEGIN;

INSERT INTO employees (emp_name, emp_surname, emp_department, emp_salary, emp_version)
VALUES ('Иван', 'Лопин', 'IT', 1800,
        0)
RETURNING emp_id;

INSERT INTO emp_details (emp_details_email, emp_details_phone_number, emp_details_password,
                         emp_details_rating, emp_id, emp_details_version)
VALUES ('xsardesxsardes@gmail.com', '+79500635346',
        'password123', 10,
        currval(pg_get_serial_sequence('employees', 'emp_id')), 0);

COMMIT;