package Controller;

import Model.GameColors;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;

public class ColorblindController {
	private BooleanProperty colorblind;
	
	public ColorblindController() {
		colorblind = new SimpleBooleanProperty();
		colorblind.setValue(false);
	}

	public Color getPatternCardColor(String name){
		return GameColors.getColorFromName(name, colorblind.getValue(), false);
	}
	
	public Color getDieCardColor(String name){
		return GameColors.getColorFromName(name, colorblind.getValue(), true);
	}
	
	public BooleanProperty colorblindProperty() {
		return colorblind;
	}

	public void switchColorblind() {
		colorblind.setValue(!colorblind.getValue());
		
	}
}
