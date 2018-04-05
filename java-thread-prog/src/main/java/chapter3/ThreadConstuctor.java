package chapter3;

public class ThreadConstuctor extends Thread {
	
	public ThreadConstuctor(String name) {
		super(name);
	}

	public ThreadConstuctor(ThreadGroup threadGroup, String name) {
		super(threadGroup, name);
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
		ThreadGroup threadGroup = t.getThreadGroup();
    	System.out.printf("threadName='%s', threadGroup='%s'\n",
    			t.getName(), threadGroup.getName());
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup tg = new ThreadGroup("MyThreadGroup");
		ThreadConstuctor tt = new ThreadConstuctor(tg, "t1");
		tt.start();
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
	}
}
