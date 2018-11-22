/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno Lopes
 */
@Entity
@Table(name = "venda_itens")
public class VendaItens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4116893293014625599L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "O quantidade deve ser informada")
	@Min(value = 0, message = "A quantidade n�o pode ser negativa")
	@Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
	private Double quantidade;

	@NotNull(message = "O valor unitario deve ser informado")
	@Min(value = 0, message = "O valor unitario n�o pode ser negativo")
	@Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(12,2)")
	private Double valorUnitario;

	@NotNull(message = "O valor total deve ser informado")
	@Min(value = 0, message = "O valor total n�o pode ser negativo")
	@Column(name = "valor_total", nullable = false, columnDefinition = "decimal(12,2)")
	private Double valorTotal;

	@NotNull(message = "A venda n�o pode ser nula")
	@ManyToOne
	@JoinColumn(name = "venda", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_venda_itens_venda_id"))
	private Venda venda;

	@NotNull(message = "O produto n�o pode ser nulo")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_venda_itens_produto_id"))
	private Produto produto;

	public VendaItens() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VendaItens other = (VendaItens) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
}
