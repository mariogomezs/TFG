package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioDTO;
import com.example.demo.model.UsuarioRegistroDTO;
import com.example.demo.model.dao.IusuarioDAO;
@Service
public class UsuarioService {
	private IusuarioDAO iusuarioDAO;

	public UsuarioService(IusuarioDAO iusuarioDAO) {
		super();
		this.iusuarioDAO = iusuarioDAO;
	}
	  public Usuario guardarUsuario(UsuarioDTO usuario) {
	        Usuario usuarioExistente = iusuarioDAO.findByEmail(usuario.getEmail());
	        if (usuarioExistente != null) {
	           return null;
	        }
	       Usuario usuarioSave= converToEntidad(usuario);
	        return iusuarioDAO.save(usuarioSave);
	    }
	  public Usuario converToEntidad(UsuarioDTO usuarioDTO) {
		  return new Usuario(usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getContrasena());
	  }
	  public Usuario convertirUsuarioRegistroDTO(UsuarioRegistroDTO usuarioRegistroDTO) {
		  return new Usuario(usuarioRegistroDTO.getEmail(),usuarioRegistroDTO.getContrasena());
	  }
	   public Usuario iniciarSesion(UsuarioRegistroDTO usuario) {
	        Usuario usuario2 = iusuarioDAO.findByEmail(usuario.getEmail());
	        if (usuario2 == null) {
	        	throw new RuntimeException("Usuario no encontrado");
	        }
	        if (!usuario.getContrasena().equals(usuario2.getContraseña())) {
	            throw new RuntimeException("La contraseña es incorrecta.");
	        }
	        return usuario2;
	    }
	}

