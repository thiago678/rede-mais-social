public class GeradorOngCampanhas {

    private ONG[] ongs;
    private Campanha[] campanhas;

    public GeradorOngCampanhas() {
        gerarONGs();
        gerarCampanhas();
    }

    private void gerarONGs() {

        ongs = new ONG[5];

        // 3 ONGs de Saúde
        ongs[0] = new ONG("Vida Melhor", "11.111.111/0001-11", "Saúde");
        ongs[1] = new ONG("Cuidar Sempre", "22.222.222/0001-22", "Saúde");
        ongs[2] = new ONG("Saúde para Todos", "33.333.333/0001-33", "Saúde");

        // 2 ONGs de Educação
        ongs[3] = new ONG("Educar é Poder", "44.444.444/0001-44", "Educação");
        ongs[4] = new ONG("Futuro Brilhante", "55.555.555/0001-55", "Educação");
    }

    private void gerarCampanhas() {

        campanhas = new Campanha[5];

        campanhas[0] = new Campanha(
                1,
                "Campanha do Sorriso",
                "01/03/2025",
                "30/03/2025",
                "Ação para atendimento odontológico gratuito",
                "11.111.111/0001-11"
        );

        campanhas[1] = new Campanha(
                2,
                "Volta às Aulas Solidária",
                "10/01/2025",
                "10/02/2025",
                "Doação de materiais escolares para crianças",
                "44.444.444/0001-44"
        );

        campanhas[2] = new Campanha(
                3,
                "Doe Sangue, Doe Vida",
                "05/02/2025",
                "05/03/2025",
                "Campanha de doação de sangue",
                "11.111.111/0001-11"
        );

        campanhas[3] = new Campanha(
                4,
                "Alimente uma Família",
                "01/04/2025",
                "30/04/2025",
                "Distribuição de cestas básicas",
                "11.111.111/0001-11"
        );

        campanhas[4] = new Campanha(
                5,
                "Inclusão Digital",
                "15/05/2025",
                "15/06/2025",
                "Aulas de informática para jovens",
                "44.444.444/0001-44"
        );
    }

    public ONG[] getOngs() {
        return ongs;
    }

    public Campanha[] getCampanhas() {
        return campanhas;
    }
}
