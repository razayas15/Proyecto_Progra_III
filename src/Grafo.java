import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grafo implements TDA_Grafo{
    private Map<Integer, List<Arista>> adyacencia;

    public Grafo(){
        adyacencia = new HashMap<>();
    }



    public void agregarVertice(int vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());

    }
    public void eliminarVertice(int vertice) {
        if (adyacencia.containsKey(vertice)) {
            adyacencia.remove(vertice);

            for(List<Arista> aristas : adyacencia.values()) {
                aristas.removeIf(arista -> arista.destino == vertice);
            }
        }

    }
    public void agregarArista(int origen, int destino, int peso) {
        agregarVertice(origen);
        agregarVertice(destino);
        adyacencia.get(origen).add(new Arista(destino, peso));

    }
    public void eliminarArista(int origen, int destino) {
        List<Arista> aristasOrigen = adyacencia.get(origen);
        if (aristasOrigen != null) {
            aristasOrigen.removeIf(arista -> arista.destino == destino);
        }

    }
    public boolean GrafoVacio() {
        return false;
    }
    public List<Integer> obtenerAdyacentes(int vertice) {
        return null;
    }
}
