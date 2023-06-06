package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Usuario;

public interface IusuarioDAO extends CrudRepository<Usuario, Long>  {
     Usuario findByNombre(String nombre);
     Usuario findByEmail(String email);
}
