package sotrap.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sotrap.com.project.model.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation,String> {
}
