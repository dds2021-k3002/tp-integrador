package com.disenio.models.personas;
// Generated 29/08/2021 23:04:39 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ContactoMedioNotificacion generated by hbm2java
 */
@Entity
@Table(name="contacto_medio_notificacion"
    ,catalog="patitas"
)
public class ContactoMedioNotificacion  implements java.io.Serializable {


     private Long idContactoNotificacion;
     private MedioNotificacion medioNotificacion;
     private PersonaContacto personaContacto;
     private char estado;
     private char preferido;

    public ContactoMedioNotificacion() {
    }

    public ContactoMedioNotificacion(MedioNotificacion medioNotificacion, PersonaContacto personaContacto, char estado, char preferido) {
       this.medioNotificacion = medioNotificacion;
       this.personaContacto = personaContacto;
       this.estado = estado;
       this.preferido = preferido;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_CONTACTO_NOTIFICACION", unique=true, nullable=false)
    public Long getIdContactoNotificacion() {
        return this.idContactoNotificacion;
    }
    
    public void setIdContactoNotificacion(Long idContactoNotificacion) {
        this.idContactoNotificacion = idContactoNotificacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_MEDIO_NOTIFICACION", nullable=false)
    public MedioNotificacion getMedioNotificacion() {
        return this.medioNotificacion;
    }
    
    public void setMedioNotificacion(MedioNotificacion medioNotificacion) {
        this.medioNotificacion = medioNotificacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PERSONA_CONTACTO", nullable=false)
    public PersonaContacto getPersonaContacto() {
        return this.personaContacto;
    }
    
    public void setPersonaContacto(PersonaContacto personaContacto) {
        this.personaContacto = personaContacto;
    }

    
    @Column(name="ESTADO", nullable=false, length=1)
    public char getEstado() {
        return this.estado;
    }
    
    public void setEstado(char estado) {
        this.estado = estado;
    }

    
    @Column(name="PREFERIDO", nullable=false, length=1)
    public char getPreferido() {
        return this.preferido;
    }
    
    public void setPreferido(char preferido) {
        this.preferido = preferido;
    }




}


