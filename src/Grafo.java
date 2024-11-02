import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grafo implements TDA_Grafo{
    private List<List<Arista>> adyacencia; // Lista de adyacencia

    public Grafo() {
        adyacencia = new ArrayList<>();
    }

    public void agregarVertice(){
        adyacencia.add(new ArrayList<>());
    }


    public void eliminarVertice(int vertice) {
        if (vertice < adyacencia.size()) {
            adyacencia.set(vertice, new ArrayList<>());

            for(List<Arista> aristas : adyacencia) {
                aristas.removeIf(arista -> arista.destino == vertice);
            }
        }

    }
    public void agregarArista(int origen, int destino, int peso) {
        while(origen >= adyacencia.size() || destino >= adyacencia.size()) {
            agregarVertice();
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adyacencia.size(); i++) {
            sb.append("Nodo ").append(i).append(" -> ");
            List<Arista> aristas = adyacencia.get(i);
            for (Arista arista : aristas) {
                sb.append("[").append(arista.destino).append(", peso: ").append(arista.peso).append("] ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
