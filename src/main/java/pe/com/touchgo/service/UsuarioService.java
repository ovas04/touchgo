package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IUsuarioDao;
import pe.com.touchgo.domain.Usuario;

@Service
public class UsuarioService implements  IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {

        return  usuarioDao.findByUsernameAndPassword(username, password);

    }
}
