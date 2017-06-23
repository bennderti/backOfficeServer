/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.backoffice.model;

import javax.persistence.*;

/**
 *
 * @author Marcos
 */
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Integer idContacto;
    private Integer celular;
    @Column(name = "telefono_fijo")
    private Integer telefonoFijo;
    private String correo;
    
    public Contacto(){
        
    }

    public Contacto(Integer celular, Integer telefonoFijo, String correo) {
        this.celular = celular;
        this.telefonoFijo = telefonoFijo;
        this.correo = correo;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public void setTelefonoFijo(Integer telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }    
}
