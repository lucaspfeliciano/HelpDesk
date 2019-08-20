/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaInexistenteException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author 11193319943
 */
public class TelaExclusaoTec extends JFrame {
    
    private JButton botaoExclusao;
    private JLabel cpf;
    private JTextField campoCpf;
    
    public TelaExclusaoTec(){
        super("Sistema de Chamados");
    }
    
    public void mostrarTela(){
       
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        ButtonPanel buttonPanel = new ButtonPanel();
        
        // configura main frame
        setSize(450, 340);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel);
        
    }
     private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fecha();
            try{
            ControladorPessoa.getInstancia().excluirTecnico(Long.parseLong(campoCpf.getText()));
            JOptionPane.showMessageDialog(null, "Técnico excluido com sucesso!");
        } catch (PessoaInexistenteException ex) {
                JOptionPane.showMessageDialog(null, "Tecnico inexistente");
        }
        }
    }
     
     private void fecha(){
         setVisible(false);
     }
     
     public class ButtonPanel extends JPanel {
       
         public ButtonPanel() {
            Dimension dim = getPreferredSize();
            dim.width = 400;
            dim.height = 70;
            setPreferredSize(dim);
            setPreferredSize(new Dimension(400,190));
            
            // configura bordas
            Border border = BorderFactory.createTitledBorder("Digite o CPF referente ao técnico que deve ser excluido");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            setLayout(new GridBagLayout());
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
            cpf = new JLabel("CPF: ");
            c.gridx = 0;
            c.gridy = 0;
            add(cpf, c);
            
            campoCpf = new JTextField("CPF do Técnico");
            c.gridx = 1;
            c.gridy = 0;
            add(campoCpf, c);
            
            botaoExclusao = new JButton("Excluir");
            botaoExclusao.addActionListener(gerenciadorBotoes);
            c.gridx = 2;
            c.gridy = 0;
            add(botaoExclusao, c);
            
            setSize(500,150);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            
            
            
        }
    
    }
}

