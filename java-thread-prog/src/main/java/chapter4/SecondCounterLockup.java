package chapter4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

public class SecondCounterLockup extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private boolean keepRunning;
	private Font paintFont;
	private String timeMsg;
	private int arcLen;
	
	public SecondCounterLockup() {
		paintFont = new Font("SansSerif", Font.BOLD, 14);
		timeMsg = "never started";
		arcLen = 0;
	}
	
	public void runClock() {
		System.out.printf("thread running runClock() is '%s'\n", 
				Thread.currentThread().getName());
		
		DecimalFormat fmt = new DecimalFormat("0.000");
		long normalSleepTime = 100;
		int counter = 0;
		keepRunning = true;
		
		while(keepRunning) {
			try {
				Thread.sleep(normalSleepTime);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			counter ++;
			double counterSecs = counter / 10.0;
			timeMsg = fmt.format(counterSecs);
			arcLen = (((int) counterSecs) % 60) * 360 / 60;
			System.out.printf("Calling repaint()\n");
			repaint();
		}
	}

	public void stopClock() {
		keepRunning = false;
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.printf("thread that invoked paint() is '%s'\n", 
				Thread.currentThread().getName());
		g.setColor(Color.BLACK);
		g.setFont(paintFont);
		g.drawString(timeMsg, 0, 15);
		
		g.fillOval(0, 20, 100, 100);

		g.setColor(Color.WHITE);
		g.fillOval(3, 23, 94, 94);
		
		g.setColor(Color.BLUE);
		g.fillArc(2, 22, 96, 96, 90, -arcLen);
	}
	
	
}
