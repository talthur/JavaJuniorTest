package br.com.talthur.developerjr.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@OneToOne
	private ClienteModel cliente;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataDaCompra;

	@NotNull
	@OneToMany(mappedBy = "pk.pedido")
	private List<PedidoProdutoModel> listaPedidoProdutos = new ArrayList<PedidoProdutoModel>();

	@Transient
	public BigDecimal getTotalCompra(List<ProdutoModel> listaProdutos) {
		BigDecimal soma = new BigDecimal(0);
		for (ProdutoModel produto : listaProdutos) {
			soma = soma.add(produto.getPreco());
		}
		return soma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataDaCompra == null) ? 0 : dataDaCompra.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((listaPedidoProdutos == null) ? 0 : listaPedidoProdutos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoModel other = (PedidoModel) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataDaCompra == null) {
			if (other.dataDaCompra != null)
				return false;
		} else if (!dataDaCompra.equals(other.dataDaCompra))
			return false;
		if (id != other.id)
			return false;
		if (listaPedidoProdutos == null) {
			if (other.listaPedidoProdutos != null)
				return false;
		} else if (!listaPedidoProdutos.equals(other.listaPedidoProdutos))
			return false;
		return true;
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

	public List<PedidoProdutoModel> getListaPedidoProdutos() {
		return listaPedidoProdutos;
	}

	public void setListaPedidoProdutos(List<PedidoProdutoModel> listaPedidoProdutos) {
		this.listaPedidoProdutos = listaPedidoProdutos;
	}

	

	

}
