package cl.bennder.backoffice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Diego on 18-05-2017.
 */
public enum CodigoNegocio {

    EXITOSO,
    //TODO: agregar errores segun negocio

    //ERRORES NEGOCIO USUARIO
    ERROR_SERVICIO_USUARIO;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
