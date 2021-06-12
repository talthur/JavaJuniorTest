package br.com.talthur.developerjr.service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.talthur.developerjr.model.PedidoModel;

@Validated
public interface PedidoService {
	
	@NotNull 
	Iterable<PedidoModel> getAllPedidos();

    PedidoModel create(@NotNull(message = "The order cannot be null.") @Valid PedidoModel pedido);

    void update(@NotNull(message = "The order cannot be null.") @Valid PedidoModel pedido);

}
