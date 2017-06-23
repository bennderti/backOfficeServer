package cl.bennder.backoffice.controller;

import cl.bennder.backoffice.reponse.ValidacionResponse;
import cl.bennder.backoffice.request.UsuarioRequest;
import cl.bennder.backoffice.security.JwtTokenUtil;
import cl.bennder.backoffice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Diego on 07-05-2017.
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/agregarUsuario", method = RequestMethod.POST)
    public ValidacionResponse agregarUsuario(@RequestBody UsuarioRequest usuarioRequest, HttpServletRequest request){

        //usuarioRequest.setIdUsuario(jwtTokenUtil.getIdUsuarioDesdeRequest(request));
        return usuarioService.agregarUsuario(usuarioRequest);
    }
}
