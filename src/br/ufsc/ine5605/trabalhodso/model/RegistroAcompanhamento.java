/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.model;

import java.util.Date;

/**
 *
 * @author 04431899944
 */
public class RegistroAcompanhamento {
    String data;
    String assusnto;
    String tecnico;

    public RegistroAcompanhamento(String data, String assusnto, String tecnico) {
        this.data = data;
        this.assusnto = assusnto;
        this.tecnico = tecnico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAssusnto() {
        return assusnto;
    }

    public void setAssusnto(String assusnto) {
        this.assusnto = assusnto;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    
    
    
}
