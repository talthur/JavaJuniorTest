package br.com.talthur.developerjr.service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.talthur.developerjr.model.PedidoModel;
import br.com.talthur.developerjr.repository.PedidoRepository;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public @NotNull Iterable<PedidoModel> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	@Override
	public PedidoModel create(PedidoModel pedido) {
		return this.pedidoRepository.save(pedido);
	}

	@Override
	public void update(PedidoModel pedido) {
		this.pedidoRepository.save(pedido);
	}

	@Override
	public void delete(@NotNull(message = "The order cannot be null.") @Valid PedidoModel pedido) {
		this.pedidoRepository.delete(pedido);
		
	}

	
}
	
	
