package View;



import Controller.MainController;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarView extends MenuBar {
	
	MyScene scene;
	
    public MenuBarView(MyScene scene) {
    	
    	this.scene = scene;
    	
        Menu home = new Menu("Home");
        
        MenuItem lobby = new MenuItem("Lobby");
        lobby.setOnAction(e -> lobbyButton());
        MenuItem logOut = new MenuItem("Log Out");
        logOut.setOnAction(e -> logOutButton());
        
        
        home.getItems().addAll(lobby, logOut);
        
        
        Menu settings = new Menu("Settings");
        
        CheckMenuItem colorBlind = new CheckMenuItem("ColorBlindness");
        colorBlind.setOnAction(e -> switchColorBlindness());
        
        settings.getItems().add(colorBlind);
        
       

        Menu stats = new Menu("Statistics");
        
        MenuItem myStats = new MenuItem("My Statistics");
        myStats.setOnAction(e -> statsButton());
        MenuItem gameStats = new MenuItem("Find New Game");
        myStats.setOnAction(e -> gameStatsButton());
        
        stats.getItems().addAll(myStats, gameStats);

        
        
        
        this.getMenus().addAll(home, settings, stats);
    }

    private void switchColorBlindness() {
		// TODO deze functie
    	System.out.println("switching colorblindness.........");
    	MainController.colorblindController.switchColorblind();
	}

	private void gameStatsButton() {
		scene.goToGameStats();
		
	}

	private void lobbyButton(){
        scene.goToLobby();
    }

    private void statsButton(){
        scene.goToAccountStats();
    }

    private void logOutButton(){
        scene.goToLogin();
        //accountController.logOut();
    }
}
