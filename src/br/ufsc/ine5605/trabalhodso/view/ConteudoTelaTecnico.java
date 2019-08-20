/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

/**
 *
 * @author Muraro
 */
public class ConteudoTelaTecnico {

    public String nome;
    public long cpf;
    public long telefone;

    public ConteudoTelaTecnico(String nome, long cpf, long telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    ConteudoTelaTecnico() {
        this.nome = "";
        this.cpf = 0;
        this.telefone = 0;

    }

}
