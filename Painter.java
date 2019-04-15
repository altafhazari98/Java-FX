/**
 * This class does the following:
 * Sets a stage of 300 by 300 pixels using the start() method.
 * The circle, square and the Text are drawn on the stage by paint() method.
 * @ Abdul Hazari, ICS-372.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Painter extends Application {
	GraphicsContext graphicsContext;
	int counter = 0;

	/**
	 * The start(Stage primaryStage) method sets the stage of 300 by 300 pixels.
	 * The stage is shown by using the (.show()) command.
	 * It also creates a new Controller Object.
	 * Which calls the constructor in the Controller class.
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas = new Canvas(300, 300);
		this.graphicsContext = canvas.getGraphicsContext2D();
		primaryStage.setScene(new Scene(new Pane(canvas)));
		primaryStage.show();
		new Controller(this);
	}

	/**
	 * The paint() method draws the circle,square and Text on the stage using:
	 * strokeOval(), strokeRect() and strokeText(). 
	 * The setStroke() is used for setting up the color.
	 * Similarly clearRect() is used for clearing the text.
	 * The counter is used for continuously drawing the figures one after other and erasing them.
	 * I calculate the modulo of counter and 3 at each instance, 
	 * Which results in just 3 possible answers(i.e 0,1 and 2.) for any number. 
	 * If the answer is 0 it draws a circle.
	 * If the answer is 1 it draws a square.
	 * If the answer is 2 it writes the Text
	 */
	public void paint() {
		if (counter % 3 == 0) {
			graphicsContext.clearRect(50, 50, 300, 300);
			graphicsContext.setStroke(Color.RED);
			graphicsContext.strokeOval(50, 50, 200, 200);
		}
		if (counter % 3 == 1) {
			graphicsContext.clearRect(50, 50, 300, 300);
			graphicsContext.setStroke(Color.GREEN);
			graphicsContext.strokeRect(100, 100, 200, 200);
		}
		if (counter % 3 == 2) {
			graphicsContext.clearRect(50, 50, 300, 300);
			graphicsContext.setStroke(Color.BLUE);
			graphicsContext.strokeText("ICS 372", 120, 150);
		}
		counter++;
	}

	/**
	 * This where we start the program from, the main: The Application.launch(args)
	 * takes you to the start() method of the class Painter.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}