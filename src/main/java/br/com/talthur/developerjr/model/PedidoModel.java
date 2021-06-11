package br.com.talthur.developerjr.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class PedidoModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotNull
	@OneToOne
	ClienteModel cliente;
	
	@NotNull
	BigDecimal totalCompra;
	
	@NotNull
	LocalDate dataDaCompra;
	
	@NotNull
	@OneToMany(fetch = FetchType.EAGER)
	List<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();

	
	public BigDecimal getTotalCompra(List<ProdutoModel> listaProdutos) {
	 for(ProdutoModel produto : listaProdutos) {
		totalCompra = totalCompra.add(produto.getPreco());
	 }
	 return totalCompra;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public List<ProdutoModel> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoModel> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	

}
