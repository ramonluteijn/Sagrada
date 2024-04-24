package Controller;

import java.util.Random;

import Model.PatternCard;
import Model.PatternCardField;
import javafx.scene.paint.Color;

public class PatternCardController {
	private PatternCard card;
	private ColorblindController colorblindController;
	
	private final int rows = 4;
	private final int cols = 5;
	
	public PatternCardController(ColorblindController colorblindController) {
		card = new PatternCard("name", 4, getPatternCardFields()); // ask for the data from the DB here
		this.colorblindController = colorblindController;
	}
	
	
	private PatternCardField[][] getPatternCardFields() {
		PatternCardField[][] fields = new PatternCardField[cols][rows];
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				
				// this is for testing. all the patternCardFields information should be gotten out of the DB.
				Random rand = new Random();
				int randint = rand.nextInt(3);
				
				if (randint == 0) {
					fields[x][y] = new PatternCardField("red", 6);
				} else if(randint == 1){
					fields[x][y] = new PatternCardField("yellow", 3);
				} else {
					fields[x][y] = new PatternCardField("green", 2);
				}
//				fields[x][y] = new PatternCardField("red", 6); // TODO ask for the data from the DB here
				
			}
			
		}
		return fields;
	}


	public Color getFieldColor(int x, int y) {
		return colorblindController.getPatternCardColor(card.getColor(x, y));
	}
	
	public int getFieldNumber(int x, int y) {
		return card.getNumber(x, y);
	}
	
	public String getName() {
		return card.getName();
	}
	
	public String getDifficulty() {
		return Integer.toString(card.getDifficulty());
	}
	
	
	public PatternCardFieldController getPatternCardFieldController(int x, int y) {
		return new PatternCardFieldController();
	}
	
	
	
}
