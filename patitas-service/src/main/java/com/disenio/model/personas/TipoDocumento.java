package com.disenio.model.personas;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TipoDocumento generated by grupo 10
 */
@Entity
@Data
@Table(name = "tipo_documento"//, catalog = "patitas"
)
public class TipoDocumento implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_TIPO_DOC", unique = true, nullable = false)
    private Integer idTipoDoc;

    @Column(name = "DESCRIPCION_CORTA", nullable = false, length = 5)
    private String descripcionCorta;

    @Column(name = "DESCRIPCION_LARGA", nullable = false, length = 50)
    private String descripcionLarga;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;


}


