--liquibase formatted sql

--changeset jkobzeva:1
CREATE INDEX students_name_index ON students (name);

--changeset jkobzeva:2
CREATE INDEX faculty_name&color_index ON faculties (name, color);

