package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.touchgo.domain.Paciente;
import pe.com.touchgo.service.IPacienteService;

import java.util.Map;

@Controller
@RequestMapping("/paciente")
@SessionAttributes("paciente")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @Value("${SERVER}")
    private String serverAddress;

    @RequestMapping(value = "/detalle/{id}",method = RequestMethod.GET)
    public String mostrarDatosPaciente(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Paciente paciente = pacienteService.findByID(id);

        model.put("paciente", paciente);

        return "paciente/detalle";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String formularioPaciente(Map<String,Object> model){

        Paciente paciente = new Paciente();

        model.put("paciente",paciente);

        return "paciente/registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registrarPaciente(Map<String,Object> model, @ModelAttribute("paciente")  Paciente paciente, SessionStatus status, RedirectAttributes redirectAttributes){

        pacienteService.savePaciente(paciente);

        status.setComplete();

        model.put("response","Registro Correcto");

        redirectAttributes.addAttribute("id", paciente.getId());

        return "redirect:/paciente/enlace/{id}";
    }

    @RequestMapping(value = "/enlace/{id}",method = RequestMethod.GET)
    public String mostrarEnlace(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        String url = serverAddress  + "/paciente/detalle/" + id.toString();

        model.put("enlace", url);

        return "paciente/enlace";
    }

}
