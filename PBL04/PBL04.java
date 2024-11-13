package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("PUCPR");
        Biblioteca b2 = new Biblioteca("UFPR");

        Prateleira p1 = new Prateleira(1);
        Prateleira p2 = new Prateleira(2);
        Prateleira p3 = new Prateleira(3);
        Prateleira p4 = new Prateleira(4);

        Livro l1 = new Livro(001, "A Jornada das Sombras", 2015, "Editora Aurora", "João Pereira", 320);
        Livro l2 = new Livro(002, "A Cidade Submersa", 2019, "Novo Horizonte", "Mariana Almeida", 275);
        Livro l3 = new Livro(003, "O Guardião dos Segredos", 2018, "Novo Horizonte", "Rafael Carvalho", 400);

        p1.addLivro(l1);

        p2.addLivro(l2);
        p2.addLivro(l3);

        b1.addPrateleira(p1);
        b1.addPrateleira(p2);

        b2.addPrateleira(p3);
        b2.addPrateleira(p4);

        b1.imprimir();
        b2.imprimir();

        Scanner teclado = new Scanner(System.in);
        while (true) {
            int opcao = teclado.nextInt();

            switch (opcao) {
                case 0:
                    b1.imprimir();
                    break;
                case 1:
                    System.out.println("Digite o código do livro");
                    int codigoLivro = teclado.nextInt();

                    Livro livro = b1.buscarLivro(codigoLivro);

                    // Se existir
                    if(livro != null) {
                        System.out.println("Você tem certeza que quer emprestar esse livro?");
                        livro.imprimir();

                        int confirmacao = teclado.nextInt();

                        if(confirmacao >= 1) livro.devolver();
                        else {
                            System.out.println("Saindo");
                            continue;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite o código do livro");
                    codigoLivro = teclado.nextInt();

                    livro = b1.buscarLivro(codigoLivro);

                    // Se existir
                    if(livro != null) {
                        if(!livro.emprestado()) {
                            System.out.println("O livro não foi emprestado");
                            continue;
                        }

                        System.out.println("Você tem certeza que quer devolver esse livro?");
                        livro.imprimir();

                        int confirmacao = teclado.nextInt();

                        if(confirmacao >= 1) livro.emprestar();
                        else {
                            System.out.println("Saindo");
                            continue;
                        }
                    }
                    break;
            }
        }
    }
}

public class Biblioteca {
    private ArrayList<Prateleira> prateleiras;
    private String nome;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.prateleiras = new ArrayList<Prateleira>();
    }

    // Getter para atributo nome
    public String getNome() {
        return this.nome;
    }

    public void addPrateleira(Prateleira p) {
        this.prateleiras.add(p);
    }

    public void imprimir() {
        System.out.printf("----- Biblioteca %s -----\n", nome);

        // for p in prateleiras
        for(Prateleira p : this.prateleiras) {
            p.imprimir();
        }
    }

    public Livro buscarLivro(int codigoLivro) {
        Livro livroEncontrado = null;
        for(Prateleira p : prateleiras) {
            livroEncontrado = p.buscarLivro(codigoLivro);

            if (livroEncontrado != null) {
                return livroEncontrado;
            }
        }
        return livroEncontrado;
    }
}

class Prateleira {
    private int codigo;
    private ArrayList<Livro> livros;

    public Prateleira(int codigo) {
        this.codigo = codigo;
        this.livros = new ArrayList<Livro>();
    }

    // Getter do atributo código
    public int getCodigo() { return this.codigo; }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void imprimir() {
        System.out.printf("--- Prateleira %d ---\n", this.codigo);

        for(Livro livro : this.livros) {
            livro.imprimir();
        }
    }

    public Livro buscarLivro(int codigo) {
        for(Livro livro : this.livros) {
            if(livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }
}

class Livro {
    private int codigo;
    private int ano;
    private int quantidadePaginas;
    private String editora;
    private String titulo;
    private String autor;
    private boolean emprestado = false;

    public Livro(int codigo, String titulo, int ano, String editora, String autor, int quantidadePaginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
    }

    public void imprimir() {
        String mensagem = "Código %d | ";
        mensagem += "Título %s | ";
        mensagem += "Ano: %d | ";
        mensagem += "Editora: %s | ";
        mensagem += "Autor: %s | ";
        mensagem += "Emprestado: %s\n";
        String textoEmprestado = "Sim";
        if(!this.emprestado) textoEmprestado = "Não";
        System.out.printf(mensagem, codigo, titulo, ano, editora, autor, textoEmprestado);
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }

    public int getCodigo() { return this.codigo; }

    public boolean emprestado() {
        return this.emprestado;
    }
}

