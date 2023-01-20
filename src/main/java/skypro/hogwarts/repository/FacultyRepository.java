package skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.hogwarts.model.Faculty;

public interface FacultyRepository extends JpaRepository <Faculty, Long>{
    Faculty findByNameIgnoreCase(String name);
}
