package br.com.asas.carrinhoDoCaminho.VO;

import br.com.asas.carrinhoDoCaminho.model.Fabricante;

public class FabricanteVO {

    private int codigo;
    private String mensagem;
    private Fabricante fabricante;

    public FabricanteVO(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public FabricanteVO(int codigo, String mensagem, Fabricante fabricante) {
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "FabricanteVO{" +
                "codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", fabricante=" + fabricante +
                '}';
    }
}
