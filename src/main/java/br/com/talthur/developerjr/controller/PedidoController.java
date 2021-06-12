package br.com.talthur.developerjr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.talthur.developerjr.dto.PedidoProdutoDTO;
import br.com.talthur.developerjr.exception.ResourceNotFoundException;
import br.com.talthur.developerjr.model.PedidoModel;
import br.com.talthur.developerjr.model.PedidoProdutoModel;
import br.com.talthur.developerjr.service.PedidoProdutoServiceImpl;
import br.com.talthur.developerjr.service.PedidoServiceImpl;
import br.com.talthur.developerjr.service.ProdutoServiceImpl;

@RestController
public class PedidoController {

	ProdutoServiceImpl produtoService;
	PedidoServiceImpl pedidoService;
	PedidoProdutoServiceImpl pedidoProdutoService;

	public PedidoController(ProdutoServiceImpl produtoService, PedidoServiceImpl pedidoService,
			PedidoProdutoServiceImpl pedidoProdutoService) {
		this.produtoService = produtoService;
		this.pedidoService = pedidoService;
		this.pedidoProdutoService = pedidoProdutoService;
	}

	@GetMapping(path = "api/pedidos")
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<PedidoModel> list() {
		return this.pedidoService.getAllPedidos();
	}

	@PostMapping(path = "api/pedido/salva")
	public ResponseEntity<PedidoModel> create(@RequestBody PedidoForm form) {
		
		if(form.equals(null)) {
			new ResourceNotFoundException("JSON vazio");
		}
		
		System.out.println("O que é o form?: " + form.getProdutoPedidos().toString());
		
		List<PedidoProdutoDTO> formDtos = form.getProdutoPedidos();
		validaExistenciaDoProduto(formDtos);
		PedidoModel pedido = new PedidoModel();
		pedido = this.pedidoService.create(pedido);

		List<PedidoProdutoModel> pedidoProdutoModel = new ArrayList<>();
		for (PedidoProdutoDTO dto : formDtos) {
			pedidoProdutoModel.add(pedidoProdutoService.create(new PedidoProdutoModel(produtoService.getProduto(dto.getProduto().getId()),
					pedido, dto.getQuantidade(), null)));
		}

		pedido.setListaProdutos(pedidoProdutoModel);

		this.pedidoService.update(pedido);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/pedidos/{id}")
				.buildAndExpand(pedido.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(pedido, headers, HttpStatus.CREATED);
	}

	private void validaExistenciaDoProduto(List<PedidoProdutoDTO> produtoPedidos) {
		
		List<PedidoProdutoDTO> list = produtoPedidos.stream()
				.filter(op -> Objects.isNull(produtoService.getProduto(op.getProduto().getId())))
				.collect(Collectors.toList());
		
		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}

	public static class PedidoForm {

		private List<PedidoProdutoDTO> produtoPedidos;
	
		public List<PedidoProdutoDTO> getProdutoPedidos() {
			return produtoPedidos;
		}

		public void setProdutoPedidos(List<PedidoProdutoDTO> produtoPedidos) {
			this.produtoPedidos = produtoPedidos;
		}

		@Override
		public String toString() {
			return "PedidoForm [produtoPedidos=" + produtoPedidos + "]";
		}
		
		

	}
}