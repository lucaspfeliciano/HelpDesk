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
public class ProblemaComunicacaoDeRede extends Problema {
    String enderecoServidor;
    String tipoConexao;

    public ProblemaComunicacaoDeRede(SistemaOperacional sistemaOperacional, TipoDeProblema tipoDeProblema, String enderecoServidor, String tipoConexao) {
        super(sistemaOperacional, tipoDeProblema);
        this.enderecoServidor = enderecoServidor;
        this.tipoConexao = tipoConexao;
    }

    public String getEnderecoServidor() {
        return enderecoServidor;
    }

    public void setEnderecoServidor(String enderecoServidor) {
        this.enderecoServidor = enderecoServidor;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    
    
}
