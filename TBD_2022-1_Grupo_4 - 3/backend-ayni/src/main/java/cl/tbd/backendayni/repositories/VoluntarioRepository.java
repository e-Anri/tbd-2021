package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Voluntario;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface para VoluntarioRepository
 */
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
    // Crud Repository
    List<Voluntario> findAll();

    Optional<Voluntario> findById(String id);

    Voluntario save(Voluntario voluntario);

    void delete(Voluntario voluntario);
}
