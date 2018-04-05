package chapter2;


public class TwoThread extends Thread {
	
	public static void main(String[] args) throws InterruptedException {
		TwoThread tt = new TwoThread();
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("Main thread\n");
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("New thread\n");
		}
	}
}
