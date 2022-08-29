package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Tarea;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/*Interface para TareaRepository*/
public interface TareaRepository extends MongoRepository<Tarea, String> {
    // Crud Repository
    List<Tarea> findAll();

    Optional<Tarea> findById(String id);

    Tarea save(Tarea tarea);

    void delete(Tarea tarea);

}
