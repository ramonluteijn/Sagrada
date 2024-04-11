package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ResultsView extends HBox {

	//PlayerController playerController = new PlayerController();
	
	public ResultsView() {
		
		ScrollPane results = new ScrollPane();
		
		HBox layoutX = new HBox();
		VBox layoutY = new VBox();
		HBox buttons = new HBox();
		
		Text username = new Text("TESTESTEST");
		Button invite = new Button("Invite");
		Button stats = new Button("Stats");
		
		buttons.getChildren().addAll(invite, stats);
		
		buttons.setAlignment(Pos.CENTER);
		
		layoutX.getChildren().addAll(username, buttons);
		
		layoutX.setSpacing(400);
		
		layoutY.getChildren().add(layoutX);
	
		results.setContent(layoutY);
		
		this.getChildren().add(results);
		
	}
	
	public /*ArrayList<Player>*/ void getResults(){
		
	}
	
	private void invitePlayer(String username) {
		
	}
	
	private void viewStats(String username) {
		
	}
	
}
