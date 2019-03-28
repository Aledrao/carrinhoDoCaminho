package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fabricante")
    private Integer codigo;

    @Column(name = "nome_fabricante", unique = true, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtos;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
