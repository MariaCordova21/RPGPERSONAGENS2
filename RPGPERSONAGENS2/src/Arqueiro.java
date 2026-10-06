public class Arqueiro extends Personagem {

    private int flechas;
    private int precisao;

    public Arqueiro(String nome, int vidaMaxima, int flechas, int precisao) {
        super(nome, "Arqueiro", vidaMaxima);

        if (flechas < 0 || precisao < 0) {
            throw new IllegalArgumentException("Flechas e precisão não podem ser negativas.");
        }

        this.flechas = flechas;
        this.precisao = precisao;
    }

    public int getFlechas() {
        return flechas;
    }

    public int getPrecisao() {
        return precisao;
    }



    public boolean atirar() {
        if (flechas <= 0) {
            System.out.println(getNome() + " está sem flechas e não pode atirar!");
            return false;
        }
        flechas--;
        System.out.println(getNome() + " atirou uma flecha com precisão " + precisao
                + "! Flechas restantes: " + flechas);
        return true;
    }



    @Override
    public String toString() {
        return super.toString() +
                "\nFlechas: " + flechas +
                "\nPrecisão: " + precisao;
    }
}
