package skypro.hogwarts.service;

import org.springframework.stereotype.Service;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long generatedId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculties.put(generatedId, faculty);
        generatedId++;
        return faculty;
    }

    public Faculty getFacultyById(Long Id) {
        return faculties.get(Id);
    }

    public Faculty updateFaculty(Long Id, Faculty faculty) {
        faculties.put(generatedId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long Id) {
        return faculties.remove(Id);
    }

    public Faculty getFacultyByAge(String color) {
        return  faculties.get(color);
    }
}
