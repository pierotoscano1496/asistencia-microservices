package com.piero.contratoservice.repository;

import java.util.List;

import com.piero.contratoservice.entity.Contrato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    public List<Contrato> findByIdCliente(Long idCliente);
}
