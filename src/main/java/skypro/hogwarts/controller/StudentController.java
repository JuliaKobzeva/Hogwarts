package skypro.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.service.StudentService;

@RequestMapping("student")
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
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity deleteStudent(@PathVariable Long Id){
        Student deletedStudent = studentService.deleteStudent(Id);
        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping("{age}")
    public ResponseEntity getStudentsByAge(@PathVariable Integer age) {
        Student student = studentService.getStudentsByAge(age);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}
