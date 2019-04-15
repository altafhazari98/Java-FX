/**
 * This class initializes the painter and has the method run(): 
 * Which basically draws stuff on the canvas.
 */
public class Controller extends Thread {
	private Painter painter;

	/**
	 * Initializes the painter
	 */
	public Controller(Painter painter) {
		this.painter = painter;
		start();
	}

	/**
	 * Within the run () we have the, painter.paint. Which calls the paint method in
	 * the Painter class continuously because of the while loop. The condition for
	 * the while loop is unless the canvas is there it calls the paint method. The
	 * Thread.sleep (3000) is the 3 seconds wait time after each figure is drawn and
	 * cleared.
	 */
	public void run() {
		while (true) {
			try {
				painter.paint();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
