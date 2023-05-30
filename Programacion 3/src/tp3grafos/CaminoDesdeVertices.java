package tp3grafos;

import java.util.*;


//EJERCICIO 4
public class CaminoDesdeVertices<T> {
    private Grafo<T> grafo;

    public CaminoDesdeVertices(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> encontrarVerticesHasta(int verticeInicial, int verticeFinal) {
        List<Integer> verticesHasta = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        Map<Integer, Boolean> visitados = new HashMap<>();

        dfs(verticeInicial, verticeFinal, caminoActual, visitados, verticesHasta);

        return verticesHasta;
    }

    private void dfs(int verticeActual, int verticeFinal, List<Integer> caminoActual, Map<Integer, Boolean> visitados, List<Integer> verticesHasta) {
        caminoActual.add(verticeActual);
        visitados.put(verticeActual, true);

        if (verticeActual == verticeFinal) {
            verticesHasta.addAll(caminoActual);
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);

            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();

                if (!visitados.containsKey(adyacente) || !visitados.get(adyacente)) {
                    dfs(adyacente, verticeFinal, caminoActual, visitados, verticesHasta);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.put(verticeActual, false);
    }
}
