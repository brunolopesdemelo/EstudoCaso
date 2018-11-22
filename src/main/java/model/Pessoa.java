package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno Lopes
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3963061189713769868L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O nome n�o pode ser nulo")
    @NotBlank(message = "O nome n�o ser em branco")
    @Length(max = 50, message = "O nome n�o pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotNull(message = "O email n�o pode ser nulo")
    @NotBlank(message = "O email n�o ser em branco")
    @Length(max = 50, message = "O email n�o pode ter mais de {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull(message = "O telefone n�o pode ser nulo")
    @NotBlank(message = "O telefone n�o ser em branco")
    @Length(max = 14, message = "O telefone n�o pode ter mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {
    }

    public void adicionarEndereco(Endereco obj) {
        obj.setPessoa(this);
        this.enderecos.add(obj);
    }

    public void removerEndereco(int index) {
        this.enderecos.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
