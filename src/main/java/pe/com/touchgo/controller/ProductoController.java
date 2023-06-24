package pe.com.touchgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.touchgo.domain.Producto;
import pe.com.touchgo.service.IProductoService;

import java.util.Map;

@Controller
@RequestMapping("/producto")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Value("${SERVER}")
    private String serverAddress;

    @RequestMapping(value = "/detalle/{id}",method = RequestMethod.GET)
    public String mostrarDatosProducto(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Producto producto = productoService.findByID(id);

        model.put("producto", producto);

        return "producto/detalle";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String formularioProducto(Map<String,Object> model){

        Producto producto = new Producto();

        model.put("producto",producto);

        return "producto/registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registrarProducto(Map<String,Object> model, @ModelAttribute("producto")  Producto producto, SessionStatus status, RedirectAttributes redirectAttributes){

        productoService.saveProducto(producto);

        status.setComplete();

        model.put("response","Registro Correcto");

        redirectAttributes.addAttribute("id", producto.getId());

        return "redirect:/producto/enlace/{id}";
    }

    @RequestMapping(value = "/enlace/{id}",method = RequestMethod.GET)
    public String mostrarEnlace(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        String url = serverAddress + "/producto/detalle/" + id.toString();

        model.put("enlace", url);

        return "producto/enlace";
    }
}
