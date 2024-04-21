package Controller;

import GameColor.GameColor;
import Model.PatternCard;
import Model.PatternCardField;
import javafx.scene.paint.Color;

public class PatternCardController {
	private PatternCard card;
	private GameColor gameColor;
	
	
	public PatternCardController() {
		PatternCardField[][] fields = new PatternCardField[3][4];
		card = new PatternCard("name", 4, fields);
	}
	
	
	public Color getFieldColor(int x, int y) {
//		return card.getColor(x, y);
		return gameColor.getColorFromString(card.getColor(x, y));
		// TODO dit
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
