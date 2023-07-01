package pe.com.touchgo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.touchgo.domain.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario findByUsernameAndPassword(String username, String password);

}
