/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaJaCadastradaException;
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
public class TelaCadastro extends JFrame {

    private JButton botaoCadastrar;
    private JLabel nome;
    private JLabel cpf;
    private JLabel telefone;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoTelefone;
    private JButton botaoCancelar;
    
    public TelaCadastro() {
        super("Sistema de Chamados");
    }

    public void mostrarTela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        ButtonPanel buttonPanel = new ButtonPanel();

        // configura main frame
        setSize(450, 340);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel);

    }

    

    private void fecha() {
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
            Border border = BorderFactory.createTitledBorder("Digite os dados referente ao técnico que deve ser adicionado");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            
            setLayout(new GridLayout(4,2));
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
            nome = new JLabel("Nome: ");
            c.gridx = 0;
            c.gridy = 0;
            add(nome, c);
            
            campoNome = new JTextField("Nome do Técnico");
            c.gridx = 1;
            c.gridy = 0;
            
            add(campoNome, c);
            
            cpf = new JLabel("CPF: ");
            c.gridx = 0;
            c.gridy = 1;
            add(cpf, c);
            
            campoCpf = new JTextField("CPF do Técnino");
            c.gridx = 1;
            c.gridy = 1;
            add(campoCpf, c);
            
            telefone = new JLabel("Telefone: ");
            c.gridx = 0;
            c.gridy = 2;
            add(telefone, c);
            
            campoTelefone = new JTextField("Telefone do Técnico");
            c.gridx = 1;
            c.gridy = 2;
            add(campoTelefone, c);
            
            botaoCadastrar = new JButton("Cadastrar");
            botaoCadastrar.addActionListener(gerenciadorBotoes);
            c.gridx = 0;
            c.gridy = 3;
            add(botaoCadastrar, c);
            
            botaoCancelar = new JButton("Cancelar");
            botaoCancelar.addActionListener(gerenciadorBotoes);
            c.gridx = 1;
            c.gridy = 3;
            add(botaoCancelar, c);
            
            setSize(500, 150);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ConteudoTelaTecnico conteudoTela = new ConteudoTelaTecnico();
            conteudoTela.nome = campoNome.getText();
            conteudoTela.cpf = Long.parseLong(campoCpf.getText());
            conteudoTela.telefone = Long.parseLong(campoTelefone.getText());
            
            if(e.getSource().equals(botaoCadastrar)) {
                getContentPane().removeAll();
                fecha();
                try {
                    getContentPane().removeAll();
                    ControladorPessoa.getInstancia().incluirTecnico(conteudoTela);
                     JOptionPane.showMessageDialog(null, "Técnico Cadastrado com sucesso!");
                     ControladorPessoa.getInstancia().mostrarTelaCadastroTecnico();
                } catch (PessoaJaCadastradaException ex) {
                    getContentPane().removeAll();
                    JOptionPane.showMessageDialog(null, "Técnico já cadastrado!");
                    ControladorPessoa.getInstancia().mostrarTelaCadastroTecnico();
                } catch (java.lang.NumberFormatException ex) {
                    
                    JOptionPane.showMessageDialog(null, "Digite somente números no campo cpf e telefone");
                } 
            } else if (e.getSource().equals(botaoCancelar)) {
                getContentPane().removeAll();
                fecha();
                ControladorPessoa.getInstancia().mostraMenuPessoa();
            
            }
        }
    }
              
}
