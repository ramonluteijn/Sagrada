package View;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PatternCardFieldView extends Pane{
	public PatternCardFieldView(Color color, int number) {
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);


		addShapes(number);
		
	}
	
	private void addShapes(int number) {
		switch(number) {
		case 0:
			break;
		case 1:
			addShapes1();
			break;
		case 2:
			addShapes2();
			break;
		case 3:
			addShapes3();
			break;
		case 4:
			addShapes4();
			break;
		case 5:
			addShapes5();
			break;
		case 6:
			addShapes6();
			break;
		}
		
	}

	private void addShapes6() {
		addShapes4();
		
		Circle eye1 = getEye();
		Circle eye2 = getEye();
		
		eye1.centerXProperty().bind(this.widthProperty().divide(4));
		eye1.centerYProperty().bind(this.heightProperty().divide(2));
		
		eye2.centerXProperty().bind(this.widthProperty().multiply((float)3/4));
		eye2.centerYProperty().bind(this.heightProperty().divide(2));
		
		
		this.getChildren().addAll(eye1, eye2);
		
		
	}

	private void addShapes5() {
		addShapes4();
		addShapes1();
		
	}
	
	private void addShapes4() {
		addShapes2();
		
		Circle eye1 = getEye();
		Circle eye2 = getEye();
		
		eye1.centerXProperty().bind(this.widthProperty().divide(4));
		eye1.centerYProperty().bind(this.heightProperty().multiply((float)3/4));
		
		eye2.centerXProperty().bind(this.widthProperty().multiply((float)3/4));
		eye2.centerYProperty().bind(this.heightProperty().divide(4));
		
		
		this.getChildren().addAll(eye1, eye2);
		
	}
	
	private void addShapes3() { 
		addShapes1();
		addShapes2();
		
		
	}

	private void addShapes2() {
		Circle eye1 = getEye();
		Circle eye2 = getEye();
		
		eye1.centerXProperty().bind(this.widthProperty().divide(4));
		eye1.centerYProperty().bind(this.heightProperty().divide(4));
		
		eye2.centerXProperty().bind(this.widthProperty().multiply((float)3/4));
		eye2.centerYProperty().bind(this.heightProperty().multiply((float)3/4));
		
		
		this.getChildren().addAll(eye1, eye2);
		
		
	}

	private void addShapes1() {
		Circle eye = getEye();
		
		eye.centerXProperty().bind(this.widthProperty().divide(2));
		eye.centerYProperty().bind(this.heightProperty().divide(2));
		this.getChildren().add(eye);
		
	}
	
	private Circle getEye() {
		Circle eye = new Circle();
		eye.radiusProperty().bind(this.widthProperty().divide(12));
		return eye;
	}
}
