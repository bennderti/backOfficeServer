package cl.bennder.backoffice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Diego on 18-05-2017.
 */
public enum CodigoValidacion {

    OK,
    ERROR_SERVICIO;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}


