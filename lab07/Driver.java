public class Driver {
	public static void main(String[] args) {
		Runnable r = new B();
		Thread t1 = new Thread(r);
		Thread t2 = new A();
		t1.start();
		t2.start();
	}
}
