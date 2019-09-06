package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "localidade_endereco")
public class LocalidadeEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_localidade_endereco")
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "cod_localidade")
    private Localidade localidade;

    @Column(name = "sem_localidade")
    private String semLocalidade;

    @ManyToOne
    @JoinColumn(name = "cod_logradouro")
    private Logradouro endereco;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public String getSemLocalidade() {
        return semLocalidade;
    }

    public void setSemLocalidade(String semLocalidade) {
        this.semLocalidade = semLocalidade;
    }

    public Logradouro getEndereco() {
        return endereco;
    }

    public void setEndereco(Logradouro endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "LocalidadeEndereco{" +
                "codigo=" + codigo +
                ", localidade=" + localidade +
                ", semLocalidade='" + semLocalidade + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalidadeEndereco that = (LocalidadeEndereco) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(localidade, that.localidade) &&
                Objects.equals(semLocalidade, that.semLocalidade) &&
                Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, localidade, semLocalidade, endereco);
    }
}
