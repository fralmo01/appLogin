package com.applogin.demo.repository;

import com.applogin.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    java.util.Optional<User> findByNombreuser(String nombreuser);

    boolean existsByNombreuser(String nombreuser);

    boolean existsByCorreo(String correo);
}
