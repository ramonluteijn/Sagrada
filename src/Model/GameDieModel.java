package Model;

//GameDieDB heeft nog GameDieModel object nodig

public class GameDieModel {
	
	private int gameID;
	private int dieNumber;
	private String dieColor;
	private int eyes;
	private int roundtrack;
	private int roundID;
	
	public GameDieModel(int gameID, int dieNumber, String dieColor, int eyes, int roundtrack, int roundID) {
		this.gameID = gameID;
		this.dieNumber = dieNumber;
		this.dieColor = dieColor;
		this.eyes = eyes;
		this.roundtrack = roundtrack;
		this.roundID = roundID;
	}
	
	public int getGameID() {
		return gameID;
	}
	
	public int getDieNumber() {
		return dieNumber;
	}
	
	public String getDieColor() {
		return dieColor;
	}
	
	public int getEyes() {
		return eyes;
	}
	
	public int getRoundtrack() {
		return roundtrack;
	}
	
	public int getRoundID() {
		return roundID;
	}
	
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	public void setDieNumber(int dieNumber) {
		this.dieNumber = dieNumber;
	}
	
	public void setDieColor(String dieColor) {
		this.dieColor = dieColor;
	}
	
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
	
	public void setRoundtrack(int roundtrack) {
		this.roundtrack = roundtrack;
	}
	
	public void setRoundID(int roundID) {
		this.roundID = roundID;
	}
}
