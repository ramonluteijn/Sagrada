package GameColor;

import javafx.scene.paint.Color;

public class GameColor {
	private boolean colorBlind = false;
	
	
	// basic game colors (they don't change with color blindness options)
	public static final Color BACKGROUND = Color.rgb(61, 90, 128);
	public static final Color PRIMARY = Color.rgb(152, 193, 217);
	public static final Color SECONDARY = Color.rgb(224, 251, 252);
	public static final Color ACCENT = Color.rgb(238, 108, 77);
	
	public static final Color DARK_TEXT = Color.BLACK;
	public static final Color LIGHT_TEXT = Color.LIGHTGRAY;
	public static final Color BUTTON = Color.LIGHTGREEN;
	public static final Color HIGHLIGHTED = Color.BLACK;
	
	
	
	// test123
	// die and patterncard colors (change if setColors() is called)
	private Color redDie;
	private Color yellowDie;
	private Color greenDie;
	private Color blueDie;
	private Color purpleDie;
	
	private Color redPatternCard;
	private Color yellowPatternCard;
	private Color greenPatternCard;
	private Color bluePatternCard;
	private Color purplePatternCard;


	public GameColor() {
		setColors();
	}
	
	public void switchColorblind() {
		colorBlind = !colorBlind;
		setColors();
	}
	
	private void setColors() {
		if (colorBlind) {
			redDie = Color.rgb(103, 73, 48);
			yellowDie = Color.rgb(158, 130, 55);
			greenDie = Color.rgb(216, 204, 114);
			blueDie = Color.rgb(153, 164, 123);
			purpleDie = Color.rgb(13, 3, 189);
			
			redPatternCard = Color.rgb(103, 73, 48); // deze kloppen nog niet. hierboven wel
			yellowPatternCard = Color.rgb(150, 150, 0); // maak kleuren donkerder in paint of vraag aan jasper
			greenPatternCard = Color.DARKGREEN;
			bluePatternCard = Color.DARKBLUE;
			purplePatternCard = Color.rgb(100, 0, 100);
			
		} else {
			redDie = Color.RED;
			yellowDie = Color.YELLOW;
			greenDie = Color.GREEN;
			blueDie = Color.BLUE;
			purpleDie = Color.PURPLE;
			
			redPatternCard = Color.DARKRED;
			yellowPatternCard = Color.rgb(150, 150, 0);
			greenPatternCard = Color.DARKGREEN;
			bluePatternCard = Color.DARKBLUE;
			purplePatternCard = Color.rgb(100, 0, 100);
		}
		
		
		
	}
	
	
	
	
	
}
