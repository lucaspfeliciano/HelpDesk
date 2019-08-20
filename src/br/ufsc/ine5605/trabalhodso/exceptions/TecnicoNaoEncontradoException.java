/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.exceptions;

/**
 *
 * @author Lucas
 */
public class TecnicoNaoEncontradoException extends Exception {
    
    public TecnicoNaoEncontradoException () {
        this("Tecnico não encontrado");
    }
    public TecnicoNaoEncontradoException (String message) {
        super(message);
    }    
}
