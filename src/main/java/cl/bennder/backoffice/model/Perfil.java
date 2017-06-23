package cl.bennder.backoffice.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Diego on 28-04-2017.
 */
@Entity
public class Perfil {

    @Id
    @GeneratedValue
    @Column(name = "id_perfil")
    private Integer id;
    private String nombre;
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
