package br.com.talthur.developerjr.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.talthur.developerjr.model.ProdutoModel;

public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long>{
	List<ProdutoModel>findAll();
	
}
