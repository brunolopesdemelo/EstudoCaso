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
@Table(name = "permissao")
public class Permissao implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6537000076897353638L;
	
	@Id
    @NotBlank(message = "O nome n�o pode ser em branco")
    @NotNull(message = "O nome n�o pode ser nulo")
    @Length(max = 30, message = "O nome n�o pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
   
	@NotBlank(message = "A descri��o n�o pode ser em branco")
    @NotNull(message = "A descri��o n�o pode ser nula")
    @Length(max = 40, message = "A descri��o n�o pode ter mais de {max} caracteres")
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;

    public Permissao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nome);
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
        final Permissao other = (Permissao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
