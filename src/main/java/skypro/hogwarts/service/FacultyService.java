package skypro.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;
import skypro.hogwarts.repository.FacultyRepository;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("A new faculty {} was created", faculty);
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long Id) {
        logger.debug("The faculty {} was found by id ", Id);
        return facultyRepository.getById(Id);
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.debug("The information about faculty {} was updated", faculty);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long Id) {
        logger.debug("The faculty {} was deleted", Id);
        facultyRepository.deleteById(Id);
    }

    public Collection<Faculty> findByColor(String color) {
        logger.debug("Faculties were found by color {}", color);
        return facultyRepository.findByColor(color);
    }

    public Faculty findByNameIgnoreCase(String name){
        logger.debug("The faculty {} was found by name ", name);
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> findStudentsOfFaculty(Long id){
        logger.debug("Students of the faculty {} were found", id);
        return facultyRepository.findStudentsByFacultyId(id);
    }

    public String findLongestFacultyName() {
        String longestFacultyName = facultyRepository.findAll().stream().map(s -> s.getName())
                .max(Comparator.comparingInt(s -> s.length())).get();
        return longestFacultyName;
    }

    //public Integer findSum() {
    //    int sum = Stream.iterate(1, a -> a +1)
    //            .limit(1_000_000)
    //            .parallel()
    //            .reduce(0, (a, b) -> a + b );
    //    return sum;
    //}

    public Integer findSum() {
        int sum = ((1 + 1_000_000)/2)* 1_000_000;
        return sum;
    }

    public Integer findSum2() {
        int num = 1_000_000;
        int sum = IntStream
                .range(1, num +1)
                .sum();

        return sum;
    }
}
