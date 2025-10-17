package com.example.demo.controllers;

import com.example.demo.domain.usuarios.AcessosUsuarios;
import com.example.demo.domain.usuarios.DadosAuthUsuarioLoginDTO;
import com.example.demo.domain.usuarios.RegistroDTO;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthUsuarioLoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosAuthUsuarioLoginDTO data){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.loggin(), data.senha());
        var auth = this.authenticationManager.authenticate(usuarioSenha);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registro")
    public ResponseEntity registro(@RequestBody @Valid RegistroDTO data){
            if (this.userRepository.findByLoggin(data.loggin()) != null) return ResponseEntity.badRequest().build();

            String senhaCriptografada = new BCryptPasswordEncoder().encode(data.senha());
            AcessosUsuarios novoUsuario = new AcessosUsuarios(data.loggin(), senhaCriptografada, data.role());

            this.userRepository.save(novoUsuario);
            return ResponseEntity.ok().build();
    }
}
