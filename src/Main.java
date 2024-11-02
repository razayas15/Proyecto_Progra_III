import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Los vértices que corresponden a las escuelas
        Vertice escuelaN1 = new Vertice(1);
        Vertice escuelaN2 = new Vertice(2);
        Vertice escuelaN3 = new Vertice(3);

        // Los gimnasios que son de la misma clase de Vertice
        Vertice shark = new Vertice(6); // Gimnasio
        Vertice fox = new Vertice(7); // Gimnasio
        Vertice city = new Vertice(8); // Gimnasio

        // Creamos el grafo
        GrafoDirigido G = new GrafoDirigido();
        G.agregarVertice(escuelaN1);
        G.agregarVertice(escuelaN2);
        G.agregarVertice(escuelaN3);
        G.agregarVertice(shark);
        G.agregarVertice(fox);
        G.agregarVertice(city);

        // Agregamos las aristas entre los vértices y su dirección:
        G.agregarArista(escuelaN1.getId(), shark.getId(), 23);
        G.agregarArista(escuelaN2.getId(), fox.getId(), 10);
        G.agregarArista(escuelaN1.getId(), escuelaN3.getId(), 5);
        G.agregarArista(escuelaN3.getId(), city.getId(), 15);
        G.agregarArista(fox.getId(), escuelaN2.getId(), 12);

        G.imprimirMatriz();

        ArrayList<Vertice> caminoMinimo = G.encontrarCaminoMinimo(1, 7);
        System.out.println("Camino mínimo encontrado desde 1 a 7:");
        for (Vertice v : caminoMinimo) {
            System.out.print(v.getId() + " ");
        }
        System.out.println();
    }
}
