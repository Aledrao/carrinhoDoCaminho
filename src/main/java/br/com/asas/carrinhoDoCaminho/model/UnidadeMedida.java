package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_unid_medida")
    private Integer codigo;

    @Column(name = "sigla_unid_medida", unique = true, nullable = false)
    private String sigla;

    @Column(name = "nome_unidade_medida", nullable = false)
    private String nomeUnidadeMedida;

    @OneToMany(mappedBy = "unidadeMedida")
    private List<Produto> produtos;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeUnidadeMedida() {
        return nomeUnidadeMedida;
    }

    public void setNomeUnidadeMedida(String nomeUnidadeMedida) {
        this.nomeUnidadeMedida = nomeUnidadeMedida;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
