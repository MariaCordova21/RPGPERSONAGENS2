public class Mago extends Personagem {

    private static final int CUSTO_MAGIA = 10;

    private int mana;
    private int poderMagico;

    public Mago(String nome, int vidaMaxima, int mana, int poderMagico) {
        super(nome, "Mago", vidaMaxima);

        if (mana < 0 || poderMagico < 0) {
            throw new IllegalArgumentException("Mana e poder mágico não podem ser negativos.");
        }

        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    public int getMana() {
        return mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }



    public boolean lancarMagia() {
        if (mana < CUSTO_MAGIA) {
            System.out.println(getNome() + " não tem mana suficiente para lançar uma magia! (mana: " + mana + ")");
            return false;
        }
        mana -= CUSTO_MAGIA;
        System.out.println(getNome() + " lançou uma magia com poder " + poderMagico
                + "! Mana restante: " + mana);
        return true;
    }



    @Override
    public String toString() {
        return super.toString() +
                "\nMana: " + mana +
                "\nPoder mágico: " + poderMagico;
    }
}
