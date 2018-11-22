package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno Lopes
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

	/**
	 * 
	 * @author Bruno Lopes
	 */
	private static final long serialVersionUID = 8857474659591525862L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	@Column(name = "codigo", nullable = false)
	private Integer codigo;

	@Column(name = "fone", nullable = false, length = 3)
	@NotBlank(message = "O FONE deve ser informado.")
	@Length(min = 4, max = 4, message = "O FONE deve ter entre {min} e {max} caracteres.")
	@NotNull(message = "O FONE não pode ser nulo.")
	private String fone;

	@Column(name = "iso", nullable = false, length = 3)
	@NotBlank(message = "O ISO deve ser informado.")
	@Length(min = 2, max = 2, message = "O ISO deve ter entre {min} e {max} caracteres.")
	@NotNull(message = "O ISO não pode ser nulo.")
	private String iso;

	@Column(name = "iso3", nullable = false, length = 3)
	@NotBlank(message = "O ISO 3 deve ser informado.")
	@Length(min = 3, max = 3, message = "O ISO 3 deve ter entre {min} e {max} caracteres.")
	@NotNull(message = "O ISO 3 não pode ser nulo.")
	private String iso3;

	@Column(name = "nome", nullable = false, length = 50)
	@NotBlank(message = "O NOME deve ser informado.")
	@Length(max = 50, message = "O NOME não pode ter mais de {max} caracteres")
	@NotNull(message = "O NOME não pode ser nulo.")
	private String nome;

	@Column(name = "nomeFormal", nullable = false, length = 100)
	@NotBlank(message = "O NOME FORMAL deve ser informado.")
	@Length(max = 100, message = "O NOME FORMAL não pode ter mais de {max} caracteres")
	@NotNull(message = "O NOME FORMAL não pode ser nulo.")
	private String nomeFormal;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFormal() {
		return nomeFormal;
	}

	public void setNomeFormal(String nomeFormal) {
		this.nomeFormal = nomeFormal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
		result = prime * result + ((iso3 == null) ? 0 : iso3.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeFormal == null) ? 0 : nomeFormal.hashCode());
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
		Pais other = (Pais) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		if (iso3 == null) {
			if (other.iso3 != null)
				return false;
		} else if (!iso3.equals(other.iso3))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeFormal == null) {
			if (other.nomeFormal != null)
				return false;
		} else if (!nomeFormal.equals(other.nomeFormal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", fone=" + fone + ", iso=" + iso + ", iso3=" + iso3 + ", nome=" + nome
				+ ", nomeFormal=" + nomeFormal + "]";
	}

}
