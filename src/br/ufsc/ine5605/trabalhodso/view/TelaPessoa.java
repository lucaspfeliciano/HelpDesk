/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufsc.ine5605.trabalhodso.exceptions.PessoaInexistenteException;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaJaCadastradaException;
import br.ufsc.ine5605.trabalhodso.control.ControladorPessoa;

import java.util.InputMismatchException;

public class TelaPessoa {

    private Scanner teclado;

    public TelaPessoa() {

        this.teclado = new Scanner(System.in);
    }

    public void mostraMenuPessoa() {
        try {
            int opcao;

            do {
                System.out.println("** Registro de Pessoas **");
                System.out.println("** Escolha a opcao que voce deseja alterar **");                        
                System.out.println("[1] - Tecnico");
                System.out.println("[2] - Usuario");
                System.out.println("[0] - Retornar Tela Principal ");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        mostrarTelaTecnico();
                        break;
                    case 2:
                        mostrarTelaUsuario();
                    case 0:
                        break;
                    default:
                        System.out.println("********************************************");
                        System.out.println("Este nao eh um numero valido, tente novamente!");
                        System.out.println("********************************************");
                        break;
                }
            } while (opcao != 0);
        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("Por favor, digite somente numeros!");
            System.out.println("***********************************");
        }
    }

    public void mostrarTelaTecnico() {
        try {
            int opcao;
            do {
                System.out.println("** Registro de Tecnicos **");
                System.out.println("** Escolha a opcao desejada**");
                System.out.println("[1] - Cadastrar Tecnico");
                System.out.println("[2] - Excluir Tecnico");
                System.out.println("[3] - Listar Tecnicos");
                System.out.println("[0] - Retornar Tela Registtro Pessoas");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        mostrarTelaCadastroTecnico();
                        break;
                    case 2:
                        mostraTelaExclusaoTecnico();
                        break;
                    case 3:
                        ControladorPessoa.getInstancia().listarTecnicos();
                    case 0:
                        break;
                    default:
                        System.out.println("********************************************");
                        System.out.println("Este nao eh um numero valido, tente novamente!");
                        System.out.println("********************************************");
                }

            } while (opcao != 0);

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("Por favor, digite somente numeros!");
            System.out.println("***********************************");
        }
    }

    public void mostrarTelaUsuario() {
        try {
            int opcao;
            do {
                System.out.println("** Registro de Usuarios **");
                System.out.println("** Escolha a opcao desejada**");
                System.out.println("[1] - Cadastrar Usuario");
                System.out.println("[2] - Excluir Usuario");
                System.out.println("[3] - Listar Usuario");
                System.out.println("[0] - Retornar Tela Registro Pessoas");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        mostrarTelaCadastroUsuario();
                        break;
                    case 2:
                        mostrarTelaExclusaoUsuario();
                        break;
                    case 3:
                        ControladorPessoa.getInstancia().listarUsuarios();
                    case 0:
                        break;
                    default:
                        System.out.println("********************************************");
                        System.out.println("Este nao eh um numero valido, tente novamente!");
                        System.out.println("********************************************");
                }

            } while (opcao != 0);
        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("Por favor, digite somente numeros!");
            System.out.println("***********************************");
        }
    }

    public void mostrarTelaCadastroTecnico() {
        try {
            System.out.println("** Novo Tecnico **");

            System.out.println("** Nome ** ");
            teclado.nextLine();
            String nome = teclado.nextLine();

            System.out.println("** CPF ** ");
            long cpf = teclado.nextLong();

            System.out.println("** Telefone ** ");
            long telefone = teclado.nextLong();

            ConteudoTelaTecnico conteudoTelaTecnico = new ConteudoTelaTecnico(nome, cpf, telefone);

            ControladorPessoa.getInstancia().incluirTecnico(conteudoTelaTecnico);
            System.out.println("********** Tecnico cadastrado com sucesso! ************");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("No campo CPF e Telefone soh eh permitida a entrada de numeros! Tente novamente!");
            System.out.println("***********************************");
        } catch (PessoaJaCadastradaException ex) {
            System.out.println(ex.getMessage());

        }
    }

    private void mostrarTelaCadastroUsuario() {

        try {
            ConteudoTelaUsuario conteudoTelaUsuario = new ConteudoTelaUsuario();

            System.out.println("** Novo Usuario **");

            System.out.println("** Nome ** ");
            teclado.nextLine();
            conteudoTelaUsuario.nome = teclado.nextLine();

            System.out.println("** CPF ** ");
            conteudoTelaUsuario.cpf = teclado.nextLong();

            System.out.println("** Telefone ** ");
            conteudoTelaUsuario.telefone = teclado.nextLong();

            System.out.println("** Numero do Contrato");
            conteudoTelaUsuario.numContrato = teclado.nextLong();

            ControladorPessoa.getInstancia().incluirUsuario(conteudoTelaUsuario);

            System.out.println("********** Usuario cadastrado com sucesso! ************");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("No campo CPF, Telefone e NumContrato soh eh permitida a entrada de numeros! Tente novamente!");
            System.out.println("***********************************");
        } catch (PessoaJaCadastradaException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void mostraTelaExclusaoTecnico() {
        try {

            ConteudoTelaTecnico conteudoTelaTecnico = new ConteudoTelaTecnico();

            System.out.println("** Exclusao de Tecnico **");
            System.out.println("Digite o CPF do tecnico que voce deseja excluir");

            System.out.println("CPF: ");
            conteudoTelaTecnico.cpf = teclado.nextLong();

            ControladorPessoa.getInstancia().excluirTecnico(conteudoTelaTecnico.cpf);
            System.out.println("******* Tecnico excluido com sucesso! *********");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine();

            System.out.println("***********************************");
            System.out.println("Soh eh permitido o uso de numeros no campo cpf!");
            System.out.println("***********************************");

        } catch (PessoaInexistenteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarTelaExclusaoUsuario() {
        try {

            ConteudoTelaUsuario conteudoTelaUsuario = new ConteudoTelaUsuario();

            System.out.println("** Exclusao de Usuario **");
            System.out.println("Digite o CPF do Usuario que voce deseja excluir");

            System.out.println("CPF: ");
            conteudoTelaUsuario.cpf = teclado.nextLong();

            ControladorPessoa.getInstancia().excluirUsuario(conteudoTelaUsuario.cpf);
            System.out.println("******* Usuario excluido com sucesso! *********");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine();

            System.out.println("***********************************");
            System.out.println("Soh eh permitido o uso de numeros no campo cpf!");
            System.out.println("***********************************");

        } catch (PessoaInexistenteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostraListaTecnicos(ArrayList<ConteudoTelaTecnico> listagemTecnicos) {
        System.out.println("************************");
        System.out.println("** Lista de Tecnicos **");
        for (ConteudoTelaTecnico conteudoTelaTecnico : listagemTecnicos) {
            
            System.out.println("Nome: " + conteudoTelaTecnico.nome);
            System.out.println("CPF: " + conteudoTelaTecnico.cpf);
            System.out.println("Telefone: " + conteudoTelaTecnico.telefone);
            System.out.println("");
        }

        System.out.println("************************");
    }

    public void mostraListaUsuarios(ArrayList<ConteudoTelaUsuario> listagemUsuarios) {
        System.out.println("************************");
        System.out.println("** Lista de Usuarios **");
        for (ConteudoTelaUsuario conteudoTelaUsuario : listagemUsuarios) {
            System.out.println("Nome: " + conteudoTelaUsuario.nome);
            System.out.println("CPF: " + conteudoTelaUsuario.cpf);
            System.out.println("Telefone: " + conteudoTelaUsuario.telefone);
            System.out.println("NumContrato: " + conteudoTelaUsuario.numContrato);
            System.out.println("");

        }
        System.out.println("************************");
    }

}
