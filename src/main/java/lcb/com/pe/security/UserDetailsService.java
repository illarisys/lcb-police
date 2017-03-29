package lcb.com.pe.security;

import lcb.com.pe.config.Logger;
import lcb.com.pe.domain.Usuario;
import lcb.com.pe.domain.UsuarioSistema;
import lcb.com.pe.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String login){

		Logger.debug("Authenticating {}", login);
		String lowercaseLogin = login.toLowerCase();

		try {

			Usuario userFromDatabase;
			/*
			 * if(lowercaseLogin.contains("@")) { userFromDatabase =
			 * userRepository.findByEmail(lowercaseLogin); } else {
			 */
			userFromDatabase = usuarioRepository.findByUsernameCaseInsensitive(lowercaseLogin, 1);

			if (userFromDatabase == null) {
				throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
			} else if (!userFromDatabase.isEstado()) {
				throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated");
			}

			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (UsuarioSistema authority : userFromDatabase.getUsuarioSistemas()) {
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getRolAutorizacion());
				grantedAuthorities.add(grantedAuthority);
			}

			return new CustomUserDetail(userFromDatabase.getUsuario(), userFromDatabase.getContrasena(), true, 
					true, true, true, 
					grantedAuthorities, null, userFromDatabase.getEmail(), 
					userFromDatabase.getNombre(), "es");					
					/*org.springframework.security.core.userdetails.User(userFromDatabase.getUsuario(),
					userFromDatabase.getContrasena(), grantedAuthorities);*/
		} catch (Exception e) {
			throw e;
		}

	}

}
