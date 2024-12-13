CREATE TABLE IF NOT EXISTS employees (
                                         emp_id SERIAL PRIMARY KEY,
                                         emp_name VARCHAR(50),
                                         emp_surname VARCHAR(50),
                                         emp_department VARCHAR(50),
                                         emp_salary INT,
                                         emp_version INT
);

CREATE TABLE IF NOT EXISTS emp_details (
                                           emp_details_id SERIAL PRIMARY KEY,
                                           emp_details_email VARCHAR(100),
                                           emp_details_phone_number VARCHAR(20),
                                           emp_details_password VARCHAR(50),
                                           emp_details_rating INT,
                                           emp_id INT,
                                           emp_details_version INT,
                                           CONSTRAINT fk_employees
                                               FOREIGN KEY (emp_id) REFERENCES employees (emp_id)
                                                   ON DELETE CASCADE
);