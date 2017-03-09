package lcb.com.pe.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String getIndex(){
		return "/login.html";
	}
	
	@RequestMapping(value="/forgot", method = RequestMethod.GET)
	public String forgotPassword(){
		return "/forgot.html";
	}

}
