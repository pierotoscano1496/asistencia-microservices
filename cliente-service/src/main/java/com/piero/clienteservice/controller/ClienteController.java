package com.piero.clienteservice.controller;

import java.util.ArrayList;

import com.piero.clienteservice.entity.Cliente;
import com.piero.clienteservice.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping()
    public ArrayList<Cliente> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long idCliente) {
        try {
            return service.findById(idCliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        try {
            return service.save(cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") Long idCliente, @RequestBody Cliente cliente) {
        try {
            return service.update(idCliente, cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
