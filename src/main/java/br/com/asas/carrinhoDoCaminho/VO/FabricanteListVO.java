package br.com.asas.carrinhoDoCaminho.VO;

import br.com.asas.carrinhoDoCaminho.model.Fabricante;

import java.util.List;

public class FabricanteListVO {

    private int codigo;
    private String mensagem;
    private List<Fabricante> fabricante;

    public FabricanteListVO(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public FabricanteListVO(int codigo, String mensagem, List<Fabricante> fabricante) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.fabricante = fabricante;
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

    public List<Fabricante> getFabricante() {
        return fabricante;
    }

    public void setFabricante(List<Fabricante> fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "FabricanteListVO{" +
                "codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", fabricante=" + fabricante +
                '}';
    }
}
