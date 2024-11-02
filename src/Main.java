public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarVertice(); // Vertice 0
        grafo.agregarVertice(); // Vertice 1
        grafo.agregarVertice(); // Vertice 2
        grafo.agregarVertice(); // Vertice 3
        // Agregar aristas
        grafo.agregarArista(0, 1, 5);
        grafo.agregarArista(0, 2, 10);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(2, 3, 1);

        System.out.println("Grafo inicial:");
        System.out.println(grafo);

    }
}