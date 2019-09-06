package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "localidade")
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_localidade")
    private Long codigo;

    @Column(name = "nome_localidade", unique = true, nullable = false)
    private String localidade;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "codigo=" + codigo +
                ", localidade='" + localidade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidade that = (Localidade) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(localidade, that.localidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, localidade);
    }
}
