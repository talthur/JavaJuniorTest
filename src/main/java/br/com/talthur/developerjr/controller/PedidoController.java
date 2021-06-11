package br.com.talthur.developerjr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.talthur.developerjr.model.PedidoModel;
import br.com.talthur.developerjr.model.ProdutoModel;
import br.com.talthur.developerjr.repository.PedidoRepository;

@RestController
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping(path = "/api/pedidos/salvar")
	public PedidoModel addPedido(@RequestBody PedidoModel pedido) {
		for(ProdutoModel produto : pedido.getListaProdutos()) {
			if(produto.getQuantidade() > 0) {
				produto.setQuantidade(produto.getQuantidade() - 1);
			}
		}
		return pedidoRepository.save(pedido);
	}

}
