package br.com.asas.carrinhoDoCaminho.VO;

import br.com.asas.carrinhoDoCaminho.model.Departamento;

public class DepartamentoVO {
    private int codigo;
    private String mensagem;
    private Departamento departamento;

    public DepartamentoVO(int codigo, String mensagem, Departamento departamento) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.departamento = departamento;
    }

    public DepartamentoVO(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "DepartamentoVO{" +
                "codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
