package br.com.talthur.developerjr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.talthur.developerjr.model.ProdutoModel;
import br.com.talthur.developerjr.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	// Salva um novo cliente no DB
	@PostMapping(path = "/api/produto/salvar")
	public ProdutoModel addProduto(@RequestBody ProdutoModel produto) {
		return produtoRepository.save(produto);
	}

	// Retorna JSON com todos clientes do DB
	@GetMapping(path = "/api/produtos")
	public List<ProdutoModel> listProduto() {
		return produtoRepository.findAll();
	}

	// Retorna JSON com dados do produto a partir de ID
	@GetMapping(path = "/api/produto/{id}")
	public ResponseEntity<ProdutoModel> getProduto(@PathVariable Long id) {
		return produtoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// Deleta um produto do DB baseado em seu ID
	@DeleteMapping(path = "api/produto/{id}")
	public void deleteProduto(@PathVariable("id") Long id) {
		produtoRepository.deleteById(id);
	}
	
	// Atualiza um cliente do DB baseado em seu ID, com conteúdo da Request
	@PutMapping(path = "api/produto/{id}")
	public ResponseEntity<ProdutoModel> updateProduto(@PathVariable("id") Long id, @RequestBody ProdutoModel produto){
		
		return produtoRepository.findById(id).map(record -> {
			record.setNome(produto.getNome());
			record.setDescricao(produto.getDescricao());
			record.setPreco(produto.getPreco());
			record.setQuantidade(produto.getQuantidade());
			ProdutoModel produtoAtualizado = produtoRepository.save(record);
			return ResponseEntity.ok().body(produtoAtualizado);}).orElse(ResponseEntity.notFound().build());
		
	}
	
}
