package br.com.talthur.developerjr.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.talthur.developerjr.model.ClienteModel;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
	List<ClienteModel> findAll();
}
