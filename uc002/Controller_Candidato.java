import java.util.Scanner;

public class Controller_Candidato {

    private Candidato[] candidatos;
    private int total;

    public Controller_Candidato() {
        candidatos = GeradorCandidatos.gerarCandidatos();
        total = candidatos.length;
    }

    // ================= BUSCAR OU CADASTRAR ================= //

    public void buscarOuCadastrar(String nome, String cpfDigitado, Scanner scanner) {

        cpfDigitado = cpfDigitado.replace(".", "").replace("-", "").replace("/", "");

        Candidato candidato = buscarCandidato(nome, cpfDigitado);

        if (candidato != null) {
            System.out.println("\n✅ Candidato encontrado:");
            exibirCandidato(candidato);
        } else {
            System.out.println("\n⚠️ Candidato não encontrado. Iniciando etapa de inscrição...");

            Candidato novo = iniciarInscricao(scanner, nome, cpfDigitado);

            if (novo != null) {
                System.out.println("\n✅ Inscrição finalizada e candidato armazenado!");
            } else {
                System.out.println("\n❌ Inscrição cancelada.");
            }
        }
    }

    // ================= BUSCA ================= //

    private Candidato buscarCandidato(String nomeDigitado, String cpfDigitado) {

        for (int i = 0; i < candidatos.length; i++) {

            String cpfBanco = candidatos[i].getCpf_cnpj()
                    .replace(".", "")
                    .replace("-", "")
                    .replace("/", "");

            if (candidatos[i].getNome().equalsIgnoreCase(nomeDigitado)
                    && cpfBanco.equals(cpfDigitado)) {

                return candidatos[i];
            }
        }

        return null;
    }

    // ================= FLUXO DE INSCRIÇÃO ================= //

    private Candidato iniciarInscricao(Scanner scanner, String nome, String cpf) {

        System.out.println("\n=== FORMULÁRIO DE IDENTIFICAÇÃO ===");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Idade: ");
        String idade = scanner.nextLine();

        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        System.out.print("Endereço residencial/comercial: ");
        String endereco = scanner.nextLine();

        System.out.print("Profissão: ");
        String profissao = scanner.nextLine();

        System.out.println("\n=== FORMULÁRIO DE PERFIL ===");

        System.out.print("Perfil: ");
        String perfil = scanner.nextLine();

        System.out.print("Habilidades: ");
        String habilidades = scanner.nextLine();

        System.out.print("Interesses: ");
        String interesses = scanner.nextLine();

        // ============ TERMO DE COMPROMISSO ============ //

        boolean aceito = termoCompromisso(scanner);

        if (!aceito) {
            return null;
        }

        // ============ CRIANDO CANDIDATO ============ //

        Candidato novo = new Candidato(
                nome,
                email,
                cpf,
                perfil,
                habilidades,
                interesses,
                sexo,
                dataNascimento,
                nacionalidade,
                endereco,
                profissao,
                "Aguardando Validação",
                idade
        );

        // ============ VALIDAÇÃO DO EMAIL ============ //

        boolean emailValidado = validarEmail(novo, scanner);

        if (!emailValidado) {
            System.out.println("\n❌ Falha na validação do e-mail. Cadastro não finalizado.");
            return null;
        }

        novo.setStatusAprovacao("Aguardando aprovação");

        adicionarCandidato(novo);

        System.out.println("\n📌 Situação do candidato: " + novo.getStatusAprovacao());
        System.out.println("📌 Aguarde a aprovação pela Rede Mais Social.");

        return novo;
    }

    // ================= VALIDAR EMAIL ================= //

    private boolean validarEmail(Candidato candidato, Scanner scanner) {

        ServicoEmail servicoEmail = new ServicoEmail();

        servicoEmail.enviarCodigoSimulado(candidato.getEmail());

        boolean validado = servicoEmail.validarCodigo(scanner);

        return validado;
    }

    // ================= TERMO ================= //

    private boolean termoCompromisso(Scanner scanner) {

        System.out.println("\n=== TERMO DE COMPROMISSO ===");
        System.out.println("Ao aceitar, você concorda com todos os termos da Rede Mais Social.");

        System.out.print("Você aceita? (S/N): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {

            System.out.print("Digite a data do aceite: ");
            String data = scanner.nextLine();

            System.out.println("\nTermo aceito em: " + data);
            return true;
        }

        return false;
    }

    // ================= ARMAZENAR ================= //

    private void adicionarCandidato(Candidato candidato) {

        Candidato[] novoArray = new Candidato[candidatos.length + 1];

        for (int i = 0; i < candidatos.length; i++) {
            novoArray[i] = candidatos[i];
        }

        novoArray[candidatos.length] = candidato;
        candidatos = novoArray;
    }

    // ================= EXIBIR ================= //

    private void exibirCandidato(Candidato c) {

        System.out.println("\n----- DADOS DO CANDIDATO -----");
        System.out.println("Nome: " + c.getNome());
        System.out.println("Email: " + c.getEmail());
        System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
        System.out.println("Sexo: " + c.getSexo());
        System.out.println("Nascimento: " + c.getDataNascimento());
        System.out.println("Idade: " + c.getIdade());
        System.out.println("Nacionalidade: " + c.getNacionalidade());
        System.out.println("Endereço: " + c.getEnderecoResidencialComercial());
        System.out.println("Profissão: " + c.getProfissao());
        System.out.println("Perfil: " + c.getPerfil());
        System.out.println("Habilidades: " + c.getHabilidades());
        System.out.println("Interesses: " + c.getInteresses());
        System.out.println("Status: " + c.getStatusAprovacao());
    }
}
