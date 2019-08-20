/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.control;

import br.ufsc.ine5605.trabalhodso.view.TelaPrincipal;
import br.ufsc.ine5605.trabalhodso.view.TelaPrincipalGrafica;

/**
 *
 * @author 11193319943
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instancia;

    private TelaPrincipal telaPrincipal;
    private TelaPrincipalGrafica telaPrincipalGrafica;


    private ControladorPrincipal() {
        this.telaPrincipal = new TelaPrincipal();
        this.telaPrincipalGrafica = new TelaPrincipalGrafica();
    }
    
    public static ControladorPrincipal getInstancia(){
        if (instancia == null){
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }

    public void iniciaSistema() {
        
        telaPrincipalGrafica.mostraTelaPrincipal();
    }
    public void abrirRegistroChamados() {
        ControladorChamado.getInstancia().mostraMenuChamado();
    }
    public void abrirRegistroPessoas() {
        ControladorPessoa.getInstancia().mostraMenuPessoa();
    }

    public void abrirRegistroEmpresasCliente() {
        ControladorEmpresaCliente.getInstancia().mostraMenuEmpresaCliente();
    }

    
    

    public ControladorChamado getControladorChamado() {
        return ControladorChamado.getInstancia();
    }

    public ControladorPessoa getControladorPessoa() {
        return ControladorPessoa.getInstancia();
    }
    
    public ControladorEmpresaCliente getControladorEmpresaCliente(){
        return ControladorEmpresaCliente.getInstancia();
    }

    public void executaOpcaoMenuPrincipal(int opcao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
