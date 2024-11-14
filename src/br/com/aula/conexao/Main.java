package br.com.aula.conexao;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler Registros de Aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma ppção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    new InserirDados();
                    break;
                case 2:
                    new AtualizaDados();
                    break;
                case 3:
                    new DeletaDados();
                    break;
                case 4:
                    new LerDados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}

