package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.com.touchgo.domain.Usuario;
import pe.com.touchgo.service.IDispositivoService;
import pe.com.touchgo.service.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class GeneralController {

    @Value("${SERVER}")
    private String serverAddress;

    private Boolean flagLogin = false;

    @Autowired
    private IDispositivoService dispositivoService;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(value = {"", "/", "/index", "/sessions"}, method = RequestMethod.GET)
    public String menuPrincipal(Model model) {

        if (!flagLogin) return "redirect:/login";

        String urlPersona = serverAddress  + "/persona/registro";
        String urlMascota = serverAddress  + "/mascota/registro";
        String urlPaciente = serverAddress  + "/paciente/registro";
        String urlDispositivos = serverAddress  + "/dispositivos";

        model.addAttribute("urlPersona", urlPersona);
        model.addAttribute("urlMascota", urlMascota);
        model.addAttribute("urlPaciente", urlPaciente);
        model.addAttribute("urlDispositivos", urlDispositivos);

        return "menu";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLogin(Model model){

        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String signIn(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status){

        usuario = usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());

        if (usuario.getId() != null){
            status.setComplete();
            flagLogin=true;
            return "redirect:/index";

        }
        else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/dispositivos"}, method = RequestMethod.GET)
    public String dispositivosCompatibles(Model model){

        model.addAttribute("dispositivos", dispositivoService.findAllDispositivos());

        return "dispositivos";
    }

}
