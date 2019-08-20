package br.com.asas.carrinhoDoCaminho.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "departamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_departamento")
    private Integer codigo;

    @NotEmpty(message="Informe o nome do departamento.")
    @Column(name = "nome_departamento", nullable = false, unique = true)
    private String departamento;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo=" + codigo +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
