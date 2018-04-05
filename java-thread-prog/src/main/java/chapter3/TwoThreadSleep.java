package chapter3;

public class TwoThreadSleep extends Thread {
	
	@Override
	public void run() {
		loop();
	}
	
	public void loop() {
		// make a note of the thread that constructed me
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.printf("Just entered loop() - '%s'\n", name);

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("name='%s'\n", name);
		}
		
		System.out.printf("About to leave loop() - '%s'\n", name);
	}
	
	public static void main(String[] args) {
		TwoThreadSleep tt = new TwoThreadSleep();
		tt.setName("my worker thread");
		tt.start();

		try {
			Thread.sleep(700);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		tt.loop();
	}
}
