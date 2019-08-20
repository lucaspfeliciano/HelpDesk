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
public class EmpresaCliente implements Serializable {

    long numContrato;
    String nome;
    Usuario usuario;

    public EmpresaCliente(long numContrato, String nome) {
        this.numContrato = numContrato;
        this.nome = nome;
        this.usuario = usuario;
    }

    public long getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(long numContrato) {
        this.numContrato = numContrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
