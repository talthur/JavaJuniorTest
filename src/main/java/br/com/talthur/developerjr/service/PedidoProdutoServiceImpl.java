package br.com.talthur.developerjr.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.talthur.developerjr.model.PedidoProdutoModel;
import br.com.talthur.developerjr.repository.PedidoProdutoRepository;

@Service
@Transactional
public class PedidoProdutoServiceImpl implements PedidoProdutoService{

	private PedidoProdutoRepository pedidoProdutoRepository;
	
	public PedidoProdutoServiceImpl(PedidoProdutoRepository pedidoProdutoRepository) {
		this.pedidoProdutoRepository = pedidoProdutoRepository;
	}
	
	@Override
	public PedidoProdutoModel create(PedidoProdutoModel pedidoProdutoModelo) {
		return this.pedidoProdutoRepository.save(pedidoProdutoModelo);
	}

}
