package model;

import java.io.Serializable;
import java.util.Objects;
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
 * @author Bruno Lopes de Melo
 */
@Entity
@Table(name = "marca")
public class Marca implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8631132698320241732L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome",length = 40, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    
    public Marca(){
        
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

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Marca other = (Marca) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
    
}
