package View;

import javafx.scene.control.TextField;


public class SearchBarView {
	
	private TextField searchBar;
	
	public SearchBarView() {
		searchBar = new TextField("Vul een gebruikersnaam in");
	}
	
	public String getSearch() {
		return searchBar.getText();
	}
}

