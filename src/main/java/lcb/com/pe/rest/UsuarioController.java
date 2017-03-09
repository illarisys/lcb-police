package lcb.com.pe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lcb.com.pe.config.Logger;
import lcb.com.pe.domain.Usuario;
import lcb.com.pe.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getUser(){
		return "/user.html";
	}
	
	@RequestMapping(value="/listUsers/{id_sistema}", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listUsers(@PathVariable("id_sistema") int id_sistema){
		Logger.info("listUsers --> " + id_sistema);
		List<Usuario> list = usuarioService.findBySistema(id_sistema);
		if(list.isEmpty()){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
}
