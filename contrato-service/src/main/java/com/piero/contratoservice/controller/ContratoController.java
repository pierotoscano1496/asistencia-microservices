package com.piero.contratoservice.controller;

import java.util.ArrayList;

import com.piero.contratoservice.entity.Contrato;
import com.piero.contratoservice.service.ContratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("contrato")
public class ContratoController {
    @Autowired
    private ContratoService service;

    @GetMapping()
    public ArrayList<Contrato> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idCliente}")
    public ArrayList<Contrato> findByIdCliente(@PathVariable Long idCliente) {
        try {
            return service.findByIdCliente(idCliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public Contrato save(@RequestBody Contrato contrato) {
        try {
            return service.save(contrato);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public Contrato update(@PathVariable("id") Long idContrato, @RequestBody Contrato contrato) {
        try {
            return service.update(idContrato, contrato);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
