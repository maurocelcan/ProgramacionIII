package tp2arboles;

public class Main {

	public static void main(String[] args) {
		TreeWithNode t1 = new TreeWithNode();
		t1.add(5);
		t1.add(3);
		t1.add(6);
		t1.add(8);
		t1.add(39393);
		t1.add(7);
		
		t1.getHeight();
		System.out.println(t1.getRoot().getValue());
		System.out.println(t1.getMaxElem());
		
	}

}
