package View;



import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarView extends MenuBar {

    public MenuBarView(MyScene scene) {
    	
    	
    	
        Menu home = new Menu("Home");
        
        MenuItem lobby = new MenuItem("Lobby");
        lobby.setOnAction(e -> lobbyButton(scene));
        MenuItem logOut = new MenuItem("Log Out");
        logOut.setOnAction(e -> logOutButton(scene));
        
        
        home.getItems().addAll(lobby, logOut);
        
        
        Menu settings = new Menu("Settings");
        
        CheckMenuItem colorBlind = new CheckMenuItem("ColorBlindness");
        colorBlind.setOnAction(e -> switchColorBlindness());
        
        settings.getItems().add(colorBlind);
        
       

        Menu stats = new Menu("Statistics");
        
        MenuItem myStats = new MenuItem("My Statistics");
        myStats.setOnAction(e -> statsButton(scene));
        MenuItem gameStats = new MenuItem("Find New Game");
        myStats.setOnAction(e -> gameStatsButton(scene));
        
        stats.getItems().addAll(myStats, gameStats);

        
        
        
        this.getMenus().addAll(home, settings, stats);
    }

    private void switchColorBlindness() {
		// TODO Auto-generated method stub
    	System.out.println("hello");
	}

	private void gameStatsButton(MyScene scene) {
		// TODO Auto-generated method stub
		
	}

	private void lobbyButton(MyScene scene){
        //scene.openLobbyView();
    }

    private void statsButton(MyScene scene){
        //scene.openStatsView();
    }

    private void logOutButton(MyScene scene){
        scene.openLoginView();
        //accountController.logOut();
    }
}
