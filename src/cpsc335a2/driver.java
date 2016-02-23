package cpsc335a2;

public class driver {

	public static void main(String[] args) {
		Bnode node = new Bnode();
		
		node.insert(7);
		node.insert(3);
		node.insert(5);
		node.insert(1);
		

		node.print();
	}

}
