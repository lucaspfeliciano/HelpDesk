/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.ufsc.ine5605.trabalhodso.exceptions.EmpresaClienteInexistenteException;
import br.ufsc.ine5605.trabalhodso.exceptions.EmpresaJahCadastradaException;
import br.ufsc.ine5605.trabalhodso.control.ControladorEmpresaCliente;

/**
 *
 * @author 11193319943
 */
public class TelaEmpresaCliente {

    private Scanner teclado;
    private ControladorEmpresaCliente controladorEmpresaCliente;

    public TelaEmpresaCliente(ControladorEmpresaCliente controladorEmpresaCliente) {
        this.controladorEmpresaCliente = controladorEmpresaCliente;
        this.teclado = new Scanner(System.in);
    }

    public void mostraMenuEmpresaCliente() {
        try {
            int opcao;

            do {
                System.out.println("** Menu de Empresas Cliente **");
                System.out.println("** Escolha a opcao desejado **");
                System.out.println("[1] - Cadastrar Empresa Cliente");
                System.out.println("[2] - Excluir Empresa Cliente");
                System.out.println("[3] - Listar Empresas Cliente");
                System.out.println("[0] - Retornar Menu Principal");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        mostrarTelaCadastroEmpresaCliente();
                        break;
                    case 2:
                        mostrarTelaExclusaoEmpresaCliente();
                        break;
                    case 3:
                        controladorEmpresaCliente.listarEmpresasCliente();
                        break;
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

    private void mostrarTelaCadastroEmpresaCliente() {

        try {
            System.out.println("** Nova Empresa Cliente **");

            System.out.println("** Nome **");
            teclado.nextLine();
            String nome = teclado.nextLine();

            System.out.println("** Numero do Contrato **");
            long numContrato = teclado.nextLong();

            ConteudoTelaEmpresaCliente conteudoTelaEmpresaCliente = new ConteudoTelaEmpresaCliente(nome, numContrato);

            controladorEmpresaCliente.cadastrarEmpresaCliente(conteudoTelaEmpresaCliente);
            System.out.println("********** Empresa Cliente cadastrada com sucesso! ************");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente

            System.out.println("***********************************");
            System.out.println("No campo Numero do Contrato soh eh permitida a entrada de numeros! Tente novamente!");
            System.out.println("***********************************");

        } catch (EmpresaJahCadastradaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarTelaExclusaoEmpresaCliente() {
        try {

            System.out.println("** Exclusao Empresa Cliente ** ");
            System.out.println("Digite o Numero de Contrato da Empresa que voce deseja excluir");

            System.out.println("Numero de Contrato: ");
            long numContrato = teclado.nextLong();

            controladorEmpresaCliente.excluirEmpresaCliente(numContrato);
            System.out.println("******* Empresa Cliente excluida com sucesso! *********");

        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("Soh eh permitido o uso de numeros no campo Numero do Contrato");
            System.out.println("***********************************");

        } catch (EmpresaClienteInexistenteException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void mostraListaEmpresasCliente(ArrayList<ConteudoTelaEmpresaCliente> listagemEmpresasCliente) {
        System.out.println("************************");
        System.out.println("** Lista de Empresas Cliente **");
        for (ConteudoTelaEmpresaCliente conteudoTelaEmpresaCliente : listagemEmpresasCliente) {
            System.out.println("Nome: " + conteudoTelaEmpresaCliente.nome);
            System.out.println("Numero de Contrato: " + conteudoTelaEmpresaCliente.numContrato);
            System.out.println("");

        }
        System.out.println("************************");
    }

}
