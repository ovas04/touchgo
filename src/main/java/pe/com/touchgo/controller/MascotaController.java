package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.touchgo.domain.Mascota;
import pe.com.touchgo.service.IMascotaService;

import java.util.Map;

@Controller
@RequestMapping("/mascota")
@SessionAttributes("mascota")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @Value("${SERVER}")
    private String serverAddress;

    @Value("${PORT}")
    private String serverport;

    @RequestMapping(value = "/detalle/{id}",method = RequestMethod.GET)
    public String mostrarDatosMascota(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Mascota mascota = mascotaService.findByID(id);

        model.put("mascota", mascota);

        return "mascota/detalle";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String formularioMascota(Map<String,Object> model){

        Mascota mascota = new Mascota();

        model.put("mascota",mascota);

        return "/mascota/registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registrarMascota(Map<String,Object> model, @ModelAttribute("mascota")  Mascota mascota, SessionStatus status, RedirectAttributes redirectAttributes){

        mascotaService.saveMascota(mascota);

        status.setComplete();

        model.put("response","Registro Correcto");

        redirectAttributes.addAttribute("id", mascota.getId());

        return "redirect:/mascota/enlace/{id}";
    }

    @RequestMapping(value = "/enlace/{id}",method = RequestMethod.GET)
    public String mostrarEnlace(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        String url = serverAddress + ":" + serverport + "/mascota/detalle/" + id.toString();

        model.put("enlace", url);

        return "mascota/enlace";
    }

}
