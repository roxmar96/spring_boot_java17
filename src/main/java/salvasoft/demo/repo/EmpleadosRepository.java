package salvasoft.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import salvasoft.demo.model.Empleados;

public interface EmpleadosRepository extends MongoRepository<Empleados, String> {
}
