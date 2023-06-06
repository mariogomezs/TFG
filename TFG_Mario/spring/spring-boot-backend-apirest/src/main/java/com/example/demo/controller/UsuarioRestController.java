package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioDTO;
import com.example.demo.model.UsuarioRegistroDTO;
import com.example.demo.services.UsuarioService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
	private UsuarioService usuarioService;
@Autowired
	public UsuarioRestController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
@PostMapping("/registro")
public ResponseEntity<Object> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    Usuario nuevoUsuario = usuarioService.guardarUsuario(usuarioDTO);
    if (nuevoUsuario != null) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\": \"Usuario registrado con éxito\", \"id\": " + nuevoUsuario.getId() + "}");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("{\"error\": \"Usuario inválido\"}");
}
@PostMapping("/login")
public ResponseEntity<Object> iniciarSesion(@RequestBody UsuarioRegistroDTO usuario) {
    try {
        Usuario usuario2 = usuarioService.iniciarSesion(usuario);
        return ResponseEntity.ok()
                .body("{\"message\": \"Inicio de sesión exitoso\", \"id\": " + usuario2.getId() + "}");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("{\"error\": \"" + e.getMessage() + "\"}");
    }
}
}