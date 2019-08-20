/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.control.ControladorChamado;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInvalidoException;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaJaCadastradaException;
import br.ufsc.ine5605.trabalhodso.model.Prioridade;
import br.ufsc.ine5605.trabalhodso.model.Problema;
import br.ufsc.ine5605.trabalhodso.model.ProblemaBancoDeDados;
import br.ufsc.ine5605.trabalhodso.model.ProblemaComunicacaoDeRede;
import br.ufsc.ine5605.trabalhodso.model.ProblemaDesempenho;
import br.ufsc.ine5605.trabalhodso.model.SistemaOperacional;
import br.ufsc.ine5605.trabalhodso.model.Status;
import br.ufsc.ine5605.trabalhodso.model.Tecnico;
import br.ufsc.ine5605.trabalhodso.model.TipoDeProblema;
import br.ufsc.ine5605.trabalhodso.model.Usuario;
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
public class TelaCadastroChamadoComunicacao extends JFrame {
    
    private JLabel titulo;
    private JLabel data;
    private JLabel descricao;
    private JLabel cpfUsu;
    private JLabel cpfTec;
    private JLabel prioridade;
    private JLabel endereco;
    private JLabel status;
    private JLabel sistemaOp;
    private JLabel conexao;
    private JComboBox escolhePrioridade;
    private JComboBox escolheProblema;
    private JComboBox escolheSistema;
    private JTextField campoTitulo;
    private JTextField campoConexao;
    private JTextField campoCpfTec;
    private JTextField campoCpfUsu;
    private JTextField campoData;
    private JTextField campoDescricao;
    private JTextField campoEndereco;
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private Prioridade priori;
    private String[] prioridades = {"Muito baixa", "Baixa", "Normal", "Alta", "Muito Alta"};
    private String[] sistema = {"Windows", "Linux"};
     
      public TelaCadastroChamadoComunicacao() {
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
            dim.width = 700;
            dim.height = 200;
            setPreferredSize(dim);
            setPreferredSize(new Dimension(770,300));
            
            // configura bordas
            Border border = BorderFactory.createTitledBorder("Preencha os dados do chamado");
            this.setBorder(border);
            
            this.setupComponents();
        }

        private void setupComponents() {
            
            setLayout(new GridLayout(12,2));
            
            GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
            GridBagConstraints c = new GridBagConstraints();
            
            titulo = new JLabel("Titulo: ");
            c.gridx = 0;
            c.gridy = 1;
            add(titulo, c);
            
            campoTitulo = new JTextField("Titulo do chamado");
            c.gridx = 1;
            c.gridy = 1;
            
            add(campoTitulo, c);
            
            data = new JLabel("Data de hoje: ");
            c.gridx = 0;
            c.gridy = 2;
            add(data, c);
            
            campoData = new JTextField("dd/mm/aaaa");
            c.gridx = 1;
            c.gridy = 2;
            add(campoData, c);
            
            endereco = new JLabel("Endereco do Servidor: ");
            c.gridx = 0;
            c.gridy = 3;
            add(endereco, c);
            
            campoEndereco = new JTextField("Endereco");
            c.gridx = 1;
            c.gridy = 3;
            add(campoEndereco, c);
            
            conexao = new JLabel("Tipo de Conexao: ");
            c.gridx = 0;
            c.gridy = 4;
            add(conexao, c);
            
            campoConexao = new JTextField("Conexao");
            c.gridx = 1;
            c.gridy = 4;
            add(campoConexao, c);
            
            descricao = new JLabel("Descricao: ");
            c.gridx = 0;
            c.gridy = 6;
            add(descricao, c);
            
            campoDescricao = new JTextField("Descricao do Problema");
            c.gridx = 1;
            c.gridy = 6;
            add(campoDescricao, c);
            
            status = new JLabel("Sistema Operacional");
            c.gridx = 0;
            c.gridy = 5;
            add(status, c);
            
            escolheSistema = new JComboBox(sistema);
            c.gridx = 1;
            c.gridy = 5;
            add(escolheSistema, c);
            
            cpfTec = new JLabel("CPF do Tecnico: ");
            c.gridx = 0;
            c.gridy = 7;
            add(cpfTec, c);
            
            campoCpfTec = new JTextField("CPF Tecnico");
            c.gridx = 1;
            c.gridy = 7;
            add(campoCpfTec, c);
            
            cpfUsu = new JLabel("CPF do Usuario: ");
            c.gridx = 0;
            c.gridy = 8;
            add(cpfUsu, c);
            
            campoCpfUsu = new JTextField("CPF Usuario");
            c.gridx = 1;
            c.gridy = 8;
            add(campoCpfUsu, c);
            
            prioridade = new JLabel("Prioridade");
            c.gridx = 0;
            c.gridy = 9;
            add(prioridade, c);
            
            escolhePrioridade = new JComboBox(prioridades);
            c.gridx = 1;
            c.gridy = 9;
            add(escolhePrioridade, c);
            
            botaoCadastrar = new JButton("Cadastrar");
            botaoCadastrar.addActionListener(gerenciadorBotoes);
            c.gridx = 0;
            c.gridy = 10;
            add(botaoCadastrar, c);
            
            botaoCancelar = new JButton("Cancelar");
            botaoCancelar.addActionListener(gerenciadorBotoes);
            c.gridx = 0;
            c.gridy = 11;
            add(botaoCancelar, c);
            
            setSize(800, 300);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
       private class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            ConteudoTelaChamado conteudoTela = new ConteudoTelaChamado();
            
            conteudoTela.date = campoData.getText();
            
            conteudoTela.descricao = campoDescricao.getText();
            
            Long cpfTec = Long.parseLong(campoCpfTec.getText());
            Tecnico tecnico = ControladorPessoa.getInstancia().buscaTecnicoPeloCpf(cpfTec);
            conteudoTela.tecnico = tecnico;
            
            Long cpfUsu = Long.parseLong(campoCpfUsu.getText());
            Usuario usuario = ControladorPessoa.getInstancia().buscaUsuarioPeloCpf(cpfUsu);
            conteudoTela.usuario = usuario;
            
            SistemaOperacional sis = SistemaOperacional.WINDOWS; 
            if(escolheSistema.getSelectedIndex() == 0) {
                sis = SistemaOperacional.WINDOWS;
            } else if(escolheSistema.getSelectedIndex()== 1) {
                sis = SistemaOperacional.LINUX;
            }
            
            Prioridade prio = Prioridade.MUITOBAIXO;
            if(escolhePrioridade.getSelectedIndex() == 1) {
                prio = Prioridade.BAIXO;
            } else if (escolhePrioridade.getSelectedIndex() == 2) {
                prio = Prioridade.NORMAL;
            } else if (escolhePrioridade.getSelectedIndex() == 3) {
                prio = Prioridade.ALTO;
            } else if (escolhePrioridade.getSelectedIndex() == 4) {
                prio = Prioridade.MUITOALTO;
            }
            conteudoTela.prioridade = prio;
            
            conteudoTela.status = Status.INICIADO;
            
            Problema prob = new ProblemaComunicacaoDeRede(sis, TipoDeProblema.COMUNICACAODEREDE,campoEndereco.getText(), campoConexao.getText());
            conteudoTela.problema = prob;
            
            if(e.getSource().equals(botaoCadastrar)) {
                getContentPane().removeAll();
                fecha();
                try {
                    getContentPane().removeAll();
                    
                    ControladorChamado.getInstancia().incluirChamado(conteudoTela);
                     JOptionPane.showMessageDialog(null, "Chamado Cadastrado com Sucesso!");
                     ControladorChamado.getInstancia().mostraMenuChamado();
                } catch (java.lang.NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite somente números no campo cpf e telefone");
                } catch (ChamadoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, "Digite somente números no campo cpf e telefone");
                } 
            } else if (e.getSource().equals(botaoCancelar)) {
                getContentPane().removeAll();
                fecha();
                ControladorChamado.getInstancia().mostraMenuChamado();
            
            }
            
       }        
   
    }     
       private void fecha() {
           setVisible(false);
    }
}

       
