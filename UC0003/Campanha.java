public class Campanha {

    private int id;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String descricao;
    private String cnpjOng;

    public Campanha(int id, String nome, String dataInicio, String dataFim, String descricao, String cnpjOng) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.cnpjOng = cnpjOng;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCnpjOng() {
        return cnpjOng;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
