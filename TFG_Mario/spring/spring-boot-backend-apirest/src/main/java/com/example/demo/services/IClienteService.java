package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Cliente;

public interface IClienteService {
public List<Cliente> findAll();
public Cliente save(Cliente cliente);
public void delete(Long id);
public Cliente findById(Long id);
}
