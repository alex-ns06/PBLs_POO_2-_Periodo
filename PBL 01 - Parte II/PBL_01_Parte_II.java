import java.util.Random;
import java.util.Scanner;

public class PBL01_parte2 {
    public static void main(String[] args) {
        int n = retornaNumeroUsuario();
        int[] vetor = geraVetorAleatorio(n);

        for(int i = 0; i < n; i++) {
            int valor = vetor[i];

            if(valor % 2 == 0) {
                System.out.println(valor + " é par");
            } else if (valor % 3 == 0) {
              System.out.println(valor + " é múltiplo de 3");
            } else {
                System.out.println(valor + " é ímpar");
            }
        }

        for(int i : vetor) {
            if(i % 2 == 0) {
                System.out.println(i + " é par");
            } else if (i % 3 == 0) {
                System.out.println(i + " é múltiplo de 3");
            } else {
                System.out.println(i + " é ímpar");
            }
        }
    }

    public static int retornaNumeroUsuario() {
        System.out.println("Digite um número");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static int[] geraVetorAleatorio(int n) {
        int[] vetor = new int[n];
        Random r = new Random();

        for(int i = 0; i < n; i = i + 1) {
            vetor[i] = r.nextInt(0, 100);
        }

        return vetor;
    }
}

