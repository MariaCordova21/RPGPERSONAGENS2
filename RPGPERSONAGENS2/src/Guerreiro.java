public class Guerreiro extends Personagem {

    private int forca;
    private int armadura;

    public Guerreiro(String nome, int vidaMaxima, int forca, int armadura) {
        super(nome, "Guerreiro", vidaMaxima); // dados gerais ficam com Personagem

        if (forca < 0 || armadura < 0) {
            throw new IllegalArgumentException("Força e armadura não podem ser negativas.");
        }

        this.forca = forca;
        this.armadura = armadura;
    }

    public int getForca() {
        return forca;
    }

    public int getArmadura() {
        return armadura;
    }



    public void golpear() {
        System.out.println(getNome() + " realizou um golpe com força " + forca + "!");
    }



    @Override
    public String toString() {
        return super.toString() +
                "\nForça: " + forca +
                "\nArmadura: " + armadura;
    }
}
