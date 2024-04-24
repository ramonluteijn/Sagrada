package View;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



public class PlayersView extends HBox{
	
	//private PlayerController playerController;
	//private ArrayList<Player> players;
	//public GameController gameController;
	
	private ArrayList<Text> playerNames = new ArrayList<Text>();
	
	public PlayersView() {
		Rectangle player1Box = new Rectangle(100, 20, Color.BLUE);
		Rectangle player2Box = new Rectangle(100, 20, Color.BLUE);
		Rectangle player3Box = new Rectangle(100, 20, Color.BLUE);
		Rectangle player4Box = new Rectangle(100, 20, Color.BLUE);
		
		Text player1Name = new Text();
		Text player2Name = new Text();
		Text player3Name = new Text();
		Text player4Name = new Text();
		
		playerNames.add(player1Name);
		playerNames.add(player2Name);
		playerNames.add(player3Name);
		playerNames.add(player4Name);
		
		
		HBox layoutX = new HBox();
		
		StackPane player1 = new StackPane();
		StackPane player2 = new StackPane();
		StackPane player3 = new StackPane();
		StackPane player4 = new StackPane();
		
		player1.getChildren().addAll(player1Box, player1Name);
		player2.getChildren().addAll(player2Box, player2Name);
		player3.getChildren().addAll(player3Box, player3Name);
		player4.getChildren().addAll(player4Box, player4Name);
		
		layoutX.getChildren().addAll(player1, player2, player3, player4); //, player2, player3, player4);
		
		layoutX.setAlignment(Pos.CENTER);
		
		//Nog responsive maken lijkt me
		layoutX.setSpacing(20);
		
		this.getChildren().add(layoutX);
	}
	
	public void addPlayer(String username) {
		for(int i = 0; i < 4; i++) {
			if(playerNames.get(i).getText().equals("")) {
				playerNames.get(i).setText(username);
				System.out.println("Succes!!!!!");
				break;
			}
		}
	}
	
	public void startGame() {
		/*
		 * Lijkt me dat deze method bedoeld wordt   v v v v v
		 */
		
		//gameController.setupGame();
		
	}
	

}
