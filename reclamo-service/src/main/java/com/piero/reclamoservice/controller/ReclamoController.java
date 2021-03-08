package com.piero.reclamoservice.controller;

import java.util.ArrayList;

import com.piero.reclamoservice.entity.Reclamo;
import com.piero.reclamoservice.service.ReclamoService;

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
@RequestMapping("/api/reclamo")
public class ReclamoController {
    @Autowired
    private ReclamoService service;

    @GetMapping
    public ArrayList<Reclamo> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Reclamo findById(@PathVariable("id") Long idReclamo) {
        try {
            return service.findById(idReclamo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{idCliente}")
    public ArrayList<Reclamo> findByIdCliente(@PathVariable Long idCliente) {
        try {
            return service.findByIdCliente(idCliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public Reclamo save(@RequestBody Reclamo reclamo) {
        try {
            return service.save(reclamo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public Reclamo update(@PathVariable("id") Long idReclamo, @RequestBody Reclamo reclamo) {
        return service.update(idReclamo, reclamo);
    }
}
