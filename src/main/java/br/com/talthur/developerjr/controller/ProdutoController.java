package br.com.talthur.developerjr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.talthur.developerjr.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;


}
