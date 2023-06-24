package pe.com.touchgo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.touchgo.domain.Mascota;
import pe.com.touchgo.domain.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
}
