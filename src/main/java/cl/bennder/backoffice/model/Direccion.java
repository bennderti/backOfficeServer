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
public class Direccion {

    @Id
    @GeneratedValue
    @Column(name = "id_direccion")
    private Integer idDireccion;
    private String calle;
    private String numero;
    private String departamento;
    private String villa;
    @ManyToOne
    @JoinColumn(name = "id_comuna")
    private Comuna comuna;
    
    public Direccion(){
        
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getVilla() {
        return villa;
    }

    public void setVilla(String villa) {
        this.villa = villa;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
}
