public class HelloWorld extends Thread{

	private int id;
	private static int cpt  = 1;
	private static final Object mutex = new Object();

	public HelloWorld() {
		synchronized(mutex){
			id =cpt++;
		}
	}
	public void run() {
		System.out.println("Hello World");
	}
}