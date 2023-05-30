package tp1;

import java.util.Iterator;

	public class ElementosComunes<T>{
		
		public ElementosComunes() {
			
		}
		//Ejercicio 6
		/*public MySimpleLinkedList<T> elementosEnComunListasOrdenadas(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
			Iterator<T> iteratorL1 = l1.iterator();
			Iterator<T> iteratorL2First = l2.iterator();
			MySimpleLinkedList<T> lista = new MySimpleLinkedList<T>();
			while(iteratorL1.hasNext()) {
				T infoL1 = iteratorL1.next();
				Iterator<T> iteratorL2Tmp = l2.iterator();
				while(iteratorL2Tmp.hasNext()) {
					T infoL2 = iteratorL2Tmp.next();
					if(infoL1.equals(infoL2) ) {
						lista.insertFront(infoL1);
					}
				}
				iteratorL2Tmp = iteratorL2First;
			}
			return lista;
		}*/
		
		public MySimpleLinkedList<T> elementosEnComunListasDesOrdenadas(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
			Iterator<T> iteratorL1 = l1.iterator();
			Iterator<T> iteratorL2First = l2.iterator();
			MySimpleLinkedList<T> lista = new MySimpleLinkedList<T>();
			while(iteratorL1.hasNext()) {
				T infoL1 = iteratorL1.next();
				Iterator<T> iteratorL2Tmp = l2.iterator();
				while(iteratorL2Tmp.hasNext()) {
					T infoL2 = iteratorL2Tmp.next();
					if(infoL1.equals(infoL2) ) {
						lista.insertarOrdenado(infoL1);
					}
				}
				iteratorL2Tmp = iteratorL2First;
			}
			return lista;
		}
		
		
		//Ejercicio 6 A --> IMPLEMENTADO CON LA EXPLICACION HECHA EN CLASE (5/4);
		// COMPLEJIDAD COMPUTACIONAL --> O(N);
		public MySimpleLinkedList<T> elementosEnComunListasOrdenadas(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
			ListaIterator<T> iteratorL1 = l1.iterator();
			ListaIterator<T> iteratorL2 = l2.iterator();
			MySimpleLinkedList<T> lista = new MySimpleLinkedList<T>();
			while(iteratorL1.hasNext()) {
				while(iteratorL2.hasNext()) {
					T infoL1 = iteratorL1.getInfoCurrent();
					T infoL2 = iteratorL2.getInfoCurrent();
					if(infoL1 < infoL2) {
						infoL1 = iteratorL1.next();
					}
					if(infoL2 < infoL1) {
						infoL2 = iteratorL2.next();
					}
					if(infoL1.equals(infoL2)) {
						lista.insertFront(infoL1);
						infoL1 = iteratorL1.next();
						infoL2 = iteratorL2.next();
					}
				}
				
			}
			return lista;
		}
		
		//Ejercicio 7 
		
		public MySimpleLinkedList<T> elementosPrimeraLista(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
			ListaIterator<T> iteratorL1 = l1.iterator();
			ListaIterator<T> iteratorL2First = l2.iterator();
			MySimpleLinkedList<T> lista = new MySimpleLinkedList<T>();
			while(iteratorL1.hasNext()) {
				T infoL1 = iteratorL1.getInfoCurrent();
				ListaIterator<T> iteratorL2 = l2.iterator();
				while(iteratorL2.hasNext()) {
					T infoL2 = iteratorL2.getInfoCurrent();
					if(!infoL1.equals(infoL2)) {
						lista.insertFront(infoL1);
					}
				}
				iteratorL2 = iteratorL2First;
			}
			return lista;
		}
		
		


}
