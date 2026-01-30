package com.applogin.demo.controller;

import com.applogin.demo.model.User;
import com.applogin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/inicio")
    public String login() {
        return "inicio";
    }

    @GetMapping("/registro")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "registro";
    }

    @PostMapping("/registro")
    public String registerSubmit(@ModelAttribute User user, Model model) {
        if (userService.existeUsuario(user.getNombreuser())) {
            model.addAttribute("error", "El nombre de usuario ya existe.");
            return "registro";
        }
        if (userService.existeCorreo(user.getCorreo())) {
            model.addAttribute("error", "El correo ya está registrado.");
            return "registro";
        }
        userService.registrarUsuario(user);
        return "redirect:/inicio?registered";
    }

    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.obtenerPorNombreUser(username);

        if (user != null) {
            model.addAttribute("nombre", user.getNombre());
            model.addAttribute("apellido", user.getApellido());
        }

        return "home";
    }
}
