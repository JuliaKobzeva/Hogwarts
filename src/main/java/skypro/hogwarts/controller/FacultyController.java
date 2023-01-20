package skypro.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("/faculty")
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
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{Id}")
    public void deleteFaculty(@PathVariable Long Id){
        facultyService.deleteFaculty(Id);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping
    public ResponseEntity findByNameIgnoreCase(@RequestParam String name){
        if(name == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyService.findByNameIgnoreCase(name));
    }

    @GetMapping
    public ResponseEntity findStudentsOfFaculty(@RequestParam Long id){
        return ResponseEntity.ok(facultyService.findStudentsOfFaculty(id));
    }

}
