/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author 11193319943
 */
public class TelaPessoaGrafica extends JFrame {
    
    private JLabel texto;
    private JButton botaoTecnico;
    private JButton botaoUsuario;
    private JButton botaoVoltar;
    
    
    public TelaPessoaGrafica(){
        super("Sistema de Chamados");
    }

    public void mostraMenuPessoa() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        ButtonPanel buttonPanel = new ButtonPanel();
        
        // configura main frame
        setSize(500, 110);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel);
        
    }

    private class GerenciadorBotoes implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoTecnico)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostrarTelaCadastroTecnico();
            } else if(e.getSource().equals(botaoUsuario)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostrarTelaCadastroUsuario();
            } else if(e.getSource().equals(botaoVoltar)) {
                getContentPane().removeAll();
                fechar();
                ControladorPessoa.getInstancia().mostraMenuPrincipal();
            }
        }

        private void fechar() {
            setVisible(false);
        }
    }
    
    public class ButtonPanel extends JPanel {
        
        public ButtonPanel() {
            Dimension dim = getPreferredSize();
            dim.width = 400;
            dim.height = 70;
            setPreferredSize(dim);
            
            // configura bordas
            Border border = BorderFactory.createTitledBorder("Selecione a pessoa que voce deseja alterar");
            this.setBorder(border);
            
            this.setupComponents();
        }
        
        private void setupComponents() {
        
            setLayout(new GridBagLayout());
            
        TelaPessoaGrafica.GerenciadorBotoes gerenciadorBotoes = new TelaPessoaGrafica.GerenciadorBotoes();
        GridBagConstraints c = new GridBagConstraints();
        
        botaoTecnico = new JButton("Técnico");
        botaoTecnico.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(botaoTecnico, c);
        
        botaoUsuario = new JButton("Usuário");
        botaoUsuario.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 0 ;
        c.anchor = GridBagConstraints.LINE_END;
        add(botaoUsuario, c);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(gerenciadorBotoes);
        c.gridx = 2;
        c.gridy = 0;
        add(botaoVoltar, c);
        
        setSize(500, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        }
        
    }
    
}
