/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInvalidoException;
import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInexistenteException;
import br.ufsc.ine5605.trabalhodso.control.ControladorChamado;
import br.ufsc.ine5605.trabalhodso.model.Chamado;
import br.ufsc.ine5605.trabalhodso.model.Prioridade;
import br.ufsc.ine5605.trabalhodso.model.Problema;
import br.ufsc.ine5605.trabalhodso.model.ProblemaBancoDeDados;
import br.ufsc.ine5605.trabalhodso.model.ProblemaComunicacaoDeRede;
import br.ufsc.ine5605.trabalhodso.model.ProblemaDesempenho;
import br.ufsc.ine5605.trabalhodso.model.RegistroAcompanhamento;
import br.ufsc.ine5605.trabalhodso.model.SistemaOperacional;
import br.ufsc.ine5605.trabalhodso.model.Status;
import br.ufsc.ine5605.trabalhodso.model.TipoDeProblema;
import java.util.Scanner;
import java.util.ArrayList;

import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;
import br.ufsc.ine5605.trabalhodso.model.Tecnico;
import br.ufsc.ine5605.trabalhodso.model.Usuario;
import java.util.InputMismatchException;

/**
 *
 * @author 04431899944
 */
public class TelaChamado {

    private final Scanner teclado;
 
    public TelaChamado() {
        this.teclado = new Scanner(System.in);
    }

    public void mostraMenuChamado() {
        try {
        int opcao;

        do {
            System.out.println("___________________________________________");
            System.out.println("------------REGISTRO DE CHAMADO------------");
            System.out.println(" Escolha a opcao desejada ");
            System.out.println("[1] - Cadastrar Chamado");
            System.out.println("[2] - Alterar Status de Chamado");
            System.out.println("[3] - Pesquisar Chamados Antigos");
            System.out.println("[4] - Listar Chamados");
            System.out.println("[5] - Listar Chamados Encerrados");
            System.out.println("[6] - Cadastrar Registro de Acompanhamento");
            System.out.println("[7] - Listar Registro de Acompanhamento");
            System.out.println("[0] - Retornar Tela Princpal");
            opcao = teclado.nextInt();

            switch (opcao) {
                 case 1 : 
                    mostraTelaCadastroChamado();
                  break;
                case 2:
                    //mostraTelaSetStatusChamado();
                    break;
                case 3:
                    mostrarTelaPesquisarChamadosAntigos();
                    break;
                case 4:
                    ControladorChamado.getInstancia().listarChamados();
                    break;
                case 5:
                    ControladorChamado.getInstancia().listarChamadosEncerrados();
                    break;
                case 6: 
                    mostrarTelaRegistraAcompanhamento();
                case 7:
                    ControladorChamado.getInstancia().listarRegistroAcompanhamento();
                case 0:
                    break;
                default:
                        System.out.println("******************************************");
                        System.out.println("Este nao eh um numero valido, tente novamente!");
                        System.out.println("******************************************");
            
            }
        } while (opcao != 0);
    }
        catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("*********************************");
            System.out.println("Por favor, digite somente numeros!");
            System.out.println("*********************************");
        }
    }    

    public void imprimeChamado(ArrayList<ConteudoTelaChamado> listaChamados) {
            System.out.println("-----------------------CHAMADOS------------------------");
        for (ConteudoTelaChamado conteudo : listaChamados) {
            Chamado chamado = ControladorChamado.getInstancia().desempacota(conteudo);
            System.out.println("Titulo: " + chamado.getTitulo() + " - Data: " + chamado.getDate());
            System.out.println("Descricao: " + chamado.getDescricao());
            System.out.println("Prioridade: " + chamado.getPrioridade() + " - Tecnico: " + chamado.getTecnico().getNome());
            System.out.println("Problema: " + chamado.getProblema().getTipoDeProblema() + " - Status: " + chamado.getStatus());
            System.out.println("-------------------------------------------------------");
        }
    }

    public void mostraTelaCadastroChamado() {
        try {
        System.out.println("_____________________________________________");
        System.out.println("** CADASTRO DE CHAMADO**");
        
        System.out.print("Data(dd/mm/aaaa): ");
        String data = teclado.next();
        
        System.out.print("Titulo: ");
        teclado.nextLine();
        String titulo = teclado.nextLine();
        System.out.println("");
          
        System.out.println("Problema encontrado: *Escolha a opcao*");
        System.out.println("1 --> Problema de Banco de Dados");
        System.out.println("2 --> Problema de Comunicacao de Rede");
        System.out.println("3 --> Problema de Desempenho");
        int opcaoProblema = teclado.nextInt();
        Problema problema = ControladorChamado.getInstancia().cadastraProblema(opcaoProblema);
        
        System.out.print("Descricao: ");
        teclado.nextLine();
        String descricao = teclado.nextLine();
        System.out.println("");
        
        Prioridade prioridade = escolhePrioridade();
        
        Status status = Status.INICIADO;
        
        System.out.print("cpf do tecnico: ");
        
        long cpf1 = teclado.nextLong();
        Tecnico tecnico = ControladorPessoa.getInstancia().buscaTecnicoPeloCpf(cpf1);
        
        System.out.println("CPF do usuario: ");
        long cpf = teclado.nextLong();
        Usuario usuario = ControladorPessoa.getInstancia().buscaUsuarioPeloCpf(cpf);
        
        
        ConteudoTelaChamado conteudo = new ConteudoTelaChamado (data, titulo, descricao, tecnico, prioridade, problema, status, usuario);
        
        
            ControladorChamado.getInstancia().incluirChamado(conteudo);
            
        } 
        
        catch (InputMismatchException exx)   {
            teclado.nextLine();
            System.out.println("________________________________________");
            System.out.println("Selecione somente as opcoes disponiveis");
            System.out.println("________________________________________");
        }
        catch (ChamadoInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Prioridade escolhePrioridade() {
        System.out.println("Prioridade: ");
        System.out.println("1 -->  Muito baixa");
        System.out.println("2 --> Baixa");
        System.out.println("3 --> Normal");
        System.out.println("4 --> Alta");
        System.out.println("5 --> Muito alta");
        int opcaoPrioridade = teclado.nextInt();
        Prioridade prioridade = ControladorChamado.getInstancia().escolheOpcaoPrioridade(opcaoPrioridade);
        return prioridade;

    }

    public ProblemaBancoDeDados mostraTelaCadastroProblemaBancoDedados() {
        TipoDeProblema tipoDeProblema = TipoDeProblema.BANCODEDADOS;
        SistemaOperacional sistemaOperacional = escolheSistemaOperacional();
        System.out.print("Banco de Dados: ");
        String bancoDeDados = teclado.next();
        ProblemaBancoDeDados problema = new ProblemaBancoDeDados(sistemaOperacional, tipoDeProblema, bancoDeDados);
        return problema;
    }

    public ProblemaComunicacaoDeRede mostraTelaCadastroProblemaComunicacao() {
        TipoDeProblema tipoDeProblema = TipoDeProblema.COMUNICACAODEREDE;
        SistemaOperacional sistemaOperacional = escolheSistemaOperacional();
        System.out.print("Endereco do servidor: ");
        String endereco = teclado.next();
        System.out.print("Tipo de conexao: ");
        String conexao = teclado.next();
        ProblemaComunicacaoDeRede problema = new ProblemaComunicacaoDeRede(sistemaOperacional, tipoDeProblema, endereco, conexao);
        return problema;
    }

    public ProblemaDesempenho mostraTelaCadastroProblemaDesempenho() {
        try {
        TipoDeProblema tipoDeProblema = TipoDeProblema.DESEMPENHO;
        SistemaOperacional sistemaOperacional = escolheSistemaOperacional();
        System.out.print("Operacao: ");
        String operacao = teclado.nextLine();
        System.out.print("Duracao da Operacao (Em minutos): ");
        int duracao = teclado.nextInt();
        ProblemaDesempenho problema = new ProblemaDesempenho (sistemaOperacional, tipoDeProblema, duracao, operacao);
        return problema;
        }
        catch (InputMismatchException ex) {
            teclado.nextLine();
            System.out.println("______________________________________________");
            System.out.println("Na duracao da operacao, digite somente numeros");
            System.out.println("______________________________________________");
           mostraMenuChamado();
        }
        return null;
    }

    private SistemaOperacional escolheSistemaOperacional() {
        try {
            int opcao;
        
        do {
        System.out.println("Escolha seu sistema operacional:");
        System.out.println("1 --> Windows");
        System.out.println("2 --> Linux");
        opcao = teclado.nextInt();

       switch (opcao) {
                 case 1 : 
                    return SistemaOperacional.WINDOWS;
                    
                case 2:
                    return SistemaOperacional.LINUX;
                default : 
                    imprimeMensagemDeErro();
                       
                    
       }
       }
       while (opcao != 0);
       }
        catch (InputMismatchException ex) {
            System.out.println("_______________________________________");
            System.out.println("Escolha uma opcao valida!");
            System.out.println("_______________________________________");
    }
    return SistemaOperacional.NAODEFINIDO;
    }

    public Status escolherStatus() {
        try {
        System.out.println("____________________________________");
        System.out.println("** Selecione o status do chamado **");
        System.out.println("1 --> Iniciado");
        System.out.println("2 --> Em atendimento");
        System.out.println("3 --> Aguardando resposta");
        System.out.println("4 --> Encerrado");
        System.out.println("5 --> Sem solucao");
        int opcao = teclado.nextInt();
        
        return ControladorChamado.getInstancia().escolheOpcaoStatus(opcao);
        }
        catch (InputMismatchException ex) {
            System.out.println("_______________________________________");
            System.out.println("Escolha uma opcao valida!");
            System.out.println("_______________________________________");
        }
        return Status.INICIADO;
    }

//    private void mostraTelaSetStatusChamado() {
//        System.out.println("Titulo do Chamado a Ser Alterado: ");
//        teclado.nextLine();
//        String titulo = teclado.nextLine();
//        try {
//            ControladorChamado.getInstancia().setStatusChamado(titulo);
//        } catch (ChamadoInexistenteException ex) {
//            System.out.println(ex.getMessage());
//        } catch (NullPointerException ex) {
//            System.out.println("Chamado nao encontrado");
//        }
//
//    }

    private void mostrarTelaPesquisarChamadosAntigos() {
        try {
        System.out.println("**Problema:**");
        System.out.println("1 --> Problema de Banco de Dados");
        System.out.println("2 --> Problema de Comunicacao de Rede");
        System.out.println("3 --> Problema de Desempenho");
        int opcaoProblema = teclado.nextInt();
        ControladorChamado.getInstancia().pesquisaChamadoAntigos(opcaoProblema);
        }
        catch (InputMismatchException ex) {
            System.out.println("_______________________________________");
            System.out.println("Escolha uma opcao valida!");
            System.out.println("_______________________________________");
        }
    }


    private void mostrarTelaRegistraAcompanhamento() {
        try {
            System.out.println("______________________________________________");
            System.out.println("----------REGISTRO DE ACOMPANHAMENTO----------");
            System.out.print("Titulo do chamado: ");
            teclado.nextLine();
            String titulo = teclado.nextLine();
            System.out.print("Data: ");
            String data = teclado.nextLine();
            System.out.print("Assunto: ");
            String assunto = teclado.nextLine();
            System.out.println("Nome do Tecnico: ");
            String tecnico = teclado.nextLine();
            Chamado c = null;

            c = ControladorChamado.getInstancia().encontraChamadoPeloTitulo(titulo);
            RegistroAcompanhamento r = new RegistroAcompanhamento(data, assunto, tecnico);
            c.addRegistroAcompanhamento(r);
            
        } catch (ChamadoInexistenteException ex) {
            ex.getMessage();
        } catch (NullPointerException alo) {
            System.out.println("");
            System.out.println("CHAMADO INEXISTENTE");
        }
    }



    public void imprimeRegistroAcompanhamento(Chamado chamado) {
        for(RegistroAcompanhamento registro : chamado.getRegistroAcompanhamento()) {
            System.out.println("________________________________");
            System.out.println("---REGISTRO DE ACOMPANHAMENTO---");
            System.out.println("Titulo Chamado: " + chamado.getTitulo());
            System.out.println("Data: " + registro.getData());
            System.out.println("Assunto: " + registro.getAssusnto());
            System.out.println("Tecnico: " + registro.getTecnico());
        }
    }
    public void imprimeMensagemDeErro(){
        System.out.println("DIGITE SOMENTE OPCOES VALIDAS");
        
    }
    
}


