package skypro.hogwarts.service;

import org.springframework.stereotype.Service;
import skypro.hogwarts.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private Map <Long, Student> students = new HashMap<>();
    private Long generatedId = 1L;

    public Student createStudent(Student student) {
        students.put(generatedId, student);
        generatedId++;
        return student;
    }

    public Student getStudentById(Long Id) {
        return students.get(Id);
    }

    public Student updateStudent(Long Id, Student student) {
        students.put(generatedId, student);
        return student;
    }

    public Student deleteStudent(Long Id) {
        return students.remove(Id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
