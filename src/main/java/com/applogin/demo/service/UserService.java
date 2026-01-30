package com.applogin.demo.service;

import com.applogin.demo.model.User;
import com.applogin.demo.repository.UserRepository;
import com.applogin.demo.util.Sha256PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final Sha256PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    public User registrarUsuario(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public boolean existeUsuario(String nombreuser) {
        return userRepository.existsByNombreuser(nombreuser);
    }

    public boolean existeCorreo(String correo) {
        return userRepository.existsByCorreo(correo);
    }

    public User obtenerPorNombreUser(String nombreuser) {
        return userRepository.findByNombreuser(nombreuser).orElse(null);
    }
}
