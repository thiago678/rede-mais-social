public class ONG {

    private String razaoSocial;
    private String cnpj;
    private String area;

    public ONG(String razaoSocial, String cnpj, String area) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.area = area;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getArea() {
        return area;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
