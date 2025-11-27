public class TermoCompromisso {

    private String nomeCandidato;
    private String dataAceite;
    private boolean aceito;

    public TermoCompromisso(String nomeCandidato, String dataAceite, boolean aceito) {
        this.nomeCandidato = nomeCandidato;
        this.dataAceite = dataAceite;
        this.aceito = aceito;
    }

    public boolean foiAceito() {
        return aceito;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public String getDataAceite() {
        return dataAceite;
    }

    @Override
    public String toString() {
        return "Termo {" +
                "Nome: " + nomeCandidato +
                ", Data Aceite: " + dataAceite +
                ", Aceito: " + aceito +
                '}';
    }
}
    