package pe.com.touchgo.service;

import pe.com.touchgo.domain.Paciente;
import pe.com.touchgo.domain.Persona;

public interface IPersonaService {

    Persona findByID(Long id);

    Persona savePersona(Persona persona);
}
