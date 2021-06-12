package br.com.talthur.developerjr.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import br.com.talthur.developerjr.model.PedidoProdutoModel;

@Validated
public interface PedidoProdutoService {
	   PedidoProdutoModel create(@NotNull(message = "Os produtos não podem ser null") @Valid PedidoProdutoModel pedidoProdutoModel);
}
