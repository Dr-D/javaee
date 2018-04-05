package chapter3;

public class TwoThreadAlive2 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			printMsg();
		}
	}
	
	private void printMsg() {
		// get a reference to the thread running this
		Thread t = Thread.currentThread();
    	System.out.printf("name='%s'\n", t.getName());
	}

	public static void main(String[] args) throws InterruptedException {
		TwoThreadAlive2 tt = new TwoThreadAlive2();
		tt.setName("my worker thread");
		
		System.out.printf("before start(), tt.isAlive()='%s'\n", 
				String.valueOf(tt.isAlive()));
		
		tt.start();
		System.out.printf("just after start(), tt.isAlive()='%s'\n", 
				String.valueOf(tt.isAlive()));
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
		
		// similar to what tt.join(); does
		while(tt.isAlive()) { /* loop until isAlive returns false */ }

		System.out.printf("at end of main(), tt.isAlive()='%s'\n", 
				String.valueOf(tt.isAlive()));
	}
}
