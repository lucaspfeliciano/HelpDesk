/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author 11193319943
 */
public class TelaCadastroUsuario extends JFrame {

    private JButton botaoRegistrar;
    private JButton botaoExcluir;
    private JButton botaoListar;
    private JButton botaoVoltar;

    public TelaCadastroUsuario() {
        super("Sistema de Chamados");
    }

    public void mostraCadastroUsuario() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,2));
        TelaCadastroUsuario.GerenciadorBotoes gerenciadorBotoes = new TelaCadastroUsuario.GerenciadorBotoes();
        GridBagConstraints c = new GridBagConstraints();

        botaoRegistrar = new JButton("Registrar usuario");
        botaoRegistrar.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 0;
        container.add(botaoRegistrar, c);

        botaoExcluir = new JButton("Excluir Usuario");
        botaoExcluir.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 0;
        container.add(botaoExcluir, c);

        botaoListar = new JButton("Listar Usuarios");
        botaoListar.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 1;
        container.add(botaoListar, c);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 1;
        container.add(botaoVoltar, c);

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            if (e.getSource().equals(botaoRegistrar)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostrarTelaCadastroUsu();
            } else if(e.getSource().equals(botaoExcluir)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostrarTelaExclusaoUsu();
            } else if(e.getSource().equals(botaoListar)) {
               
            } else if(e.getSource().equals(botaoVoltar)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostraMenuPessoa();
            }
            }
        }

        private void fechar() {
            setVisible(false);
        }
    }

