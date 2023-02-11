package skypro.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        logger.debug("A new student {} was created", student);
        return studentRepository.save(student);
    }

    public Student getStudentById(Long Id) {
        logger.debug("The student {} was found by id", Id);
        logger.error("The id {} doesn't exist", Id);
        return studentRepository.getById(Id);
    }

    public Student updateStudent(Student student) {
        logger.debug("The information about the student {} was updated", student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long Id) {
        logger.debug("The student {} was deleted", Id);
        logger.error("The id {} doesn't exist", Id);
        studentRepository.deleteById(Id);
    }

    public Collection<Student> findByAge(int age) {
        logger.debug("Student whose age is {} were found", age);
        logger.error("The age {} doesn't exist", age);
        return studentRepository.findByAge(age);
    }

    public Student findByAgeBetween(int min, int max){
        logger.debug("Students with age between {} and {} were found", min, max);
        logger.error("There are no students with age between {} and {}", min, max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Student findFacultyOfStudent(String name){
        logger.debug("The faculty of the student {} was found", name);
        logger.error("There is no student with name {}", name);
        return studentRepository.findByNameFacultyOfStudent(name);
    }

    public Integer findAmountOfStudents(){
        logger.info("Amount of students was found");
        return studentRepository.findAmountOfStudents();
    }

    public Integer findAverageAgeOfStudents(){
        logger.info("Average age of students was found");
        return studentRepository.findAverageAgeOfStudents();
    }

    public Integer findFiveLastStudents(){
        logger.info("Five last students were found");
        return studentRepository.findFiveLastStudents();
    }

    public Collection<Student> findByName(String name){
        logger.debug("Students with name {} were found", name);
        return studentRepository.findByName(name);
    }
}
