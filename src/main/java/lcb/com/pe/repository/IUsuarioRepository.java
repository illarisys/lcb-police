package lcb.com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lcb.com.pe.domain.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String>{

    @Query("SELECT u FROM Usuario u left join fetch "
    		+ "u.usuarioSistemas sis WHERE LOWER(u.usuario) = LOWER(:usuario)")
    Usuario findByUsernameCaseInsensitive(@Param("usuario") String username);

    @Query
    Usuario findByEmail(String email);

    @Query
    Usuario findByEmailAndContrasena(String email, String contrasena);
	
}
