package br.com.talthur.developerjr.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.talthur.developerjr.exception.ResourceNotFoundException;
import br.com.talthur.developerjr.model.ClienteModel;
import br.com.talthur.developerjr.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	@Override
	public ClienteModel getCliente(long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
	}

	@Override
	public ClienteModel save(ClienteModel cliente) {
		return clienteRepository.save(cliente);
	}

}
