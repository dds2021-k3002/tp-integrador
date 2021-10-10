package com.disenio.model.mascotas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MascotaRescatada generated by hbm2java
 */
@Entity
@Table(name = "mascota_rescatada"
        , catalog = "patitas"
)
public class MascotaRescatada implements java.io.Serializable {


    private Integer idMascotaRescatada;
    private Persona persona;
    private TamanioMascota tamanioMascota;
    private TipoMascota tipoMascota;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaUltimaModificacion;
    private Date fechaBaja;
    private char estado;
    private Set mascotaHogarTransitos = new HashSet(0);
    private Set ubicacionMascotaRescatadas = new HashSet(0);
    private Set mascotaFotos = new HashSet(0);

    public MascotaRescatada() {
    }


    public MascotaRescatada(Persona persona, TamanioMascota tamanioMascota, TipoMascota tipoMascota, String descripcion, Date fechaAlta, Date fechaUltimaModificacion, char estado) {
        this.persona = persona;
        this.tamanioMascota = tamanioMascota;
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estado = estado;
    }

    public MascotaRescatada(Persona persona, TamanioMascota tamanioMascota, TipoMascota tipoMascota, String descripcion, Date fechaAlta, Date fechaUltimaModificacion, Date fechaBaja, char estado, Set mascotaHogarTransitos, Set ubicacionMascotaRescatadas, Set mascotaFotos) {
        this.persona = persona;
        this.tamanioMascota = tamanioMascota;
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.mascotaHogarTransitos = mascotaHogarTransitos;
        this.ubicacionMascotaRescatadas = ubicacionMascotaRescatadas;
        this.mascotaFotos = mascotaFotos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "ID_MASCOTA_RESCATADA", unique = true, nullable = false)
    public Integer getIdMascotaRescatada() {
        return this.idMascotaRescatada;
    }

    public void setIdMascotaRescatada(Integer idMascotaRescatada) {
        this.idMascotaRescatada = idMascotaRescatada;
    }

    @JsonView(Views.Internal.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TAMANIO", nullable = false)
    public TamanioMascota getTamanioMascota() {
        return this.tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_MASCOTA", nullable = false)
    public TipoMascota getTipoMascota() {
        return this.tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }


    @Column(name = "DESCRIPCION", nullable = false, length = 2000)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    public Date getFechaUltimaModificacion() {
        return this.fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BAJA", length = 0)
    public Date getFechaBaja() {
        return this.fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }


    @Column(name = "ESTADO", nullable = false, length = 1)
    public char getEstado() {
        return this.estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascotaRescatada")
    public Set<MascotaHogarTransito> getMascotaHogarTransitos() {
        return this.mascotaHogarTransitos;
    }

    public void setMascotaHogarTransitos(Set mascotaHogarTransitos) {
        this.mascotaHogarTransitos = mascotaHogarTransitos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascotaRescatada")
    public Set<UbicacionMascotaRescatada> getUbicacionMascotaRescatadas() {
        return this.ubicacionMascotaRescatadas;
    }

    public void setUbicacionMascotaRescatadas(Set ubicacionMascotaRescatadas) {
        this.ubicacionMascotaRescatadas = ubicacionMascotaRescatadas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascotaRescatada")
    public Set<MascotaFoto> getMascotaFotos() {
        return this.mascotaFotos;
    }

    public void setMascotaFotos(Set mascotaFotos) {
        this.mascotaFotos = mascotaFotos;
    }


}


