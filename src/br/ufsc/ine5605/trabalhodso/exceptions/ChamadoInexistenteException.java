/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.exceptions;

/**
 *
 * @author 04431899944
 */
public class ChamadoInexistenteException extends Exception {
    public ChamadoInexistenteException() {
        this("Chamado não encontrado");
    }
    public ChamadoInexistenteException (String message) {
        super(message);
    }
}
