package skypro.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.service.FacultyService;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{Id}")
    public ResponseEntity getFaculty (@PathVariable Long Id) {
        Faculty faculty = facultyService.getFacultyById(Id);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity deleteFaculty(@PathVariable Long Id){
        Faculty deletedFaculty = facultyService.deleteFaculty(Id);
        return ResponseEntity.ok(deletedFaculty);
    }

    @GetMapping("{color}")
    public ResponseEntity getFacultysByAge(@PathVariable String color) {
        Faculty faculty  = facultyService.getFacultyByAge(color);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

}
