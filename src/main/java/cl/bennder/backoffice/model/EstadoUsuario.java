package cl.bennder.backoffice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Diego on 06-05-2017.
 */
@Entity
public class EstadoUsuario {

    @Id
    @GeneratedValue
    private Integer idEstado;
    private String nombre;
}
