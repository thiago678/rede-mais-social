public class Candidato {

    private String nome;
    private String email;
    private String cpf_cnpj;
    private String perfil;
    private String habilidades;
    private String interesses;
    private String sexo;
    private String dataNascimento;
    private String idade;
    private String nacionalidade;
    private String enderecoResidencialComercial;
    private String profissao;
    private String statusAprovacao;

    public Candidato(String nome, String email, String cpf_cnpj, String perfil,
                     String habilidades, String interesses, String sexo,
                     String dataNascimento, String nacionalidade,
                     String enderecoResidencialComercial, String profissao,
                     String statusAprovacao,String idade) {

        this.nome = nome;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.perfil = perfil;
        this.habilidades = habilidades;
        this.interesses = interesses;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.enderecoResidencialComercial = enderecoResidencialComercial;
        this.profissao = profissao;
        this.statusAprovacao = statusAprovacao;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public String getInteresses() {
        return interesses;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getEnderecoResidencialComercial() {
        return enderecoResidencialComercial;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setStatusAprovacao(String statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

        public String getIdade() {
        return idade;
    }
}

