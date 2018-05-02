package resource;

public class Fibonacci {
	public static void main(String[] args) {
		double n1, n2;
		n1 = 1;
		n2 = 1;
		double temp;
		for (int i = 0; i < 10000; i++) {
			temp = n1 + n2;
			System.out.println(n1 / n2);
			n1 = n2;
			n2 = temp;
		}
	}
}
