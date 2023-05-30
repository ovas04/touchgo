package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IMascotaDao;
import pe.com.touchgo.dao.IPacienteDao;
import pe.com.touchgo.domain.Paciente;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private IPacienteDao pacienteDao;

    @Override
    public Paciente findByID(Long id) {
        return pacienteDao.findById(id).orElse(null);
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteDao.save(paciente);
    }
}
