public class FormularioPerfil {

    private String perfil;
    private String habilidades;
    private String interesses;

    public FormularioPerfil(String perfil, String habilidades, String interesses) {
        this.perfil = perfil;
        this.habilidades = habilidades;
        this.interesses = interesses;
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
}
