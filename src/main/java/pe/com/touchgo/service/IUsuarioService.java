package pe.com.touchgo.service;

import pe.com.touchgo.domain.Producto;
import pe.com.touchgo.domain.Usuario;

public interface IUsuarioService {

    Usuario findByUsernameAndPassword(String username, String password);
}
