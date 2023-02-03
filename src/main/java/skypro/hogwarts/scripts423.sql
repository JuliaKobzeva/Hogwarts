SELECT Student.name, Student.age, Faculty.name FROM Student INNER JOIN Faculty ON Student.faculty_id = Faculty.id
SELECT Student.name, Student.age, Avatar.id FROM Student INNER JOIN Avatar ON Student.avatar_id = Avatar.id
