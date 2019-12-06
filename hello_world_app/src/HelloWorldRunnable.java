public class HelloWorldRunnable implements Runnable{

	private int id;
	private static int cpt  = 1;
	private static final Object mutex = new Object();


	public HelloWorldRunnable() {
		synchronized(mutex){
			id =cpt++;
		}
	}

	public void run() {
		System.out.println("thread " + id + " salue " );
	}
}