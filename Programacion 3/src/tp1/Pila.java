package tp1;

public class Pila<T> {

	private MySimpleLinkedList<T> lista;
	int size;
	
	public Pila(MySimpleLinkedList<T> lista) {
		this.lista = lista;
		this.size = this.lista.size();
	}
	
	public void push(T o) {
		lista.insertFront(o);
	}
	
	public T pop() {
		T tmp = lista.extractFront();
		return tmp;
	}
	
	public T top() {
		return lista.get(size);
	}
	
	public void reverse() {
		MySimpleLinkedList<T> listTmp = new MySimpleLinkedList<T>();
		while(!this.lista.isEmpty()) {
			T infoTmp = lista.extractFront();
			listTmp.insertFront(infoTmp);
		}
		this.lista = listTmp;
	}
}
