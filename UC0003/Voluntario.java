public class Voluntario extends Candidato {

    private int idCampanha; // O código da campanha que você mencionou

    // Construtor principal
    // Dentro da classe Voluntario
    public Voluntario(Candidato candidato, int idCampanha) {
    super(
        candidato.getNome(),
        candidato.getEmail(),
        candidato.getCpf_cnpj(),
        candidato.getPerfil(),
        candidato.getHabilidades(),
        candidato.getInteresses(),
        candidato.getSexo(),
        candidato.getDataNascimento(),
        candidato.getNacionalidade(),
        candidato.getEnderecoResidencialComercial(),
        candidato.getProfissao(),
        candidato.getStatusAprovacao(),
        candidato.getIdade()
    );
    this.idCampanha = idCampanha;
    }

    // Getters e Setters específicos do Voluntário
    public int getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }
}