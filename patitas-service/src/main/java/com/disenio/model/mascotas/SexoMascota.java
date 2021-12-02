package com.disenio.model.mascotas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * SexoMascota generated by Grupo 10
 */
@Entity
@Data
@Table(name = "sexo_mascota"//, catalog = "patitas"
 )
public class SexoMascota implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_SEXO", unique = true, nullable = false)
    private Integer idSexo;

    @Column(name = "DESCRIPCION", nullable = false, length = 10)
    private String descripcion;

}


