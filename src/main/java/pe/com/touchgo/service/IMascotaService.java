package pe.com.touchgo.service;

import pe.com.touchgo.domain.Mascota;

public interface IMascotaService {

    Mascota findByID(Long id);

    Mascota saveMascota(Mascota mascota);

}
