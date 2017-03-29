package lcb.com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lcb.com.pe.domain.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String>{

    @Query("SELECT u FROM Usuario u "
    		+ "left join fetch u.usuarioSistemas sis "
    		+ "left join fetch sis.rol rol "
    		+ "left join fetch rol.sistema st "
    		+ "WHERE LOWER(u.usuario) = LOWER(:usuario) "
    		+ "and st.idSistema = :sistema")
    Usuario findByUsernameCaseInsensitive(@Param("usuario") String username, @Param("sistema") int sistema);

    @Query
    Usuario findByEmail(String email);

    @Query
    Usuario findByEmailAndContrasena(String email, String contrasena);
	
}
