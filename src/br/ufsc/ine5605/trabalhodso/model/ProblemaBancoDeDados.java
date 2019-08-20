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
public class ProblemaBancoDeDados extends Problema {
    String bancoDeDados;

    public ProblemaBancoDeDados(SistemaOperacional sistemaOperacional, TipoDeProblema tipoDeProblema, String bancoDeDados) {
        super(sistemaOperacional, tipoDeProblema);
        this.bancoDeDados = bancoDeDados;
    }

    public String getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(String bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    @Override
    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
  
}
