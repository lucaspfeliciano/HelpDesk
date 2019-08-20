/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.model;

import java.io.Serializable;

/**
 *
 * @author 04431899944
 */
public abstract class Problema implements Serializable {
    SistemaOperacional sistemaOperacional;
    TipoDeProblema tipoDeProblema;

    public Problema(SistemaOperacional sistemaOperacional, TipoDeProblema tipoDeProblema) {
        this.sistemaOperacional = sistemaOperacional;
        this.tipoDeProblema = tipoDeProblema;
    }

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public TipoDeProblema getTipoDeProblema() {
        return tipoDeProblema;
    }

    public void setTipoDeProblema(TipoDeProblema tipoDeProblema) {
        this.tipoDeProblema = tipoDeProblema;
    }
    
    
}


