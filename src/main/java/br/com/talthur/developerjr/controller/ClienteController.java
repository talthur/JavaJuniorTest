package br.com.talthur.developerjr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.talthur.developerjr.model.ClienteModel;
import br.com.talthur.developerjr.repository.ClienteRepository;

@RestController()
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	// Retorna JSON com dados do cliente a partir de ID
	@GetMapping(path = "api/cliente/{id}")
	public ResponseEntity<ClienteModel> getCliente(@PathVariable("id") Long id) {
		return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// Retorna JSON com todos clientes do DB
	@GetMapping(path = "api/clientes")
	public List<ClienteModel> listCliente() {
		return clienteRepository.findAll();
	}

	// Salva um novo cliente no DB
	@PostMapping(path = "api/cliente/salvar")
	public ClienteModel addCliente(@RequestBody @Validated ClienteModel cliente) {
		return clienteRepository.save(cliente);
	}

	// Deleta um cliente do DB baseado em seu ID
	@DeleteMapping(path = "api/cliente/{id}")
	public void deleteCliente(@PathVariable("id") long id) {
		clienteRepository.deleteById(id);
	}

	// Atualiza um cliente do DB baseado em seu ID, com conteúdo da Request
	@PutMapping(path = "api/cliente/{id}")
	public ResponseEntity<ClienteModel> atualizaCliente(@PathVariable("id") long id,
			@RequestBody ClienteModel cliente) {
		
		return clienteRepository.findById(id).map(record -> 
		{record.setNome(cliente.getNome());
		 record.setCpf(cliente.getCpf());
		 record.setDataDeNascimento(cliente.getDataDeNascimento());
		 ClienteModel clienteAtualizado = clienteRepository.save(record);
		 return ResponseEntity.ok().body(clienteAtualizado);}).orElse(ResponseEntity.notFound().build());
		
	}

}
