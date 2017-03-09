package lcb.com.service.interfaces;

import java.util.List;

import lcb.com.pe.domain.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findBySistema(int id_sistema);

}
