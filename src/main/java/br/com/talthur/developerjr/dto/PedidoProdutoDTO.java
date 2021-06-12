package br.com.talthur.developerjr.dto;

import br.com.talthur.developerjr.model.ProdutoModel;

public class PedidoProdutoDTO {
	
	private ProdutoModel produto;
	private Integer quantidade;
	
	public ProdutoModel getProduto() {
		return produto;
	}
	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "PedidoProdutoDTO [produto=" + produto + ", quantidade=" + quantidade + ", getProduto()=" + getProduto()
				+ ", getQuantidade()=" + getQuantidade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
