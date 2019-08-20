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
public class EmpresaJahCadastradaException extends Exception {

    public EmpresaJahCadastradaException() {
        this("Jah existe uma empresa cadastrada com esse nome ou numero de contrato!");
    }

    public EmpresaJahCadastradaException(String message) {
        super(message);
    }
}
