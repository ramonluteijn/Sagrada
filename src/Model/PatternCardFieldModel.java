package Model;

public class PatternCardFieldModel {
    final private String color;
    final private int number;


    public PatternCardFieldModel(String color, int number) {
        this.color = color;
        this.number = number;
    }


    public String getColor() {
        return color;
    }


    public int getNumber() {
        return number;
    }

}
