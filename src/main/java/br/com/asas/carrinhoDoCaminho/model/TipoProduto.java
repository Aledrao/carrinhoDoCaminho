package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_produto")
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_tipo_produto")
    private Integer codigo;

    @Column(name = "nome_tipo_produto", unique = true, nullable = false)
    private String tipoProduto;

    @OneToMany(mappedBy = "tipoProduto")
    private List<Produto> produtos;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
