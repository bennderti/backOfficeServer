package cl.bennder.backoffice.service;

import cl.bennder.backoffice.reponse.ValidacionResponse;
import cl.bennder.backoffice.request.UsuarioRequest;

/**
 * Created by Diego on 07-05-2017.
 */
public interface UsuarioService {

    ValidacionResponse agregarUsuario(UsuarioRequest usuarioRequest);
}
