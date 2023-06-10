package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IDispositvoDao;
import pe.com.touchgo.domain.Dispostivo;

import java.util.List;
@Service
public class DispositivoService  implements  IDispositivoService{

    @Autowired
    private IDispositvoDao dispositvoDao;

    @Override
    public List<Dispostivo> findAllDispositivos() {
        return (List<Dispostivo>) dispositvoDao.findAll();
    }
}
