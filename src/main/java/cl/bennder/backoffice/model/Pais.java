package cl.bennder.backoffice.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Diego on 06-05-2017.
 */
@Entity
public class Pais {

    @Id
    @Column(name = "id_pais")
    private Integer idPais;
    private String nombre;
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    private List<Region> regiones;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }
}
