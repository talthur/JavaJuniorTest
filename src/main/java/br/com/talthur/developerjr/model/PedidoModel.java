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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "pedido")
public class PedidoModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@OneToOne(mappedBy = "pk.pedido")
	private ClienteModel cliente;
	
	@NotNull
	private BigDecimal totalCompra;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataDaCompra;
	
	@NotNull
	@JsonManagedReference
	@OneToMany(mappedBy = "pk.pedido")
	private List<PedidoProdutoModel> listaPedidoProdutos = new ArrayList<PedidoProdutoModel>();

	@Transient
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

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public List<PedidoProdutoModel> getListaProdutos() {
		return listaPedidoProdutos;
	}

	public void setListaProdutos(List<PedidoProdutoModel> listaProdutos) {
		this.listaPedidoProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataDaCompra == null) ? 0 : dataDaCompra.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((listaPedidoProdutos == null) ? 0 : listaPedidoProdutos.hashCode());
		result = prime * result + ((totalCompra == null) ? 0 : totalCompra.hashCode());
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
		if (totalCompra == null) {
			if (other.totalCompra != null)
				return false;
		} else if (!totalCompra.equals(other.totalCompra))
			return false;
		return true;
	}

	
	

}
