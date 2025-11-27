public class GeradorCandidatos {

    public static Candidato[] gerarCandidatos() {

        Candidato[] candidatos = new Candidato[4];

        candidatos[0] = new Candidato(
            "Ana Paula",
            "ana@email.com",
            "123.456.789-00",
            "Voluntária Social",
            "Cuidados com crianças, organização",
            "Educação",
            "Feminino",
            "12/05/1998",
            "Brasileira",
            "Zona Leste - São Paulo",
            "Estudante de Pedagogia",
            "Pendente",
            "26"
        );

        candidatos[1] = new Candidato(
            "Lucas Moraes",
            "lucas@email.com",
            "987.654.321-00",
            "Voluntário Administrativo",
            "Planilhas, atendimento ao público",
            "Saúde",
            "Masculino",
            "03/09/1995",
            "Brasileiro",
            "Santo André - SP",
            "Auxiliar Administrativo",
            "Pendente",
            "29"
        );

        candidatos[2] = new Candidato(
            "Ricardo Silva",
            "ricardo@email.com",
            "456.789.123-00",
            "Voluntário em Logística",
            "Organização de doações, transporte",
            "Ações humanitárias",
            "Masculino",
            "21/01/1990",
            "Brasileiro",
            "Osasco - SP",
            "Motorista",
            "Pendente",
            "34"
        );

        candidatos[3] = new Candidato(
            "Marina Costa",
            "marina@email.com",
            "321.654.987-00",
            "Voluntária em Comunicação",
            "Redação, redes sociais",
            "Saúde",
            "Feminino",
            "17/11/1997",
            "Brasileira",
            "Guarulhos - SP",
            "Estudante de Jornalismo",
            "Pendente",
            "27"
        );

        return candidatos;
    }
}
