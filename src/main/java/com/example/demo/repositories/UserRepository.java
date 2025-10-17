package com.example.demo.repositories;

import com.example.demo.domain.usuarios.AcessosUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<AcessosUsuarios, String> {
    UserDetails findByLoggin(String loggin);
}
