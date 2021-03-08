package com.piero.clienteservice.service;

import java.util.ArrayList;

import com.piero.clienteservice.entity.Cliente;
import com.piero.clienteservice.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) repository.findAll();
        return clientes;
    }

    public Cliente findById(Long idCliente) {
        Cliente cliente = repository.findById(idCliente).orElse(null);
        return cliente;
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(Long idCliente, Cliente cliente) {
        Cliente clienteSelected = repository.findById(idCliente).orElse(null);
        if (clienteSelected != null) {
            clienteSelected.setDocumento(cliente.getDocumento());
            clienteSelected.setTipoDocumento(cliente.getTipoDocumento());
            clienteSelected.setCodigo(cliente.getCodigo());
            clienteSelected.setNombres(cliente.getNombres());
            clienteSelected.setApellidos(cliente.getApellidos());
            clienteSelected.setFechaNacimiento(cliente.getFechaNacimiento());
            return repository.save(clienteSelected);
        }
        return clienteSelected;
    }
}
