package pe.com.touchgo.service;

import pe.com.touchgo.domain.Paciente;

public interface IPacienteService {

    Paciente findByID(Long id);

    Paciente savePaciente(Paciente paciente);

}
