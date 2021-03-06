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
 * @author Bruno Lopees
 */
@Entity
@Table(name = "compra_item")
public class CompraItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 441763397282713794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "A quantidade deve ser informada")
	@Min(value = 0, message = "Quantidade n�o pode ser negativa")
	@Column(name = "quantidade", nullable = false, columnDefinition = "numeric(10,2)")
	private Double quantidade;

	@NotNull(message = "O valor unitario deve ser informado")
	@Min(value = 0, message = "O valor unitario n�o pode ser negativo")
	@Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(10,2)")
	private Double valorUnitario;

	@NotNull(message = "O valor total deve ser informado")
	@Min(value = 0, message = "O valor total n�o pode ser negativo")
	@Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
	private Double valorTotal;

	@NotNull(message = "O produto deve ser informado")
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_compra_item_produto_id"))
	private Produto produto;

	@NotNull(message = "A compra deve ser informada")
	@ManyToOne
	private Compra compra;

	public CompraItem() {
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.id);
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
		final CompraItem other = (CompraItem) obj;
		return Objects.equals(this.id, other.id);
	}

}
