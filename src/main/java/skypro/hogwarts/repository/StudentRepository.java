package skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import skypro.hogwarts.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long>{
    Student findByAgeBetween(int min, int max);
    Student findByNameFacultyOfStudent(String name);
    Collection<Student> findByAge(int age);

    @Query(value = "SELECT COUNT(*) FROM Student", nativeQuery = true)
    Integer findAmountOfStudents();

    @Query(value = "SELECT AVG(age) FROM Student", nativeQuery = true)
    Integer findAverageAgeOfStudents();

    @Query(value = "SELECT * FROM Student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Integer findFiveLastStudents();
}
