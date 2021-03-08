package com.piero.productoservice.service;

import java.util.ArrayList;

import com.piero.productoservice.entity.Producto;
import com.piero.productoservice.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public ArrayList<Producto> findAll() {
        ArrayList<Producto> productos = (ArrayList<Producto>) repository.findAll();
        return productos;
    }

    public Producto findById(Long idProducto) {
        Producto producto = repository.findById(idProducto).orElse(null);
        return producto;
    }

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public Producto update(Long idProducto, Producto producto) {
        Producto productoSelected = repository.findById(idProducto).orElse(null);
        if (productoSelected != null) {
            productoSelected.setCodigo(producto.getCodigo());
            productoSelected.setNombre(producto.getNombre());
            productoSelected.setTecnologia(producto.getTecnologia());
            return repository.save(productoSelected);
        }
        return productoSelected;
    }
}
