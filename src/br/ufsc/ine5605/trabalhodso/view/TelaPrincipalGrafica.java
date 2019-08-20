/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorPrincipal;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Muraro
 */
public class TelaPrincipalGrafica extends JFrame {

    private JLabel lbTexto;
    private JButton btRegistroChamados;
    private JButton btRegistroPessoas;
    private JButton btRegistroEmpresasCliente;
    
    public TelaPrincipalGrafica(){
        super("Sistema de Chamados");
    }

    public void mostraTelaPrincipal() {
        getContentPane().removeAll();
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        ButtonPanel buttonPanel = new ButtonPanel();
        
        //configura main grame
       
        setSize(600, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel);

    }

    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(btRegistroChamados)) {
                fechar();
                ControladorPrincipal.getInstancia().abrirRegistroChamados();
            } else if(e.getSource().equals(btRegistroPessoas)) {
                fechar();
                ControladorPrincipal.getInstancia().abrirRegistroPessoas();
            } else if(e.getSource().equals(btRegistroEmpresasCliente)){
                fechar();
                ControladorPrincipal.getInstancia().abrirRegistroEmpresasCliente();
            }
        }

        private void fechar() {
            setVisible(false);
        }
        private void mostrar(){
            setVisible(true);
        }

    }
    
    public class ButtonPanel extends JPanel {
        public ButtonPanel() {
            Dimension dim = getPreferredSize();
            dim.width = 550;
            dim.height = 150;
            setPreferredSize(dim);
            
            //configura bordas
            Border border = BorderFactory.createTitledBorder("O que você deseja fazer?");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            
            setLayout(new GridBagLayout());
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
        btRegistroChamados = new JButton("Registro de Chamados");
        btRegistroChamados.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1.0;
        
        add(btRegistroChamados, c);

        btRegistroPessoas = new JButton("Registro de Pessoas");
        btRegistroPessoas.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 1;
        add(btRegistroPessoas, c);

        btRegistroEmpresasCliente = new JButton("Registro de Empresas Cliente");
        btRegistroEmpresasCliente.addActionListener(gerenciadorBotoes);
        c.gridx = 2;
        c.gridy = 1;

        add(btRegistroEmpresasCliente, c);

        setSize(600, 150);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
            

}
