package skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.hogwarts.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long>{
    Collection<Student> findByAge(int age);
}
