package pe.com.touchgo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.touchgo.domain.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
}
