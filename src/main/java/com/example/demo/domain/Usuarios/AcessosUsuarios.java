package com.example.demo.domain.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "acessos_usuarios")
@Entity(name = "acessos_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class AcessosUsuarios implements UserDetails {
    private String id;
    private String loggin;
    private String senha;
    private UserRole roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return loggin;
    }
}