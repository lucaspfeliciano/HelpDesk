/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.control;

import br.ufsc.ine5605.trabalhodso.exceptions.EmpresaJahCadastradaException;
import java.util.ArrayList;
import br.ufsc.ine5605.trabalhodso.exceptions.EmpresaClienteInexistenteException;
import br.ufsc.ine5605.trabalhodso.mapeadores.MapeadorEmpresaCliente;
import br.ufsc.ine5605.trabalhodso.model.EmpresaCliente;
import br.ufsc.ine5605.trabalhodso.view.ConteudoTelaEmpresaCliente;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroEmpresa;
import br.ufsc.ine5605.trabalhodso.view.TelaEmpresaCliente;
import br.ufsc.ine5605.trabalhodso.view.TelaEmpresaClienteGrafica;
import br.ufsc.ine5605.trabalhodso.view.TelaExclusaoEmpresa;
import br.ufsc.ine5605.trabalhodso.view.TelaListagemEmpresa;

/**
 *
 * @author 11193319943
 */
public class ControladorEmpresaCliente {

    
    private TelaEmpresaCliente telaEmpresaCliente;
    private TelaEmpresaClienteGrafica telaEmpresaClienteGrafica;
    private TelaCadastroEmpresa telaCadastroEmpresa;
    private TelaExclusaoEmpresa telaExclusaoEmpresa;
    private TelaListagemEmpresa telaListagemEmpresa;
    private static ControladorEmpresaCliente instancia;
    private MapeadorEmpresaCliente mapeadorEmpresaClientes;

    private ControladorEmpresaCliente() {
        
        mapeadorEmpresaClientes = new MapeadorEmpresaCliente();
        this.telaEmpresaCliente = new TelaEmpresaCliente(this);
        this.telaEmpresaClienteGrafica = new TelaEmpresaClienteGrafica();
        this.telaCadastroEmpresa = new TelaCadastroEmpresa();
        this.telaExclusaoEmpresa = new TelaExclusaoEmpresa();
        this.telaListagemEmpresa = new TelaListagemEmpresa();
       

    }
    
    public static ControladorEmpresaCliente getInstancia(){
        if (instancia == null){
            instancia = new ControladorEmpresaCliente();
        }
        return instancia;
    }

    public void mostraMenuEmpresaCliente() {
        telaEmpresaClienteGrafica.mostraMenuEmpresaCliente();
    }
    
    public void mostrarTelaCadastroEmpresa() {
        telaCadastroEmpresa.mostraTela();
    }
    
    public void mostrarTelaExclusaoEmpresa() {
        telaExclusaoEmpresa.mostraTela();
    }
    
    public void mostrarTelaListagemEmpresa() {
        telaListagemEmpresa.mostrarTela();
    }

    public void cadastrarEmpresaCliente(ConteudoTelaEmpresaCliente conteudoTelaEmpresaCliente) throws EmpresaJahCadastradaException {
        for (EmpresaCliente empresaCliente : mapeadorEmpresaClientes.getList()) {
            if (empresaCliente.getNumContrato() == conteudoTelaEmpresaCliente.numContrato || empresaCliente.getNome().equals(conteudoTelaEmpresaCliente.nome)) {
                throw new EmpresaJahCadastradaException();
            }
        }
        EmpresaCliente empresaCliente = desempacota(conteudoTelaEmpresaCliente);
        mapeadorEmpresaClientes.put(empresaCliente); 
    }

    public void excluirEmpresaCliente(long numContrato) throws EmpresaClienteInexistenteException {
        EmpresaCliente empresaCliente = buscaEmpresaClientePeloNumContrato(numContrato);
        if (empresaCliente == null) {
            throw new EmpresaClienteInexistenteException();
        }
        mapeadorEmpresaClientes.remove(empresaCliente);
    }

    public void listarEmpresasCliente() {
        ArrayList<ConteudoTelaEmpresaCliente> listagemEmpresasCliente = new ArrayList<>();

        for (EmpresaCliente empresaCliente : mapeadorEmpresaClientes.getList()) {
            listagemEmpresasCliente.add(empacota(empresaCliente));
        }

        telaEmpresaCliente.mostraListaEmpresasCliente(listagemEmpresasCliente);

    }

    private EmpresaCliente desempacota(ConteudoTelaEmpresaCliente conteudoTelaEmpresaCliente) {
        return new EmpresaCliente(conteudoTelaEmpresaCliente.numContrato, conteudoTelaEmpresaCliente.nome);
    }

    private ConteudoTelaEmpresaCliente empacota(EmpresaCliente empresaCliente) {
        return new ConteudoTelaEmpresaCliente(empresaCliente.getNome(), empresaCliente.getNumContrato());
    }

    private EmpresaCliente buscaEmpresaClientePeloNumContrato(long numContrato) {
        for (EmpresaCliente empresaCliente : mapeadorEmpresaClientes.getList()) {
            if (empresaCliente.getNumContrato() == numContrato) {
                return empresaCliente;
            }
        }
        return null;
    }

}
