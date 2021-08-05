create table students(
    name varchar_ignorecase(50) not null primary key,
	grade enum('FRESHMAN', 'SOPHOMORE', 'JUNIOR', 'SENIOR')
);

INSERT INTO students (name, grade) VALUES ('John', 'FRESHMAN');
INSERT INTO students (name, grade) VALUES ('Mary', 'SOPHOMORE');
INSERT INTO students (name, grade) VALUES ('Tom', 'JUNIOR');
INSERT INTO students (name, grade) VALUES ('Jessica', 'SENIOR');