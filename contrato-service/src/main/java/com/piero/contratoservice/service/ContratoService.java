package com.piero.contratoservice.service;

import java.util.ArrayList;

import com.piero.contratoservice.entity.Contrato;
import com.piero.contratoservice.repository.ContratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository repository;

    public ArrayList<Contrato> findAll() {
        ArrayList<Contrato> contratos = (ArrayList<Contrato>) repository.findAll();
        return contratos;
    }

    public ArrayList<Contrato> findByIdCliente(Long idCliente) {
        ArrayList<Contrato> contratos = (ArrayList<Contrato>) repository.findByIdCliente(idCliente);
        return contratos;
    }

    public Contrato save(Contrato contrato) {
        return repository.save(contrato);
    }

    public Contrato update(Long idContrato, Contrato contrato) {
        Contrato contratoSelected = repository.findById(idContrato).orElse(null);
        if (contratoSelected != null) {
            contratoSelected.setNumero(contrato.getNumero());
            contratoSelected.setFecha(contrato.getFecha());
            contratoSelected.setDescripcion(contrato.getDescripcion());
            contratoSelected.setIdCliente(contrato.getIdCliente());
            contratoSelected.setIdProducto(contrato.getIdProducto());
            return repository.save(contratoSelected);
        }
        return contratoSelected;
    }
}
