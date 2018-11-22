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
@Table(name = "endereco")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -224332653064848415L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nick_name")
	@NotNull(message = "O apelido não pode ser nulo")
	@NotBlank(message = "O apelido deve ser informado.")
	@Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
	private String nickName;

	@NotNull(message = "O endereco não pode ser nulo")
	@NotBlank(message = "O endereco deve ser informado.")
	@Length(max = 50, message = "O endereco não pode ter mais de {max} caracteres")
	@Column(name = "endereco")
	private String endereco;

	@NotNull(message = "O numero não pode ser nulo")
	@NotBlank(message = "O numero não ser em branco")
	@Length(max = 10, message = "O numero não pode ter mais de {max} caracteres")
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;

	@Length(max = 20, message = "O complemento não pode ter mais de {max} caracteres")
	@Column(name = "complemento", length = 20)
	private String complemento;

	@NotNull(message = "O cep não pode ser nulo")
	@NotBlank(message = "O cep não ser em branco")
	@Length(max = 9, message = "O cep não pode ter mais de {max} caracteres")
	@Column(name = "cep", length = 9, nullable = false)
	private String cep;

	@NotNull(message = "O bairro não pode ser nulo")
	@NotBlank(message = "O bairro não ser em branco")
	@Length(max = 40, message = "O bairro não pode ter mais de {max} caracteres")
	@Column(name = "bairro", length = 40, nullable = false)
	private String bairro;

	@Length(max = 30, message = "A referÃªncia não pode ter mais de {max} caracteres")
	@Column(name = "referencia", length = 30)
	private String referencia;

	@NotNull(message = "A pessoa deve ser informada")
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_endereco_pessoa_id"))
	private Pessoa pessoa;

	@NotNull(message = "O Tipo Endereco deve ser informada")
	@ManyToOne
	@JoinColumn(name = "tipo_endereco_id", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_endereco_tipo_endereco_id"))
	private TipoEndereco tipoEndereco;

	@NotNull(message = "A cidade deve ser informada")
	@ManyToOne
	@JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "fk_endereco_cidade_id"))
	private Cidade cidade;

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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento
	 *            the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia
	 *            the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the tipoEndereco
	 */
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * @param tipoEndereco
	 *            the tipoEndereco to set
	 */
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
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
		final Endereco other = (Endereco) obj;
		return Objects.equals(this.id, other.id);
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
