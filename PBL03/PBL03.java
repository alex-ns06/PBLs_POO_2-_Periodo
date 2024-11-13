public class Cliente {
    private String nome;
    private double saldo;

    // Construtor
    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    // Método para depositar valor
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso.\n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para retirar valor
    public void retirar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.printf("Retirada de R$%.2f realizada com sucesso.\n", valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para retirada.");
        }
    }

    // Método para imprimir os dados do cliente
    public void imprimirDados() {
        System.out.printf("Cliente: %s\nSaldo: R$%.2f\n", nome, saldo);
    }
}

public class Banco {
    public static void main(String[] args) {
        // Criação das instâncias de Cliente
        Cliente cliente1 = new Cliente("Jandira Silva", 2500.00);
        Cliente cliente2 = new Cliente("Sandra Rodrigues", 1800.00);
        Cliente cliente3 = new Cliente("Luciana Teixeira", 5000.00);

        // Imprimir dados iniciais dos clientes
        System.out.println("Dados iniciais dos clientes:");
        cliente1.imprimirDados();
        cliente2.imprimirDados();
        cliente3.imprimirDados();

        // Operações com a cliente Jandira Silva
        System.out.println("\nOperações com Jandira Silva:");
        cliente1.retirar(1000.00);
        cliente1.imprimirDados();

        // Operações com a cliente Sandra Rodrigues
        System.out.println("\nOperações com Sandra Rodrigues:");
        cliente2.retirar(2000.00);
        cliente2.depositar(500.00);
        cliente2.imprimirDados();
        cliente2.retirar(2000.00);
        cliente2.imprimirDados();

        // Operações com a cliente Luciana Teixeira
        System.out.println("\nOperações com Luciana Teixeira:");
        cliente3.depositar(1000.00);
        cliente3.imprimirDados();
    }
}

