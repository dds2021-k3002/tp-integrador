package com.disenio.model.personas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.usuarios.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Persona generated by hbm2java
 */
@Entity
@Data
@Table(name = "persona", catalog = "patitas")
public class Persona implements java.io.Serializable {

    @JsonView(Views.External.class)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_PERSONA", unique = true, nullable = false)
    private Integer idPersona;

    @JsonView(Views.External.class)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @JsonView(Views.External.class)
    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;

    @JsonView(Views.External.class)
    @Column(name = "FECHA_NACIMIENTO", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+8")
    private Calendar fechaNacimiento;


    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaAlta;


    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaUltimaModificacion;


    @Column(name = "FECHA_BAJA", length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaBaja;

    @JsonView(Views.External.class)
    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<PersonaDocumento> personaDocumentos ;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<PersonaContacto> personaContactos;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<PersonaDireccion> personaDireccions;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Mascota> mascotas ;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Usuario> usuarios;

    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<MascotaRescatada> mascotaRescatadas;

    //Funcionalidad
    public void notificar(String mensaje) {
        /*TODO magia notificacion*/
    }

}


