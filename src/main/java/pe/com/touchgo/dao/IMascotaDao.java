package pe.com.touchgo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.touchgo.domain.Mascota;
import pe.com.touchgo.domain.Persona;

public interface IMascotaDao extends CrudRepository<Mascota, Long> {
}
