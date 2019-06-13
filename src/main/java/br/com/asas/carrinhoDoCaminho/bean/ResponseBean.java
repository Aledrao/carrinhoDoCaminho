package br.com.asas.carrinhoDoCaminho.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


public class ResponseBean {
    public ResponseBean(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public ResponseBean(int codigo, String mensagem, Object objeto) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.objeto = objeto;
    }

    public ResponseBean(int codigo, String mensagem, List<Object> objetos) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.objetos = objetos;
    }

    private int codigo;
    private String mensagem;
    private Object objeto;
    private List<Object> objetos;

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

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public List<Object> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Object> objetos) {
        this.objetos = objetos;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", objeto=" + objeto +
                ", objetos=" + objetos +
                '}';
    }
}
