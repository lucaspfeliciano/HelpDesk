/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorChamado;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.control.ControladorPrincipal;
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
 * @author LucasViadinho
 */
public class TelaChamadoG extends JFrame {
    private JButton botaoRegistrar;
    private JButton botaoExcluir;
    private JButton botaoListar;
    private JButton botaoListarEncerrados;
    private JButton botaoAlterarStatus;
    private JButton botaoCadastrarAcompanhamento;
    private JButton botaoListarAcompanhamento;
    private JButton botaoVoltar;
    
    
    
            
    public TelaChamadoG() {
        super("Sistema de Chamados");
    }

    public void mostraMenuChamado() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,5));
        TelaChamadoG.GerenciadorBotoes gerenciadorBotoes = new TelaChamadoG.GerenciadorBotoes();
        GridBagConstraints c = new GridBagConstraints();

        botaoRegistrar = new JButton("Registrar Chamado");
        botaoRegistrar.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 0;
        container.add(botaoRegistrar, c);

        botaoExcluir = new JButton("Excluir Chamado");
        botaoExcluir.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 0;
        container.add(botaoExcluir, c);

        botaoListar = new JButton("Listar Chamados");
        botaoListar.addActionListener(gerenciadorBotoes);
        c.gridx = 2;
        c.gridy = 0;
        container.add(botaoListar, c);
        
        botaoListarEncerrados = new JButton("Listar Chamados Encerrados");
        botaoListarEncerrados.addActionListener(gerenciadorBotoes);
        c.gridx = 3;
        c.gridy = 0;
        container.add(botaoListarEncerrados, c);
        
        botaoAlterarStatus = new JButton("Alterar Status de Chamado");
        botaoAlterarStatus.addActionListener(gerenciadorBotoes);
        c.gridx = 0;
        c.gridy = 1;
        container.add(botaoAlterarStatus, c);
        
        botaoCadastrarAcompanhamento = new JButton("Cadastrar Acompanhamento");
        botaoCadastrarAcompanhamento.addActionListener(gerenciadorBotoes);
        c.gridx = 1;
        c.gridy = 1;
        container.add(botaoCadastrarAcompanhamento, c);
        
        botaoListarAcompanhamento = new JButton("Listar Acompanhamentos");
        botaoListarAcompanhamento.addActionListener(gerenciadorBotoes);
        c.gridx = 2;
        c.gridy = 1;
        container.add(botaoListarAcompanhamento, c);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(gerenciadorBotoes);
        c.gridx = 3;
        c.gridy = 1;
        container.add(botaoVoltar, c);

        setSize(700, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(botaoRegistrar)) {
                getContentPane().removeAll();
                fechar();
                ControladorChamado.getInstancia().mostraTelaEscolheProblema();
            } else if(e.getSource().equals(botaoExcluir)) {
                getContentPane().removeAll();
                fechar();
                ControladorChamado.getInstancia().mostrarTelaExclusaoChamado();
            } else if(e.getSource().equals(botaoListar)) {
                getContentPane().removeAll();
                fechar();
               ControladorChamado.getInstancia().mostrarTelaListarChamados();
            } else if(e.getSource().equals(botaoListarEncerrados)) {
                getContentPane().removeAll();
                fechar();
               ControladorChamado.getInstancia().mostrarTelaListarChamadosEncerrados();
            } else if(e.getSource().equals(botaoAlterarStatus)) {
                getContentPane().removeAll();
                fechar();
               ControladorChamado.getInstancia().mostrarTelaSetStatusChamado();
            } else if(e.getSource().equals(botaoCadastrarAcompanhamento)) {
                getContentPane().removeAll();
                fechar();
               ControladorChamado.getInstancia().mostrarTelaRegistroAcompanhamento();
            } else if(e.getSource().equals(botaoListarAcompanhamento)) {
                getContentPane().removeAll();
                fechar();
               ControladorChamado.getInstancia().mostrarTelaListarRegistroAcompanhamento();
            } else if(e.getSource().equals(botaoVoltar)) {
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
