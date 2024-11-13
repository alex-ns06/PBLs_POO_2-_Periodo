import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados de entrada
        System.out.print("Digite o valor do primeiro termo da PA: ");
        double a1 = scanner.nextDouble();

        System.out.print("Digite a razão da PA: ");
        double r = scanner.nextDouble();

        System.out.print("Digite o número de termos da PA: ");
        int n = scanner.nextInt();

        if (n > 0) {
            // Cálculo do último termo
            double an = a1 + (n - 1) * r;
            System.out.printf("Último termo da PA: %.2f\n", an);

            // Cálculo da soma dos termos
            double Sn = (a1 + an) * n / 2;
            System.out.printf("Soma de todos os termos da PA: %.2f\n", Sn);
        } else {
            System.out.println("Erro: o número de termos deve ser positivo.");
        }

        scanner.close();
    }
}
