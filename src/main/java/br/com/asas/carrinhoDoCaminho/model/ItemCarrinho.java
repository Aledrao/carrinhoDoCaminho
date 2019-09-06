package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_item_carrinho")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_item")
    private Item item;

    @Column(name = "valor_minimo")
    private BigDecimal valorMinimo;

    @Column(name = "valor_maximo")
    private BigDecimal valorMaximo;

    @Column(name = "quantidade_minima")
    private Float quantidadeMinima;

    @Column(name = "quantidade_maxima")
    private Float quantidadeMaxima;

    @ManyToOne
    @JoinColumn(name = "cod_carrinho")
    private Carrinho carrinho;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Float getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Float quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Float getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(Float quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "ItemCarrinho{" +
                "codigo=" + codigo +
                ", item=" + item +
                ", valorMinimo=" + valorMinimo +
                ", valorMaximo=" + valorMaximo +
                ", quantidadeMinima=" + quantidadeMinima +
                ", quantidadeMaxima=" + quantidadeMaxima +
                ", carrinho=" + carrinho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinho that = (ItemCarrinho) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(item, that.item) &&
                Objects.equals(valorMinimo, that.valorMinimo) &&
                Objects.equals(valorMaximo, that.valorMaximo) &&
                Objects.equals(quantidadeMinima, that.quantidadeMinima) &&
                Objects.equals(quantidadeMaxima, that.quantidadeMaxima) &&
                Objects.equals(carrinho, that.carrinho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, item, valorMinimo, valorMaximo, quantidadeMinima, quantidadeMaxima, carrinho);
    }
}
