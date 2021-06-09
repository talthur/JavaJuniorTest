package br.com.talthur.developerjr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ClienteController {
	
	@GetMapping(path="api/cliente")
	public String usuario(){
		return "Está funcionando";
	}
	
}
