/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorChamado;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 11193319943
 */
public class TelaEscolheProblema extends JFrame {
    
    private JButton botaoBanco;
    private JButton botaoComunicacao;
    private JButton botaoDesempenho;
    private JButton botaoVoltar;
    
    public TelaEscolheProblema(){
        super("Sistema de Chamados");
    }

    public void mostrarTela() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,2));
        GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
        GridBagConstraints c = new GridBagConstraints();
        
        botaoDesempenho = new JButton("Problema de Desemepenho"); 
        botaoDesempenho.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 0;
        container.add(botaoDesempenho, c);
        
        botaoComunicacao = new JButton("Problema de Comunicacao de Rede");
        botaoComunicacao.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 0;
        container.add(botaoComunicacao, c);
                
        botaoBanco = new JButton("Problema de Banco de Dados");
        botaoBanco.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 1;
        container.add(botaoBanco, c);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 1;
        container.add(botaoVoltar, c);
        
        setSize(600,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
        
        
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoBanco)) {
                fechar();
                ControladorChamado.getInstancia().mostrarTelaCadastroChamado();
                
            }else if (e.getSource().equals(botaoDesempenho)) {
                fechar();
                ControladorChamado.getInstancia().mostrarTelaCadastroChamadoDesempenho();
            } else if(e.getSource().equals(botaoComunicacao)) {
                getContentPane().removeAll();
                fechar();
                ControladorChamado.getInstancia().mostrarTelaCadastroChamadoComunicacao();
            } else if (e.getSource().equals(botaoVoltar)) {
                getContentPane().removeAll();
                fechar();
                ControladorChamado.getInstancia().mostraMenuChamado();
            }
            
        }

        private void fechar() {
            setVisible(false);
        }
    }
    
}
