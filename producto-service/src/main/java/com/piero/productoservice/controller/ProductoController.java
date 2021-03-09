package com.piero.productoservice.controller;

import java.util.ArrayList;

import com.piero.productoservice.entity.Producto;
import com.piero.productoservice.service.ProductoService;

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
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public ArrayList<Producto> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno en el servidor");
        }
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable("id") Long idProducto) {
        try {
            return service.findById(idProducto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno en el servidor");
        }
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        try {
            return service.save(producto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable("id") Long idProducto, @RequestBody Producto producto) {
        try {
            return service.update(idProducto, producto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
