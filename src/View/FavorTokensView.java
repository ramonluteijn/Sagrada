package View;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class FavorTokensView extends HBox{
	
	private ArrayList<Circle> favortokens;
	private HBox layoutX;
	//private ToolcardController toolcardController;

	public FavorTokensView(/*ToolcardController toolcardController*/) {
		
		//toolcardController = new ToolcardController();
		
		//Arraylist voor variabel aantal favortokens (ligt aan je raamframe kaart ding)
		favortokens = new ArrayList<Circle>();
		
		//HBox om ze in weer te geven
		layoutX = new HBox();
		
		//Zorgen dat layoutX te zien wordt in FavorTokensView (die HBox extend)
		this.getChildren().add(layoutX);
		
	}
	
	//Variabel aantal favortokens aanmaken en in de arraylist stoppen
	public void createFavortoken(int amount) {
		for(int i = 0; i < amount; i++) {
			
			//Circle(double centerX, double centerY, double radius, Paint fill)
			favortokens.add(new Circle(10, 10, 10, Color.GRAY));
		}
	}
	
	//Favortokens weergeven (vgm ook updaten maar weet niet zeker en weet nie hoe ik dat moet testen)
	public void drawFavortokens() {
		
		//Checken of favortokens leeg is om exceptions te voorkomen
		if(favortokens.size() > 0) {
			
			//Loop om alle favortokens naast elkaar toe te voegen aan layoutX (en dus te drawen)
			for(int i = 0; i < favortokens.size(); i++) {
				layoutX.getChildren().add(favortokens.get(i));
			}
		}
	}
}
