package skypro.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("{Id}")
    public ResponseEntity getStudent(@PathVariable Long Id) {
        Student student = studentService.getStudentById(Id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{Id}")
    public void deleteStudent(@PathVariable Long Id){
       studentService.deleteStudent(Id);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping
    public ResponseEntity findByAgeBetween(@RequestParam int min, @RequestParam int max){
        if(min < 0 || max < 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
    }

    public ResponseEntity findFacultyOfStudent(@RequestParam String name){
        return ResponseEntity.ok(studentService.findFacultyOfStudent(name));
    }

}
