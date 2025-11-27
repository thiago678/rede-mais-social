public class FormularioIdentificacao {

    private String nome;
    private String sexo;
    private String dataNascimento;
    private String nacionalidade;
    private String enderecoResidencial;
    private String enderecoComercial;
    private String profissao;

    public FormularioIdentificacao(String nome, String sexo, String dataNascimento,
                                     String nacionalidade, String enderecoResidencial,
                                     String enderecoComercial, String profissao) {

        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.enderecoResidencial = enderecoResidencial;
        this.enderecoComercial = enderecoComercial;
        this.profissao = profissao;
    }

    public String getNome() { return nome; }
    public String getSexo() { return sexo; }
    public String getDataNascimento() { return dataNascimento; }
    public String getNacionalidade() { return nacionalidade; }
    public String getEnderecoResidencial() { return enderecoResidencial; }
    public String getEnderecoComercial() { return enderecoComercial; }
    public String getProfissao() { return profissao; }
}
