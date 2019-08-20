/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorEmpresaCliente;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.control.ControladorPrincipal;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author 11193319943
 */
public class TelaEmpresaClienteGrafica extends JFrame {
    
    private JButton botaoRegistrar;
    private JButton botaoExcluir;
    private JButton botaoListar;
    private JButton botaoVoltar;
    
    public TelaEmpresaClienteGrafica(){
        super("Sistema de Chamados");
    }

    public void mostraMenuEmpresaCliente() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
        GridBagConstraints c = new GridBagConstraints();
        
        botaoRegistrar = new JButton("Registrar Empresa"); 
        botaoRegistrar.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 0;
        container.add(botaoRegistrar, c);
        
        botaoExcluir = new JButton("Excluir Empresa");
        botaoExcluir.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 0;
        container.add(botaoExcluir, c);
                
        botaoListar = new JButton("Listar Empresas");
        botaoListar.addActionListener(gerenciadorBotoes);
        c.gridx = 2;
        c.gridy = 0;
        container.add(botaoListar, c);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(gerenciadorBotoes);
        c.gridx = 3;
        c.gridy = 0;
        container.add(botaoVoltar, c);
        
        setSize(600,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
      private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoRegistrar)) {
                fechar();
                ControladorEmpresaCliente.getInstancia().mostrarTelaCadastroEmpresa();
               
            }else if (e.getSource().equals(botaoExcluir)) {
                getContentPane().removeAll();
                fechar();
                ControladorEmpresaCliente.getInstancia().mostrarTelaExclusaoEmpresa();
            }else if (e.getSource().equals(botaoListar)) {
                getContentPane().removeAll();
                fechar();
                ControladorEmpresaCliente.getInstancia().mostrarTelaListagemEmpresa();
            } else if (e.getSource().equals(botaoVoltar)) {
                getContentPane().removeAll();
                fechar();
                ControladorPrincipal.getInstancia().iniciaSistema();
                
            }
            
        }

        private void fechar() {
            setVisible(false);
        }
    
    }
}
