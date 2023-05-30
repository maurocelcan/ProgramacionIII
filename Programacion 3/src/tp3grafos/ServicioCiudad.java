package tp3grafos;
import java.util.*;
// EJERCICIO 7
public class ServicioCiudad<T> {
	
	private Grafo<T> grafo;

    public ServicioCiudad(Grafo<T> grafo) {
        this.grafo = grafo;
    }
  
    public List<Integer> obtenerCaminoMasCorto(int esquinaInicio, int esquinaFin) {
        // Verificar si las esquinas de inicio y fin existen en el grafo
        if (!grafo.contieneVertice(esquinaInicio) || !grafo.contieneVertice(esquinaFin)) {
            throw new IllegalArgumentException("Las esquinas de inicio y fin no existen en el grafo.");
        }

        // Estructuras de datos para realizar la búsqueda en anchura
        Queue<Integer> cola = new LinkedList<>(); // Cola para el recorrido en anchura
        Map<Integer, Integer> distancias = new HashMap<>(); // Mapa de distancias mínimas desde la esquina de inicio
        Map<Integer, Integer> predecesores = new HashMap<>(); // Mapa de predecesores en el camino más corto

        // Inicializar las distancias con un valor infinito, excepto para la esquina de inicio que se inicializa en 0
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int esquina = vertices.next();
            distancias.put(esquina, Integer.MAX_VALUE);
        }
        distancias.put(esquinaInicio, 0);

        // Agregar la esquina de inicio a la cola
        cola.offer(esquinaInicio);

        // Aplicar el algoritmo de búsqueda en anchura
        while (!cola.isEmpty()) {
            int esquinaActual = cola.poll();

            // Obtener las esquinas adyacentes a la esquina actual
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(esquinaActual);

            // Actualizar las distancias y predecesores de las esquinas adyacentes
            while (adyacentes.hasNext()) {
                int esquinaAdyacente = adyacentes.next();

                // Si la esquina adyacente no ha sido visitada, se actualiza la distancia y el predecesor
                if (!distancias.containsKey(esquinaAdyacente)) {
                    distancias.put(esquinaAdyacente, distancias.get(esquinaActual) + 1); // Se asume que todas las calles tienen distancia 1
                    predecesores.put(esquinaAdyacente, esquinaActual);
                    cola.offer(esquinaAdyacente);
                }
            }
        }

        // Reconstruir el camino más corto desde la esquina de inicio hasta la esquina de fin
        List<Integer> caminoMasCorto = new ArrayList<>();
        int esquinaActual = esquinaFin;
        while (esquinaActual != esquinaInicio) {
            caminoMasCorto.add(0, esquinaActual);
            esquinaActual = predecesores.get(esquinaActual);
        }
        caminoMasCorto.add(0, esquinaInicio);
        return caminoMasCorto;
    }
}
