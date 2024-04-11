package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchAccountView extends HBox{

	private MyScene scene;
	
	public SearchAccountView(MyScene scene /* ViewController viewController, PlayerController playerController, GameController gameController */) {
		this.scene = scene;
		
		SearchBarView searchBar = new SearchBarView();
		PlayersView playersView = new PlayersView();
		ResultsView resultsView = new ResultsView();
		
		VBox layoutY = new VBox();
		
		
		
		
		
		
		
		
		//HBox layoutX = new HBox();
		
		layoutY.getChildren().addAll(searchBar, resultsView, playersView);
		
		this.getChildren().add(layoutY);
		
		playersView.addPlayer("Jonas");
		playersView.addPlayer("Bob");
		playersView.addPlayer("Frank");
	}
	
}
