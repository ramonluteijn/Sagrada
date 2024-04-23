package Model;

import javafx.scene.paint.Color;

public enum GameColors{
	
	
	
	RED("red", Color.RED, Color.ALICEBLUE, Color.GREEN, Color.GREY), 
	YELLOW("yellow", Color.YELLOW, Color.BEIGE, Color.BLACK, Color.GREY), 
	GREEN("green", Color.GREEN, Color.BLUE, Color.BLACK, Color.GREY), // TODO kleuren kloppen niet. en is niet compleet.
//	BLUE("blue", );
//	PURPLE("purple", )
	
	NOCOLOR(null, Color.RED, Color.ALICEBLUE, Color.FIREBRICK, Color.GREEN);
	
	
	// basic game colors (they don't change with color blindness options)
	public static final Color BACKGROUND = Color.rgb(61, 90, 128);
	public static final Color PRIMARY = Color.rgb(152, 193, 217);
	public static final Color SECONDARY = Color.rgb(224, 251, 252);
	public static final Color ACCENT = Color.rgb(238, 108, 77);
	
	public static final Color DARK_TEXT = Color.BLACK;
	public static final Color LIGHT_TEXT = Color.LIGHTGRAY;
	public static final Color BUTTON = Color.LIGHTGREEN;
	public static final Color HIGHLIGHTED = Color.BLACK;
	
	private final String name;
	private final Color dieColor;
	private final Color dieColorblindColor;
	private final Color patternColor;
	private final Color patternColorblindColor;
	
	
	
	
private GameColors(String name, Color dieColor, Color dieColorblindColor, Color patternColor, Color patternColorblindColor) {
		this.name = name;
		this.dieColor = dieColor;
		this.dieColorblindColor = dieColorblindColor;
		this.patternColor = patternColor;
		this.patternColorblindColor = patternColorblindColor;
	}


	
	public static Color getColorFromName(String name, boolean colorblind, boolean isDieColor) {
		for (GameColors gameColor : GameColors.values()) { 
			if (gameColor.name == name) {
				return gameColor.getColor(colorblind, isDieColor);
			}
		}
		
		System.out.println("deze kleur bestaat niet. dit komt van gameColors, die enum"); // TODO haal dit later weg.
		return Color.WHITE;
	}


	private Color getColor(boolean colorblind, boolean isDieColor) { 
		if (isDieColor) {
			if (colorblind) {
				return dieColorblindColor;
			} else {
				return dieColor;
			}
		} else {
			if (colorblind) {
				return patternColorblindColor;
			} else {
				return patternColor;
			}
		}
	}
}
