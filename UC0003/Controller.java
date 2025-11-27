public class Controller {

    private Candidato[] candidatos;
    private int totalCandidatos;

    // --- NOVO: Array para armazenar os voluntários ---
    private Voluntario[] voluntarios; 
    private int totalVoluntarios; 
    // ------------------------------------------------

    private ONG[] ongs;
    private Campanha[] campanhas;
    private int totalOngs;
    private int totalCampanhas;

    public Controller() {
        candidatos = GeradorCandidatos.gerarCandidatos();
        totalCandidatos = candidatos.length;

        GeradorOngCampanhas geradorDados = new GeradorOngCampanhas();
        ongs = geradorDados.getOngs();
        campanhas = geradorDados.getCampanhas();
        totalOngs = ongs.length;
        totalCampanhas = campanhas.length;

        // --- NOVO: Inicializa o array de voluntários ---
        // Estou definindo tamanho 100, mas você pode ajustar conforme necessidade
        voluntarios = new Voluntario[100]; 
        totalVoluntarios = 0;
        // ------------------------------------------------
    }

    public void listarCandidatosPendentes() {

        System.out.println("\n=== CANDIDATOS PENDENTES ===");

        boolean encontrou = false;

        for (int i = 0; i < totalCandidatos; i++) {

            if (candidatos[i].getStatusAprovacao().equalsIgnoreCase("Pendente")) {

                System.out.println("Nome: " + candidatos[i].getNome());
                System.out.println("Email: " + candidatos[i].getEmail());
                System.out.println("CPF: " + candidatos[i].getCpf_cnpj());
                System.out.println("Idade: " + candidatos[i].getIdade());
                System.out.println("Perfil: " + candidatos[i].getPerfil());
                System.out.println("Status: " + candidatos[i].getStatusAprovacao());
                System.out.println("--------------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum candidato pendente encontrado.");
        }
    }

   public void buscarCandidatoPorCpfCnpj(String cpfCnpj) {

    boolean encontrado = false;

    String cpfCnpjLimpo = cpfCnpj.replaceAll("[^0-9]", "");

    for (int i = 0; i < totalCandidatos; i++) {

        String cpfCnpjCandidato = candidatos[i].getCpf_cnpj().replaceAll("[^0-9]", "");

        if (cpfCnpjCandidato.equals(cpfCnpjLimpo)) {

            System.out.println("\n=== DETALHES DO CANDIDATO ===");
            System.out.println("Nome: " + candidatos[i].getNome());
            System.out.println("Email: " + candidatos[i].getEmail());
            System.out.println("CPF/CNPJ: " + candidatos[i].getCpf_cnpj());
            System.out.println("Sexo: " + candidatos[i].getSexo());
            System.out.println("Idade: " + candidatos[i].getIdade());
            System.out.println("Data de Nascimento: " + candidatos[i].getDataNascimento());
            System.out.println("Perfil: " + candidatos[i].getPerfil());
            System.out.println("Habilidades: " + candidatos[i].getHabilidades());
            System.out.println("Interesses: " + candidatos[i].getInteresses());
            System.out.println("Nacionalidade: " + candidatos[i].getNacionalidade());
            System.out.println("Endereço: " + candidatos[i].getEnderecoResidencialComercial());
            System.out.println("Profissão: " + candidatos[i].getProfissao());
            System.out.println("Status: " + candidatos[i].getStatusAprovacao());
            System.out.println("==============================");

            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Candidato com CPF/CNPJ " + cpfCnpj + " não encontrado.");
    }
}
    public void alterarStatusPorCpfCnpj(String cpfCnpjEntrada, int codigoStatus) {

    // Remove tudo que não for número
    String cpfLimpo = cpfCnpjEntrada.replaceAll("[^0-9]", "");

    boolean encontrado = false;

    for (int i = 0; i < totalCandidatos; i++) {

        String cpfDoCandidato = candidatos[i].getCpf_cnpj()
                .replaceAll("[^0-9]", "");

        if (cpfDoCandidato.equals(cpfLimpo)) {

            if (codigoStatus == 1) {
                candidatos[i].setStatusAprovacao("Aprovado");

            } else if (codigoStatus == 2) {
                candidatos[i].setStatusAprovacao("Reprovado");

            } else if (codigoStatus == 3) {
                candidatos[i].setStatusAprovacao("Pendente");

            } else {
                System.out.println("Código inválido! Use: 1 (Aprovar), 2 (Negar) ou 3 (Manter Pendente).");
                return;
            }

            System.out.println("Status atualizado com sucesso!");
            System.out.println("Nome: " + candidatos[i].getNome());
            System.out.println("Novo status: " + candidatos[i].getStatusAprovacao());

            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Candidato com CPF/CNPJ informado não encontrado.");
    }
}

public void recomendarOngsECampanhas(String cpfCnpj) {

    // Remove pontos, traços e barras pra comparar só números
    String cpfLimpo = cpfCnpj.replaceAll("[^0-9]", "");

    Candidato candidatoEncontrado = null;

    // 1. Buscar o candidato
    for (int i = 0; i < totalCandidatos; i++) {

        String cpfCandidato = candidatos[i]
                .getCpf_cnpj()
                .replaceAll("[^0-9]", "");

        if (cpfCandidato.equals(cpfLimpo)) {
            candidatoEncontrado = candidatos[i];
            break;
        }
    }

    if (candidatoEncontrado == null) {
        System.out.println("Candidato não encontrado.");
        return;
    }

    String interesse = candidatoEncontrado.getInteresses();

    System.out.println("\n=== RECOMENDAÇÕES PARA: " + candidatoEncontrado.getNome() + " ===");
    System.out.println("Interesse: " + interesse);

    boolean encontrouOng = false;

    // 2. Buscar ONGs com área igual ao interesse
    for (int i = 0; i < totalOngs; i++) {

        if (ongs[i].getArea().equalsIgnoreCase(interesse)) {

            encontrouOng = true;

            System.out.println("\n--- ONG RECOMENDADA ---");
            System.out.println("Nome: " + ongs[i].getRazaoSocial());
            System.out.println("CNPJ: " + ongs[i].getCnpj());
            System.out.println("Área: " + ongs[i].getArea());

            // 3. Buscar campanhas dessa ONG
            System.out.println("Campanhas dessa ONG:");

            boolean temCampanha = false;

            for (int j = 0; j < totalCampanhas; j++) {

                String cnpjCampanha = campanhas[j].getCnpjOng()
                        .replaceAll("[^0-9]", "");

                String cnpjOng = ongs[i].getCnpj()
                        .replaceAll("[^0-9]", "");

                if (cnpjCampanha.equals(cnpjOng)) {

                    temCampanha = true;

                    System.out.println(" -> Nome: " + campanhas[j].getNome());
                    System.out.println("    ID: " + campanhas[j].getId());
                    System.out.println("    Início: " + campanhas[j].getDataInicio());
                    System.out.println("    Fim: " + campanhas[j].getDataFim());
                    System.out.println("    Descrição: " + campanhas[j].getDescricao());
                    System.out.println("----------------------------");
                }
            }

            if (!temCampanha) {
                System.out.println("Nenhuma campanha ativa para essa ONG.");
            }
        }
    }

    if (!encontrouOng) {
        System.out.println("Nenhuma ONG encontrada para o interesse: " + interesse);
    }
}

public void inscreverCandidatoEmCampanha(String cpfCandidato, int idCampanha) {

    // 1. Limpeza do CPF recebido
    String cpfLimpo = cpfCandidato.replaceAll("[^0-9]", "");
    
    Candidato candidatoEncontrado = null;
    boolean campanhaExiste = false;
    String nomeCampanha = "";

    // 2. Busca o Candidato pelo CPF
    for (int i = 0; i < totalCandidatos; i++) {
        String cpfAtual = candidatos[i].getCpf_cnpj().replaceAll("[^0-9]", "");
        
        if (cpfAtual.equals(cpfLimpo)) {
            candidatoEncontrado = candidatos[i];
            break;
        }
    }

    if (candidatoEncontrado == null) {
        System.out.println("Erro: Candidato com CPF " + cpfCandidato + " não encontrado.");
        return;
    }

    // (Opcional) Validação: Só permite se o candidato estiver APROVADO
    if (!candidatoEncontrado.getStatusAprovacao().equalsIgnoreCase("Aprovado")) {
        System.out.println("Erro: O candidato " + candidatoEncontrado.getNome() + " não está com status 'Aprovado'.");
        return;
    }

    // 3. Verifica se a Campanha existe (para não inscrever em campanha fantasma)
    for (int i = 0; i < totalCampanhas; i++) {
        if (campanhas[i].getId() == idCampanha) {
            campanhaExiste = true;
            nomeCampanha = campanhas[i].getNome();
            break;
        }
    }

    if (!campanhaExiste) {
        System.out.println("Erro: Campanha com ID " + idCampanha + " não encontrada.");
        return;
    }

    // 4. A VIRADA DE CHAVE: Cria o Voluntário herdando dados do Candidato
    // Importante: A classe Voluntario deve ter o construtor que recebe (Candidato, int)
    Voluntario novoVoluntario = new Voluntario(candidatoEncontrado, idCampanha);

    // 5. Salva no array de voluntários
    if (totalVoluntarios < voluntarios.length) {
        voluntarios[totalVoluntarios] = novoVoluntario;
        totalVoluntarios++;
        
        System.out.println("\n=== SUCESSO! ===");
        System.out.println("O candidato " + novoVoluntario.getNome() + " agora é um VOLUNTÁRIO!");
        System.out.println("Inscrito na campanha: " + nomeCampanha + " (ID: " + idCampanha + ")");
        System.out.println("================\n");
    } else {
        System.out.println("Erro: Limite de voluntários atingido no sistema.");
    }
}
public void listarVoluntarios() {

    if (totalVoluntarios == 0) {
        System.out.println("\nNenhum voluntário cadastrado ainda.");
        return;
    }

    System.out.println("\n===== LISTA DE VOLUNTÁRIOS =====");

    for (int i = 0; i < totalVoluntarios; i++) {

        Voluntario v = voluntarios[i];

        System.out.println("\n-----------------------------");
        System.out.println("Nome: " + v.getNome());
        System.out.println("CPF/CNPJ: " + v.getCpf_cnpj());
        System.out.println("Email: " + v.getEmail());
        System.out.println("Status: " + v.getStatusAprovacao());

        System.out.println("Campanha: " + v.getIdCampanha());
    }
}
}