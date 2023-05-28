package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IPersonaDao;
import pe.com.touchgo.domain.Paciente;
import pe.com.touchgo.domain.Persona;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public Persona findByID(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaDao.save(persona);
    }

}
