package tp3grafos;

import java.util.*;

//EJERCICIO 5
public class ServicioCaminoHastaVertice<T> {

    private Grafo<T> grafo;

    public ServicioCaminoHastaVertice(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> obtenerVerticesConCaminoHacia(int verticeDestino) {
        List<Integer> verticesConCamino = new ArrayList<>();
        Map<Integer, Boolean> visitados = new HashMap<>();

        // Realizar la búsqueda DFS desde cada vértice
        Iterator<Integer> verticesIterador = grafo.obtenerVertices();
        while (verticesIterador.hasNext()) {
            int vertice = verticesIterador.next();
            if (!visitados.containsKey(vertice)) {
                dfs(vertice, verticeDestino, visitados, verticesConCamino);
            }
        }

        return verticesConCamino;
    }

    private boolean dfs(int verticeActual, int verticeDestino, Map<Integer, Boolean> visitados, List<Integer> verticesConCamino) {
        // Marcar el vértice actual como visitado
        visitados.put(verticeActual, true);

        // Si el vértice actual es el vértice destino, agregarlo a la lista de verticesConCamino
        if (verticeActual == verticeDestino) {
            verticesConCamino.add(verticeActual);
            return true;
        }

        // Obtener los vértices adyacentes al vértice actual
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);

        // Recorrer los vértices adyacentes
        while (adyacentes.hasNext()) {
            int verticeAdyacente = adyacentes.next();

            // Si el vértice adyacente no ha sido visitado, realizar la búsqueda DFS desde él
            if (!visitados.containsKey(verticeAdyacente)) {
                boolean encontrado = dfs(verticeAdyacente, verticeDestino, visitados, verticesConCamino);
                if (encontrado) {
                    verticesConCamino.add(verticeActual);
                    return true;
                }
            }
        }

        return false;
    }
}

