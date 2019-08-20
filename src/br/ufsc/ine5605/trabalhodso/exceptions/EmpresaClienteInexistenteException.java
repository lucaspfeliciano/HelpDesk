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
public class EmpresaClienteInexistenteException extends Exception {

    public EmpresaClienteInexistenteException() {
        this("Empresa nao encontrada, verifique se o Numero do Contrato estah certo");
    }

    public EmpresaClienteInexistenteException(String message) {
        super(message);
    }
}
