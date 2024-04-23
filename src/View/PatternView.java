package View;

import java.util.Random;

import Controller.ColorBlindController;
import Controller.MainController;
import Controller.PatternCardController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PatternView extends BorderPane{
	
	private PatternCardController controller;
	
	private SelectPatternView selectPatternView;
	private final static int rows = 4;
	private final static int cols = 5;
	
	
	public PatternView(SelectPatternView selectPatternView) {
		this.controller = MainController.getPatternCardController();

		
		this.selectPatternView = selectPatternView;
		
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null ,null)));  // test color i think

		
		

		this.setBorder(new Border(new BorderStroke(Color.BISQUE, // background color
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK)));
		
		this.setOnMouseReleased(e -> selected());
		
		
		
		this.setCenter(getPattern());
		this.setBottom(getCardInfo());
		
		
		
		
	}

	private GridPane getPattern() {
		
		GridPane pattern = new GridPane();
		
		
		pattern.prefHeightProperty().bind(selectPatternView.heightProperty().divide(3));
		pattern.prefWidthProperty().bind(selectPatternView.heightProperty().divide(3));
		
		
		pattern.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));
		Random rand = new Random();
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				@SuppressWarnings("unused")
				Color RAND_COLOR = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
				@SuppressWarnings("unused")
				int RAND_NUMBER = rand.nextInt(7); // voor testen kan later weg
				
				
				Color color = controller.getFieldColor(x, y);
				int number = controller.getFieldNumber(x, y);
				
				PatternCardFieldView field = new PatternCardFieldView(color, number);
				
				pattern.add(field, x, y);
				
			}
		}
		
		
		
		return pattern;
	}

	private AnchorPane getCardInfo() {

		AnchorPane info = new AnchorPane();
		Text name = new Text("naampie");
		Text difficulty = new Text("4");
	
		AnchorPane.setTopAnchor(name, 0d);
		AnchorPane.setTopAnchor(difficulty, 0d);
		AnchorPane.setLeftAnchor(name, 10d);
		AnchorPane.setRightAnchor(difficulty, 10d);
		
		info.getChildren().addAll(name, difficulty);
		
		return info;
	}

	private void selected() {
		System.out.println("selected, " + this);
		selectPatternView.setSelectedPatternCard(this);
	}
}
