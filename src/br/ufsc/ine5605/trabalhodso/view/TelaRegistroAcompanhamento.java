/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.view.TelaCadastro.ButtonPanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author LucasViadinho
 */
public class TelaRegistroAcompanhamento extends JFrame {

    private JLabel titulo;
    private JLabel data;
    private JLabel assunto;
    private JLabel tecnico;
    private JTextField campoTitulo;
    private JTextField campoAssunto;
    private JTextField campoData;
    private JTextField campoTecnico;
    private JButton botaoRegistrar;
    private JButton botaoCancelar;
    
    public TelaRegistroAcompanhamento() {
        super("Sistema de Chamados");
    }
    
    public void mostrarTela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        ButtonPanel buttonPanel = new ButtonPanel();

        // configura main frame
        setSize(600, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel);
    }
     public class ButtonPanel extends JPanel {
        public ButtonPanel() {
            Dimension dim = getPreferredSize();
            dim.width = 500;
            dim.height = 100;
            setPreferredSize(dim);
            setPreferredSize(new Dimension(400,190));
            
            // configura bordas
            Border border = BorderFactory.createTitledBorder("Registrar Acompanhamnto");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            
            setLayout(new GridLayout(5,2));
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
            titulo = new JLabel("Titulo: ");
            c.gridx = 0;
            c.gridy = 0;
            add(titulo, c);
            
            campoTitulo = new JTextField("Titulo do chamado");
            c.gridx = 1;
            c.gridy = 0;
            
            add(campoTitulo, c);
            
            data = new JLabel("Data: ");
            c.gridx = 0;
            c.gridy = 1;
            add(data, c);
            
            campoData = new JTextField("dd/mm/aaaa");
            c.gridx = 1;
            c.gridy = 1;
            
            add(campoData, c);
            
            assunto = new JLabel("Assunto: ");
            c.gridx = 0;
            c.gridy = 2;
            add(assunto, c);
            
            campoAssunto = new JTextField("Assunto");
            c.gridx = 1;
            c.gridy = 2;
            
            add(campoAssunto, c);
            
            tecnico = new JLabel("Nome do Tecnico: ");
            c.gridx = 0;
            c.gridy = 3;
            add(tecnico, c);
            
            campoTecnico = new JTextField("Nome do Tecnico");
            c.gridx = 1;
            c.gridy = 3;
            
            add(campoTecnico, c);
            
            botaoRegistrar = new JButton("Registrar");
            c.gridx = 0;
            c.gridy = 4;
            add(botaoRegistrar, c);
            
            botaoCancelar = new JButton("Cancelar");
            c.gridx = 1;
            c.gridy = 4;
            add(botaoCancelar, c);
            
            
            setSize(700, 250);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
       private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
       }
}
