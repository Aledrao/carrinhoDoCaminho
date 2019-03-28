package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.math.BigDecimal;

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
}
