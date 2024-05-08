package marcha;

public class Carta {
    private String valor;
    private String naipe;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getValorNumerico() {
        switch(valor) {
            case "2": return 9; 
            case "3": return 10; 
            case "4": return 1;  
            case "5": return 2;  
            case "6": return 3;
            case "7": return 4;
            case "Q": return 5; 
            case "J": return 6; 
            case "K": return 7; 
            case "A": return 8; 
            default: return 0;   
        }
    }
    

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }
}
