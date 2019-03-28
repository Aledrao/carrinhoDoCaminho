package br.com.asas.carrinhoDoCaminho.model;

import javax.persistence.*;

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
}
