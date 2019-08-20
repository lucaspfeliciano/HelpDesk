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
public class LimiteDeChamadosException extends Exception {
    public LimiteDeChamadosException() {
        this("Cliente atingiu o limite de 3 chamados abertos");
    }
    
    public LimiteDeChamadosException(String message) {
        super(message);
    }
    
}
