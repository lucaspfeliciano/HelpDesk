/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.model;

/**
 *
 * @author 11193319943
 */
public class Usuario extends Pessoa {

    long numContrato;

    public Usuario(String nome, long cpf, long telefone, long numContrato) {
        super(nome, cpf, telefone);
        this.numContrato = numContrato;
    }

    public long getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(long numContrato) {
        this.numContrato = numContrato;
    }

}
