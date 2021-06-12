package br.com.talthur.developerjr.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.talthur.developerjr.model.ProdutoModel;

@Validated
public interface ProdutoService {
	@NotNull Iterable<ProdutoModel> getAllProdutos();

    ProdutoModel getProduto(@Min(value = 1L, message = "Invalid product ID.") long id);

    ProdutoModel save(ProdutoModel produto);
}
