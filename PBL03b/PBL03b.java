public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private int idade;
    private String departamento;

    // Construtor 1: Para cargos de nível júnior
    public Funcionario(String nome, String cargo, int idade, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.departamento = departamento;
        this.salario = 2500.00; // Salário padrão para júnior
    }

    // Construtor 2: Para cargos de nível pleno
    public Funcionario(String nome, String cargo, double salario, int idade, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario > 2500.00 ? salario : 3500.00; // Salário padrão para pleno
        this.idade = idade;
        this.departamento = departamento;
    }

    // Construtor 3: Para cargos de nível sênior com bônus
    public Funcionario(String nome, String cargo, double salario, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario > 4000.00 ? salario + 1000.00 : 4500.00; // Bônus sênior
        this.departamento = departamento;
        this.idade = 0; // Idade opcional nesse caso
    }

    // Método para exibir os dados do funcionário
    public void exibirDados() {
        System.out.printf("Nome: %s | Cargo: %s | Salário: R$%.2f | Idade: %d | Departamento: %s\n",
                nome, cargo, salario, idade, departamento);
    }

    // Método para obter o salário
    public double getSalario() {
        return salario;
    }
}

public class Empresa {
    public static void main(String[] args) {
        // Instanciando 5 funcionários com diferentes construtores
        Funcionario func1 = new Funcionario("João Silva", "Analista Júnior", 22, "TI");
        Funcionario func2 = new Funcionario("Maria Oliveira", "Analista Pleno", 4000.00, 30, "TI");
        Funcionario func3 = new Funcionario("Carlos Souza", "Gerente Sênior", 6000.00, "Administração");
        Funcionario func4 = new Funcionario("Ana Costa", "Assistente", 20, "Recursos Humanos");
        Funcionario func5 = new Funcionario("Lucas Pereira", "Coordenador Pleno", 3800.00, 35, "Financeiro");

        // Exibindo os dados dos funcionários
        System.out.println("Dados dos Funcionários:");
        func1.exibirDados();
        func2.exibirDados();
        func3.exibirDados();
        func4.exibirDados();
        func5.exibirDados();

        // Calculando e exibindo o total de salários
        double totalSalarios = func1.getSalario() + func2.getSalario() + func3.getSalario() +
                               func4.getSalario() + func5.getSalario();
        System.out.printf("\nTotal a pagar para todos os funcionários: R$%.2f\n", totalSalarios);
    }
}
