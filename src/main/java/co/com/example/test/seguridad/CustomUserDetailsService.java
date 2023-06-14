package co.com.example.test.seguridad;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Rol;
import co.com.example.test.entity.Usuario;
import co.com.example.test.repository.IUsuarioRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioRepository usuarioRepositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByCodigo(codigo)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese  email : " + codigo));
	
		return new User(usuario.getEmail(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}
}
