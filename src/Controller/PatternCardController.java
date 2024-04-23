package Controller;

import Model.PatternCard;
import Model.PatternCardField;
import javafx.scene.paint.Color;

public class PatternCardController {
	private PatternCard card;
	private ColorBlindController colorBlindController;
	
	private final int rows = 4;
	private final int cols = 5;
	
	public PatternCardController(ColorBlindController colorBlindController) {
		card = new PatternCard("name", 4, getPatternCardFields());
		this.colorBlindController = colorBlindController;
	}
	
	
	private PatternCardField[][] getPatternCardFields() {
		PatternCardField[][] fields = new PatternCardField[cols][rows];
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				fields[x][y] = new PatternCardField("red", 6); // TODO ask for the data from the DB here
				
			}
			
		}
		return fields;
	}


	public Color getFieldColor(int x, int y) {
		return colorBlindController.getPatternCardColor(card.getColor(x, y));
	}
	
	public int getFieldNumber(int x, int y) {
		return card.getNumber(x, y);
	}
	
	public String getName() {
		return card.getName();
	}
	
	public int getDifficulty() {
		return card.getDifficulty();
	}
}
