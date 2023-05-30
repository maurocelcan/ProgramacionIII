package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	
	public T extractFront() {		
		if(this.first != null) {
			Node<T> tmp = this.first;
			this.first = tmp.getNext();
			size--;
			return tmp.getInfo();
		}
		return null;
	}

	public boolean isEmpty() {
		if(this.first == null) {
			return true;
		}
		return false;
	}
	
	//La lista empieza en 1
	public T get(int index) {
		if(this.first != null) {
			Node<T> tmp = this.first;
			for(int i=1;i<=index;i++) {
				if(i==index) {
					return tmp.getInfo();
				}
				tmp = tmp.getNext();
			}
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String string = "";
		int i = 1;
		Node<T> tmp = this.first;
		while(i <= this.size()) {
			string += tmp.getInfo();
			tmp = tmp.getNext();
			i++;
		}
		return string;
	}
	
	public int indexOf(T elemento) {
		int i = 1;
		Node<T> tmp = this.first;
		while(tmp.getInfo() != elemento) {
			i++;
			tmp = tmp.getNext();
		}
		if(tmp.getInfo().equals(elemento)) {
			return i;
		}
		return -1;
	}

	@Override
	public ListaIterator<T> iterator() {
        return new ListaIterator<T>(this.first);
    }
	
	public void insertarOrdenado(T info) {
		Node<T> tmp = new Node<T>(info,null);
		Node<T> current = this.first;
		if(this.first != null) {
			if(info<this.first.getInfo()) {
				this.first = tmp;
				tmp.setNext(first);
			}else {
				while(info>current.getInfo() || current.getNext() != null) {
					current = current.getNext();	
				}
				if(current.getNext()==null) {
					current.setNext(tmp);
				}else {
					Node<T> next = current.getNext();
					current.setNext(tmp);
					tmp.setNext(next);
				}
			}
		}
		this.first = tmp;
	}
	

}
