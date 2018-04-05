package chapter3;

public class TwoThreadSetName extends Thread {
	
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
		TwoThreadSetName tt = new TwoThreadSetName();
		tt.setName("my worker thread");
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
	}
}
