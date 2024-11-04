import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GrafoDirigido {
    private int[][] matrizAdyacencia; // Matriz de adyacencia
    private ArrayList<Vertice> vertices; // Lista para almacenar vértices
    private int numVertices; // Número actual de vértices
    public GrafoDirigido() {
        this.matrizAdyacencia = new int[0][0];
        this.vertices = new ArrayList<>();
        this.numVertices = 0;
    }
    public void agregarVertice(Vertice vertice) {
        int nuevoTamano = numVertices + 1;
        int[][] nuevaMatriz = new int[nuevoTamano][nuevoTamano];

        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, nuevaMatriz[i], 0, numVertices);
        }
        matrizAdyacencia = nuevaMatriz;

        vertices.add(vertice);
        numVertices++;
    }
    public void agregarArista(int origenId, int destinoId, int peso) {
        int origen = encontrarIndicePorId(origenId);
        int destino = encontrarIndicePorId(destinoId);

        if (origen == -1 || destino == -1) {
            System.out.println("Vértice no válido.");
            return;
        }
        matrizAdyacencia[origen][destino] = peso;
    }
    private int encontrarIndicePorId(int id) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public void eliminarArista(int origen, int destino) {
        if (origen < 0 || origen >= numVertices || destino < 0 || destino >= numVertices) {
            System.out.println("Vértice no válido.");
            return;
        }
        matrizAdyacencia[origen][destino] = 0;
    }
    public void obtenerAdyacentes(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice no válido.");
            return;
        }
        System.out.print("Vértices adyacentes a " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] != 0) {
                System.out.print(i + " (peso: " + matrizAdyacencia[vertice][i] + "), ");
            }
        }
        System.out.println();
    }
    public void imprimirMatriz() {
        System.out.println("\nMatriz de Adyacencia");
        System.out.println("---------------------");
        System.out.print("\t");
        for (Vertice v : vertices) {
            System.out.print(v.getId() + "\t");
        }
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i).getId() + "\t");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public ArrayList<Vertice> encontrarCaminoMinimo(int origenId, int destinoId) throws CaminoNoEncontradoException {
        int origen = encontrarIndicePorId(origenId);
        int destino = encontrarIndicePorId(destinoId);

        if (origen == -1 || destino == -1) {
            throw new CaminoNoEncontradoException("Vértice no válido.");
        }

        int[] distancias = new int[numVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origen] = 0;

        boolean[] visitado = new boolean[numVertices];
        int[] predecesor = new int[numVertices];
        Arrays.fill(predecesor, -1); // -1 significa que no hay predecesor

        PriorityQueue<Integer> cola = new PriorityQueue<>((a, b) -> Integer.compare(distancias[a], distancias[b]));
        cola.add(origen);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual == destino) break;
            visitado[actual] = true;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[actual][i] > 0 && !visitado[i]) {
                    int nuevaDistancia = distancias[actual] + matrizAdyacencia[actual][i];
                    if (nuevaDistancia < distancias[i]) {
                        distancias[i] = nuevaDistancia;
                        predecesor[i] = actual;
                        cola.add(i);
                    }
                }
            }
        }
        if (distancias[destino] == Integer.MAX_VALUE) {
            throw new CaminoNoEncontradoException("No hay camino entre los vértices " + origenId + " y " + destinoId);
        }

        ArrayList<Vertice> camino = new ArrayList<>();
        for (int at = destino; at != -1; at = predecesor[at]) {
            camino.add(0, vertices.get(at));
        }
        return camino;
    }

    public int calcularPesoTotal(ArrayList<Vertice> camino) {
        int pesoTotal = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            int origen = encontrarIndicePorId(camino.get(i).getId());
            int destino = encontrarIndicePorId(camino.get(i + 1).getId());
            pesoTotal += matrizAdyacencia[origen][destino];
        }
        return pesoTotal;
    }


}