package Model;

public class PatternCardModel {

	private final PatternCardFieldModel[][] fields;

	private final String name;
	private final int difficulty;

	public PatternCardModel(String name, int difficulty, PatternCardFieldModel[][] fields) {
		this.name = name;
		this.difficulty = difficulty;
		this.fields = fields;
	}
	
	public String getColor(int x, int y) {
		return fields[x][y].getColor();
	}

	public int getNumber(int x, int y) {
		return fields[x][y].getNumber();
	}

	public String getName() {
		return name;
	}

	public int getDifficulty() {
		return difficulty;
	}
	
	
	
	
}
