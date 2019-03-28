package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;

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
}
