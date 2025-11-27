import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller_Candidato controller = new Controller_Candidato();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Verificar cadastro do candidato");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("\nDigite seus dados:");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF ou CNPJ (apenas números): ");
                    String cpfCnpj = scanner.nextLine();

                    controller.buscarOuCadastrar(nome, cpfCnpj, scanner);
                    break;

                case 2:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 2);

        scanner.close();
    }
}
