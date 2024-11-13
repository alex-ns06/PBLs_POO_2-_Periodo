package polimorfismo.sobrecarga;

public class Comida {
    public static void main(String[] args) {
        Carne c1 = new Carne("Mignon");
        Carne c2 = new Carne("Picanha");

        Pizza p1 = new Pizza("Quatro queijos");
        Pizza p2 = new Pizza("Margherita");

        Pao pa1 = new Pao("de queijo");
        Pao pa2 = new Pao("francês");

        assar(p1);
        assar(pa2);
        assar(c1);
        assar(c2);
        assar(pa1);
        assar(p2);
    }

    public static void assar(Pizza pi) {
        System.out.println("Assando uma deliciosa pizza");
        pi.mostrarMensagem();
    }

    public static void assar(Carne ca) {
        System.out.println("Assando carne");
        ca.mostrarMensagem();
    }

    public static void assar(Pao pa) {
        System.out.println("Assando pão");
        pa.mostrarMensagem();
    }
}

class Pizza {
    private String sabor;

    public Pizza(String sabor) {
        this.sabor = sabor;
    }

    public void mostrarMensagem() {
        System.out.printf("Pizza sabor %s\n", sabor);
    }
}

class Carne {
    private String corte;

    public Carne(String corte) {
        this.corte = corte;
    }

    public void mostrarMensagem() {
        System.out.printf("Carne corte %s\n", corte);
    }
}

class Pao {
    private String tipo;

    public Pao(String tipo) {
        this.tipo = tipo;
    }

    public void mostrarMensagem() {
        System.out.printf("Pão tipo %s\n", tipo);
    }
}
