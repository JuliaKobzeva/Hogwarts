package skypro.hogwarts.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skypro.hogwarts.model.Avatar;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.service.AvatarService;
import skypro.hogwarts.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;
    private final AvatarService avatarService;

    public StudentController(StudentService studentService, AvatarService avatarService) {
        this.studentService = studentService;
        this.avatarService = avatarService;
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

    @GetMapping
    public ResponseEntity findFacultyOfStudent(@RequestParam String name){
        return ResponseEntity.ok(studentService.findFacultyOfStudent(name));
    }

    @PostMapping(value = "{Id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long Id, @RequestParam MultipartFile avatar) throws IOException{
        if(avatar.getSize() >= 1024 * 300){
            return ResponseEntity.badRequest().body("Файл слишком большой");
        }
        avatarService.uploadAvatar(Id, avatar);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{Id}/avatar/preview")
    public ResponseEntity<byte[]> downloadAvatarPreview (@PathVariable Long Id){
        Avatar avatar = avatarService.findAvatar(Id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getPreview().length);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getPreview());
    }

    @GetMapping (value = "{Id}/avatar")
    public void downloadAvatar(@PathVariable Long Id, HttpServletResponse response)throws IOException{
        Avatar avatar = avatarService.findAvatar(Id);

        Path path = Path.of(avatar.getFilePath());

        try(InputStream is = Files.newInputStream(path);
            OutputStream os = response.getOutputStream();
        ){
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int)avatar.getFileSize());
            is.transferTo(os);
        }
    }

    @GetMapping("/amount")
    public Integer findAmountOfStudents(){
        return studentService.findAmountOfStudents();
    }

    @GetMapping("/average-age")
    public Integer findAverageAgeOfStudents(){
        return studentService.findAverageAgeOfStudents();
    }

    @GetMapping("/five-last-students")
    public Integer findFiveLastStudents(){
        return studentService.findFiveLastStudents();
    }

}
