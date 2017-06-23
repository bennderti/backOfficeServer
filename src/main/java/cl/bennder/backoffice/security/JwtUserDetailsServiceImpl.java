package cl.bennder.backoffice.security;

import cl.bennder.backoffice.model.Usuario;
import cl.bennder.backoffice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("No se pudo encontrar usuario con username '%s'.", username));
        } else {
            return JwtUserFactory.create(usuario);
        }
    }
}