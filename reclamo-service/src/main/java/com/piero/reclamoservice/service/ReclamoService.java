package com.piero.reclamoservice.service;

import java.util.ArrayList;
import java.util.Date;

import com.piero.reclamoservice.entity.Reclamo;
import com.piero.reclamoservice.repository.ReclamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamoService {
    @Autowired
    private ReclamoRepository repository;

    public ArrayList<Reclamo> findAll() {
        ArrayList<Reclamo> reclamos = (ArrayList<Reclamo>) repository.findAll();
        return reclamos;
    }

    public Reclamo findById(Long idReclamo) {
        Reclamo reclamo = repository.findById(idReclamo).orElse(null);
        return reclamo;
    }

    public ArrayList<Reclamo> findByIdCliente(Long idCliente) {
        ArrayList<Reclamo> reclamos = (ArrayList<Reclamo>) repository.findByIdCliente(idCliente);
        return reclamos;
    }

    public Reclamo save(Reclamo reclamo) {
        return repository.save(reclamo);
    }

    public Reclamo update(Long idReclamo, Reclamo reclamo) {
        Reclamo reclamoSelected = repository.findById(idReclamo).orElse(null);
        if (reclamoSelected != null) {
            reclamoSelected.setCodigo(reclamo.getCodigo());
            reclamoSelected.setMotivo(reclamo.getMotivo());
            reclamoSelected.setFecha(reclamo.getFecha());
            reclamoSelected.setDescripcion(reclamo.getDescripcion());
            reclamoSelected.setEstado(reclamo.getEstado());
            reclamoSelected.setFechaSolucion(reclamo.getFechaSolucion());
            reclamoSelected.setDescripcionSolucion(reclamo.getDescripcionSolucion());
            reclamoSelected.setIdCliente(reclamo.getIdCliente());
            reclamoSelected.setIdProducto(reclamo.getIdProducto());
            return repository.save(reclamoSelected);
        }
        return reclamoSelected;
    }

    public Reclamo setTerminado(Long idReclamo, Reclamo reclamo) {
        Reclamo reclamoSelected = repository.findById(idReclamo).orElse(null);
        if (reclamoSelected != null) {
            reclamoSelected.setEstado(1);
            reclamoSelected.setFechaSolucion(new Date());
            reclamoSelected.setDescripcionSolucion(reclamo.getDescripcionSolucion());
            return repository.save(reclamoSelected);
        }
        return reclamoSelected;
    }
}
