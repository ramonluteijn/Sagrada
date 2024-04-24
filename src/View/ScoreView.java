package View;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class ScoreView extends HBox{

	int testscore = 10;
	
	public ScoreView() {

		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);
        
        this.getChildren().add(this.setupView());
        

        
	}
	
	private Label setupView() {
		
		Label ownScore = new Label("SCORE: " + testscore);
		Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
		
		ownScore.setPrefSize(400, 50);
		ownScore.setFont(font);
		
		
		return ownScore;
	}
}
