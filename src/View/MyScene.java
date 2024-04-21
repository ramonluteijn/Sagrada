package View;

import Controller.MainController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

	private BorderPane root;
	private MainController mainCon;
    
	public MyScene() {
        super(new Pane());
        mainCon = new MainController();
        
        root = new BorderPane();
//        goToLogin();
        goToSelectPattern();
        
        setRoot(root);
        
    }
	
	public void goToLogin() {
		root.setTop(null); // resetting the menuBar
		root.setCenter(new LoginView(this));
	}
	
	public void goToLobby() {
		root.setTop(new MenuBarView(this)); // MenuBar only needs to be added here, because its gonna stay if you switch to a differnet view
		root.setCenter(new LobbyView(this));
		
	}
	
	public void goToAccountStats() {
//		root.setCenter(new AccountStatsView());
	}
	
	public void goToHostGame() {
//		root.setCenter(new HostGameView());
	}
	
	public void goToSelectPattern() {
		root.setCenter(new SelectPatternView());
	}
	
	public void goToGameStats() {
//		root.setCenter(new GameStatsView());
	}
	
	public void goToGame() {
//		root.setCenter(new GameView());
	}
	
	public void goToChallengesView() {
		root.setCenter(new ChallengesView(mainCon.challengeController));
	}
}
