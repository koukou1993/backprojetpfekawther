package sotrap.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sotrap.com.project.model.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {


}
