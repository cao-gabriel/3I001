public class TestHelloWorld {

	static final int NB_HELLO = 10;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_GREEN = "\u001B[32m";


	public static void main(String[] args) {
		System.out.println(ANSI_GREEN);

		Thread[] hellos = new Thread[NB_HELLO];
		for(int i = 0 ; i < NB_HELLO; i++){

			/*
			//Using extends Thread
			hellos[i] = new HelloWorld();
			*/

			//Using implements Runnable
			hellos[i] = new Thread(new HelloWorldRunnable());

			hellos[i].start();
		}
		try{
			for(int i = 0 ; i < NB_HELLO; i++){
				hellos[i].join();
			}
		}catch(InterruptedException ie){
			System.out.println("WTF");
		}

		System.out.println(ANSI_RESET);

	}
}