package com.disenio.model.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("adoptante")
public class PublicacionAdoptante extends PublicacionAdopcion {
    @JsonView(Views.External.class)
    private boolean esVisible = false;

    private String clave;

    protected PublicacionAdoptante(Persona autor) {
        super(autor);
    }

    public PublicacionAdoptante() {

    }

    //Accessors
    @Column(columnDefinition = "boolean default false", name = "es_visible", nullable = false)
    public boolean getEsVisible() {
        return esVisible;
    }

    public void setEsVisible(Boolean esVisible) {
        this.esVisible = esVisible;
    }

    @Transient
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //Funcionalidad
    @Override
    public void contactar() {
        /*TODO Magia para contactar*/
    }

    public void darBaja() {
        /*TODO Magia para dar de baja*/
    }

    public String generarLink() {
        //TODO Revisar
        String link = "https:/.../publicacion/adoptante/{id}/borrar?clave=";
        generarClave();
        return link + clave;
    }

    private void generarClave() {
        this.clave = "rotar"; // TODO: Generar un string random
    }


}
