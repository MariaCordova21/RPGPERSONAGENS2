public class Personagem {

    private String nome;
    private String classe;


    private final int vidaMaxima;


    private int vidaAtual;
    private int nivel;
    private int moedas;

    public Personagem(String nome, String classe, int vidaMaxima) {
        if (vidaMaxima <= 0) {
            throw new IllegalArgumentException("Vida máxima deve ser maior que zero.");
        }

        this.nome = nome;
        this.classe = classe;
        this.vidaMaxima = vidaMaxima;


        this.vidaAtual = vidaMaxima; // inicia com vida cheia
        this.nivel = 1;              // inicia no nível 1
        this.moedas = 100;           // inicia com 100 moedas
    }


    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMoedas() {
        return moedas;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }



    public void receberDano(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        }
        vidaAtual -= quantidade;
        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
    }

    public void recuperarVida(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A recuperação de vida não pode ser negativa.");
        }
        vidaAtual += quantidade;
        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }
    }

    public void receberMoedas(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de moedas recebida não pode ser negativa.");
        }
        moedas += quantidade;
    }

    public boolean gastarMoedas(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de moedas gasta não pode ser negativa.");
        }
        if (quantidade > moedas) {
            return false; // não permite gastar mais do que possui
        }
        moedas -= quantidade;
        return true;
    }

    public void subirNivel() {
        nivel++;
    }



    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nClasse: " + classe +
                "\nVida: " + vidaAtual + "/" + vidaMaxima +
                "\nNível: " + nivel +
                "\nMoedas: " + moedas;
    }
}