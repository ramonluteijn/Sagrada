package Controller;

import Model.GameColors;
import javafx.scene.paint.Color;

public class ColorBlindController {
	private boolean colorblind;
	
	public Color getPatternCardColor(String name){
		return GameColors.getColorFromName(name, colorblind, false);
	}
	
	public Color getDieCardColor(String name){
		return GameColors.getColorFromName(name, colorblind, true);
	}
}
