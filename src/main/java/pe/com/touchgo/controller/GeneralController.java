package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralController {

    @Value("${SERVER}")
    private String serverAddress;


    @RequestMapping(value = {"", "/", "/index", "/sessions"}, method = RequestMethod.GET)
    public String menuPrincipal(Model model) {

        String urlPersona = serverAddress  + "/persona/registro";
        String urlMascota = serverAddress  + "/mascota/registro";
        String urlPaciente = serverAddress  + "/paciente/registro";

        model.addAttribute("urlPersona", urlPersona);
        model.addAttribute("urlMascota", urlMascota);
        model.addAttribute("urlPaciente", urlPaciente);

        return "menu";
    }
}
