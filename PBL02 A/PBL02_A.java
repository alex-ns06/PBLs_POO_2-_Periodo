import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();

        if (a <= b) {
            System.out.print("Digite o valor de n (número de trapézios): ");
            int n = scanner.nextInt();

            if (n > 0) {
                double h = (b - a) / n;
                double areaTotal = 0;
                double x = a;
                double y1 = f(x);

                for (int i = 0; i < n; i++) {
                    x = x + h;
                    double y2 = f(x);
                    double areaTrapezio = ((y1 + y2) / 2) * h;
                    areaTotal += areaTrapezio;
                    y1 = y2;
                }

                System.out.printf("A integral calculada é: %.15f\n", areaTotal);
            } else {
                System.out.println("Erro: o valor de n deve ser maior que zero.");
            }
        } else {
            System.out.println("Erro: valor de a deve ser menor ou igual ao valor de b.");
        }

        scanner.close();
    }

    public static double f(double x) {
        return 2 * Math.sin(x) + (Math.cos(x) / 3);
    }
}

