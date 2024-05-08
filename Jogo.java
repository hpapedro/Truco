package marcha;

import java.util.Scanner;

public class Jogo {
    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private int vitoriasJogador1 = 0;
    private int vitoriasJogador2 = 0;

    public Jogo(String nomeJogador1, String nomeJogador2) {
        baralho = new Baralho();
        jogador1 = new Jogador(nomeJogador1);
        jogador2 = new Jogador(nomeJogador2);
    }

    public void iniciarJogo() {
        baralho.embaralhar();
        distribuirCartas();
        Scanner scanner = new Scanner(System.in);
    
        for (int i = 0; i < 3; i++) {
            System.out.println("Rodada " + (i + 1));
            Carta cartaJogador1 = turnoJogador(jogador1, scanner);
            Carta cartaJogador2 = turnoJogador(jogador2, scanner);
    
            if (cartaJogador1.getValorNumerico() > cartaJogador2.getValorNumerico()) {
                vitoriasJogador1++;
                System.out.println(jogador1.getNome() + " vence a rodada!");
            } else if (cartaJogador1.getValorNumerico() < cartaJogador2.getValorNumerico()) {
                vitoriasJogador2++;
                System.out.println(jogador2.getNome() + " vence a rodada!");
            } else {
                System.out.println("Empate na rodada!");
            }
            System.out.println();
        }
    
        scanner.close();
        determinarVencedor();
    }

    private void distribuirCartas() {
        for (int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.getCartas().remove(0));
            jogador2.receberCarta(baralho.getCartas().remove(0));
        }
    }

    private Carta turnoJogador(Jogador jogador, Scanner scanner) {
        System.out.println("\nVez de " + jogador.getNome() + ":");
        System.out.println("Suas cartas:");
        int indiceCarta = 0;
        for (Carta carta : jogador.getMao()) {
            System.out.println(indiceCarta + ": " + carta);
            indiceCarta++;
        }
        System.out.print("Escolha uma carta para jogar (0, 1, 2): ");
        int escolha = scanner.nextInt();
        return jogador.jogarCarta(escolha);
    }

    private void determinarVencedor() {
        if (vitoriasJogador1 > vitoriasJogador2) {
            System.out.println(jogador1.getNome() + " vence o jogo!");
        } else if (vitoriasJogador1 < vitoriasJogador2) {
            System.out.println(jogador2.getNome() + " vence o jogo!");
        } 
    }
}
