package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.touchgo.domain.Persona;
import pe.com.touchgo.service.IPersonaService;

import java.util.Map;

@Controller
@RequestMapping("/persona")
@SessionAttributes("persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Value("${SERVER}")
    private String serverAddress;

    @Value("${PORT}")
    private String serverport;

    @RequestMapping(value = "/detalle/{id}",method = RequestMethod.GET)
    public String mostrarDatosPersona(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Persona persona = personaService.findByID(id);

        model.put("persona", persona);

        return "persona/detalle";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String formularioPersona(Map<String,Object> model){

        Persona persona = new Persona();

        model.put("persona",persona);

        return "/persona/registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registrarPersona(Map<String,Object> model, @ModelAttribute("persona")  Persona persona, SessionStatus status, RedirectAttributes redirectAttributes){

        personaService.savePersona(persona);

        status.setComplete();

        model.put("response","Registro Correcto");

        redirectAttributes.addAttribute("id", persona.getId());

        return "redirect:/persona/enlace/{id}";
    }

    @RequestMapping(value = "/enlace/{id}",method = RequestMethod.GET)
    public String mostrarEnlace(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        String url = serverAddress + ":" + serverport + "/persona/detalle/" + id.toString();

        model.put("enlace", url);

        return "persona/enlace";
    }

}
