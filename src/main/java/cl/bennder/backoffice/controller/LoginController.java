package cl.bennder.backoffice.controller;

import cl.bennder.backoffice.enums.CodigoNegocio;
import cl.bennder.backoffice.enums.CodigoValidacion;
import cl.bennder.backoffice.model.Validacion;
import cl.bennder.backoffice.reponse.LoginResponse;
import cl.bennder.backoffice.request.LoginRequest;
import cl.bennder.backoffice.security.JwtTokenUtil;
import cl.bennder.backoffice.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Diego on 06-05-2017.
 */
@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws AuthenticationException {

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setValidacion(new Validacion(CodigoValidacion.OK, CodigoNegocio.ERROR_SERVICIO_USUARIO,"Usuario no encontrado"));
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsuario(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(authenticationRequest.getUsuario());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        loginResponse.setValidacion(new Validacion(CodigoValidacion.OK, CodigoNegocio.EXITOSO,"login exitoso"));
        loginResponse.setToken(token);
        return ResponseEntity.ok(loginResponse);
    }
}
