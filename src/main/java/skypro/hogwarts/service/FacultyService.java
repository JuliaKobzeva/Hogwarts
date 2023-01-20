package skypro.hogwarts.service;

import org.springframework.stereotype.Service;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long Id) {
        return facultyRepository.getById(Id);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long Id) {
        facultyRepository.deleteById(Id);
    }

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultyRepository.findAll()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }

    public Faculty findByNameIgnoreCase(String name){
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> findStudentsOfFaculty(String faculty){
        return facultyRepository.findByNameStudentsOfFaculty(faculty);
    }
}
