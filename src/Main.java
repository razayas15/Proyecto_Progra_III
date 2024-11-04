import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CaminoNoEncontradoException {
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
        G.agregarArista(shark.getId(), escuelaN2.getId(), 5);
        G.agregarArista(escuelaN2.getId(), fox.getId(), 10);

        //Camino 2, prueba de escuela1 id = 1 hasta gym FOX id = 7:
        G.agregarArista(escuelaN1.getId(), city.getId(), 3);
        G.agregarArista(city.getId(), escuelaN3.getId(), 7);
        G.agregarArista(escuelaN3.getId(), fox.getId(), 3);

        //Camino 3, prueba que sea directo:
        G.agregarArista(escuelaN1.getId(), fox.getId(), 5);

        //Camino 4, al reves de FOX id = 7 hacia la escuela 1 id = 1
        G.agregarArista(fox.getId(), escuelaN2.getId(), 3);
        G.agregarArista(escuelaN2.getId(), city.getId(), 3);
        G.agregarArista(city.getId(), escuelaN1.getId(), 1);

        G.imprimirMatriz();

        try {
            ArrayList<Vertice> caminoMinimo = G.encontrarCaminoMinimo(1, 7);
            System.out.print("Camino mínimo: ");
            for (Vertice vertice : caminoMinimo) {
                System.out.print(vertice.getId() + " ");
            }
            System.out.println();
            int pesoTotal = G.calcularPesoTotal(caminoMinimo);
            System.out.println("Peso total del camino: " + pesoTotal);

        } catch (CaminoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            ArrayList<Vertice> caminoMinimo = G.encontrarCaminoMinimo(7, 1);
            System.out.print("Camino mínimo: ");
            for (Vertice vertice : caminoMinimo) {
                System.out.print(vertice.getId() + " ");
            }
            System.out.println();
            int pesoTotal = G.calcularPesoTotal(caminoMinimo);
            System.out.println("Peso total del camino: " + pesoTotal);

        } catch (CaminoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
