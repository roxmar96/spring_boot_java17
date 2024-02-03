package salvasoft.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import salvasoft.demo.model.Email;

public interface EmailRepository extends MongoRepository<Email, String> {
}
