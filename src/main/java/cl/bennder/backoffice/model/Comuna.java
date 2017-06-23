package cl.bennder.backoffice.model;

import javax.persistence.*;

/**
 * Created by Diego on 06-05-2017.
 */
@Entity
public class Comuna {

    @Id
    @Column(name = "id_comuna")
    private Integer idComuna;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;
}
