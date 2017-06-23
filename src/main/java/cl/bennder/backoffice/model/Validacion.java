/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.backoffice.model;

import cl.bennder.backoffice.enums.CodigoNegocio;
import cl.bennder.backoffice.enums.CodigoValidacion;

import java.io.Serializable;

/**
 *
 * @author dyanez
 */
public class Validacion implements Serializable{
    private CodigoValidacion codigo;//0: Indica que servicio responde OK,1: Indica servicio responde NOK
    private CodigoNegocio codigoNegocio;//0: Indica exito, y otro distino es para comportamiento a futuro
    private String mensaje;
    public Validacion() {
//        this.codigo = "1";
//        this.codigoNegocio = "0";
//        this.mensaje = "Error en validación";
    }
    
    public Validacion(CodigoValidacion codigo, CodigoNegocio codigoNegocio, String mensaje) {
        this.codigo = codigo;
        this.codigoNegocio = codigoNegocio;
        this.mensaje = mensaje;
    }

    public CodigoValidacion getCodigo() {
        return codigo;
    }

    public void setCodigo(CodigoValidacion codigo) {
        this.codigo = codigo;
    }

    public CodigoNegocio getCodigoNegocio() {
        return codigoNegocio;
    }

    public void setCodigoNegocio(CodigoNegocio codigoNegocio) {
        this.codigoNegocio = codigoNegocio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
