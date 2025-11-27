import java.util.Random;
import java.util.Scanner;

public class ServicoEmail {

    private String codigoGerado;

    public void enviarCodigoSimulado(String emailDestino) {

        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);
        codigoGerado = String.valueOf(numero);

        System.out.println("\n=================================");
        System.out.println("📨 SIMULAÇÃO DE ENVIO DE E-MAIL");
        System.out.println("Para: " + emailDestino);
        System.out.println("Código: " + codigoGerado);
        System.out.println("=================================");
    }

    public boolean validarCodigo(Scanner scanner) {

        System.out.print("\nDigite o código recebido: ");
        String codigoDigitado = scanner.nextLine();

        if (codigoDigitado.equals(codigoGerado)) {
            System.out.println("✅ E-mail validado com sucesso!");
            return true;
        } else {
            System.out.println("❌ Código inválido!");
            return false;
        }
    }
}
