/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

/**
 *
 * @author 11193319943
 */
public class ConteudoTelaEmpresaCliente {

    public long numContrato;
    public String nome;

    public ConteudoTelaEmpresaCliente(String nome, long numContrato) {
        this.numContrato = numContrato;
        this.nome = nome;
    }
    ConteudoTelaEmpresaCliente() {
        this.numContrato = 0;
        this.nome = "";
    }
}