/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.exceptions;

/**
 *
 * @author 11193319943
 */
public class PessoaJaCadastradaException extends Exception {

    public PessoaJaCadastradaException() {
        this("Esta pessoa ja foi cadastrada.");
    }

    public PessoaJaCadastradaException(String message) {
        super(message);
    }
}
