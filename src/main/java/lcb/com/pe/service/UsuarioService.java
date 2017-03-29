package lcb.com.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lcb.com.pe.domain.Usuario;
import lcb.com.pe.repository.IUsuarioRepository;
import lcb.com.service.interfaces.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{

	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findBySistema(int id_sistema) {
		System.out.println("******************-----------------------------------------------------****************************");
		return usuarioRepository.findAll();
	}
	
}
