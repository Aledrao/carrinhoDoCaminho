package br.com.asas.carrinhoDoCaminho.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_carrinho")
    private Long codigo;

    @OneToMany(mappedBy = "carrinho")
    private List<ItemCarrinho> itens;

    @Column(name = "total_itens", nullable = false)
    private Integer totalItens;

    @ManyToOne
    @JoinColumn(name = "cod_pessoa")
    private Pessoa responsavel;

    @Column(name = "valor_total", unique = true)
    private BigDecimal valorTotal;

    @ManyToMany(mappedBy = "compartilhado")
    private List<Pessoa> compartilhado;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name = "time_data_criacao")
    private LocalDateTime dataCriacao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public Integer getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Integer totalItens) {
        this.totalItens = totalItens;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pessoa> getCompartilhado() {
        return compartilhado;
    }

    public void setCompartilhado(List<Pessoa> compartilhado) {
        this.compartilhado = compartilhado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "codigo=" + codigo +
                ", itens=" + itens +
                ", totalItens=" + totalItens +
                ", responsavel=" + responsavel +
                ", valorTotal=" + valorTotal +
                ", compartilhado=" + compartilhado +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(codigo, carrinho.codigo) &&
                Objects.equals(itens, carrinho.itens) &&
                Objects.equals(totalItens, carrinho.totalItens) &&
                Objects.equals(responsavel, carrinho.responsavel) &&
                Objects.equals(valorTotal, carrinho.valorTotal) &&
                Objects.equals(compartilhado, carrinho.compartilhado) &&
                Objects.equals(dataCriacao, carrinho.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, itens, totalItens, responsavel, valorTotal, compartilhado, dataCriacao);
    }
}
