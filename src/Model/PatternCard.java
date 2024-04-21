package Model;

public class PatternCard {
	
	private final PatternCardField[][] fields;
	
	private final String name;
	private final int difficulty;
	
	public PatternCard(String name, int difficulty, PatternCardField[][] fields) {
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
