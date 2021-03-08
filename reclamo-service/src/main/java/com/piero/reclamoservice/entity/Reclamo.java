package com.piero.reclamoservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reclamo")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamo;

    @Column(length = 50, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private int motivo;

    @Column(nullable = false)
    private Date fecha;

    @Column(length = 200)
    private String descripcion;

    @Column
    private int estado;

    @Column(name = "fecha_solucion ")
    private Date fechaSolucion;

    @Column(name = "descripcion_solucion", length = 200)
    private String descripcionSolucion;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_producto ", nullable = false)
    private Long idProducto;

    public Reclamo() {
    }

    public Reclamo(Long idReclamo, String codigo, int motivo, Date fecha, String descripcion, int estado,
            Date fechaSolucion, String descripcionSolucion, Long idCliente, Long idProducto) {
        if (idReclamo != 0) {
            this.idReclamo = idReclamo;
        }
        this.codigo = codigo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaSolucion = fechaSolucion;
        this.descripcionSolucion = descripcionSolucion;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public Long getIdReclamo() {
        return idReclamo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getMotivo() {
        return motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public String getDescripcionSolucion() {
        return descripcionSolucion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdReclamo(Long idReclamo) {
        this.idReclamo = idReclamo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public void setDescripcionSolucion(String descripcionSolucion) {
        this.descripcionSolucion = descripcionSolucion;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}
