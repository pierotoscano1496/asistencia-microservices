package com.piero.reclamoservice.repository;

import java.util.List;

import com.piero.reclamoservice.entity.Reclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
    public List<Reclamo> findByIdCliente(Long idCliente);
}
