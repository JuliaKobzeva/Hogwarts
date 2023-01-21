package skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.hogwarts.model.Faculty;
import skypro.hogwarts.model.Student;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository <Faculty, Long>{
    Faculty findByNameIgnoreCase(String name);
    Collection<Student> findStudentsByFacultyId(Long Id);
    Collection<Faculty> findByColor(String color);
}
