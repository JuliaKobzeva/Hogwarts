package skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.hogwarts.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long>{

}
