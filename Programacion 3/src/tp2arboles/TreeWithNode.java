package tp2arboles;

import java.util.ArrayList;
import java.util.List;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	
	
	public boolean delete(Integer value) {
	    TreeNode current = root;
	    TreeNode parent = root;
	    boolean isLeftChild = true;

	    // Buscar el nodo a eliminar
	    while (current.getValue() != value) {
	        parent = current;
	        if (value < current.getValue()) {
	            isLeftChild = true;
	            current = current.getLeft();
	        } else {
	            isLeftChild = false;
	            current = current.getRight();
	        }
	        if (current == null) {
	            // El valor no está en el árbol
	            return false;
	        }
	    }

	    // Paso 1 y 2: Determinar si el nodo a eliminar tiene hijos y cuántos tiene
	    if (current.getLeft() == null && current.getRight() == null) {
	        // El nodo a eliminar no tiene hijos
	        if (current == root) {
	            root = null; // El árbol está vacío
	        } else if (isLeftChild) {
	            parent.setLeft(null); // El nodo a eliminar es un hijo izquierdo
	        } else {
	            parent.setRight(null); // El nodo a eliminar es un hijo derecho
	        }
	    } else if (current.getRight() == null) {
	        // El nodo a eliminar tiene un hijo izquierdo
	        if (current == root) {
	            root = current.getLeft(); // El nodo a eliminar es la raíz
	        } else if (isLeftChild) {
	            parent.setLeft(current.getLeft()); // El nodo a eliminar es un hijo izquierdo
	        } else {
	            parent.setRight(current.getLeft()); // El nodo a eliminar es un hijo derecho
	        }
	    } else if (current.getLeft() == null) {
	        // El nodo a eliminar tiene un hijo derecho
	        if (current == root) {
	            root = current.getRight(); // El nodo a eliminar es la raíz
	        } else if (isLeftChild) {
	            parent.setLeft(current.getRight()); // El nodo a eliminar es un hijo izquierdo
	        } else {
	            parent.setRight(current.getRight()); // El nodo a eliminar es un hijo derecho
	        }
	    } else {
	        // El nodo a eliminar tiene dos hijos
	        TreeNode successor = getSuccessor(current);
	        current.setValue(successor.getValue());
	        delete(successor.getValue());
	    }
	    return true;
	}

	// Método auxiliar para encontrar el sucesor de un nodo
	private TreeNode getSuccessor(TreeNode node) {
	    TreeNode current = node.getRight();
	    TreeNode parent = node;
	    TreeNode successor = node;
	    while (current != null) {
	        parent = successor;
	        successor = current;
	        current = current.getLeft();
	    }
	    if (successor != node.getRight()) {
	        parent.setLeft(successor.getRight());
	        successor.setRight(node.getRight());
	    }
	    return successor;
	}
	
	//O(H)-> H es la altura del arbol
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	


	
	
	
	//O(1)
	public TreeNode getRoot() {
		return this.root;
	}
	
	//O(H) -> H es la altura del arbol
	public boolean hasElement(Integer value) {
		return hasElement(this.root, value);
	}
	
	private boolean hasElement(TreeNode actual, Integer value) {
		if(actual == null) {
			return false;
		}
		if(actual.getValue().equals(value)) {
			return true;
		}
		if(actual.getValue() > value) {
			return hasElement(actual.getLeft(), value);
		}else {
			return hasElement(actual.getRight(), value);
		}
	}
	
	//O(1)
	public boolean isEmpty() {
		if(this.root != null) {
			return false;
		}
		return true;
	}
	
	
	//O(N)
	public int getHeight() {
		return getHeight(this.root);
	}
	private int getHeight(TreeNode actual) {
		if (actual == null) { // caso base
			return 0;
	    }
		int leftHeight = getHeight(actual.getLeft());
        int rightHeight = getHeight(actual.getRight());
        return 1 + Math.max(leftHeight, rightHeight); // La altura es la máxima altura de sus hijos más 1 (la altura del propio nodo)
	}
	
	//O(N)
	public void printPosOrder() {
		if (this.root == null) {
	        return;
	    }else {
	    	 printPosOrder(this.root);
	    }
	}
	private void printPosOrder(TreeNode actual) {
		if(actual.getLeft() != null) {
			printPosOrder(actual.getLeft());
		}
		if(actual.getRight() != null) {
		    printPosOrder(actual.getRight());
		}
		System.out.print(actual.getValue() + " ");
	}
	
	
	//O(N)
	public void printPreOrder() {
		if (this.root == null) {
	        return;
	    }else {
	    	printPreOrder(this.root);
	    }
	}
	private void printPreOrder(TreeNode actual) {
		System.out.print(actual.getValue() + " ");
		if(actual.getLeft() != null) {
			printPosOrder(actual.getLeft());
		}
		if(actual.getRight() != null) {
		    printPosOrder(actual.getRight());
		}
		
	}
	
	
	//O(N)
	public void printEnOrder() {
		if (this.root == null) {
	        return;
	    }else {
	    	printEnOrder(this.root);
	    }
	}
	private void printEnOrder(TreeNode actual) {
		if(actual.getLeft() != null) {
			printPosOrder(actual.getLeft());
		}
		System.out.print(actual.getValue() + " ");
		if(actual.getRight() != null) {
		    printPosOrder(actual.getRight());
		}
	}
	
	// método para obtener la lista de la rama más larga del árbol
	//O(N)
	public List<Integer> getLongestBranch(){
		List<Integer> result = new ArrayList<Integer>();
        getLongestBranchHelper(root, result);
        return result;
	}
	
	 private void getLongestBranchHelper(TreeNode node, List<Integer> branch) {
	        if (node == null) {
	        	 // si el nodo es null, entonces se ha llegado al final de la rama
	            return;
	        }
	        
	        // agregamos el valor del nodo actual a la rama
	        branch.add(node.getValue());
	        
	        if (node.getLeft() == null && node.getRight() == null) {
	            return;
	        }
	        
	        // hacemos la recursión por la rama izquierda y derecha
	        List<Integer> leftBranch = new ArrayList<Integer>(branch);
	        List<Integer> rightBranch = new ArrayList<Integer>(branch);
	        getLongestBranchHelper(node.getLeft(), leftBranch);
	        getLongestBranchHelper(node.getRight(), rightBranch);
	        
	        // comparamos las longitudes de las ramas izquierda y derecha para ver cuál es más larga
	        if (leftBranch.size() >= rightBranch.size()) {
	            branch.clear();
	            branch.addAll(leftBranch);
	        } else {
	            branch.clear();
	            branch.addAll(rightBranch);
	        }
	    }
	 
	 
	 
	 public List<Integer> getFrontera() {
		    List<Integer> frontera = new ArrayList<>();
		    getFronteraHelper(this.root, frontera);
		    return frontera;
		}

	private void getFronteraHelper(TreeNode node, List<Integer> frontera) {
		    if (node == null) {
		        return;
		    }

		    if (node.getLeft() == null && node.getRight() == null) {
		        // Si es una hoja, agregamos su valor a la frontera
		        frontera.add(node.getValue());
		    } else {
		        // Si no es una hoja, hacemos la recursión en sus subárboles izquierdo y derecho
		        getFronteraHelper(node.getLeft(), frontera);
		        getFronteraHelper(node.getRight(), frontera);
		    }
		}
		
		
		
		//O(H)
	public Integer getMaxElem() {
		    if (this.root == null) {
		        return null;
		    } else {
		        return getMaxElem(this.root);
		    }
		}

	private Integer getMaxElem(TreeNode node) {
		    if (node.getRight() == null) {
		        // Si no hay subárbol derecho, el nodo actual es el máximo
		        return node.getValue();
		    } else {
		        // Si hay subárbol derecho, busca en ese subárbol
		        return getMaxElem(node.getRight());
		    }
		}
		
	public List<Integer> getElemAtLevel(int level) {
		    List<Integer> elems = new ArrayList<>();
		    getElemAtLevelHelper(this.root, level, 1, elems);
		    return elems;
		}

	private void getElemAtLevelHelper(TreeNode node, int level, int currentLevel, List<Integer> elems) {
		    if (node == null) {
		        return;
		    }
		    if (currentLevel == level) {
		        elems.add(node.getValue());
		    } else {
		        getElemAtLevelHelper(node.getLeft(), level, currentLevel + 1, elems);
		        getElemAtLevelHelper(node.getRight(), level, currentLevel + 1, elems);
		    }
		}
	
	
		
		
	//EJERCICIO 2
	public int sumaNodosInternos() {
			return sumaNodosInternos(this.root);
		}
	private int sumaNodosInternos(TreeNode actual) {
			 if (actual == null || (actual.getLeft() == null && actual.getRight() == null)) {
				 return 0;
			 }else {
				 return actual.getValue() + sumaNodosInternos(actual.getLeft()) + sumaNodosInternos(actual.getRight());
			 }
		}
	
	
		
	
		//EJERCICIO 3
	public List<Integer> obtenerHojasConValoresMayorA(int k){
			List<Integer> result = new ArrayList<>();
			 if (this.root == null) {
				 return result;
			 }
			 obtenerHojasConValoresMayorAHelper(this.root, k, result);
			 return result;
			 
		}
	private void obtenerHojasConValoresMayorAHelper(TreeNode actual, int k, List<Integer> result) {
			if (actual == null) {
		        return;
		    }
			if (actual.getLeft() == null && actual.getRight() == null && actual.getValue() > k) {
				result.add(actual.getValue());
			}
			obtenerHojasConValoresMayorAHelper(actual.getLeft(), k, result);
			obtenerHojasConValoresMayorAHelper(actual.getRight(), k, result);
		}
		
		
		
		//EJERCICIO 4
	public void rellenarNodosInternos() {
			if (this.root == null) {
	            return;
	        }
			rellenarNodosInternosHelper(this.root);
		}
		
	private void rellenarNodosInternosHelper(TreeNode node) {
			if (node == null) {
		        return;
		    }
		    if (node.getLeft() == null && node.getRight() == null) {
		        return;
		    }
		    rellenarNodosInternosHelper(node.getLeft());
		    rellenarNodosInternosHelper(node.getRight());
		    				
		    int leftValue = (node.getLeft() == null) ? 0 : node.getLeft().getValue();
		    int rightValue = (node.getRight() == null) ? 0 : node.getRight().getValue();
		    node.setValue(rightValue - leftValue);
		}
		
		
		
	//EJERCICIO 5
	public List<String> buscarPalabrasConNVocales(int n) {
	        List<String> palabras = new ArrayList<>();
	        buscarPalabrasConNVocalesDFS(this.root, "", 0, n, palabras);
	        return palabras;
	    }
	private void buscarPalabrasConNVocalesDFS(TreeNode nodo, String palabraActual, int numVocales, int n, List<String> palabras) {
	        if (nodo == null) {
	            return;
	        }

	        palabraActual += nodo.getValue();
	        if (esVocal(nodo.getValue())) {
	            numVocales++;
	        }

	        if (nodo.getLeft() == null && nodo.getRight() == null) {
	            if (numVocales == n) {
	                palabras.add(palabraActual);
	            }
	        }else {
	            buscarPalabrasConNVocalesDFS(nodo.getLeft(), palabraActual, numVocales, n, palabras);
	            buscarPalabrasConNVocalesDFS(nodo.getRight(), palabraActual, numVocales, n, palabras);
	        }
	    }
	private boolean esVocal(char c) {
	        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	    }
		
		
		//EJERCICIO 6
		/*1: 
		 *Para almacenar todos los libros utilizaria un arbol binario de busqueda en el cual cada clave haga referencia a un libro.
		 *La complejidad computacional de la busqueda de un libro seria O(log2N), lo cual seria bastante eficiente.
		 *
		 *2:
		 *Primer servicio:
		 *Para resolver el primer servicio se puede almacenar una variable cantEjemplares dentro de cada libro la cual una vez encontrado
		 *el libro a traves de su clave, solo habria que preguntarle a traves de un getCantEjempleres() cuantos tiene del mismo.
		 *La complejidad de este servicio seria o(log2N)
		 *
		 *Segundo servicio:
		 *Para el segundo servicio veo 2 maneras de resolverlo, si se utiliza el mismo arbol que el servicio anterior entonces se deberia recorrer
		 *todos los nodos, preguntarle su genero, almacenarlos en una lista y finalmente retornarla.
		 *Sino se podria hacer una lista de factoreo la cual dentro del arbol se almacenarian todos los generos y al encontrar el genero deseado,dentro
		 *tendria una lista asociada con todos los libros de ese genero, pero para eso se deberia crear otro arbol.
		 *
		 *Tercer servicio:
		 *Para el tercer servicio se puede hacer lo mismo que en el servicio anterior, hacer una lista de factoreo la cual cada clave sea la fecha de publicacion
		 *y en base a eso recorrer el arbol binario de busqueda. Si la raiz esta en el rango dado se agrega, sino se busca en el subarbol izquierdo o el derecho.
		 *En este caso la complejidad seria O(log2N), siempre y cuando el arbol este balanceado.
		 *
		 * */
		
		
		

}
		

	
	
	
	
	

