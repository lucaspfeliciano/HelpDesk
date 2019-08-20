/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.model;

/**
 *
 * @author 04431899944
 */
public class ProblemaDesempenho extends Problema {
    int duracao;
    String operacao;

    public ProblemaDesempenho(SistemaOperacional sistemaOperacional, TipoDeProblema tipoDeProblema, int duracao, String operacao) {
        super(sistemaOperacional, tipoDeProblema);
        this.duracao = duracao;
        this.operacao = operacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    
    
}
