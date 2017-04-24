import paquete.Matriz;

public class main {

	public static void main(String[] args) {
		Matriz m1 = new Matriz(2,2);
		Matriz m2 = new Matriz(2,2);
		Matriz m3 = new Matriz(2,2);
		m1.add(1,0,0);
		m1.add(2,0,1);
		m1.add(3,1,0);
		m1.add(4,1,1);
		m2.add(3,0,0);
		m2.add(4,0,1);
		m2.add(5,1,0);
		m2.add(1,1,1);
		m3= m1.product(m2);
		m3.show();
	}

}
