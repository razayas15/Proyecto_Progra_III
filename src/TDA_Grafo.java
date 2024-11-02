import java.util.List;
public interface TDA_Grafo {
    void agregarVertice(); // Agrega un vértice al grafo
    void eliminarVertice(int vertice); // Elimina un vértice del grafo
    void agregarArista(int origen, int destino, int peso); // Agrega una arista dirigida entre dos vértices con un peso
    void eliminarArista(int origen, int destino); // Elimina una arista dirigida entre dos vértices
    boolean GrafoVacio();
    List<Integer> obtenerAdyacentes(int vertice); // Devuelve una lista de adyacencia o una lista de vértices adyacentes
}
