package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_item")
    public Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_produto")
    private Produto produto;

    @Column(name = "quantidade")
    private Float quantidade;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "item")
    private List<ItemCarrinho> itensCarrinhos;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemCarrinho> getItensCarrinhos() {
        return itensCarrinhos;
    }

    public void setItensCarrinhos(List<ItemCarrinho> itensCarrinhos) {
        this.itensCarrinhos = itensCarrinhos;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", itensCarrinhos=" + itensCarrinhos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(codigo, item.codigo) &&
                Objects.equals(produto, item.produto) &&
                Objects.equals(quantidade, item.quantidade) &&
                Objects.equals(valorUnitario, item.valorUnitario) &&
                Objects.equals(valorTotal, item.valorTotal) &&
                Objects.equals(itensCarrinhos, item.itensCarrinhos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, produto, quantidade, valorUnitario, valorTotal, itensCarrinhos);
    }
}
