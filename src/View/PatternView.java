package View;

import java.util.Random;

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
	SelectPatternView selectPatternView;
	double SIZE;
	public PatternView(SelectPatternView selectPatternView) {
		this.selectPatternView = selectPatternView;
		
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null ,null)));

		
		

		this.setBorder(new Border(new BorderStroke(Color.BISQUE, 
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
		
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 5; x++) {
				Color COLOR = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
				int VALUE = rand.nextInt(7);
				PatternCardFieldView field = new PatternCardFieldView(COLOR, VALUE);
				
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
