package br.com.talthur.developerjr.service;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import br.com.talthur.developerjr.model.ClienteModel;

@Validated
public interface ClienteService {

    ClienteModel getCliente(@Min(value = 1L, message = "Invalid Cliente.") long id);

    ClienteModel save(ClienteModel cliente);
}
