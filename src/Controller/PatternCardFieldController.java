package Controller;

import Model.PatternCardField;
import javafx.scene.paint.Color;

public class PatternCardFieldController {
	private PatternCardField field;

	public int getNumber() {
		return field.getNumber();
	}

	public Color getColor() {
	
//		return field.getColor(); TODO do get Color from name in colorblindcontroller
		return Color.RED;
	}
}
