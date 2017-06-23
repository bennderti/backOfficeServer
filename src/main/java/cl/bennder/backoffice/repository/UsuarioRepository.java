package cl.bennder.backoffice.repository;

import cl.bennder.backoffice.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>  {

    Usuario findByUsuario(String usuario);
}