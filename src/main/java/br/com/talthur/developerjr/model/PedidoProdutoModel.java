package br.com.talthur.developerjr.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoProdutoModel {

	@EmbeddedId
	@JsonIgnore
	private PedidoProdutoPK pk;

	@Column(nullable = false)
	private int quantidade;

	/**
	 * @deprecated hibernate only
	 */
	public PedidoProdutoModel() {
		super();
	}

	public PedidoProdutoModel(ProdutoModel produto, PedidoModel pedido, int quantidade, ClienteModel cliente) {
		pk = new PedidoProdutoPK();
		pk.setPedido(pedido);
		pk.setProduto(produto);
		pk.setCliente(cliente);
		this.quantidade = quantidade;
	}
	

	@Transient
	public ProdutoModel getProduto() {
		return this.pk.getProduto();
	}

	@Transient
	public BigDecimal getTotalPrice() {
		return pk.getProduto().getPreco().multiply(new BigDecimal(this.quantidade));
	}

	public PedidoProdutoPK getPk() {
		return pk;
	}

	public void setPk(PedidoProdutoPK pk) {
		this.pk = pk;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + quantidade;
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
		PedidoProdutoModel other = (PedidoProdutoModel) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}
	
	

}
