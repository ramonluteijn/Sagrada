package View;

import Controller.ColorblindController;
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

public class PatternCardView extends BorderPane{
	
	private PatternCardController controller;
	private ColorblindController colorblindController;
	
	private SelectPatternView selectPatternView;
	private final static int rows = 4;
	private final static int cols = 5;
	
	
	public PatternCardView(SelectPatternView selectPatternView) {
		this.controller = MainController.getPatternCardController();
		this.colorblindController = MainController.colorblindController;
		
		this.selectPatternView = selectPatternView;
		
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null ,null)));  // test color i think

		
		

		this.setBorder(new Border(new BorderStroke(Color.BISQUE, // background color
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK)));
		
		this.setOnMouseReleased(e -> selected());
		
		
		
		this.setCenter(getPattern());
		this.setBottom(getCardInfo());
		
		colorblindController.colorblindProperty().addListener(e -> changeColorblindColors());
		
		
		
	}

	private void changeColorblindColors() {
		this.setCenter(getPattern());
	}

	private GridPane getPattern() {
		
		GridPane pattern = new GridPane();
		
		
		pattern.prefHeightProperty().bind(selectPatternView.heightProperty().divide(3));
		pattern.prefWidthProperty().bind(selectPatternView.heightProperty().divide(3));
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				Color color = controller.getFieldColor(x, y);
				int number = controller.getFieldNumber(x, y);
				
				PatternCardFieldView field = new PatternCardFieldView(color, number);
//				
				pattern.add(field, x, y);
			}
		}
		
		
		return pattern;
	}

	private AnchorPane getCardInfo() {

		AnchorPane info = new AnchorPane();
		Text name = new Text(controller.getName());
		Text difficulty = new Text(controller.getDifficulty());
	
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
