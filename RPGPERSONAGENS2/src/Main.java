import java.util.Scanner;

public class Main {

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {


        Mago monark = new Mago("Monark", 100, 30, 40);
        Guerreiro blackpantr = new Guerreiro("Blackpantr", 150, 25, 20);
        Arqueiro butterfly = new Arqueiro("Butterfly", 90, 3, 35);

        Personagem[] personagens = {monark, blackpantr, butterfly};


        System.out.println("=== Personagens criados ===\n");
        for (Personagem p : personagens) {
            System.out.println(p);
            System.out.println();
        }


        int opcao;
        do {
            System.out.println("=== ESCOLHA O PERSONAGEM ===");
            for (int i = 0; i < personagens.length; i++) {
                System.out.println((i + 1) + " - " + personagens[i].getNome()
                        + " (" + personagens[i].getClasse() + ")");
            }
            System.out.println("0 - Sair");

            opcao = lerInteiro("Opção: ");

            if (opcao >= 1 && opcao <= personagens.length) {
                menuPersonagem(personagens[opcao - 1]);
            } else if (opcao != 0) {
                System.out.println("Opção inválida!\n");
            }
        } while (opcao != 0);


        System.out.println("\n=== Estado final dos personagens ===\n");
        for (Personagem p : personagens) {
            System.out.println(p);
            System.out.println();
        }
        System.out.println("Fim do jogo!");
    }



    private static void menuPersonagem(Personagem personagem) {
        int opcao;
        do {
            System.out.println("\n=== " + personagem.getNome().toUpperCase()
                    + " (" + personagem.getClasse() + ") ===");
            System.out.println("1 - " + nomeAcaoEspecifica(personagem));
            System.out.println("2 - Receber dano");
            System.out.println("3 - Recuperar vida");
            System.out.println("4 - Receber moedas");
            System.out.println("5 - Gastar moedas");
            System.out.println("6 - Subir de nível");
            System.out.println("7 - Exibir informações");
            System.out.println("0 - Voltar");

            opcao = lerInteiro("Opção: ");
            System.out.println();

            try {
                switch (opcao) {
                    case 1:
                        executarAcaoEspecifica(personagem);
                        break;
                    case 2:
                        personagem.receberDano(lerInteiro("Quanto de dano? "));
                        System.out.println(personagem.getNome() + " agora tem vida "
                                + personagem.getVidaAtual() + "/" + personagem.getVidaMaxima());
                        break;
                    case 3:
                        personagem.recuperarVida(lerInteiro("Quanto de vida recuperar? "));
                        System.out.println(personagem.getNome() + " agora tem vida "
                                + personagem.getVidaAtual() + "/" + personagem.getVidaMaxima());
                        break;
                    case 4:
                        personagem.receberMoedas(lerInteiro("Quantas moedas receber? "));
                        System.out.println(personagem.getNome() + " agora tem "
                                + personagem.getMoedas() + " moedas.");
                        break;
                    case 5:
                        if (personagem.gastarMoedas(lerInteiro("Quantas moedas gastar? "))) {
                            System.out.println("Compra realizada! Moedas restantes: "
                                    + personagem.getMoedas());
                        } else {
                            System.out.println("Moedas insuficientes! Moedas: "
                                    + personagem.getMoedas());
                        }
                        break;
                    case 6:
                        personagem.subirNivel();
                        System.out.println(personagem.getNome() + " subiu para o nível "
                                + personagem.getNivel() + "!");
                        break;
                    case 7:
                        System.out.println(personagem);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Valor inválido: " + e.getMessage());
            }
        } while (opcao != 0);
        System.out.println();
    }



    private static String nomeAcaoEspecifica(Personagem personagem) {
        if (personagem instanceof Guerreiro) {
            return "Golpear";
        } else if (personagem instanceof Mago) {
            return "Lançar magia";
        } else if (personagem instanceof Arqueiro) {
            return "Atirar";
        }
        return "Ação específica";
    }

    private static void executarAcaoEspecifica(Personagem personagem) {
        if (personagem instanceof Guerreiro) {
            ((Guerreiro) personagem).golpear();
        } else if (personagem instanceof Mago) {
            ((Mago) personagem).lancarMagia();
        } else if (personagem instanceof Arqueiro) {
            ((Arqueiro) personagem).atirar();
        }
    }



    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
