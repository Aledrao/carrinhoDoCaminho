package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name = "sigla_estado")
    private String sigla;

    @Column(name = "nome_estado", nullable = false, unique = true)
    private String nome;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
