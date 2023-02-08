package skypro.hogwarts.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long Id) {
        return studentRepository.getById(Id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long Id) {
        studentRepository.deleteById(Id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Student findByAgeBetween(int min, int max){
        return studentRepository.findByAgeBetween(min, max);
    }

    public Student findFacultyOfStudent(String name){
        return studentRepository.findByNameFacultyOfStudent(name);
    }

    public Integer findAmountOfStudents(){
        return studentRepository.findAmountOfStudents();
    }

    public Integer findAverageAgeOfStudents(){
        return studentRepository.findAverageAgeOfStudents();
    }

    public Integer findFiveLastStudents(){
        return studentRepository.findFiveLastStudents();
    }

    public Collection<Student> findByName(String name){
        return studentRepository.findByName(name);
    }
}
