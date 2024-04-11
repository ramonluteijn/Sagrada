package View;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class DiceView extends TilePane{
	
	DieView selectedDie = null;
	
	DiceView(){
		DieView die1 = new DieView(1, Color.RED, this);
		DieView die2 = new DieView(2, Color.ORANGE, this);
		DieView die3 = new DieView(3, Color.GREEN, this);
		DieView die4 = new DieView(4, Color.BLUE, this);
		DieView die5 = new DieView(5, Color.PURPLE, this);
		DieView die6 = new DieView(6, Color.YELLOW, this);
		
		this.setPrefTileHeight(200);
		this.setPrefTileWidth(200);
		this.getChildren().addAll(die1, die2, die3, die4, die5, die6);
	}
	
	public void setSelectedDie(DieView die) {
		if (this.selectedDie != null) {  // resets the bordercolor of the unselected die. but only if it exists
			this.selectedDie.setBorder(new Border(new BorderStroke(Color.BISQUE, // color is the same as the background color
		            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK))); 
		}
		

		this.selectedDie = die;
		this.selectedDie.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK))); // sets a border when selected.
		
	}
}
