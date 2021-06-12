package br.com.talthur.developerjr.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.talthur.developerjr.exception.ResourceNotFoundException;
import br.com.talthur.developerjr.model.ProdutoModel;
import br.com.talthur.developerjr.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {
	private ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Iterable<ProdutoModel> getAllProdutos() {
		return produtoRepository.findAll();
	}

	public ProdutoModel getProduto(long id) {

		return produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
	}

	public ProdutoModel save(ProdutoModel produtoModel) {
		return produtoRepository.save(produtoModel);
	}
}
