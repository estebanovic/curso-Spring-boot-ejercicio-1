package com.springboot.web.app.controllers;

import com.springboot.web.app.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", ""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework!!");
        return "index";
    }
    
    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Esteban");
        usuario.setApellido("Obilinovic");
        usuario.setEmail("esteban@gmail.com");
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo", "Perfil de ".concat(usuario.getNombre()));
        return "perfil";
    }
    
    @RequestMapping("/listar")
    public String listar(Model model){
        
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";
    }
    
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Esteban", "Obilinovic", "email@gmail.com"));
        usuarios.add(new Usuario("Shinji", "Ikari", "email@gmail.com"));
        usuarios.add(new Usuario("Gordon", "Freeman", "email@gmail.com"));
        
        return usuarios;
    }
}
