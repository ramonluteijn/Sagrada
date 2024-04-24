package View;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class PatternCardFieldView extends PaneWithEyesView {

	
	public PatternCardFieldView(Color color, int number) {
		super(number);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE); 
		

		addEyes(number);
		
	}
	
	
}
