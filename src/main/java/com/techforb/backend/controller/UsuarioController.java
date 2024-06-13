package com.techforb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.techforb.backend.model.Usuario;
//import com.techforb.backend.security.JwtUtils;
//import com.techforb.backend.security.JwtResponse;
import com.techforb.backend.service.UsuarioService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    //@Autowired
    //private AuthenticationManager authenticationManager;

    //@Autowired
    //private JwtUtils jwtUtils;

    @Autowired
    private UsuarioService usuarioService;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUsuario(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        if (!isValidEmailAddress(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Error: El formato del correo electrónico no es válido");
        }

        if (usuarioService.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Error: El correo electrónico ya está en uso!");
        }

        //usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuarioService.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente!");
    }

    private boolean isValidEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUsuario(@RequestBody Usuario usuario) {
        //Authentication authentication = authenticationManager.authenticate(
        //        new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));

        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //String jwt = jwtUtils.generateJwtToken(authentication);

        //UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //return ResponseEntity.ok(new JwtResponse(jwt));
        return null;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUsuarioLogueado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUsuario() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.status(HttpStatus.OK).body("Usuario desconectado exitosamente!");
    }
}