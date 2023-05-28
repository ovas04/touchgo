package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IMascotaDao;
import pe.com.touchgo.domain.Mascota;
import pe.com.touchgo.domain.Paciente;

@Service
public class MascotaService  implements  IMascotaService{

    @Autowired
    private IMascotaDao mascotaDao;

    @Override
    public Mascota findByID(Long id) {
        return mascotaDao.findById(id).orElse(null);
    }

    @Override
    public Mascota saveMascota(Mascota mascota) {
        return mascotaDao.save(mascota);    }
}
