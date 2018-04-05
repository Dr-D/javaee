package chapter3;

public class TwoThreadGetName extends Thread {
	
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
		TwoThreadGetName tt = new TwoThreadGetName();
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
	}
}
