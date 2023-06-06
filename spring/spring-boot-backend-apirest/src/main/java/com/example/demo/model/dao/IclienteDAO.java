package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Cliente;

public interface IclienteDAO extends CrudRepository<Cliente, Long> {

}
