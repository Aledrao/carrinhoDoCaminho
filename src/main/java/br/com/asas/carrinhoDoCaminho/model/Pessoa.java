package br.com.asas.carrinhoDoCaminho.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pessoa")
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "apelido", nullable = false, unique = true)
    private String apelido;

    @Email(message = "Informe um endereço de email válido.")
    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name = "time_data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "responsavel")
    private List<Carrinho> carrinhos;

    @ManyToMany
    @JoinTable(name = "carrinho_compartilhado_pessoa")
    private List<Carrinho> compartilhado;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public List<Carrinho> getCompartilhado() {
        return compartilhado;
    }

    public void setCompartilhado(List<Carrinho> compartilhado) {
        this.compartilhado = compartilhado;
    }
}
