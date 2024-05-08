package marcha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        inicializarBaralho();
        embaralhar();
    }

    private void inicializarBaralho() {
        String[] naipes = { "Ouros", "Copas", "Espadas", "Paus" };
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "Q", "J", "K" };

        for (String naipe : naipes) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, naipe));//combinações 
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }


}
