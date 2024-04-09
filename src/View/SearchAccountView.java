package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchAccountView extends HBox{

	private MyScene scene;
	
	public SearchAccountView(MyScene scene /* ViewController viewController, PlayerController playerController, GameController gameController */) {
		this.scene = scene;
		
		SearchBarView searchBar = new SearchBarView();
		
		VBox layoutY = new VBox();
		HBox layoutX = new HBox();
		
		layoutY.getChildren().add(searchBar);
		
		this.getChildren().add(layoutY);
	}
	
}
