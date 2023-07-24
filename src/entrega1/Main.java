package entrega1;

import java.util.Iterator;
import java.util.List;

public class Main {

	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		
		grafo.agregarArco(3, 4, null);
		grafo.agregarArco(4, 5, null);
		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(2, 3, null);
		
		System.out.println("Vertices del grafo");
		//obtenerVertices()
		Iterator<Integer> vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			System.out.print(vertices.next() + " ");
		}
		
		System.out.println(" ");
		
		//obtenerArcos()
		System.out.println("Arcos del grafo");
		Iterator<Arco<T>> arcos = grafo.obtenerArcos();
		
		while(arcos.hasNext()) {
			System.out.println(arcos.next());
		}
		//ObtenerAdyacentes()
		Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(2);
		System.out.println("Adyacentes a vertice 2");
		while(itAdyacentes.hasNext()) {
			System.out.println(itAdyacentes.next() + " ");
		}
		
		System.out.println("Vertices del grafo");
		//obtenerVertices()
		vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			System.out.print(vertices.next() + " ");
		}
		
		System.out.println(" ");
//		//existeArco() borrarArco()
//		System.out.println("Existe arco 1, 3: " + grafo.existeArco(1, 3));
//		grafo.borrarArco(1, 3);
//		System.out.println("Existe arco 1, 3: " + grafo.existeArco(1, 3));
		
		//agregarArco()
		grafo.agregarArco(1, 4, null);
		

		
		//contieneVertice() borrarVertice()
		System.out.println("Contiene vertice 4 = " + grafo.contieneVertice(4));
		grafo.borrarVertice(4);
		
		System.out.println("Borro vertice 4");
		
		System.out.println("Contiene vertice 4 = " + grafo.contieneVertice(4));
		
		System.out.println("Vertices del grafo");
		//obtenerVertices()
		vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			System.out.print(vertices.next() + " ");
		}
		
		System.out.println(" ");
		
		System.out.println("Cant vertices: " + grafo.cantidadVertices() +  " cant arcos:" +  grafo.cantidadArcos());
		
		System.out.println("Arcos del grafo despues de borrar vertice 4");
		Iterator<Arco<T>> arcos2 = grafo.obtenerArcos();
		
		while(arcos2.hasNext()) {
			System.out.println(arcos2.next());
		}
		
		
		

//		ServicioDFS<T> dfs = new ServicioDFS<>(grafo);
//		System.out.println("Recorrido DFS: ");
//		System.out.println(dfs.DFS());
//		
//		System.out.println("Recorrido BFS: ");
//		ServicioBFS<T> bfs = new ServicioBFS<>(grafo);
//		System.out.println(bfs.BFS());
		System.out.println("");
		System.out.println("<---------------------------------------------->");
		System.out.println("SERVICIOS:");
		
		GrafoDirigido<T> grafo2 = new GrafoDirigido<>();
		grafo2.agregarVertice(1);
		grafo2.agregarVertice(2);
		grafo2.agregarVertice(3);
		grafo2.agregarVertice(4);
		grafo2.agregarVertice(5);
		grafo2.agregarVertice(6);
		grafo2.agregarVertice(7);
		
		grafo2.agregarArco(1, 2, null);
		grafo2.agregarArco(1, 3, null);
		grafo2.agregarArco(2, 5, null);
		grafo2.agregarArco(3, 4, null);
		grafo2.agregarArco(4, 5, null);
		grafo2.agregarArco(4, 5, null);
		grafo2.agregarArco(5, 6, null);
		grafo2.agregarArco(5, 7, null);
		grafo2.agregarArco(5, 1, null);
		
		System.out.println("Servicio DFS");
		ServicioDFS dfs = new ServicioDFS(grafo2);
		System.out.println(dfs.dfsForest());
		
		System.out.println("Servicio BFS");
		ServicioBFS bfs = new ServicioBFS(grafo2);
		System.out.println(bfs.bfsForest());
		
		Grafo<T> grafo3 = new GrafoDirigido<>();
		
		grafo3.agregarVertice(1);
		grafo3.agregarVertice(2);
		grafo3.agregarVertice(3);
		grafo3.agregarVertice(4);
		grafo3.agregarVertice(5);
		grafo3.agregarVertice(6);
		grafo3.agregarVertice(7);
		
		grafo3.agregarArco(1, 5, null);
		grafo3.agregarArco(2, 1, null);
		grafo3.agregarArco(2, 3, null);
		grafo3.agregarArco(3, 4, null);
		grafo3.agregarArco(3, 1, null);
		grafo3.agregarArco(4, 6, null);
		grafo3.agregarArco(4, 5, null);
		grafo3.agregarArco(5, 6, null);
		grafo3.agregarArco(6, 7, null);
		
		
		System.out.println("Servicio Caminos");
		ServicioCaminos caminos = new ServicioCaminos(grafo3, 2, 5, 5);
		List<List<Integer>> listaCaminos = caminos.caminos();
		for(List<Integer> lista: listaCaminos) {
			System.out.println(lista);
		}
		

	}

}