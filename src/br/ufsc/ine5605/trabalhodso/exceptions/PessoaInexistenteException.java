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
public class PessoaInexistenteException extends Exception {

    public PessoaInexistenteException() {
        this("Pessoa nao encontrada, verifique se o cpf estah certo.");
    }

    public PessoaInexistenteException(String message) {
        super(message);
    }

}
