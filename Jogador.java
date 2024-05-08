package marcha;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }


    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public Carta jogarCarta(int indice) {
        if (indice >= 0 && indice < mao.size()) {
            Carta cartaJogada = mao.remove(indice);
            System.out.println(nome + " jogou a carta: " + cartaJogada);
            return cartaJogada;
        } else {
            System.out.println("Índice inválido. Tente novamente.");
            return null;
        }
    }
    
}