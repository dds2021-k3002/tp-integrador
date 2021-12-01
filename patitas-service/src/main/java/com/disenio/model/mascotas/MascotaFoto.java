package com.disenio.model.mascotas;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * generated by grupo10
 */
@Entity
@Data
@Table(name = "mascota_foto", catalog = "patitas")
public class MascotaFoto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_MASCOTA_FOTO", unique = true, nullable = false)
    private Integer idMascotaFoto;

    @Column(name = "VALOR_FOTO", nullable = false)
    private String valorFoto;

    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaAlta;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaUltimaModificacion;

    @Column(name = "FECHA_BAJA", length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaBaja;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    public MascotaFoto() {
        this.estado = 'A';
        this.fechaAlta = Calendar.getInstance();
        this.fechaUltimaModificacion = Calendar.getInstance();
    }

    public MascotaFoto(String valorFoto) {
        this.estado = 'A';
        this.fechaAlta = Calendar.getInstance();
        this.fechaUltimaModificacion = Calendar.getInstance();
        this.valorFoto = valorFoto;
    }
}


