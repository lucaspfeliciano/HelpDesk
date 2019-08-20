/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import java.util.Scanner;
import br.ufsc.ine5605.trabalhodso.control.ControladorPrincipal;
import java.util.InputMismatchException;

/**
 *
 * @author 11193319943
 */
public class TelaPrincipal {

    private Scanner teclado;

    public TelaPrincipal() {
        this.teclado = new Scanner(System.in);

    }

    public void mostraMenuPrincipal() {
        try {
            int opcao;
            do {
                System.out.println("*** Sistema de Chamados ***");
                System.out.println("*** Digite a opcao desejada ***");
                System.out.println("[1] - Registro de Chamados");
                System.out.println("[2] - Registro de Pessoas");
                System.out.println("[3] - Registro de Empresas Clientes");
                System.out.println("[0] - Sair");
                opcao = teclado.nextInt();
                ControladorPrincipal.getInstancia().executaOpcaoMenuPrincipal(opcao);
            } while (opcao != 0);
        } catch (InputMismatchException inputMismatchException) {
            teclado.nextLine(); // descarta entrada para o usuário
            // tentar novamente
            System.out.println("***********************************");
            System.out.println("Por favor, digite somente numeros!");
            System.out.println("***********************************");
            mostraMenuPrincipal();
        }
    }

    public void imprimeMensagemNumeroInvalido() {
        System.out.println("********************************************");
        System.out.println("Este nao eh um numero valido, tente novamente!");
        System.out.println("********************************************");
    }
}
