


CREATE SEQUENCE employee_id_seq;
CREATE TABLE employee (
    id integer NOT NULL PRIMARY KEY DEFAULT nextval('employee_id_seq'),
	first_name text NOT NULL,
	last_name text NOT NULL,
	email text NOT NULL
);
ALTER SEQUENCE employee_id_seq OWNED BY employee.id;