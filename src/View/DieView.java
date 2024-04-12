package View;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class DieView extends PaneWithEyes{
	
	private DiceView diceView;
	
	
	public DieView(int number, Color color, DiceView diceView) {
		super(number); // sets the eyes of the die
		this.diceView = diceView;
		
		
		
		setBorder(new Border(new BorderStroke(Color.ALICEBLUE, // should be the background color. this is the color that the border should have when not selected
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
		
		
		setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setOnMouseReleased(e -> selected());
		
	}

	private void selected() {
		diceView.setSelectedDie(this);
	}
	
	
	/**
	Changes the amount of eyes.
	*/
	public void changeNumber(int number) { 
		this.getChildren().clear(); // getting rid of the original eyes
		this.addEyes(number);
	}
	
		
	

}
