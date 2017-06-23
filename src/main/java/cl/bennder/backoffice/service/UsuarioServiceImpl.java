package cl.bennder.backoffice.service;

import cl.bennder.backoffice.enums.CodigoNegocio;
import cl.bennder.backoffice.enums.CodigoValidacion;
import cl.bennder.backoffice.model.*;
import cl.bennder.backoffice.reponse.ValidacionResponse;
import cl.bennder.backoffice.repository.EmpresaRepository;
import cl.bennder.backoffice.repository.EsquemaRepository;
import cl.bennder.backoffice.repository.PerfilRepository;
import cl.bennder.backoffice.repository.UsuarioRepository;
import cl.bennder.backoffice.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 07-05-2017.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EsquemaRepository esquemaRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public ValidacionResponse agregarUsuario(UsuarioRequest usuarioRequest) {

        ValidacionResponse response = new ValidacionResponse(new Validacion(CodigoValidacion.ERROR_SERVICIO, CodigoNegocio.ERROR_SERVICIO_USUARIO, "Problemas al agregar un usuario"));

        try {
            Usuario usuario = new Usuario(usuarioRequest);
            usuario.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));

            //obteniendo empresa desde db
            Empresa empresa = empresaRepository.findOne(usuarioRequest.getIdEmpresa());

            esquemaRepository.cambiarEsquema(empresa.getEsquema());

            //obteniendo Perfil desde db
            Perfil perfil = perfilRepository.findByNombre(usuarioRequest.getNombrePerfil());
            List<Perfil> perfiles = new ArrayList<>();
            perfiles.add(perfil);
            usuario.setPerfiles(perfiles);

            //creando Contacto
            Contacto contacto = new Contacto(usuarioRequest.getCelular(), usuarioRequest.getTelefonoFijo(), usuarioRequest.getCorreo());
            usuario.setContacto(contacto);

            usuarioRepository.save(usuario);
            response.setValidacion(new Validacion(CodigoValidacion.OK, CodigoNegocio.EXITOSO, "Usuario agregado con exito"));
        }
        catch (Exception ex){
            response.setValidacion(new Validacion(CodigoValidacion.ERROR_SERVICIO, CodigoNegocio.ERROR_SERVICIO_USUARIO, "Error de sistema al agregar un usuario"));
        }
        return response;
    }
}
