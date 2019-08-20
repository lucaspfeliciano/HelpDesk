/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorChamado;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInvalidoException;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaInexistenteException;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastro.ButtonPanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author LucasViadinho
 */
public class TelaExcluirChamado extends JFrame {

    private JLabel titulo;
    private JTextField campoTitulo;
    private JButton botaoExcluir;
    private JButton botaoCancelar;
    
    public TelaExcluirChamado() {
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
            Border border = BorderFactory.createTitledBorder("Excluir Chamado");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            
            setLayout(new GridLayout(2,2));
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
            titulo = new JLabel("Titulo: ");
            c.gridx = 0;
            c.gridy = 0;
            add(titulo, c);
            
            campoTitulo = new JTextField("Titulo do chamado: ");
            c.gridx = 1;
            c.gridy = 0;
            
            add(campoTitulo, c);
            
            
            botaoExcluir = new JButton("Excluir");
            botaoExcluir.addActionListener(gerenciadorBotoes);
            c.gridx = 0;
            c.gridy = 1;
            add(botaoExcluir, c);
            
            botaoCancelar = new JButton("Cancelar");
            botaoCancelar.addActionListener(gerenciadorBotoes);
            c.gridx = 1;
            c.gridy = 1;
            add(botaoCancelar, c);
            
            
            setSize(700, 250);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
     
     private void fecha(){
         setVisible(false);
     }
       private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(botaoExcluir)) {
                getContentPane().removeAll();
                fecha();
            try{
                getContentPane().removeAll();
                ControladorChamado.getInstancia().excluirChamado(campoTitulo.getText());
                JOptionPane.showMessageDialog(null, "Chamado excluido com sucesso!");
                ControladorChamado.getInstancia().mostraMenuChamado();
            
        }   catch (ChamadoInvalidoException ex) {
            getContentPane().removeAll();
            JOptionPane.showMessageDialog(null, "Chamado Inexis7en7e");
            ControladorChamado.getInstancia().mostraMenuChamado();
        }
            }  else if (e.getSource().equals(botaoCancelar)) {
                getContentPane().removeAll();
                fecha();
                ControladorChamado.getInstancia().mostraMenuChamado();
            
            }
        
        }
       }
}