package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class SearchBarView extends HBox{
	
	private TextField searchBar;
	private Button searchButton;
	
	public SearchBarView() {
		searchBar = new TextField("Vul een gebruikersnaam in");
		searchButton = new Button("Zoek");
		
		HBox layoutX = new HBox();
		
		layoutX.getChildren().addAll(searchBar, searchButton);
		
		layoutX.setAlignment(Pos.CENTER_LEFT);
		
		this.getChildren().add(layoutX);
		
	}
	
	public String getSearch() {
		return searchBar.getText();
	}
	
}

