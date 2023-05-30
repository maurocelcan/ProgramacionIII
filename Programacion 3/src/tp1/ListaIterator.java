package tp1;

import java.util.Iterator;

public class ListaIterator<T> implements Iterator<T> {

	Node<T> current;
	
	public ListaIterator(Node<T> current) {
		this.current = current;
	}
	
	@Override
	public boolean hasNext() {
		return this.current != null;
	}

	@Override
	public T next() {
		Node<T> tmp = this.current;
		this.current = tmp.getNext();
		return tmp.getInfo();
	}
	
	public T getInfoCurrent() {
		Node<T> tmp = this.current;
		return tmp.getInfo();
	}

}
