package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.touchgo.service.IDispositivoService;

@Controller
public class GeneralController {

    @Value("${SERVER}")
    private String serverAddress;

    @Autowired
    private IDispositivoService dispositivoService;

    @RequestMapping(value = {"", "/", "/index", "/sessions"}, method = RequestMethod.GET)
    public String menuPrincipal(Model model) {

        String urlPersona = serverAddress  + "/persona/registro";
        String urlMascota = serverAddress  + "/mascota/registro";
        String urlPaciente = serverAddress  + "/paciente/registro";
        String urlDispositivos = serverAddress  + "/dispositivos";
        String urlProducto = serverAddress  + "/producto/registro";

        model.addAttribute("urlPersona", urlPersona);
        model.addAttribute("urlMascota", urlMascota);
        model.addAttribute("urlPaciente", urlPaciente);
        model.addAttribute("urlDispositivos", urlDispositivos);
        model.addAttribute("urlProducto", urlProducto);

        return "menu";
    }

    @RequestMapping(value = {"/dispositivos"}, method = RequestMethod.GET)
    public String dispositivosCompatibles(Model model){

        model.addAttribute("dispositivos", dispositivoService.findAllDispositivos());

        return "dispositivos";
    }

}
