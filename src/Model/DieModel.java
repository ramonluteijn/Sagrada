package Model;

//DieDB heeft nog DieModel object nodig

public class DieModel {

	private	int number;
	private String color;
	
	public DieModel(int number, String color) {
		this.number = number;
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
