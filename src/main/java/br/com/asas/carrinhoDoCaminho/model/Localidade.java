package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;

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
}
