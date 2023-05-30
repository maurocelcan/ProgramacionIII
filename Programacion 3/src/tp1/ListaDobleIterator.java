package tp1;

import java.util.Iterator;

public class ListaDobleIterator<T> implements Iterator<T>{
	
	NodeDouble<T> first;
	
	public ListaDobleIterator(NodeDouble<T> first) {
		this.first = first;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

}
