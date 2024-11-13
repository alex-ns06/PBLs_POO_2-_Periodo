public class Pessoa {
    protected String nome;
    protected int idade;
    protected String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void apresentar() {
        System.out.printf("Nome: %s | Idade: %d | Email: %s\n", nome, idade, email);
    }

    public String getNome() {
        return nome;
    }
}

public class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    public Aluno(String nome, int idade, String email, String matricula, String curso) {
        super(nome, idade, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Matrícula: %s | Curso: %s\n", matricula, curso);
    }
}

public class Professor extends Pessoa {
    private String disciplina;
    private double salario;

    public Professor(String nome, int idade, String email, String disciplina, double salario) {
        super(nome, idade, email);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Disciplina: %s | Salário: R$%.2f\n", disciplina, salario);
    }

    public double calcularBonus() {
        return salario * 0.10;
    }
}

public class Funcionario extends Pessoa {
    private String departamento;
    private int horasTrabalhadas;
    private double salarioHora;

    public Funcionario(String nome, int idade, String email, String departamento, int horasTrabalhadas, double salarioHora) {
        super(nome, idade, email);
        this.departamento = departamento;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Departamento: %s | Horas Trabalhadas: %d | Salário por Hora: R$%.2f\n", departamento, horasTrabalhadas, salarioHora);
    }

    public double calcularPagamento() {
        return horasTrabalhadas * salarioHora;
    }
}

public class Monitor extends Aluno {
    private int horasMonitoria;

    public Monitor(String nome, int idade, String email, String matricula, String curso, int horasMonitoria) {
        super(nome, idade, email, matricula, curso);
        this.horasMonitoria = horasMonitoria;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.printf("Horas de Monitoria: %d\n", horasMonitoria);
    }

    public double calcularPagamentoMonitoria(double valorPorHora) {
        return horasMonitoria * valorPorHora;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class EscolaDanca {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Criando algumas pessoas
        pessoas.add(new Aluno("Ana Silva", 20, "ana@email.com", "A123", "Ballet"));
        pessoas.add(new Professor("Carlos Souza", 45, "carlos@email.com", "Jazz", 5000.00));
        pessoas.add(new Funcionario("Beatriz Oliveira", 35, "beatriz@email.com", "Administração", 160, 30.00));
        pessoas.add(new Monitor("Lucas Santos", 22, "lucas@email.com", "M234", "Contemporâneo", 10));

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Listar Pessoas");
            System.out.println("2. Visualizar Detalhes de uma Pessoa");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 1) {
                System.out.println("\nPessoas cadastradas:");
                for (Pessoa p : pessoas) {
                    System.out.println("- " + p.getNome());
                }
            } else if (opcao == 2) {
                System.out.print("Digite o nome da pessoa: ");
                String nome = scanner.nextLine();
                Pessoa pessoaEncontrada = null;

                for (Pessoa p : pessoas) {
                    if (p.getNome().equalsIgnoreCase(nome)) {
                        pessoaEncontrada = p;
                        System.out.println("Essa é a pessoa que você deseja visualizar?");
                        pessoaEncontrada.apresentar();
                        System.out.print("Confirmar (sim/não)? ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("sim")) {
                            break;
                        } else {
                            pessoaEncontrada = null;
                        }
                    }
                }

                if (pessoaEncontrada == null) {
                    System.out.println("Pessoa não encontrada.");
                }
            } else if (opcao == 3) {
                System.out.println("Encerrando o sistema.");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
