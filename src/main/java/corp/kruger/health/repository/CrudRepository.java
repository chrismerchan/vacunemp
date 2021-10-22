package corp.kruger.health.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/*
 * Class: CrudRepository
 * Interface publica que define las operaciones que puede 
 * usarse sobre la entidad empleado. Estas operaciones se 
 * mapean de forma automatica hacia la base de datos
 */
@NoRepositoryBean
public interface CrudRepository<T, ID> extends Repository<T, ID> {
	
	
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional<T> findById(ID id);
    boolean existsById(ID id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
    Iterable<T> findAllByVaccinationStatus(String vaccinationStatus);
    long count();
    void deleteById(ID id);
    void delete(T entity);
    void deleteAll(Iterable<? extends T> entities);
    void deleteAll();

}
