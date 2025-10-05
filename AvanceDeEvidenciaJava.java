import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Clase que representa una carta
class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

// Clase que representa el deck de cartas
class Deck {
    private List<Card> cartas;

    public Deck() {
        cartas = new ArrayList<>();
        inicializarDeck();
    }

    // Inicializa las 52 cartas de poker
    private void inicializarDeck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? colores[1] : colores[0];
            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    // Mezclar deck
    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    // Mostrar primera carta y removerla
    public void head() {
        if (!cartas.isEmpty()) {
            Card carta = cartas.remove(0);
            System.out.println(carta.toString());
            System.out.println("Quedan " + cartas.size() + " cartas en deck");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    // Seleccionar carta al azar y removerla
    public void pick() {
        if (!cartas.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(cartas.size());
            Card carta = cartas.remove(index);
            System.out.println(carta.toString());
            System.out.println("Quedan " + cartas.size() + " cartas en deck");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    // Regresar 5 cartas y removerlas
    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.remove(0);
                System.out.println(carta.toString());
            }
            System.out.println("Quedan " + cartas.size() + " cartas en deck");
        } else {
            System.out.println("No hay suficientes cartas en el deck.");
        }
    }
}

// Clase principal
public class PokerGame {
    public static void main(String[] args) {
        Deck deck = new Deck();

        // Probar funcionalidades
        deck.shuffle();   // Mezclar
        deck.head();      // Primera carta
        deck.pick();      // Carta aleatoria
        deck.hand();      // Mano de 5 cartas
    }
}

}

