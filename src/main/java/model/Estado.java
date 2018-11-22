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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno Lopes
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1656685821951989692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 50)
	@NotBlank(message = "O NOME deve ser informado.")
	@Length(max = 50, message = "O NOME não pode ter mais de {max} caracteres")
	@NotNull(message = "O NOME não pode ser nulo.")
	private String nome;

	@Column(name = "iso", nullable = false, length = 3)
	@NotBlank(message = "A UF deve ser informado.")
	@Length(min = 2, max = 2, message = "A UF deve ter entre {min} e {max} caracteres.")
	@NotNull(message = "A UF não pode ser nulo.")
	private String uf;

	@NotNull(message = "O Pais deve ser informado")
	@ManyToOne
	@JoinColumn(name = "pais", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_estado_pais_id"))
	private Pais pais;

	public Estado() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf
	 *            the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.id);
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
		final Estado other = (Estado) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}
