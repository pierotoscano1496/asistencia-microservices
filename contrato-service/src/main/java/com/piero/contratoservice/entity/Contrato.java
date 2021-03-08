package com.piero.contratoservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    @Column(length = 50, nullable = false)
    private String numero;

    @Column(nullable = false)
    private Date fecha;

    @Column(length = 200)
    private String descripcion;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_producto ", nullable = false)
    private Long idProducto;

    public Contrato() {
    }

    public Contrato(Long idContrato, String numero, Date fecha, String descripcion, Long idCliente, Long idProducto) {
        if (idContrato != 0) {
            this.idContrato = idContrato;
        }
        this.numero = numero;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public String getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}
