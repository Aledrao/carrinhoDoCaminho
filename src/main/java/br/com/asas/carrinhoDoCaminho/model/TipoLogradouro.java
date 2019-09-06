package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipo_logradouro")
public class TipoLogradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_tipo_logradouro")
    private Integer codigo;

    @Column(name = "tipo_logradouro")
    private String tipoLogradouro;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Override
    public String toString() {
        return "TipoLogradouro{" +
                "codigo=" + codigo +
                ", tipoLogradouro='" + tipoLogradouro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoLogradouro that = (TipoLogradouro) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(tipoLogradouro, that.tipoLogradouro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, tipoLogradouro);
    }
}
