package br.com.asas.carrinhoDoCaminho.VO;

import br.com.asas.carrinhoDoCaminho.model.Departamento;

import java.util.List;

public class DepartamentoListVO {
    private int codigo;
    private String mensagem;
    private List<Departamento> departamentos;

    public DepartamentoListVO(int codigo, String mensagem, List<Departamento> departamentos) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.departamentos = departamentos;
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

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public String toString() {
        return "DepartamentoLIstVO{" +
                "codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}
