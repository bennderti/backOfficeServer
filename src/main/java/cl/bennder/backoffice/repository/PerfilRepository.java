package cl.bennder.backoffice.repository;

import cl.bennder.backoffice.model.Perfil;
import cl.bennder.backoffice.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Diego on 07-05-2017.
 */
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {

    Perfil findByNombre(String nombre);
}
