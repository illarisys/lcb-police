package lcb.com.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lcb.com.pe.repository.IPermisoRepositorioRepository;
import lcb.com.service.interfaces.IPermisoRepositorioService;

@Service("permisoRepositorioService")
public class PermisoRepositorioService implements IPermisoRepositorioService{

	@Autowired
	private IPermisoRepositorioRepository permisoRepositorioRepository;

	@Override
	public boolean findPermisoByRolUsuario(String tabla, String rol) {
		return true;
	}
	
	
}
