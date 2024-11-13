public abstract class Personagem {
    private boolean vivo;
    protected float posicao_x;
    protected float posicao_y;
    protected float posicao_z;
    protected int cor;

    public Personagem(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        this.vivo = vivo;
        this.posicao_x = posicao_x;
        this.posicao_y = posicao_y;
        this.posicao_z = posicao_z;
        this.cor = cor;
    }

    public abstract void correr(float x, float y);
    public abstract void saltar(float z);
    public abstract void atirar();
    public void morrer() {
        this.vivo = false;
        System.out.println("Morto");
    }
    public void camuflar(int cor) {
        this.cor = cor;
        System.out.printf("%s camuflando...\n", this.getClass().getSimpleName());
    }
}

abstract class Heroi extends Personagem {
    public Heroi(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void correr(float x, float y) {
        this.posicao_x = x;
        this.posicao_y = y;
        System.out.printf("%s correndo...\n", this.getClass().getSimpleName());
    }

    public void saltar(float z) {
        this.posicao_z = z;
        System.out.printf("%s saltando...\n", this.getClass().getSimpleName());
    }
}

class Batman extends Heroi {
    public Batman(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }
}

class JamesBond extends Heroi {
    public JamesBond(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }
}

abstract class Vilao extends Personagem {
    public Vilao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void correr(float x, float y) {
        this.posicao_x = x;
        this.posicao_y = y;
        System.out.printf("%s correndo...\n", this.getClass().getSimpleName());
    }
}

abstract class Ladrao extends Vilao {
    public Ladrao(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void saltar(float z) {
        this.posicao_z = z;
        System.out.printf("%s saltando...\n", this.getClass().getSimpleName());
    }
}

abstract class Terrorista extends Vilao {
    public Terrorista(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }
}

class Coringa extends Ladrao {
    public Coringa(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }
}

class Pinguim extends Ladrao {
    public Pinguim(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }

    public void correr(float x, float y) {
        this.posicao_x = x;
        this.posicao_y = y;
        System.out.printf("%s correndo...\n", this.getClass().getSimpleName());
    }
}

class Goldfinger extends Terrorista {
    private Heroi heroi;

    public Goldfinger(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void saltar(float z) {
        this.posicao_z = z;
        System.out.printf("%s saltando...\n", this.getClass().getSimpleName());
    }

    public void personificar(Heroi h) {
        this.heroi = h;
        System.out.println("Personificando...");
    }
}

class DrNo extends Terrorista {
    public DrNo(boolean vivo, float posicao_x, float posicao_y, float posicao_z, int cor) {
        super(vivo, posicao_x, posicao_y, posicao_z, cor);
    }

    public void saltar(float z) {
        this.posicao_z = z;
        System.out.printf("%s saltando...\n", this.getClass().getSimpleName());
    }

    public void atirar() {
        System.out.printf("%s atirando...\n", this.getClass().getSimpleName());
    }

    public void correr(float x, float y) {
        this.posicao_x = x;
        this.posicao_y = y;
        System.out.printf("%s correndo...\n", this.getClass().getSimpleName());
    }
}

class Teste {
    public static void main(String[] args) {
        Batman batman = new Batman(true, 0, 0, 0, 1);
        JamesBond bond = new JamesBond(true, 1, 1, 1, 2);
        Coringa coringa = new Coringa(true, 2, 2, 2, 3);
        Pinguim pinguim = new Pinguim(true, 3, 3, 3, 4);
        Goldfinger goldfinger = new Goldfinger(true, 4, 4, 4, 5);
        DrNo drNo = new DrNo(true, 5, 5, 5, 6);

        // Testando métodos
        batman.correr(10, 10);
        batman.saltar(5);
        batman.atirar();
        batman.camuflar(7);
        batman.morrer();

        bond.correr(20, 20);
        bond.saltar(10);
        bond.atirar();

        coringa.correr(30, 30);
        coringa.saltar(15);
        coringa.atirar();

        pinguim.correr(40, 40);
        pinguim.saltar(20);
        pinguim.atirar();

        goldfinger.correr(50, 50);
        goldfinger.saltar(25);
        goldfinger.personificar(batman);

        drNo.correr(60, 60);
        drNo.saltar(30);
        drNo.atirar();
    }
}
