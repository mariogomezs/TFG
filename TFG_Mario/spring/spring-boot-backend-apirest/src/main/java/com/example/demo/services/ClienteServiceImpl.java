package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.dao.IclienteDAO;

import jakarta.transaction.Transactional;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IclienteDAO clienteDAO;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDAO.save(cliente);
	}

	@Override
	public void delete(Long id) {
		clienteDAO.deleteById(id);
		
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDAO.findById(id).orElse(null);
	}

}
