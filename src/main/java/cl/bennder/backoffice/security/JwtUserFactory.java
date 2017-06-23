package cl.bennder.backoffice.security;

import cl.bennder.backoffice.model.Perfil;
import cl.bennder.backoffice.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Usuario usuario) {
        return new JwtUser(
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getNombres(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getUsuario(),
                usuario.getPassword(),
                mapToGrantedAuthorities(usuario.getPerfiles()),
                usuario.getHabilitado()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Perfil> perfiles) {
        return perfiles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getNombre()))
                .collect(Collectors.toList());
    }
}