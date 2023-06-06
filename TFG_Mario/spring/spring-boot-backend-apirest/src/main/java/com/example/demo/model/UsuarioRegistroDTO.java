package com.example.demo.model;

public class UsuarioRegistroDTO {
	private String email;
	private String contrasena;
	public UsuarioRegistroDTO(String email, String contrasena) {
		super();
		this.email = email;
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
