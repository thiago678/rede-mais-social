import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar candidatos pendentes");
            System.out.println("2 - Buscar candidato por CPF/CNPJ");
            System.out.println("3 - Alterar status do candidato");
            System.out.println("4 - Recomendar ONGs e campanhas");
            System.out.println("5 - Inscrever candidato em campanha");
            System.out.println("6 - Listar voluntários");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    controller.listarCandidatosPendentes();
                    break;

                case 2:
                    System.out.print("Digite o CPF/CNPJ do candidato: ");
                    String cpf = scanner.nextLine();
                    controller.buscarCandidatoPorCpfCnpj(cpf);
                    break;

                case 3:
                    System.out.println("\nDigite no formato:");
                    System.out.println("CPF_OU_CNPJ CÓDIGO");
                    System.out.println("Ex: 12345678900 1");
                    System.out.println("Códigos: 1 = Aprovar | 2 = Reprovar | 3 = Manter Pendente");

                    System.out.print("Entrada: ");
                    String entrada = scanner.nextLine();

                    String[] partes = entrada.split(" ");

                    if (partes.length != 2) {
                        System.out.println("Formato inválido! Use: CPF CÓDIGO");
                        break;
                    }

                    String cpfCnpj = partes[0];
                    int codigo;

                    try {
                        codigo = Integer.parseInt(partes[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Código inválido! Digite apenas 1, 2 ou 3.");
                        break;
                    }

                    controller.alterarStatusPorCpfCnpj(cpfCnpj, codigo);
                    break;

                case 4:
                    System.out.println("\nDigite o CPF/CNPJ do candidato:");
                    System.out.print("Entrada: ");
                    String cpfBusca = scanner.nextLine();
                    controller.recomendarOngsECampanhas(cpfBusca);
                    break;

                case 5:
                    System.out.println("\nDigite no formato:");
                    System.out.println("CPF_OU_CNPJ ID_CAMPANHA");
                    System.out.println("Ex: 12345678900 2");

                    System.out.print("Entrada: ");
                    String insc = scanner.nextLine();

                    String[] dados = insc.split(" ");

                    if (dados.length != 2) {
                        System.out.println("Formato inválido!");
                        break;
                    }

                    String cpfInsc = dados[0];
                    int idCampanha;

                    try {
                        idCampanha = Integer.parseInt(dados[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("ID da campanha inválido.");
                        break;
                    }

                    controller.inscreverCandidatoEmCampanha(cpfInsc, idCampanha);
                    break;

                // 🔥 NOVA OPÇÃO: LISTAR VOLUNTÁRIOS
                case 6:
                    controller.listarVoluntarios();
                    break;

                case 7:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}
