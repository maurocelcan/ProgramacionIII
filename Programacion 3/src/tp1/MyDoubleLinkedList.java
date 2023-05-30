package tp1;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {

	private NodeDouble<T> first;
    private int size;

    public MyDoubleLinkedList() {
        this.first = null;
        this.size = 0;
    }
    
    public void insertFront(T info) {
    	NodeDouble<T> newNode = new NodeDouble<T>(info, null, null);
    	if(this.first == null) {
    		this.first = newNode;
    	}else {
    		this.first.setPrev(newNode);
    		newNode.setNext(this.first);
    		this.first = newNode;
    		
    	}
    	this.size++;
    }

    public T extractFront() {
	   if(this.first != null) {
		   NodeDouble<T> tmp = this.first;
		   this.first = tmp.getNext();
		   this.first.setPrev(null);
		   this.size--;
		   return tmp.getInfo();
	   }
	   return null;
    }	
   
    public boolean isEmpty() {
	   if(this.first!=null) {
		  return true;
	   }
	   return false;
    }
    
    public T get(int index) {
    	if(this.first != null) {
			NodeDouble<T> tmp = this.first;
			for(int i=1;i<=index;i++) {
				if(i==index) {
					return tmp.getInfo();
				}
				tmp = tmp.getNext();
			}
		}
		return null;
	}
  
	@Override
	public String toString() {
		String string = "";
		int i = 1;
		NodeDouble<T> tmp = this.first;
		while(i <= this.size()) {
			string += tmp.getInfo();
			tmp = tmp.getNext();
			i++;
		}
		return string;
	}
   
	public int size() {
		return this.size;
	}
	
	
	public int indexOf(T elemento) {
		int i = 1;
		NodeDouble<T> tmp = this.first;
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
	public ListaDobleIterator<T> iterator() {
        return new ListaDobleIterator<T>(this.first);
    }

}
