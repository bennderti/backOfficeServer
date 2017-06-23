package cl.bennder.backoffice.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Diego on 06-05-2017.
 */
@Entity
public class Region {

    @Id
    @Column(name = "id_region")
    private Integer idRegion;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Comuna> comunas;

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }
}
