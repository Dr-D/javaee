package chapter3;

public class TwoThread extends Thread {
	
	Thread creatorThread;
	
	public TwoThread() {
		// make a note of the thread that constructed me
		creatorThread = Thread.currentThread();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			printMsg();
		}
	}
	
	private void printMsg() {
		// get a reference to the thread running this
		Thread t = Thread.currentThread();
		
		if (t.equals(creatorThread)) {
			System.out.printf("Creator thread\n");
		} else if ( t.equals(this)) {
			System.out.printf("New thread\n");
		} else {
			System.out.printf("Mystery thread - unexpected!\n");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TwoThread tt = new TwoThread();
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
	}
}
